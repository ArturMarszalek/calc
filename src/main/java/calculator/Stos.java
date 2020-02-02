package calculator;

import java.util.Vector;

public class Stos<T> {

    private Vector<T> stos;

    public Stos() {
        stos = new Vector<>();
    }

    public void push(T element) {
        stos.addElement(element);
    }

}
