package stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringProblem {
    public static void main(String[] args) {
        String string="furkan";
        String collect = IntStream.range(0,string.length())
                .map(i -> string.charAt(string.length() - 1 - i))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(collect);
    }
}
