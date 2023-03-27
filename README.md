# capacitor-plugin-moonbounce

A Capacitor plugin for the Moonbounce VPN library.

## Install

```bash
npm install capacitor-plugin-moonbounce
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`startVPN(...)`](#startvpn)
* [`stopVPN()`](#stopvpn)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### startVPN(...)

```typescript
startVPN(options: { serverIP: string; serverPort: number; disallowedApp: string; excludeIP: string; }) => Promise<{ vpnStarted: boolean; }>
```

| Param         | Type                                                                                             |
| ------------- | ------------------------------------------------------------------------------------------------ |
| **`options`** | <code>{ serverIP: string; serverPort: number; disallowedApp: string; excludeIP: string; }</code> |

**Returns:** <code>Promise&lt;{ vpnStarted: boolean; }&gt;</code>

--------------------


### stopVPN()

```typescript
stopVPN() => Promise<{ vpnStopped: boolean; }>
```

**Returns:** <code>Promise&lt;{ vpnStopped: boolean; }&gt;</code>

--------------------

</docgen-api>
