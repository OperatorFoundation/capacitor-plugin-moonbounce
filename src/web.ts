
import { WebPlugin } from '@capacitor/core';
import type { MoonbounceVPNPlugin } from './definitions';

export class MoonbounceVPNWeb extends WebPlugin implements MoonbounceVPNPlugin 
{

  constructor() 
  {
    super();
  }

  startVPN(options: { serverIP: string; serverPort: number; disallowedApp: string; excludeIP: string; }): Promise<{ vpnStarted: boolean}> 
  {
    console.log('startVPN was called with the following options:');
    console.log('server IP: ' + options.serverIP);
    console.log('server port: ' + options.serverPort);
    console.log('disallowedApp: ' + options.disallowedApp);
    console.log('exclude IP: ' + options.excludeIP);

    throw this.unavailable('MoonbounceVPN is not available for web.');
  }

  stopVPN(): Promise<{ vpnStopped: boolean; }> 
  {
    console.log('stopVPN was called');
    throw this.unavailable('MoonbounceVPN is not available for web.');
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
