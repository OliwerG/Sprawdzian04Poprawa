package zadanie01;

import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {
        List<String> stringList = List.of("Bmw", "Ferrari", "Bugatti", "Lamborghini");

        MinMax<String> minAndMax = MinMaxService.getMinAndMax(stringList);
        System.out.println(minAndMax);
    }
}
