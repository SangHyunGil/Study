package modenJavaInAction.Chapter6;

import java.util.Optional;

import static java.util.stream.Collectors.*;
import static modenJavaInAction.Chapter6.Dish.menu;

public class Quiz {
    public static void main(String[] args) {

        // 퀴즈 6-1
        String shortMenu1 = menu.stream().map(Dish::getName).collect(joining(", "));
        String shortMenu2 = menu.stream().map(Dish::getName).collect(reducing((s1, s2) -> s1 + ", " + s2)).get();
//        String shortMenu3 = menu.stream().collect(reducing( (d1, d2) -> d1.getName() + ", " + d2.getName())).get();
        String shortMenu4 = menu.stream().collect(reducing("", Dish::getName, (s1, s2) -> s1 + ", " + s2));

        System.out.println(shortMenu1);
        System.out.println(shortMenu2);
        System.out.println(shortMenu4);
    }
}
