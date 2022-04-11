package array.day1;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> l = new ArrayList<>();
            if (i == 0) {
                l.add(1);

            } else if (i == 1) {
                l.add(1);
                l.add(1);
            } else {
                l.add(1);
                for (int j = 0; j < list.get(list.size() - 1).size() - 1; j++) {
                    l.add(list.get(list.size() - 1).get(j) + list.get(list.size() - 1).get(j + 1));
                }
                l.add(1);
            }
            list.add(l);


        }
        return list;
    }
    // TC - O(numRows^2) SC - O(numRows^2)


    public static void main(String[] args){
        System.out.println(generate(5));
    }

}
