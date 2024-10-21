// cSpell:ignore guia telefono
package guia06.tp.Session01;

import java.util.ArrayList;
import java.util.Arrays;

public class Pruebas {

    static Llamada l1 = new Llamada(new Persona("Camilo Tuta", new Telefono("3212739433")));
    static Llamada l2 = new Llamada(new Persona("Sallie Simpson", new Telefono("(756) 392-2958")));
    static Llamada l3 = new Llamada(new Persona("Justin Bowman", new Telefono("(500) 430-1260")));
    static Llamada l4 = new Llamada(new Persona("Tommy Ryan", new Telefono("(336) 233-9709")));
    static Llamada l5 = new Llamada(new Persona("Cynthia Porter", new Telefono("(787) 757-7731")));
    static Llamada l6 = new Llamada(new Persona("Jerome Willis", new Telefono("(234) 721-6939")));
    static Llamada l7 = new Llamada(new Persona("Willie Blake", new Telefono("(526) 469-4633")));

    public static void main(String[] args) {
        l1.enviarNuevoMensaje("ajajajajajajajjajajaj");
        new CallCenter(new ArrayList<>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7)));

    }

}
