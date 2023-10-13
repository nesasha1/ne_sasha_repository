/*Напишите программу,
которая для заданного числа от 2 до 10^10 (10 000 000 000)
проверит является ли это число простым.
Вывести на экран “Простое” или “Составное” число.*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number from 2 to 10 000 000 000: ");
        int number = in.nextInt();

            int i = 0;
            boolean number_ver = true;

            while (i++ < number) {
                if (number % i == 0 && number != i && i != 1) {
                    number_ver = true;
                    break;
                } else {
                    number_ver = false;
                }
            }

            int j = 0;
            boolean number_twin_ver1 = true;

            if (!number_ver) {
                while (j++ < (number + 2)) {
                    if ((number + 2) % j == 0 && (number + 2) != j && j != 1) {
                        number_twin_ver1 = true;
                        break;
                    }
                    else {
                        number_twin_ver1 = false;
                    }
                }
            }

        int k = 0;
        boolean number_twin_ver2 = true;

        if (!number_ver) {
            while (k++ < (number - 2)) {
                if ((number - 2) % k == 0 && (number - 2) != k && k != 1) {
                    number_twin_ver2 = true;
                    break;
                }
                else {
                    number_twin_ver2 = false;
                }
            }
        }

            if (!number_ver) {
                System.out.print("Простое число");
//                System.out.print("\n" + number % i + "\n");
//                System.out.print(number + "\n");
//                System.out.print(i + "\n");
                if (!number_twin_ver1) {
                    System.out.print("\n" + " Число-близнец");
                }
                else if (!number_twin_ver2) {
                    System.out.print("\n" + " Число-близнец");
                }
           } else {
               System.out.print("Составное число");
//               System.out.print("\n" + number % i + "\n");
//               System.out.print(number + "\n");
//               System.out.print(i + "\n");\
            }

        in.close();
    }

}