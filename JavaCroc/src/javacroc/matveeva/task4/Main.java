package javacroc.matveeva.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите значения: ");
        int FirstElement = in.nextInt();
        int Difference = in.nextInt();
        int NumberOfElements = in.nextInt();
        in.close();

        long i = 0;
        long SumOfElements = FirstElement;

        while (i++ < (NumberOfElements - 1)) {
            SumOfElements += (FirstElement + (Difference * i));
        }

        System.out.print("Сумма арифметической прогрессии: " + SumOfElements);

    }
}