package array.day2;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingAndRepeatingNumber {

    public static Pair<Integer, Integer> missingAndRepeating(ArrayList<Integer> arr, int n) {
        int slow = arr.get(0);
        int fast = arr.get(0);
        do {
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        } while (slow != fast);
        fast = arr.get(0);
        while (slow != fast) {
            slow = arr.get(slow);
            fast = arr.get(fast);
        }
        int ans = (n * (n + 1)) / 2;
        int sum = 0;
        for (int it : arr) {
            sum += it;
        }
        int val = ans - sum;
        return new Pair<>(slow, slow + val);

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(4);
        arr.add(4);
        System.out.println(missingAndRepeating(arr, 5));
    }
}
