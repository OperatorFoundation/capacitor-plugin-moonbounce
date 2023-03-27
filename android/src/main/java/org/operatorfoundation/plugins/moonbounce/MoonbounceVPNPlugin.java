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

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public ComponentName startVPN(PluginCall call)
    {
        String ipAddress = call.getString("ipString");
        Integer port = Integer.valueOf(call.getString("port"));
        Context context = getContext();

        vpnService = new MoonbounceJava(context, ipAddress, port, "", "");
        ComponentName serviceName = vpnService.startVPN();

        JSObject returnValue = new JSObject();
        returnValue.put(startVPNReturnValueKey, serviceName != null);
        call.resolve(returnValue);

        return serviceName;
    }

    @PluginMethod
    public Boolean stopVPN(PluginCall call)
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

        return serviceStopped;
    }
}
