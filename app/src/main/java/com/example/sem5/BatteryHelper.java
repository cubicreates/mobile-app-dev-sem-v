package com.example.sem5;

public class BatteryHelper {

    /**
     * Calculates the battery percentage from raw level and scale values.
     *
     * @param level Current battery level from BatteryManager.EXTRA_LEVEL
     * @param scale Maximum battery scale from BatteryManager.EXTRA_SCALE
     * @return Battery percentage (0-100), or -1 if inputs are invalid
     */
    public static int calculatePercentage(int level, int scale) {
        if (level < 0 || scale <= 0) {
            return -1;
        }
        int percentage = (int) ((level / (float) scale) * 100);
        return Math.min(100, Math.max(0, percentage));
    }
}
