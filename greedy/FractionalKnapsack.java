package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    static class ItemSort {
        int value, weight;
        double p;

        public ItemSort(int value, int weight, double p) {
            this.value = value;
            this.weight = weight;
            this.p = p;
        }
    }

    static double fractionalKnapsack(int w, Item[] arr, int n) {
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double r1 = (double) (o1.value) / (double) (o1.weight);
                double r2 = (double) (o2.value) / (double) (o2.weight);
                if (r1 < r2)
                    return 1;
                else if (r1 > r2)
                    return -1;
                return 0;
            }
        });
      double ans = 0;
        for (int i = 0; i < n; i++) {
            int weight = arr[i].weight;
            if (w >= weight) {
                ans += arr[i].value;
                w -= weight;
            } else {
                ans += (((double) w / (double) weight) * (double) arr[i].value);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        Item[] arr = {
                new Item(60, 10), new Item(100, 20), new Item(120, 30)
        };
        System.out.println(fractionalKnapsack(50, arr, 3));


    }

}
