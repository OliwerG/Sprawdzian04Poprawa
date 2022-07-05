package zadanie01;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinMaxService {
    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        LinkedList<T> linkedList = new LinkedList<>(elements);
        Collections.sort(linkedList);
        return new MinMax<>(linkedList.getFirst(), linkedList.getLast());
    }
}
