/* Напишите короткую программу, которая выводит на экран числа от 1 до 100, каждое в новой строке.

        Вместо каждого числа, которое делится на 3, выводите ‘Fizz’.
        Вместо каждого числа, которое делится на 5, выводите ‘Buzz’.
        Вместо каждого числа, которое делится и на 3, и на 5, выводите ‘FizzBuzz’. */


public class Main {
    public static void main(String[] args) {
        int i = 0;
        while (i++ < 100) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.print(i);
            } else {
                if (i % 3 == 0)
                    System.out.print("Fizz");
                if (i % 5 == 0)
                    System.out.print("Buzz");
            }
            System.out.println();
        }
    }
}