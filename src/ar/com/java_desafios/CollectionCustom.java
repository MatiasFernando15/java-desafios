package ar.com.java_desafios;

public class CollectionCustom<T> {

	private Object[] elementos; // Usamos un array de Object para almacenar elementos genéricos.
    private int tamaño; // Tamaño actual de la colección.

    public CollectionCustom(int capacidad) {
        elementos = new Object[capacidad];
        tamaño = 0;
    }

    public int size() {
        return tamaño;
    }

    public void addFirst(T elemento) {
    	asegurarCapacidad();
    	desplazarElementosDerecha();
        elementos[0] = elemento;
        tamaño++;
    }

    public void addLast(T elemento) {
    	asegurarCapacidad();
        elementos[tamaño] = elemento;
        tamaño++;
    }

    public void add(T elemento) {
        addLast(elemento);
    }

    public T remove(T elemento) {
        for (int i = 0; i < tamaño; i++) {
            if (elementos[i].equals(elemento)) {
                @SuppressWarnings("unchecked")
                T removedElement = (T) elementos[i];
                desplazarElementosIzquierda(i);
                tamaño--;
                return removedElement;
            }
        }
        return null; // El elemento no se encontró en la colección.
    }

    public void removeAll(T elemento) {
        for (int i = tamaño - 1; i >= 0; i--) {
            if (elementos[i].equals(elemento)) {
            	desplazarElementosIzquierda(i);
                tamaño--;
            }
        }
    }

    public boolean empty() {
        return tamaño == 0;
    }

    private void asegurarCapacidad() {
        if (tamaño == elementos.length) {
            int newCapacidad = elementos.length * 2;
            elementos = java.util.Arrays.copyOf(elementos, newCapacidad);
        }
    }

    private void desplazarElementosDerecha() {
        for (int i = tamaño; i > 0; i--) {
            elementos[i] = elementos[i - 1];
        }
    }

    private void desplazarElementosIzquierda(int indiceInicio) {
        for (int i = indiceInicio; i < tamaño - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[tamaño - 1] = null; // Eliminamos la última referencia.
    }
}
