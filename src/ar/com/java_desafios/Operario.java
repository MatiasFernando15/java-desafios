package ar.com.java_desafios;

public class Operario {

	public boolean autorizarAterrizajePista2(Volador volador) {
        if (!volador.cumpleRequisitosPista1()) {
            System.out.println("El operario autoriza a " + volador + " a aterrizar en la pista 2.");
            return true;
        } else {
            System.out.println("El operario no autoriza a " + volador + " a aterrizar en la pista 2.");
            return false;
        }
    }
}
