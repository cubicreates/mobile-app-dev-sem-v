package com.example.sem5;

import android.content.Context;
import android.provider.Settings;

public class AirplaneModeHelper {

    public static final int COLOR_ACTIVE = 0xFF2E7D32; // Green
    public static final int COLOR_OFF = 0xFFC62828;    // Red

    /**
     * Checks if Airplane Mode is currently enabled.
     *
     * @param context Application or Activity context
     * @return true if Airplane Mode is enabled, false otherwise
     */
    public static boolean isAirplaneModeOn(Context context) {
        if (context == null) {
            return false;
        }
        return Settings.Global.getInt(
                context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON,
                0
        ) != 0;
    }

    /**
     * Returns the banner status label.
     *
     * @param isActive whether airplane mode is currently active
     * @return display label for the banner
     */
    public static String getStatusText(boolean isActive) {
        return isActive ? "Airplane Mode: Active" : "Airplane Mode: Off";
    }

    /**
     * Returns the banner color based on state.
     *
     * @param isActive whether airplane mode is currently active
     * @return ARGB color integer (green for active, red for off)
     */
    public static int getStatusColor(boolean isActive) {
        return isActive ? COLOR_ACTIVE : COLOR_OFF;
    }
}
