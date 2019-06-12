import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long start = n + 1;
        long commonMultiple1 = 1; // 计算出前半部分的公倍数

        for (int i = 0; i < n; i++) {
            commonMultiple1 = commonMultiple(commonMultiple1, i + 1);
        }



        long commonMultiple2 = commonMultiple1; // 前半部分每次加上一个数后的公倍数
        long commonMultiple3 = start; // 后半部分每次加上一个数后的公倍数



        while (commonMultiple2 != commonMultiple3) { // 依次加入数并计算公倍数
            commonMultiple2 = commonMultiple(commonMultiple2, start);
            commonMultiple3 = commonMultiple(commonMultiple3, start + 1);
            start++;
        }

        System.out.print(start);
    }



    public static long commonMultiple(long[] a) {// 求多个数的最小公倍数
        long value = a[0];
        for (int i = 1; i < a.length; i++) {
            value = commonMultiple(value, a[i]);
        }
        return value;
    }

    //最大公约数
    public static long max(long m, long n){
        if(m < n){
            long temp = n;
            n = m;
            m = temp;
        }
        if(m%n == 0){
            return n;
        }
        return max(n,m%n);
    }

    //最小公倍数
    public static long commonMultiple(long m, long n){
        return m*n/max(m,n);
    }
}
