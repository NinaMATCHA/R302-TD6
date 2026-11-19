package tp6;

public class DLinkedList {
    private DNode header;
    private DNode trailer;
    private long size;

    private class DNode {
    int element;
    DNode prev;
    DNode next;

        private DNode(int e, DNode p, DNode n) {
            element = e;
            prev = p;
            next = n;
        }
    }

    public DLinkedList() {
        header = new DNode(0, null, null);
        trailer = new DNode(0, header, null);
        header.next = trailer;
        size = 0;
    }

    public void addLast(int e) {
        DNode nouveau = new DNode(e, trailer.prev, trailer);
        trailer.prev.next = nouveau;
        trailer.prev = nouveau;
        size++;
    }

    public void triBulle() {
        if (size < 2) return;

        boolean echange = false;
        do {
            aChange = false;
            DNode courant = header.next;

            while (courant != trailer && courant.next != trailer) {
                if (courant.element > courant.next.element) {
                    echange(courant, courant.next);
                    aChange = true;
                } else {
                    courant = courant.next;
                }
            }
        } while (aChange);
    }

    private void echange(DNode a, DNode b) {
        DNode avant = a.prev;
        DNode apres = b.next;

        avant.next = b;
        b.prev = avant;

        b.next = a;
        a.prev = b;

        a.next = apres;
        apres.prev = a;
    }

    @Override
    private String toString() {
        StringBuilder sb = new StringBuilder();
        DNode courant = header.next;
        while (courant != trailer) {
            sb.append(courant.element).append(" ");
            courant = courant.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DLinkedList liste = new DLinkedList();
        liste.addLast(5);
        liste.addLast(1);
        liste.addLast(10);

        System.out.println("Avant tri :" + liste);
        liste.triBulle();
        System.out.println("Apres tri :" + liste);
}