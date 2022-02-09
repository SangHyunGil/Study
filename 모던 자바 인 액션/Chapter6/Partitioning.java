package modenJavaInAction.Chapter6;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static modenJavaInAction.Chapter6.Dish.menu;

public class Partitioning {
    public static void main(String[] args) {
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println("partitionedMenu = " + partitionedMenu);

        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        System.out.println("vegetarianDishes = " + vegetarianDishes);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu.stream().collect(partitioningBy(Dish::isVegetarian,
                        groupingBy(Dish::getType)));
        System.out.println("vegetarianDishesByType = " + vegetarianDishesByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println("mostCaloricPartitionedByVegetarian = " + mostCaloricPartitionedByVegetarian);
    }

}
