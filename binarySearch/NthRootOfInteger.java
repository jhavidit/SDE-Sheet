package binarySearch;

public class NthRootOfInteger {

    public double nthRoot(int n, int m) {
        double start = 1;
        double end = m;
        double e = 1e-6;
        while ((end - start) > e) {
            double mid = (start + end) / 2.0;
            if (Math.pow(mid, n) < m) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args){
        NthRootOfInteger obj = new NthRootOfInteger();
        System.out.println(obj.nthRoot(2,9));
    }


}
