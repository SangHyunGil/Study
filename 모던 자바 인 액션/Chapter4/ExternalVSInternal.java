package modenJavaInAction.char4;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static modenJavaInAction.char4.Dish.menu;

public class ExternalVSInternal {
    public static void main(String[] args) {

        // 컬렉션 : for-each 루프를 이용하는 외부 반복
        List<String> names1 = new ArrayList<>();
        for(Dish dish : menu){
            names1.add(dish.getName());
        }

        // 스트림 : 내부 반복
        List<String> names2 = menu.stream()
                        .map(Dish::getName)
                        .collect(toList());
    }
}
