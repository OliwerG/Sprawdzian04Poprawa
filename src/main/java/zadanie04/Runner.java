package zadanie04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        List<Person> personList = List.of(
                new Person("Oliwier", "Garbiński", "Brzozów", 18),
                new Person("Julia", "Nowak", "Rzeszów", 19),
                new Person("Michał", "Słoniewski", "Warszawa", 30),
                new Person("Kornelia", "Kowalska", "Sopot", 17),
                new Person("Waldemar", "Pietrzak", "Warszawa", 32));


        PersonService personService = new PersonService();
        Person oldestWoman = personService.getOldestWomenOrNoWomenException(personList);
        System.out.println("Najstarsza kobieta to: " + oldestWoman);

        double averageAge = personService.getAverageAgeAllPeople(personList);
        System.out.println("Średni wiek wszystkich osób wynosi: " + averageAge);

        double averageAgeMan = personService.getAverageAgeMen(personList);
        System.out.println("Średni wiek mężczyzn wynosi: " + averageAgeMan);

        double averageAgeWoman = personService.getAverageAgeWoman(personList);
        System.out.println("Średni wiek kobiet wynosi: " + averageAgeWoman);

        String citiesWithMostPeople = String.valueOf(personService.getCitiesWithTheMostEmployees(personList));
        System.out.println("Miasto z największą liczbą osób z listy to: " + citiesWithMostPeople);

        String cities = String.valueOf(personService.getDifferentCities(personList));
        System.out.println("Wszystkie różne miasta z listy to: " + cities);

//        double person = personService.getAggregatesGender(personList, "");
//        System.out.println(person);


    }
}
