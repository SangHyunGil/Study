package modenJavaInAction.char5;

import modenJavaInAction.char4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static modenJavaInAction.char4.Dish.menu;

public class Finding {
    public static void main(String[] args) {

        // anyMatch
        System.out.println("------------ anyMatch ------------");
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is vegetarian friendly!");
        }
        System.out.println();

        // allMatch
        System.out.println("------------ allMatch ------------");
        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);
        System.out.println();

        // noneMatch
        System.out.println("------------ noneMatch ------------");
        isHealthy = menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println(isHealthy);
        System.out.println();

        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(dish);

        List<Integer> numbers = Arrays.asList(4, 5, 6, 1, 2, 3);
        Optional<Integer> firstSquareDivisibleByThree = numbers.stream()
                .filter(n -> n % 3 == 0)
                .map(n -> n * n)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree);

    }
}
