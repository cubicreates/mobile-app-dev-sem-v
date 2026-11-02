package com.example.sem5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BatteryHelperTest {

    @Test
    public void calculatePercentage_validValues_returnsCorrectPercentage() {
        assertEquals(85, BatteryHelper.calculatePercentage(85, 100));
        assertEquals(50, BatteryHelper.calculatePercentage(50, 100));
        assertEquals(0, BatteryHelper.calculatePercentage(0, 100));
        assertEquals(100, BatteryHelper.calculatePercentage(100, 100));
    }

    @Test
    public void calculatePercentage_scaledValues_returnsCorrectPercentage() {
        // e.g. level 500, scale 1000
        assertEquals(50, BatteryHelper.calculatePercentage(500, 1000));
    }

    @Test
    public void calculatePercentage_invalidValues_returnsNegativeOne() {
        assertEquals(-1, BatteryHelper.calculatePercentage(-1, 100));
        assertEquals(-1, BatteryHelper.calculatePercentage(50, 0));
        assertEquals(-1, BatteryHelper.calculatePercentage(50, -100));
    }
}
