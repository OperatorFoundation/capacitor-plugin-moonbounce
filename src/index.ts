import { registerPlugin } from '@capacitor/core';

import type { MoonbounceVPNPlugin } from './definitions';

const MoonbounceVPN = registerPlugin<MoonbounceVPNPlugin>('MoonbounceVPN', {
  web: () => import('./web').then(m => new m.MoonbounceVPNWeb()),
});

export * from './definitions';
export { MoonbounceVPN };
