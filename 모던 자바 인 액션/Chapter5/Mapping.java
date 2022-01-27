package modenJavaInAction.char5;

import modenJavaInAction.char4.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static modenJavaInAction.char4.Dish.menu;

public class Mapping {
    public static void main(String[] args) {
        // map
        System.out.println("------------ map ------------");
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);
        System.out.println();

        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);
        System.out.println();

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(dishNameLengths);
        System.out.println();

        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(uniqueCharacters);
        System.out.println();

        // 퀴즈 5-2
        System.out.println("------------ quiz ------------");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(toList());
        System.out.println(squares);
        System.out.println();

        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(4, 5);
        List<int[]> pairs = nums1.stream()
                .flatMap(i -> nums2.stream()
                        .map(j -> new int[] {i, j}))
                .collect(toList());


    }
}
