package modenJavaInAction.char5;

import modenJavaInAction.char4.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static modenJavaInAction.char4.Dish.menu;

public class Filtering {
    public static void main(String[] args) {
        // 프레디케이트
        System.out.println("-------------------- 프레디케이트 --------------------");
        List<Dish> vegetarianMenu = menu.stream()
                                        .filter(Dish::isVegetarian)
                                        .collect(toList());
        System.out.println(vegetarianMenu);
        System.out.println();

        // 고유 요소, distinct
        System.out.println("-------------------- distinct --------------------");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        List<String> str = Arrays.asList("apple", "banana", "tomato", "banana", "tomato");
        str.stream()
                .filter(s -> s.length() > 5)
                .distinct()
                .forEach(System.out::println);
        System.out.println();
    }
}
