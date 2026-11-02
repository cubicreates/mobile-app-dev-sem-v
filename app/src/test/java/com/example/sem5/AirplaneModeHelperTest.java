package com.example.sem5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirplaneModeHelperTest {

    @Test
    public void getStatusText_whenActive_returnsActiveText() {
        assertEquals("Airplane Mode: Active", AirplaneModeHelper.getStatusText(true));
    }

    @Test
    public void getStatusText_whenOff_returnsOffText() {
        assertEquals("Airplane Mode: Off", AirplaneModeHelper.getStatusText(false));
    }

    @Test
    public void getStatusColor_whenActive_returnsGreen() {
        assertEquals(AirplaneModeHelper.COLOR_ACTIVE, AirplaneModeHelper.getStatusColor(true));
    }

    @Test
    public void getStatusColor_whenOff_returnsRed() {
        assertEquals(AirplaneModeHelper.COLOR_OFF, AirplaneModeHelper.getStatusColor(false));
    }
}
