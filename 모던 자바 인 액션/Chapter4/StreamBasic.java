package modenJavaInAction.char4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

public class StreamBasic {

    public static void main(String[] args) {

        // 자바 7
        System.out.println("----------------- Java 7 -----------------");
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);
        System.out.println();

        // 자바 8
        System.out.println("----------------- Java 8 -----------------");
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
        System.out.println();

        System.out.println("----------------- HighCaloricDish -----------------");
        getThreeHighCaloricDishNames(Dish.menu).forEach(System.out::println);

    }

    private static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish dish : dishes){
            if(dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }

        List<String> lowCaloricDishesName = new ArrayList<>();
        lowCaloricDishes.sort(comparing(Dish::getCalories));

        for(Dish dish : lowCaloricDishes){
            lowCaloricDishesName.add(dish.getName());
        }

        return lowCaloricDishesName;
    }

    private static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()  // .parallelStream() -> 병렬 처리
                .filter(dish -> dish.getCalories() < 400)  // 400칼로리 이하의 요리 선택
                .sorted(comparing(Dish::getCalories))  // 칼로리로 요리 정렬
                .map(Dish::getName)  // 요리명 추출
                .collect(toList());  // 모든 요리명을 리스트에 저장
    }

    private static List<String> getThreeHighCaloricDishNames(List<Dish> dishes){
        return dishes.stream()
//                .filter(dish -> dish.getCalories() > 300)
                .filter(dish -> {
                    System.out.println("filtering " + dish.getName() + " " + dish.getCalories());
                    return dish.getCalories() > 300;
                })
                .sorted(comparing(Dish::getCalories, reverseOrder())) // 내림차순 정렬
//                .map(Dish::getName)
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();
                })
                .limit(3)  // 상위 3개
                .collect(toList());
    }

    private static void java7Ver() {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish dish : Dish.menu){
            if(dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {  // 익명 클래스로 요리 정렬
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for(Dish dish : lowCaloricDishes){
            lowCaloricDishesName.add(dish.getName());
        }
        System.out.println(lowCaloricDishesName);
    }

    private static void java8Ver(){
        List<String> lowCaloricDishesName =
                Dish.menu.stream()  // .parallelStream() -> 병렬 처리
                        .filter(dish -> dish.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(toList());

        System.out.println(lowCaloricDishesName);
    }

}
