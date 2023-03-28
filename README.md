# capacitor-plugin-moonbounce

A Capacitor plugin for the Moonbounce VPN library.

## Install

```bash
npm install capacitor-plugin-moonbounce
npx cap sync
```

## API

<docgen-index>

* [`startVPN(...)`](#startvpn)
* [`stopVPN()`](#stopvpn)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### startVPN(...)

```typescript
startVPN(options: { serverIP: string; serverPort: number; disallowedApp: string; excludeIP: string; }) => boolean
```

| Param         | Type                                                                                             |
| ------------- | ------------------------------------------------------------------------------------------------ |
| **`options`** | <code>{ serverIP: string; serverPort: number; disallowedApp: string; excludeIP: string; }</code> |

**Returns:** <code>boolean</code>

--------------------


### stopVPN()

```typescript
stopVPN() => boolean
```

**Returns:** <code>boolean</code>

--------------------

</docgen-api>
