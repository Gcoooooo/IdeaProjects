import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        boolean[] nums = new boolean[n];

        for (int i = 0; i < n; i++) {
            nums[i] = true;
        }

        nums[0] = false;
        nums[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (!nums[i]) continue;
            for (int j = i * i; j <= n; j += i) nums[j] = false;
        }

        int mx = 1;
        for (long i = 2; i <= n; i++) {
            if (!nums[i]) continue;
            long b = i;
            while (b * i <= n) b *= i;
            mx = Math.max(mx, (int) b);
        }

        System.out.print(mx * 2);
    }
}

