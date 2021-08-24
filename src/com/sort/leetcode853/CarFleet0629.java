package com.sort.leetcode853;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet0629 {


    private class Car {
        private int position;
        private int target;
        private int speed;
        private double cost;

        public Car(int position, int target, int speed) {
            this.position = position;
            this.target = target;
            this.speed = speed;
            cost = (target - position) * 1.0 / speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {


        int len = speed.length;

        Car[] cars = new Car[len];
        for (int i = 0; i < len; i++) {
            cars[i] = new Car(position[i], target, speed[i]);
        }

        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {

                if (o1.position > o2.position) {
                    return -1;
                } else {

                    return 1;
                }
            }
        });


        int count = cars.length;
        for (int i = 0; i < len - 1; i++) {
            Car before = cars[i];
            Car after = cars[i + 1];

            if (before.cost >= after.cost) {
                count--;
                cars[i + 1] = before;
            }
        }
        return count;

    }


}
