import type { PermissionState  } from "@capacitor/core";

export interface PermissionStatus {
  vpnConnection: PermissionState;
}

export interface MoonbounceVPNPlugin {

  checkPermissions(): Promise<PermissionStatus>;
  
  requestPermissions(): Promise<PermissionStatus>;
  
  startVPN(options: {
    serverIP: string;
    serverPort: number;
    disallowedApp: string;
    excludeIP: string;
  }): Promise<void>;

  stopVPN(): Promise<void>;
}
