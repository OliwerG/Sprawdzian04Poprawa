package zadanie02;

import java.util.Optional;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            System.out.println("\n Długość: " + name.length());
        } else
            System.out.println("\n Długość: 0");
        System.out.print("\n Podaj pesel: ");
        String s = scanner.nextLine();
        checkPesel(s);
        scanner.close();
    }

    public static void checkPesel(String pesel) throws InvalidPeselException {
        String birthdate = "";
        birthdate = pesel.substring(0, 6);

        Optional.ofNullable(pesel)
                .filter(x -> x.matches("\\d{11}"))
                .orElseThrow(() -> new InvalidPeselException("Nieprawidłowy pesel!"));

        System.out.println("Data urodzenia to: " + birthdate);

    }
}
