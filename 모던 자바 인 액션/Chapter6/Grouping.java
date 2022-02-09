package modenJavaInAction.Chapter6;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static modenJavaInAction.Chapter6.Dish.dishTags;
import static modenJavaInAction.Chapter6.Dish.menu;

public class Grouping {

    enum CaloricLevel { DIET, NORMAL, FAT };

    public static void main(String[] args) {
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().
                collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
        System.out.println(dishesByCaloricLevel);

        Map<Dish.Type, List<Dish>> caloricDishedByType1 =
                menu.stream().filter(dish -> dish.getCalories() > 500)
                        .collect(groupingBy(Dish::getType));
        System.out.println(caloricDishedByType1);

        Map<Dish.Type, List<Dish>> caloricDishedByType2 =
                menu.stream().collect(groupingBy(Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));
        System.out.println(caloricDishedByType2);

        Map<Dish.Type, List<String>> dishNamesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        mapping(Dish::getName, toList())));
        System.out.println(dishNamesByType);

        Map<Dish.Type, Set<String>> dishTagsByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));
        System.out.println(dishTagsByType);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(groupingBy(Dish::getType,  // 첫 번째 수준의 분류 함수
                        groupingBy(dish -> {  // 두 번째 수준의 분류 함수
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })
                )
        );
        System.out.println(dishesByTypeCaloricLevel);

        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(typesCount);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType1 =
                menu.stream().collect(groupingBy(Dish::getType,
                        maxBy(comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType1);

        Map<Dish.Type, Dish> mostCaloricByType2 =
                menu.stream().collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricByType2);

    }


}
