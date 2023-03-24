package org.operatorfoundation.plugins.moonbounce;

import android.util.Log;
import org.operatorfoundation.moonbouncevpnservice.*;

public class MoonbounceVPN {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
