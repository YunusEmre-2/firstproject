package quiz;
import java.io.*;
import java.util.*;

public class quiz1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Bir sayı girin (Çıkmak için 'Exit' yazın): ");
        String input = scanner.nextLine();
        
        while (!input.equalsIgnoreCase("Exit")) {
            try {
                int limit = Integer.parseInt(input);
                System.out.println("Armstrong Sayıları:");
                for (int i = 1; i <= limit; i++) {
                    if (isArmstrong(i)) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();

                System.out.println("Emirp Sayıları:");
                for (int i = 1; i <= limit; i++) {
                    if (isEmirp(i)) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz sayı, lütfen geçerli bir sayı girin.");
            }

            System.out.print("Bir sayı girin (Çıkmak için 'Exit' yazın): ");
            input = scanner.nextLine();
        }

        scanner.close();
    }

    public static boolean isArmstrong(int num) {
        int sum = 0, temp = num, n = String.valueOf(num).length();

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, n);
            temp /= 10;
        }

        return sum == num;
    }

    public static boolean isEmirp(int num) {
        if (!isPrime(num)) return false;
        int reversed = reverseNumber(num);
        return num != reversed && isPrime(reversed);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}
