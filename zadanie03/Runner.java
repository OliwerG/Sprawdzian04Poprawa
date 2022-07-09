package zadanie03;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(100, 200, 300, 400, 500, 600);
        List<Integer> integerList2 = Arrays.asList(100, 200, 300);
        List<Integer> integerList3 = Arrays.asList(100, 200, 300, null, 500, 600);
        List<Integer> result = returnFiveBiggestElements(integerList);
        List<Integer> result2 = returnFiveBiggestElements(integerList2);
        List<Integer> result3 = returnFiveBiggestElements(integerList3);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);

    }

    private static List<Integer> returnFiveBiggestElements(Collection<Integer> elements) {
        List<Integer> sortedList = Optional.ofNullable(elements)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());

        return (sortedList.size() < 5) ? Collections.EMPTY_LIST : sortedList;

    }

}

