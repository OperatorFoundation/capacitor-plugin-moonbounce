package org.operatorfoundation.plugins.moonbounce;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.operatorfoundation.moonbouncevpnservice.*;

@CapacitorPlugin(name = "MoonbounceVPN")
public class MoonbounceVPNPlugin extends Plugin {

    private MoonbounceVPN implementation = new MoonbounceVPN();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");



        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public boolean startVPN(PluginCall call) {
        String ipAddress = call.getString("ipString");
        Integer port = Integer.valueOf(call.getString("port"));

        // TODO: Context needs to be provided by the calling app
//        MoonbounceJava vpnService = new MoonbounceJava(ipAddress, port);

        JSObject returnValue = new JSObject();
        returnValue.put("connected", true);
        call.resolve(returnValue);
        return false;
    }
}
