public class Q开根号 {

    /*
    对n开根号  使用二分法
     */
    public static double getSqrt(int n, double error){
        double start = 0;
        double end = n;
        double mid = start + (end - start) / 2.0;

        while (Math.abs(n - mid * mid) > error){
            if (n < mid * mid)
                end = mid;
            else
                start = mid;

            mid = start + (end - start) / 2.0;
        }
        return mid;
    }

    public static void main(String[] args){
        System.out.println(getSqrt(9, 0.00001));
    }

}
