package javacroc.matveeva.task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number from 2 to 10 000 000 000: ");
        long number = in.nextLong();
        in.close();

            long i = 1;
            boolean IsComposite = true;

            while (i++ < number) {
                if (number % i == 0 && number != i) {
                    IsComposite = true;
                    break;
                } else {
                    IsComposite = false;
                }
            }

            long j = 1;
            boolean IsFollowingPrime = true;
            boolean IsPreviousPrime = true;

            if (!IsComposite) {
                while (j++ < (number + 2)) {
                    if ((number + 2) % j == 0 && (number + 2) != j) {
                        IsFollowingPrime = false;
                        break;
                    }
                } while (j++ < (number - 2)) {
                    if ((number - 2) % j == 0 && (number - 2) != j) {
                        IsPreviousPrime = false;
                        break;
                    }
                }
            }

            if (!IsComposite) {
                System.out.print("Prime number");

                if (IsPreviousPrime || IsFollowingPrime) {
                    System.out.print("\n" + "Twin number");
                }

           } else {
               System.out.print("Composite number");
            }
    }

}