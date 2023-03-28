 package org.operatorfoundation.plugins.moonbounce;

 import android.content.ComponentName;
 import android.content.Context;
 import android.util.Log;

 import com.getcapacitor.JSObject;
 import com.getcapacitor.PluginCall;

 import org.operatorfoundation.moonbouncevpnservice.MoonbounceJava;

 public class MoonbounceVPN
 {
     public MoonbounceJava vpnService;
     public String stopVPNReturnValueKey = "vpnStopped";
     public String startVPNReturnValueKey = "vpnStarted";
     public String startVPNIPKey = "serverIP";
     public String startVPNPortKey = "serverPort";
     public String startVPNDisallowedAppKey = "disallowedApp";
     public String startVPNExcludeIPKey = "excludeIP";

     public Boolean startVPN(Context context, String ipAddress, Integer port, String disallowedApp, String excludeIP)
     {
         vpnService = new MoonbounceJava(context, ipAddress, port, disallowedApp, excludeIP);
         ComponentName serviceName = vpnService.startVPN();
         return serviceName != null;
     }

     public boolean stopVPN()
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

         return serviceStopped;
     }
 }
