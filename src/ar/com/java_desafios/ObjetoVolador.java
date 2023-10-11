package ar.com.java_desafios;

public class ObjetoVolador implements Volador {

	private String nombre;
    private boolean autorizacionPista2;

    public ObjetoVolador(String nombre) {
        this.nombre = nombre;
        this.autorizacionPista2 = false;
    }

    @Override
    public void aterrizarPista1() {
        if (cumpleRequisitosPista1()) {
            System.out.println(nombre + " aterrizó en la pista 1.");
        } else {
            System.out.println(nombre + " no cumple los requisitos para aterrizar en la pista 1.");
            autorizacionPista2 = true;
        }
    }

    @Override
    public void aterrizarPista2() {
        if (autorizacionPista2) {
            System.out.println(nombre + " aterrizó en la pista 2 con autorización del operario.");
        } else {
            System.out.println(nombre + " no tiene autorización para aterrizar en la pista 2.");
        }
    }

    @Override
    public boolean cumpleRequisitosPista1() {
        // Define aquí la lógica para verificar si cumple los requisitos de la pista 1.
        // Devuelve true si cumple los requisitos y false si no.
        return true;
    }
}
