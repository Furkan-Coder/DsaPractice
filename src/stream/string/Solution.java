package stream.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        String string = "furkan";
        String collect = IntStream.range(0, string.length())
                .map(i -> string.charAt(string.length() - 1 - i))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(collect);

//        Count strings longer than 4 characters
        List<String> words = Arrays.asList("hi", "hello", "hey", "world", "ok", "java");
        long result = words.stream()
                .filter(e -> e.length() > 4)
                .count();
        System.out.println(result);

//        Convert list of names to uppercase
        List<String> name = words.stream()
                .map(String::toUpperCase).toList();
        System.out.println(name);

//        Get distinct elements from a list
        List<Integer> nums = Arrays.asList(1, 3, 2, 1, 4, 3, 5, 2);
        Set<Map.Entry<Integer, Long>> freqCount = nums.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .collect(Collectors.toSet());
        System.out.println(freqCount);
        List<Integer> distelement = nums.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(distelement);
//        Sum of all even numbers in a list
        Integer sum = nums.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

//        Find first name starting with 'A'
        List<String> names = Arrays.asList("Bob", "Alice", "Anna", "Carol");
        List<String> startWithA = names.stream()
                .filter(c -> c.startsWith("A")).collect(Collectors.toList());
        System.out.println(startWithA);
//        Find Nth longest string (Sony: 3rd longest)
        Optional<String> third = words.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .distinct()
                .skip(2)
                .findFirst();
        System.out.println(third);

//        Count word frequency in a sentence
        String sentence = "the cat sat on the mat the cat";
        Set<Map.Entry<String, Long>> entries = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet();
        entries.stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .forEach(e->System.out.println(e.getKey()+" : "+e.getValue()));

        String name1="furkan";
//        For above string count frequency of characters using map in streams
      Map<Character,Long>freq=  name1.chars()
              .mapToObj(e->(char)e)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(freq);

        String name2="furkan ali";
//        (there is a space between the two names). Now count the characters except the space using streams
       Map<Character,Long>freq1= name2.chars()
                .filter(c->c !=' ')
                .mapToObj(e->(char)e)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(freq1);

//        WAJP to group by list of strings using streams based on string length
        List<String>names1=Arrays.asList("furkan","Farhan","Sandeep", "Swati","Varshini");
        Map<Integer, List<String>> collect1 = names1.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(collect1);
    }


}