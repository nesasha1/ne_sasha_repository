package javacroc.matveeva.task12;

public class Example extends TernaryOperator{

    public static void main(String[] args) {

        // Проверка четности/нечетности числа
        int number = 10;
        String result1 = ternaryOperator(number, n -> n % 2 == 0, n -> " четное", n -> " нечетное");
        System.out.println("Число " + number + " -" + result1);

        // Проверка возраста
        int age = 25;
        String result3 = ternaryOperator(age, a -> a >= 18, a -> "совершеннолетний", a -> "несовершеннолетний");
        System.out.println("Этот человек - "+ result3);
    }

}
