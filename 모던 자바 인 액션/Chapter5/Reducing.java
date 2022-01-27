package modenJavaInAction.char5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static modenJavaInAction.char4.Dish.menu;

public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> nums = Arrays.asList();

        System.out.println("------------------ sum ------------------");
        System.out.println();
        int sum1 = 0;
        for(int num : numbers)
            sum1 += num;

        int sum2 = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum2);

        int sum3 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum3);

        Optional<Integer> sum4 = numbers.stream().reduce(Integer::sum);
        System.out.println(sum4);

        Optional<Integer> sum5 = nums.stream().reduce(Integer::sum);
        System.out.println(sum5);

        System.out.println("------------------ max ------------------");
        int max1 = numbers.stream().reduce(0, Integer::max);
        System.out.println(max1);

//        Optional<Integer> max2 = nums.stream().reduce(0, Integer::max);
        Optional<Integer> max2 = nums.stream().reduce(Integer::max);
        System.out.println(max2);

        System.out.println("------------------ min ------------------");
        int min1 = numbers.stream().reduce(0, Integer::min);
        System.out.println(min1);

        Optional<Integer> min2 = nums.stream().reduce(Integer::min);
        System.out.println(min2);


        System.out.println("------------------ quiz ------------------");
        // 퀴즈 5-3
        int count = menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        System.out.println(count);
    }
}
