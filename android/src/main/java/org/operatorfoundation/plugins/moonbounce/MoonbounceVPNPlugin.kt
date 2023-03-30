package org.operatorfoundation.plugins.moonbounce

import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin
import kotlinx.coroutines.*

@CapacitorPlugin(name = "MoonbounceVPN")
class MoonbounceVPNPlugin : Plugin()
{
    private val implementation = MoonbounceVPNCommunicator()

    @PluginMethod
    fun startVPN(call: PluginCall)
    {
        val returnValue = JSObject()
        val ipAddress = call.getString(implementation.startVPNIPKey)
        val portString = call.getString(implementation.startVPNPortKey)

        if (portString == null || ipAddress == null) {
            returnValue.put(implementation.startVPNReturnValueKey, false)
            call.resolve(returnValue)
            return
        }

        val port = Integer.valueOf(portString)
        val disallowedApp = call.getString(implementation.startVPNDisallowedAppKey)
        val excludeIP = call.getString(implementation.startVPNExcludeIPKey)
        val context = context
        val started = implementation.startVPN(context, ipAddress, port, disallowedApp, excludeIP)

        returnValue.put( implementation.startVPNReturnValueKey, started )
        call.resolve(returnValue)
    }

    @PluginMethod
    fun stopVPN(call: PluginCall) = runBlocking {
        val returnValue = JSObject()
        val deferred = async(Dispatchers.Default) { implementation.stopVPN() }
        returnValue.put(implementation.stopVPNReturnValueKey, deferred.await())
        call.resolve(returnValue)
    }
}