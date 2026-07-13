package stream.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {


//   1. Using streams to filter  even numbers from a list.
        List<Integer> list = Arrays.asList(2, 4, 5, 7, 3, 9, 1);

        list.stream().filter(e -> e % 2 == 0)
                .forEach(System.out::println);
        list.stream().filter(e->e%2 !=0)
                .forEach(System.out::println);

        //    Using Streams to find the maximum value in a list of integers.
        list.stream().max(Integer::compareTo)
                .ifPresent(System.out::println);
        list.stream().min(Integer::compareTo)
                .ifPresent(System.out::println);
//    Sort a list of integer in ascending order
        list.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
//    count the elements in a list that are greater than 5.
        long count = list.stream().filter(e -> e > 5).count();
        System.out.println(count);
//    retrieve all distinct element from a list.
        list.stream().distinct().forEach(System.out::println);
//    skip the first two element and return rest all
        list.stream().skip(2).forEach(System.out::println);
//    Using stream remove duplicate.
//    Using stream calculate the sum of integers.
        list.stream().reduce(Integer::sum).ifPresent(System.out::println);
        
        String string = "swiss";
//    convert string to uppercase.
        System.out.println(string.toUpperCase());
        string.chars()
                .mapToObj(e->(char)e)
                .map(Character::toUpperCase).forEach(System.out::println);
//    Given a list of strings, write a program to count the number of strings that start with a specific character
        List<String>names=Arrays.asList("apple","banana","kivi","gavava","jackfruit","watermelon");
        long a = names.stream().filter(e -> e.startsWith("a")).count();
        System.out.println(a);
//    Write a java program to fin d average of list of floating point numbers using streams.
//    Given a list of strings, write a program to concatinate all the strings using streams.
//    Write a program to check if elements in a list satisfy a given conditon using stream.
//    Given a list of objects, write a program to sort the objects based  on a specific atributes using streams.

//    Given a sentence, find and print the frequency of each word.
        String sentence="hello java world";
        Map<String, Long> collect = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
//    Given a list of integers, find out all the numbers starting with 1.
//    Given a list of names, group them by their first letter, and then count the number of names in each group.
        Map<Character, Long> collect1 = names.stream()
                .collect(Collectors.groupingBy(e -> e.charAt(0), Collectors.counting()));
        System.out.println(collect1);

//    Find and print the duplicate number in an array if it contains multiple duplicate.
//    REmove duplicate from a given array in java.
//    Given a list of words, filter and print the palindrome.
//            How do you merge two sorted arrays into a single sorted array.
//    Given two list of strings, concatenate them and remove duplicate.
//    Student grade Classification -70 and above pass
//    Given a list of Strings,sort them according to increasing order of their length.
//            How do you find the intersction of two array.
//    Given the String[] group the string based on the middle character.
//    Find the union of two list of integers.
//    FInd the kth smallest element inside a list.
//    Remove all non -numeric character from list.
//    Find and print strings containing only digits.
//    Find intersection of two list.
//    Generates the first 10numbers of the fibonacci sequence.
//    Converts a list of integers to a list of their squares.
//    Transform person object into single string.
//    Given a list of string group them by their first character and countthe number of strings ineach group.
//    WAJP using stream API to print the most repeating character in the string :
//    Input:    String s ="Proggrrmmiing" output : r g
//    Write a program to fetch the 5th element in a list using Stream API.

    }
}
