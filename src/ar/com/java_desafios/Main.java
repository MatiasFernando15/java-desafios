package ar.com.java_desafios;

public class Main {
    public static void main(String[] args) {
    	TorreControl torre = new TorreControl();
        Operario operario = new Operario();

        // Agregar objetos voladores a la torre de control
        torre.agregarVolador(new ObjetoVolador("Avión 1"));
        torre.agregarVolador(new ObjetoVolador("Helicóptero 1"));
        torre.agregarVolador(new ObjetoVolador("Avión 2"));

        // Gestionar el aterrizaje
        torre.gestionarAterrizaje(operario);
    }
}
