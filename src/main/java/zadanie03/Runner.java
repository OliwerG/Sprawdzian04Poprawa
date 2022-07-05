package zadanie03;

import zadanie04.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(100, 200, 300, 400, 500, 600);
        List<Integer> integerList2 = List.of(100, 200, 300);
        List<Integer> result = returnFiveBiggestElements(integerList);
        List<Integer> result2 = returnFiveBiggestElements(integerList2);
        System.out.println(result);
        System.out.println(result2);

    }

    private static List<Integer> returnFiveBiggestElements(Collection<Integer> elements) {
        List<Integer> sortedList = (List<Integer>) Optional.ofNullable(elements)
                .orElse(Collections.EMPTY_LIST)
                .stream().sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());

        return (sortedList.size() < 5) ? Collections.EMPTY_LIST : sortedList;

    }

}

