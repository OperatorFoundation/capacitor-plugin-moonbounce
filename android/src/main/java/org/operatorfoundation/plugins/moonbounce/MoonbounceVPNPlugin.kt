package org.operatorfoundation.plugins.moonbounce

import android.Manifest
import com.getcapacitor.*
import com.getcapacitor.annotation.CapacitorPlugin
import com.getcapacitor.annotation.Permission
import com.getcapacitor.annotation.PermissionCallback
import kotlinx.coroutines.*

const val vpnPermissionAlias = "vpnConnection"
const val vpnPluginName = "MoonbounceVPN"

@CapacitorPlugin(
    name = vpnPluginName,
    permissions = arrayOf(
        Permission( alias = vpnPermissionAlias, strings = arrayOf(
            Manifest.permission.BIND_VPN_SERVICE)
        ))
)
class MoonbounceVPNPlugin : Plugin()
{
    private var implementation = MoonbounceVPNCommunicator()
    private var callID: String? = null

    var serverIP: String? = null
    var serverPort: Int? = null
    var disallowedApp: String? = null
    var excludeIP: String? = null

//    override fun load() {
//    }

    @PluginMethod
    fun startVPN(call: PluginCall)
    {
        bridge.saveCall(call)
        callID = call.callbackId

        val portString = call.getString(implementation.startVPNPortKey)
        this.serverPort = Integer.valueOf(portString)
        this.serverIP = call.getString(implementation.startVPNIPKey)
        this.disallowedApp = call.getString(implementation.startVPNDisallowedAppKey)
        this.excludeIP = call.getString(implementation.startVPNExcludeIPKey)

        if (getPermissionState(vpnPermissionAlias) != PermissionState.GRANTED)
        {
            requestPermissionForAlias(vpnPermissionAlias, call, "vpnPermissionCallback")
        }
        else
        {
            createVPNConnection(call)
        }
    }

    private fun createVPNConnection(call: PluginCall)
    {
        if (serverPort == null || serverIP == null) {
            bridge.releaseCall(call)
            callID = null
            call.reject("Server IP and port are required in order to create a VPN connection.")
        }
        else
        {
            val started = implementation.startVPN(context, serverIP!!, serverPort!!, disallowedApp, excludeIP)

            if (started)
            {
                bridge.releaseCall(call)
                callID = null
                call.resolve()
            }
            else
            {
                bridge.releaseCall(call)
                callID = null
                call.reject("Failed to create a VPN connection.")
            }
        }
    }

    @PluginMethod
    fun stopVPN(call: PluginCall)
    {
        val stopped = implementation.stopVPN()

        if (stopped)
        {
            call.resolve()
        }
        else
        {
            call.reject("Failed to stop the Android VPN service.")
        }
    }

    @PermissionCallback
    private fun vpnPermissionCallback(call: PluginCall)
    {
        if (getPermissionState(vpnPermissionAlias) == PermissionState.GRANTED)
        {
            createVPNConnection(call)
        }
        else
        {
            call.reject("Permission is required to create a VPN connection.")
        }
    }
}