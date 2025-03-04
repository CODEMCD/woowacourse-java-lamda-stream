package techcourse.fp.mission;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {
    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

//        long count = 0;
//        for (String w : words) {
//            if (w.length() > 12) count++;
//        }
        return words.stream()
                .filter(w -> w.length() > 12)
                .count();
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
//        List<Integer> result = new ArrayList<>();
//        for(Integer number: numbers) {
//            result.add(2 * number);
//        }

        return numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
//        int result = 0;
//
//        for(Integer number: numbers) {
//            result += number;
//        }

        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream().filter(v -> v > 3).mapToInt(v -> v * 2).sum();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        System.out.println(words);
        System.out.println(words.size());
        // TODO 이 부분에 구현한다.
        words.stream()
                .distinct()
                .map(String::toLowerCase)
                .filter(word -> word.length() > 12)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .limit(100)
                .forEach(System.out::println);
    }
}
