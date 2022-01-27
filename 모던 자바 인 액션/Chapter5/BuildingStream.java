package modenJavaInAction.char5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BuildingStream {

    public static void main(String[] args) {
        // stream.of
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // Stream.ofNullable
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream1 = homeValue == null ? Stream.empty() : Stream.of(homeValue);

        Stream<String> homeValueStream2 = Stream.ofNullable(System.getProperty("home"));

        // Arrays.stream
        int[] numbers = {2, 3, 4, 6, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // iterate를 이용한 피보나치
        Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] })
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        IntStream.iterate(0, n -> n < 50, n -> n + 10)
                .forEach(System.out::println);

        IntStream.iterate(0, n -> n + 10)
                .takeWhile(n -> n < 50)
                .forEach(System.out::println);

        // Stream.generate를 이용한 임의의 double 스트림
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // Stream.generate을 이용한 요소 1을 갖는 스트림
        IntStream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);
    }
}
