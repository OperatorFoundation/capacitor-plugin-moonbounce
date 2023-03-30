import { WebPlugin } from '@capacitor/core';

import type { MoonbounceVPNPlugin } from './definitions';

export class MoonbounceVPNWeb extends WebPlugin implements MoonbounceVPNPlugin {
  constructor() {
    super();
  }

  async startVPN(options: {
    serverIP: string;
    serverPort: number;
    disallowedApp: string;
    excludeIP: string;
  }): Promise<{ started: boolean }> {
    console.error('startVPN was called with the following options:');
    console.error('server IP: ' + options.serverIP);
    console.error('server port: ' + options.serverPort);
    console.error('disallowedApp: ' + options.disallowedApp);
    console.error('exclude IP: ' + options.excludeIP);
    console.error('MoonbounceVPN is not available for web.');
    return { started: false };
  }

  async stopVPN(): Promise<{ stopped: boolean }> {
    console.error('stopVPN was called');
    console.error('MoonbounceVPN is not available for web.');
    return { stopped: false };
  }
}
