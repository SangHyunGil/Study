package modenJavaInAction.char4;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static modenJavaInAction.char4.Dish.menu;

public class Quiz {
    public static void main(String[] args) {

        List<String> names = menu.stream()
                .filter(dish -> dish.getCalories() > 300)  // 중간 연산
                .map(Dish::getName)  // 중간 연산
                .limit(3)  // 중간 연산
                .collect(toList());  // 스트림을 리스트로 변환

        // quiz 4-1
        List<String> highCaloricDishes =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)
                        .collect(toList());
        System.out.println(highCaloricDishes);

        // quiz 4-2
        long count = menu.stream()
                .filter(d -> d.getCalories() > 500)
                .distinct()
                .limit(5)
                .count();
        System.out.println(count);

        List<String> name = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering : " + dish.getName() + ", calorie : " + dish.getCalories());
                    return dish.getCalories() > 500;
                })  // 중간 연산
                .map(dish -> {
                    System.out.println("mapping : " + dish.getName());
                    return dish.getName();
                })  // 중간 연산
                .limit(3)  // 중간 연산
                .collect(toList());  // 스트림을 리스트로 변환

    }
}
