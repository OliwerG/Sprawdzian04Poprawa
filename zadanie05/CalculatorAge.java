package zadanie05;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalculatorAge {

    public void calculatorAge(Date myBirthDate) {
        Calendar myBirthDay = Calendar.getInstance();
        myBirthDay.setTimeInMillis(myBirthDate.getTime());

        long currentTime = System.currentTimeMillis();
        Calendar todayDate = Calendar.getInstance();
        todayDate.setTimeInMillis(currentTime);

        if (myBirthDay.getTimeInMillis() > todayDate.getTimeInMillis()) {
            throw new InvalidBirthDateException("Wrong Date!");
        }

        Duration differenceInDays = Duration.between(myBirthDate.toInstant(), todayDate.toInstant());

        LocalDate birthday = LocalDate.ofInstant(myBirthDay.toInstant(), ZoneId.systemDefault());
        LocalDate today = LocalDate.now();

        Period differenceInMonths = Period.between(birthday, today);

        Period age = Period.between(birthday, today);


        System.out.println("Liczba dni, których żyję to: " + differenceInDays.toDays());
        System.out.println("Liczba miesięcy, których żyję to: " + differenceInMonths.toTotalMonths());
        System.out.println("Liczba lat, których żyję to: " + age.getYears());

        int dayOfWeek = myBirthDay.get(GregorianCalendar.DAY_OF_WEEK);

        String weekday = String.valueOf(dayOfWeek - 1);
        weekday = weekday.replace("0", "Niedziela");
        weekday = weekday.replace("1", "Poniedziałek");
        weekday = weekday.replace("2", "Wtorek");
        weekday = weekday.replace("3", "Środa");
        weekday = weekday.replace("4", "Czwartek");
        weekday = weekday.replace("5", "Piątek");
        weekday = weekday.replace("6", "Sobota");

        System.out.println("Dzień tygodnia w którym się urodziłeś to: " + weekday);

        int cMonth = myBirthDay.get(Calendar.MONTH) + 1;
        int cYears = myBirthDay.get(Calendar.YEAR);
        if (myBirthDay.get(Calendar.DATE) > 13) ;
        cMonth = cMonth + 1;

        for (int i = 0; i <= 12; i++) {
            if (cMonth > 11) {
                cMonth = 0;
                cYears = cYears + 1;
            }
            myBirthDay.set(cYears, cMonth, 13);
            dayOfWeek = myBirthDay.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == 6) {
                System.out.println("Następny Piątek 13-nastego po moich urodzinach będzie w: " + myBirthDay.get(Calendar.DATE) + "\\" +
                        (cMonth + 1) + "\\" + cYears);
                break;
            }

            cMonth++;
            if (i == 12) {
                i = 0;
            }
        }
    }
}
