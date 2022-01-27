package modenJavaInAction.char4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVSCollection {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
//        s.forEach(System.out::println);  // 스트림은 한 번만 읽을 수 있음.
    }
}
