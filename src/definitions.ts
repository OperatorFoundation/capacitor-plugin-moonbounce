export interface MoonbounceVPNPlugin {
  startVPN(options: {serverIP: string, serverPort: number, disallowedApp: string, excludeIP: string}): boolean;
  stopVPN(): boolean;
}
