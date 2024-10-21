// cSpell:ignore guia telefono

package guia06.tp.Session01.CallCenter;

import java.lang.Thread;
import java.util.ArrayList;

public class CallCenter {
    ArrayList<Llamada> llamadasActivas = new ArrayList<Llamada>();

    public CallCenter(ArrayList<Llamada> llamadas) {
        llamadasActivas.addAll(llamadas);
        for (Llamada llamada : llamadasActivas) {
            Thread t = new Thread(llamada);
            t.start();

            llamada.mostrarMensajes();
        }
    }
}
