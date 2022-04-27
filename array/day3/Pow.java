package array.day3;

public class Pow {
    public double myPow(double x, int n) {
        boolean flag = false;
        if (n == 0)
            return 1.0;
        if (n < 0)
            flag = true;
        double a = recursive(x, Math.abs((long) n));
        if (flag)
            return 1 / a;
        else
            return a;
    }

    public double recursive(double x, long n) {
        if (n == 1)
            return x;
        if (n % 2 == 0)
            return recursive(x * x, n / 2);
        else return x * recursive(x, n - 1);
    }

    public static void main(String[] args) {
        Pow obj = new Pow();
        double x = 2.0;
        int n = 10;
        System.out.println(obj.myPow(x, n));
    }
}
