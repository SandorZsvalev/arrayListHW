package homework080822;
import java.util.*;

public class FindApp {

    public static void main(String[] args) {
        /*
        Задать массив из 15-20 чисел, отсортированных в порядке по убыванию.
        С помощью бинарного поиска найти определенное число в массиве.
        В качестве вывода вывести результаты поиска если искомое число будет граничным значение
        слева, справа, в левой части от середины и в правой. Те для 4-х вариантов.
         */

        List<Integer> arrayList = new ArrayList<>(Arrays.asList(6, 2, 3, 9, 10, 3, 22, 1, 32, 65, 7, 3, 27, 33, 7, 5, 16, 18, 76, 45));
        arrayList.sort(Collections.reverseOrder(Integer::compareTo)); //отсортировали в обратном порядке
        System.out.println(arrayList);

        int indexOfSearchNumber = binarySearch(-1, arrayList); // несуществующий справа
        int indexOfSearchNumber2 = binarySearch(76, arrayList);
        int indexOfSearchNumber3 = binarySearch(27, arrayList);
        int indexOfSearchNumber4 = binarySearch(7, arrayList);
        int indexOfSearchNumber5 = binarySearch(1, arrayList);
        int indexOfSearchNumber6 = binarySearch(88, arrayList); // несуществующий слева

        /*
        С помощью итератора, а может двух, перевернуть ArrayList из 10 элементов,
        не использовать дополнительные структуры данных для помощи , такие как списки или массивы
        и не использовать встроенные методы реверса.
         */
        reverseArray(arrayList);
        System.out.println(arrayList);

        reverseArray2(arrayList);
        System.out.println(arrayList);
    }

    public static int binarySearch(int target, List<Integer> arrayList) {
        int count = 0;
        int startPoint = 0;
        int endPoint = arrayList.size() - 1;
        int checkPoint;
        System.out.println(target);

        while (startPoint <= endPoint) {
            count++;
            checkPoint = startPoint + ((endPoint - startPoint) / 2);
            if (arrayList.get(checkPoint) == target) {
                System.out.println("попыток " + count);
                System.out.println("найдено под номером " + arrayList.indexOf(arrayList.get(checkPoint)));
                return arrayList.indexOf(arrayList.get(checkPoint));
            } else if (arrayList.get(checkPoint) < target) { //середина меньше, чем искомое. ищем слева
                endPoint = checkPoint - 1;
            } else if (arrayList.get(checkPoint) > target) { //середина больше, чем искомое. ищем справа
                startPoint = checkPoint + 1;
            }
        }
        System.out.println("попыток " + count);
        System.out.println("Не найдено");
        return -1;
    }

    //разворот без итератора в цикле for i
    public static void reverseArray(List<Integer> arrayList) {
        int length = arrayList.size() - 1;
        for (int i = 0; i < (arrayList.size() / 2); i++) {
            int temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(length));
            arrayList.set(length--, temp);
        }
    }

    //разворот с итератором и циклом while
    public static void reverseArray2(List<Integer> arrayList) {
        ListIterator<Integer> startIterator = arrayList.listIterator();
        ListIterator<Integer> endIterator = arrayList.listIterator(arrayList.size());
        while (startIterator.nextIndex() < endIterator.previousIndex()) {
            int temp = startIterator.next();
            startIterator.set(endIterator.previous());
            endIterator.set(temp);
        }
    }
}
