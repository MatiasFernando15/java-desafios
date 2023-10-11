package ar.com.java_desafios;

import java.util.ArrayList;
import java.util.List;

public class TorreControl {
	private List<Volador> voladores = new ArrayList<>();

    public void agregarVolador(Volador volador) {
        voladores.add(volador);
    }

    public void gestionarAterrizaje(Operario operario) {
        for (Volador volador : voladores) {
            volador.aterrizarPista1();
            volador.aterrizarPista2();
            if (!volador.cumpleRequisitosPista1()) {
                operario.autorizarAterrizajePista2(volador);
            }
        }
    }
}
