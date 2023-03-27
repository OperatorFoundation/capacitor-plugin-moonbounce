package org.operatorfoundation.plugins.moonbounce;

import android.content.ComponentName;
import android.content.Context;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.operatorfoundation.moonbouncevpnservice.*;

@CapacitorPlugin(name = "MoonbounceVPN")
public class MoonbounceVPNPlugin extends Plugin
{
    private MoonbounceVPN implementation = new MoonbounceVPN();
    private MoonbounceJava vpnService;

    public String stopVPNReturnValueKey = "vpnStopped";
    public String startVPNReturnValueKey = "vpnStarted";
    public String startVPNIPKey = "serverIP";
    public String startVPNPortKey = "serverPort";
    public String startVPNDisallowedAppKey = "disallowedApp";
    public String startVPNExcludeIPKey = "excludeIP";

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void startVPN(PluginCall call)
    {
        JSObject returnValue = new JSObject();
        String ipAddress = call.getString(startVPNIPKey);
        String portString = call.getString(startVPNPortKey);

        if (portString == null)
        {
            returnValue.put(startVPNReturnValueKey, false);
            call.resolve(returnValue);
            return;
        }

        Integer port = Integer.valueOf(portString);
        String disallowedApp = call.getString(startVPNDisallowedAppKey);
        String excludeIP = call.getString(startVPNExcludeIPKey);
        Context context = getContext();

        vpnService = new MoonbounceJava(context, ipAddress, port, disallowedApp, excludeIP);
        ComponentName serviceName = vpnService.startVPN();

        returnValue.put(startVPNReturnValueKey, serviceName != null);
        call.resolve(returnValue);
    }

    @PluginMethod
    public void stopVPN(PluginCall call)
    {
        Boolean serviceStopped;

        if (vpnService != null)
        {
            serviceStopped = vpnService.stopVPN();
        }
        else
        {
            serviceStopped = true;
        }

        JSObject returnValue = new JSObject();
        returnValue.put(stopVPNReturnValueKey, serviceStopped);
        call.resolve(returnValue);
    }
}
