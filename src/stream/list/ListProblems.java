package stream.list;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListProblems {
    public static void main(String[] args) {
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> collect = nested.stream().flatMap(Collection::stream)
                .distinct().sorted()
                .collect(Collectors.toList());
        System.out.println(collect);

//        Write the duplicate elements from the list using streams
//        Input: (1,2,3,4,5,1,2)
//        Output: (1,2)
        List<Integer>list = Arrays.asList(
                1,2,3,4,5,1,2
        );
        List<Integer> list1 = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(list1);
    }
}
