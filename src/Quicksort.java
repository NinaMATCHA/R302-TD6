package tp6;
import java.util.ArrayList;

public class Quicksort {
    // methode Lomuto p118 cm

    // DIVIDE
    public static void tris(ArrayList<Integer> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        quicksort(list, 0, list.size() - 1);
    }

    private static int partition(ArrayList<Integer> list, int deb, int fin) {
        int pivot = list.get(fin);
        for (int j = deb; j < fin; j++) {
            if (list.get(j) <= pivot) {
                swap(list, i, j);
                i++;
            }
        }

        swap(list, i, fin);
        return i;
    }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    //CONQUER
    private static void quicksort(ArrayList<Integer> list, int deb, int fin) {
        if (deb < fin) {
            int indexPivot = partition(list, deb, fin);
            quicksort(list, deb, indexPivot - 1);
            quicksort(list, indexPivot + 1, fin);
        }
    }

    private static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(8);

        System.out.println("list avant le tris : " + list);
        tris(list);
        System.out.println("list après le tris : " + list);
    }
}