
import { WebPlugin } from '@capacitor/core';
import type { MoonbounceVPNPlugin } from './definitions';

export class MoonbounceVPNWeb extends WebPlugin implements MoonbounceVPNPlugin 
{
  constructor() 
  {
    super();
  }

  startVPN(options: { serverIP: string; serverPort: number; disallowedApp: string; excludeIP: string; }): boolean
  {
    console.log('startVPN was called with the following options:');
    console.log('server IP: ' + options.serverIP);
    console.log('server port: ' + options.serverPort);
    console.log('disallowedApp: ' + options.disallowedApp);
    console.log('exclude IP: ' + options.excludeIP);
    console.log('MoonbounceVPN is not available for web.');
    return false;
  }

  stopVPN(): boolean
  {
    console.log('stopVPN was called');
    console.log('MoonbounceVPN is not available for web.');
    return false;
  }
}
