package zadanie05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws ParseException, InvalidBirthDateException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Podaj datę urodzenia w formacie dd.MM.yyyy: ");
        Scanner scanner = new Scanner(System.in);
        String birthDay = scanner.nextLine();
        Date birthDate = simpleDateFormat.parse(birthDay);
        CalculatorAge obj = new CalculatorAge();
        obj.calculatorAge(birthDate);
        scanner.close();
    }
}

