package zadanie02;

import java.util.Optional;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj imię: ");
        Optional<String> name = Optional.ofNullable(scanner.nextLine());
        name.ifPresentOrElse(x -> {
            System.out.println("Długość:  " + name.get().length());
        }, () -> System.out.println(0));
        System.out.print("\n Podaj pesel: ");
        Optional<String> pesel = Optional.ofNullable(scanner.nextLine());
        checkPesel(String.valueOf(pesel));

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
