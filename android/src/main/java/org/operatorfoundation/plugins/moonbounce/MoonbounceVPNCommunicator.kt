package org.operatorfoundation.plugins.moonbounce

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.operatorfoundation.moonbouncevpnservice.MoonbounceKotlin

class MoonbounceVPNCommunicator {
    var vpnService: MoonbounceKotlin? = null
    var startVPNIPKey = "serverIP"
    var startVPNPortKey = "serverPort"
    var startVPNDisallowedAppKey = "disallowedApp"
    var startVPNExcludeIPKey = "excludeIP"

    fun startVPN(
        context: Context,
        ipAddress: String,
        port: Int,
        disallowedApp: String?,
        excludeIP: String?
    ): Boolean = runBlocking {
        vpnService = MoonbounceKotlin(context, ipAddress, port, disallowedApp, excludeIP)
        val serviceName = async(Dispatchers.Default) { vpnService!!.startVPN() }
        serviceName.await() != null
    }

    fun stopVPN(): Boolean {
        val serviceStopped: Boolean
        serviceStopped = if (vpnService != null) {
            vpnService!!.stopVPN()
        } else {
            true
        }

        return serviceStopped
    }
}