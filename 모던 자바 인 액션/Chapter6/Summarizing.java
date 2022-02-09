package modenJavaInAction.Chapter6;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;

import static java.util.stream.Collectors.*;
import static modenJavaInAction.Chapter6.Dish.menu;

public class Summarizing {

    public static void main(String[] args) {
        long howManyDishes1 = menu.stream().collect(counting());
        long howManyDishes2 = menu.stream().count();

        System.out.println(howManyDishes1);
        System.out.println(howManyDishes2);

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish);

        Optional<Dish> leastCalorieDish = menu.stream().collect(minBy(dishCaloriesComparator));
        System.out.println(leastCalorieDish);

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);
    }
}
