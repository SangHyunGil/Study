package modenJavaInAction.char5;

import modenJavaInAction.char4.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamSlicing {
    public static void main(String[] args) {
        // 스트림 슬라이싱
        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        // 정렬되어 있는 상황에서
        System.out.println("------------ filter ------------");
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println(filteredMenu);
        System.out.println();

        // takeWhile 사용
        System.out.println("------------ takeWhile ------------");
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println(slicedMenu1);
        System.out.println();

        // dropWhile 사용
        System.out.println("------------ dropWhile ------------");
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println(slicedMenu2);
        System.out.println();




        // 스트림 축소, limit
        System.out.println("------------ limit ------------");
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() >= 300)
                .limit(3)
                .collect(toList());
        System.out.println(dishes);
        System.out.println();

        // 요소 건너뛰기, skip
        System.out.println("------------ skip ------------");
        List<Dish> dishesSkip = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println(dishesSkip);
        System.out.println();


        // 퀴즈 5-1
        System.out.println("------------ quiz ------------");
        List<Dish> meatDish = specialMenu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());
        System.out.println(meatDish);
    }
}
