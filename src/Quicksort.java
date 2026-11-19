package tp6;
import java.util.ArrayList;

public class Quicksort {

    private static int partitionnement(ArrayList<Integer> list, int inf, int sup) {
        int pivot = list.get(sup);
        int i = inf - 1;
        int n = list.size();
        if(n < 2)
            return -1;
        for (int j = inf; j < sup; j++) {
            if (list.get(j) <= pivot) {
                i++;
                int tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);
            }
        }
        int tmp = list.get(i + 1);
        list.set(i + 1, list.get(sup));
        list.set(sup, tmp);
        return i + 1;
    }

    private static void quickSort(ArrayList<Integer> list, int inf, int sup) {
        if (inf < sup) {
            int part = partitionnement(list, inf, sup);
            quickSort(list, inf, part - 1);
            quickSort(list, part + 1, sup);
        }
    }

    public static void quickSort(ArrayList<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

}
