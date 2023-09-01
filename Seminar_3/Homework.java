import java.io.*;
import java.nio.file.FileSystemException;
import java.util.Scanner;

public class Homework implements AutoCloseable {
    public static void main(String[] args) throws IOException {

        try {
            newPerson();
            System.out.println("Создана новая запись");
        } catch (FileSystemException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void newPerson() throws Exception {
        String[] array = scanText();

        String fileData = checkFields(array);

        writeIntoFile(array, fileData);

    }

    private static String[] scanText() throws WrongCountException {
        System.out.println("Введите фамилию, имя, отчество, номер телефона, разделенные пробелом");

        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        scan.close();

        String[] array = text.split(" ");
        if (array.length != 4) {
            throw new WrongCountException("Введено неверное количество параметров");
        }
        return array;
    }

    private static String checkFields(String[] array) throws FormatException {
        if (!array[0].matches("^[а-яА-Я]*$")) {
            throw new FormatException("Неверный формат фамилии");
        }

        if (!array[1].matches("^[а-яА-Я]*$")) {
            throw new FormatException("Неверный формат имени");
        }

        if (!array[2].matches("^[а-яА-Я]*$")) {
            throw new FormatException("Неверный формат отчества");
        }

        int phone;
        try {
            phone = Integer.parseInt(array[3]);
        } catch (Exception e) {
            throw new FormatException("Неверный формат телефона");
        }

        String fileData = String.format("<%s><%s><%s><%d>", array[0], array[1], array[2], phone);
        return fileData;
    }

    private static void writeIntoFile(String[] array, String fileData) throws FileSystemException {
        String fileName = array[0] + ".txt";
        File file = new File(fileName);

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (file.length() > 0) {
                fileWriter.write('\n');
            }
            fileWriter.write(fileData);
        } catch (IOException e) {
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }
    }

    public void close() throws Exception {
    }
}

class WrongCountException extends Exception {
    public WrongCountException(String s) {
        super(s);
    }
}

class FormatException extends Exception {
    public FormatException(String s) {
        super(s);
    }
}
