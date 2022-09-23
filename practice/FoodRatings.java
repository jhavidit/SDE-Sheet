package practice;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;


class FoodRatings {

    static class Foods {
        String c;
        int r;

        Foods(String c, int r) {
            this.c = c;
            this.r = r;
        }
    }


    HashMap<String, Foods> hm;
    TreeMap<String, TreeMap<Integer, TreeSet<String>>> tm;

    public FoodRatings(String[] foods, String[] c, int[] r) {

        hm = new HashMap<>();
        tm = new TreeMap<>();
        for (int i = 0; i < foods.length; i++) {
            hm.put(foods[i], new Foods(c[i], r[i]));

            if (!tm.containsKey(c[i])) {
                tm.put(c[i], new TreeMap<>());
            }
            if (!tm.get(c[i]).containsKey(r[i]))
                tm.get(c[i]).put(r[i], new TreeSet<>());
            tm.get(c[i]).get(r[i]).add(foods[i]);
        }

    }

    public void changeRating(String food, int newRating) {
        int oldRating = hm.get(food).r;
        String c = hm.get(food).c;
        hm.put(food, new Foods(c, newRating));
        tm.get(c).get(oldRating).remove(food);
        if(tm.get(c).get(oldRating).isEmpty())
            tm.get(c).remove(oldRating);
        if (!tm.get(c).containsKey(newRating))
        tm.get(c).put(newRating, new TreeSet<>());
        tm.get(c).get(newRating).add(food);

    }

    public String highestRated(String cuisine) {
        return tm.get(cuisine).get(tm.get(cuisine).lastKey()).first();
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
