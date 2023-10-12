package ar.com.java_desafios;

public class Main {

	public static void main(String[] args) {
		
		CollectionCustom<Integer> collection = new CollectionCustom<>(5);

        collection.addLast(1);
        collection.addLast(2);
        collection.addLast(3);
        collection.addLast(4);
        collection.addLast(5);

        System.out.println("tamaño: " + collection.size());
        System.out.println("La colección está vacía: " + collection.empty());

        collection.addFirst(0);

        System.out.println("tamaño después de agregar el primer elemento: " + collection.size());

        collection.remove(3);
        System.out.println("tamaño después de eliminar el elemento 3: " + collection.size());

        collection.removeAll(5);
        System.out.println("tamaño después de eliminar todas las ocurrencias de 5: " + collection.size());

        collection.add(6);
        System.out.println("tamaño después de agregar el elemento 6: " + collection.size());
	}

}
