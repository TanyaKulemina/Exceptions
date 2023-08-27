import java.util.Scanner;

public class Homework_4 {
    public static void main(String[] args) throws StringNotNullException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        try {
            System.out.println(printString(str));
        } catch (StringNotNullException e) {
            System.out.printf("%s", e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String printString(String str) throws StringNotNullException {
        if (str.isEmpty())
            throw new StringNotNullException("Пустые строки вводить нельзя!", str);
        return str;
    }

    static class StringNotNullException extends Exception {

        public String string;

        public String getString() {
            return string;
        }

        public StringNotNullException(String message, String string) {
            super(message);
            this.string = string;
        }
    }
}
