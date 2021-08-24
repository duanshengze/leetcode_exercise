package com.sort.leetcode1333;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilterRestaurants0704 {


    private class Restaurant {
        private int id;
        private int rating;

        public Restaurant(int id, int rating) {
            this.id = id;
            this.rating = rating;
        }
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {


        int len = restaurants.length;

        List<Restaurant> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {

            if (restaurants[i][3] > maxPrice || restaurants[i][4] > maxDistance) {
                continue;
            }

            if (veganFriendly == 1 && restaurants[i][2] == 1) {
                list.add(new Restaurant(restaurants[i][0], restaurants[i][1]));
            }

            if (veganFriendly == 0) {
                list.add(new Restaurant(restaurants[i][0], restaurants[i][1]));
            }

        }

        Collections.sort(list, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {

                if (o1.rating < o2.rating) {
                    return 1;
                } else if (o1.rating > o2.rating) {
                    return -1;
                } else {
                    return Integer.compare(o2.id, o1.id);
                }
            }
        });

        List<Integer> res = new ArrayList<>();
        for (Restaurant r : list) {
            res.add(r.id);
        }
        return res;
    }
}
