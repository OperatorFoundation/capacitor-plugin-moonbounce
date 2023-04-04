import { WebPlugin } from '@capacitor/core';

import { PermissionStatus } from './definitions';
import type { MoonbounceVPNPlugin } from './definitions';

export class MoonbounceVPNWeb extends WebPlugin implements MoonbounceVPNPlugin {
  constructor() {
    super();
  }

  async checkPermissions(): Promise<PermissionStatus>
  {
    throw this.unavailable('Moonbounce VPN API is not available in browser.');
  }
  
  async requestPermissions(): Promise<PermissionStatus> {
    throw this.unavailable('Moonbounce VPN API is not available in browser.');
  }

  async startVPN(options: {
    serverIP: string;
    serverPort: number;
    disallowedApp: string;
    excludeIP: string;
  }): Promise<void> {
    console.error('startVPN was called with the following options:');
    console.error('server IP: ' + options.serverIP);
    console.error('server port: ' + options.serverPort);
    console.error('disallowedApp: ' + options.disallowedApp);
    console.error('exclude IP: ' + options.excludeIP);
    throw this.unavailable('Moonbounce VPN API is not available in browser.');
  }

  async stopVPN(): Promise<void> {
    console.error('stopVPN was called');
    throw this.unavailable('Moonbounce VPN API is not available in browser.');
  }
}
