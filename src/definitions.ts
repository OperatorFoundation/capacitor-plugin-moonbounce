export interface MoonbounceVPNPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  startVPN(options: {serverIP: string, serverPort: number, disallowedApp: string, excludeIP: string}): Promise<{ connected: boolean}>
}
