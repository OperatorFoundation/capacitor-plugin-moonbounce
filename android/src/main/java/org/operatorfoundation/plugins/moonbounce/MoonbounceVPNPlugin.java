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

    @PluginMethod
    public void startVPN(PluginCall call)
    {
        JSObject returnValue = new JSObject();
        String ipAddress = call.getString(implementation.startVPNIPKey);
        String portString = call.getString(implementation.startVPNPortKey);

        if (portString == null)
        {
            returnValue.put(implementation.startVPNReturnValueKey, false);
            call.resolve(returnValue);
            return;
        }

        Integer port = Integer.valueOf(portString);
        String disallowedApp = call.getString(implementation.startVPNDisallowedAppKey);
        String excludeIP = call.getString(implementation.startVPNExcludeIPKey);
        Context context = getContext();

        returnValue.put(implementation.startVPNReturnValueKey, implementation.startVPN(context, ipAddress, port, disallowedApp, excludeIP));
        call.resolve(returnValue);
    }

    @PluginMethod
    public void stopVPN(PluginCall call)
    {
        JSObject returnValue = new JSObject();
        returnValue.put(implementation.stopVPNReturnValueKey, implementation.stopVPN());
        call.resolve(returnValue);
    }
}
