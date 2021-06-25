package com.sort.leetcode853;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet0620 {

    private class Car {
        private int position;
        private int speed;
        private int target;

        private double cost;

        public Car(int target, int position, int speed) {
            this.position = position;
            this.speed = speed;
            this.target = target;
            cost = (target - position) * 1.0 / speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {

        int len = position.length;
        Car[] cars = new Car[len];
        for (int i = 0; i < len; i++) {
            cars[i] = new Car(target, position[i], speed[i]);
        }

        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.position - o1.position;
            }
        });

        int ans = len;
        for (int i = 0; i < len - 1; i++) {
            Car before = cars[i];
            Car after = cars[i + 1];

            if (before.cost >= after.cost) {
                ans--;
                cars[i + 1] = before;
            }

        }

        return ans;
    }
}
