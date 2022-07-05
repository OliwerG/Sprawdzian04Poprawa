package zadanie04;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService {

    public Person getOldestWomenOrNoWomenException(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getFirstname().endsWith("a"))
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new NoWomanException("No woman found"));
    }

    public double getAverageAgeAllPeople(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }

    public double getAverageAgeMen(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> !x.getFirstname().endsWith("a"))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }

    public double getAverageAgeWoman(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getFirstname().endsWith("a"))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }

    //Nie wiem jak to zrobić :/
    public double getAggregatesGender(List<Person> personList, String gender) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getFirstname().endsWith("a"))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);

    }

    public List<String> getCitiesWithTheMostEmployees(List<Person> employeeList) {
        Set<Map.Entry<String, Long>> entries = Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getCity()))
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .entrySet();

        long max = entries.stream()
                .mapToLong(e -> e.getValue())
                .max()
                .orElse(0);

        List<String> collect = entries.stream()
                .filter(e -> e.getValue() == max)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        return collect;
    }

    public List<String> getDifferentCities(List<Person> personList) {
        Set<Map.Entry<String, Long>> entries = Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getCity()))
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .entrySet();

        long max = entries.stream()
                .mapToLong(e -> e.getValue())
                .max()
                .orElse(0);

        List<String> collect = entries.stream()
                .filter(e -> e.getValue() != max + max)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        return collect;
    }
}