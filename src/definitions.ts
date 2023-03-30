export interface MoonbounceVPNPlugin {
  startVPN(options: {
    serverIP: string;
    serverPort: number;
    disallowedApp: string;
    excludeIP: string;
  }): Promise<{ started: boolean }>;
  stopVPN(): Promise<{ stopped: boolean }>;
}
