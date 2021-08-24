package com.binary_search.leetcode1011;

import junit.framework.TestCase;

public class ShipWithinDaysTest extends TestCase {

    public void testShipWithinDays() {
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        shipWithinDays.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
    }

    public void testShipWithinDays1() {
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        shipWithinDays.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1);
    }
}