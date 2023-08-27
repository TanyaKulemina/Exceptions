import java.util.Scanner;

public class Homework_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число:");
        String number1 = scanner.nextLine();

        while (checkFloat(number1) == false) {
            System.out.println("Введите дробное число:");
            number1 = scanner.nextLine();
        }

        scanner.close();
    }

    public static boolean checkFloat(String number) {
        try {
            System.out.printf("Указанное значение: %f", Float.parseFloat(number));
            return true;
        } catch (NumberFormatException e) {
            System.out.printf("Необходимо ввести дробное число, а не %s\n", number);
            return false;
        }
    }
}
