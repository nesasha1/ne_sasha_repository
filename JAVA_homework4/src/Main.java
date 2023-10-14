import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner fe = new Scanner(System.in);
        System.out.print("Введите начальный элемент арифметической прогрессии: ");
        int first_elem = fe.nextInt();

        Scanner re = new Scanner(System.in);
        System.out.print("Введите разность арифметической прогрессии: ");
        int razn_elem = re.nextInt();

        Scanner ae = new Scanner(System.in);
        System.out.print("Введите кол-во членов арифметической прогрессии: ");
        int amount_elem = ae.nextInt();

        int i = 1;
        int sum_elem = first_elem;
        while (i++ < amount_elem) {
            sum_elem += razn_elem;
        }

        System.out.print("Сумма арифметической прогрессии: " + sum_elem);

    }
}