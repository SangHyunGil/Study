package modenJavaInAction.Chapter6;

import java.util.Optional;

import static java.util.stream.Collectors.*;
import static modenJavaInAction.Chapter6.Dish.menu;

public class Reducing {
    public static void main(String[] args) {

        int totalCalories = menu.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCalories);

        totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalCalories);

        Optional<Dish> mostCalorieDish = menu.stream().collect(reducing(
                (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(mostCalorieDish);

        Optional<Integer> reduce = menu.stream().map(Dish::getCalories).reduce(Integer::sum);
        System.out.println(reduce.get());


    }

}
