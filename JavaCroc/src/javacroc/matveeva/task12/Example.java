package javacroc.matveeva.task12;

public class Example extends TernaryOperator{

    public static void main(String[] args) {

        // Пример 1
        int number = 10;
        String result = ternaryOperator(
                number,
                n -> n % 2 == 0,
                n -> String.valueOf(n * 2), // удвоение числа и преобразование в строку
                n -> String.valueOf(n + 1) // увеличение числа на 1 и преобразование в строку
        );
        System.out.println("Результат: " + result);

        // Пример 2
        String text = "быть или не быть";
        String textResult = ternaryOperator(
                text,
                str -> str.length() > 10,
                Example::extractSubstring, // метод-референс для статического метода extractSubstring
                String::toUpperCase // метод-референс для метода toUpperCase
        );
        System.out.println("Результат: " + textResult);
    }

    // метод для извлечения подстроки
    public static String extractSubstring(String str) {
        return str.substring(0, 7); // Вернуть первые 5 символов строки
    }
}


