package homework040822;
import java.util.*;

public class App {

    public static void main(String[] args) {
        /*
        Создать два ArrayList , заполнить их числами, упорядочить каждый и объединить в один
        ArrayList в упорядоченном виде.
        Результат вывести в консоль.
         */

        List<Integer> firstList = new ArrayList<>(Arrays.asList(6, 2, 3, 9, 10, 3, 22));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(1, -32, 65, 7, 3, 27, 33, 42, 12, 5));

        //здесь сортирую, методом sort интерфейса List, передавая в качестве аргумента компаратор (метод compareTo класса Integer)
        firstList.sort(Integer::compareTo);
        secondList.sort(Integer::compareTo);

        List<Integer> unitedList = mergeArrList(firstList, secondList);
        System.out.println(unitedList);
    }

    public static List<Integer> mergeArrList(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<>();
        int indexFirst = 0;
        int indexSecond = 0;
        for (int i = 0; i < firstList.size() + secondList.size(); i++) {
            if (indexFirst >= firstList.size()) {
                result.add(i, secondList.get(indexSecond++));
                continue;
            }
            if (indexSecond >= secondList.size()) {
                result.add(i, firstList.get(indexFirst));
                continue;
            }
            if (firstList.get(indexFirst) <= secondList.get(indexSecond)) {
                result.add(i, firstList.get(indexFirst++));
            } else {
                result.add(i, secondList.get(indexSecond++));
            }
        }
        return result;
    }
}
