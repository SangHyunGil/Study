package modenJavaInAction.char5;

import modenJavaInAction.char4.Dish;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static modenJavaInAction.char4.Dish.menu;

public class NumericStream {
    public static void main(String[] args) {

        // 숫자 스트림을 매핑
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories);

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);  // 스트림을 숫자 스트림으로 변환
        Stream<Integer> stream = intStream.boxed();  // 숫자 스트림을 스트림으로 변환

        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println("maxCalories : " + maxCalories);

        int max = maxCalories.orElse(1);  // 값이 없을 때 기본 최대값을 명시적으로 설정

        IntStream evenNumbers1 = IntStream.rangeClosed(1, 100)  // [1, 100] 범위
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers1.count());  // 50

        IntStream evenNumbers2 = IntStream.range(1, 100)  // (1, 100) 범위
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers2.count());  // 49

        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(b*b) % 3 == 0)
                .forEach(System.out::println);

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
                        .map(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));
        pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
        System.out.println();

        Stream<int[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0))
                .map(array -> Arrays.stream(array).mapToInt(a -> (int) a).toArray());
        pythagoreanTriples2.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
