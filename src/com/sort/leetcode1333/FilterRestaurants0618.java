package com.sort.leetcode1333;

import java.util.ArrayList;
import java.util.List;

public class FilterRestaurants0618 {

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
        Restaurant[] arr = new Restaurant[len];
        int index = 0;
        for (int i = 0; i < len; i++) {

            if (restaurants[i][3] > maxPrice || restaurants[i][4] > maxDistance) {
                continue;
            }


            if ((veganFriendly == 1 && restaurants[i][2] == 1) || veganFriendly == 0) {
                arr[index++] = new Restaurant(restaurants[i][0], restaurants[i][1]);
            }
        }

        dumpSort(arr, 0, index - 1);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            ans.add(arr[i].id);
        }

        return ans;
    }

    private void dumpSort(Restaurant[] arr, int start, int end) {
        buildDump(arr, end);

        for (int i = end; i > 0; i--) {
            swap(arr, i, 0);
            adjustDump(arr, 0, i - 1);
        }
    }

    private void buildDump(Restaurant[] arr, int end) {
        int len = end + 1;
        for (int i = len / 2; i >= 0; i--) {
            adjustDump(arr, i, end);
        }

    }

    private void adjustDump(Restaurant[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int maxIndex = start;

        int lefIndex = start * 2;


        if (lefIndex <= end && check(arr, lefIndex, maxIndex)) {
            maxIndex = lefIndex;
        }

        int rightIndex = start * 2 + 1;
        if (rightIndex <= end && check(arr, rightIndex, maxIndex)) {
            maxIndex = rightIndex;
        }

        if (maxIndex != start) {
            swap(arr, maxIndex, start);
            adjustDump(arr, maxIndex, end);
        }

    }

    private boolean check(Restaurant[] arr, int aIndex, int bIndex) {
        Restaurant a = arr[aIndex];
        Restaurant b = arr[bIndex];
        if (a.rating > b.rating) {
            return false;
        } else if (a.rating == b.rating) {
            return a.id < b.id;
        } else {
            return true;
        }

    }


    private void swap(Restaurant[] arr, int x, int y) {
        Restaurant tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }


}
