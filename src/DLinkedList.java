package tp6;
public class tris {

    public Noeud[] triBulle(Noeud[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j].nb > a[j].suivant.nb) {
                    Noeud temp = a[j];
                    a[j] = a[j].suivant;
                    a[j].suivant = temp;
                }
            }
        }
        return a;
    }


}
