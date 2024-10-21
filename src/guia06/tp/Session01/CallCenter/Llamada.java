// cSpell:ignore guia
package guia06.tp.Session01.CallCenter;

import java.util.ArrayList;

public class Llamada implements Runnable {
    private Persona persona;
    private ArrayList<String> mensajes = new ArrayList<String>();

    public Llamada(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void enviarNuevoMensaje(String mensajeNuevo) {
        try {
            this.mensajes.add(mensajeNuevo);
            System.out.println(String.format("El mensaje '%s' ha sido enviado a '%s' correctamente", mensajeNuevo,
                    this.getPersona().getTelefonoPersona()));
        } catch (Exception e) {
            System.out.println("Hubo un error al enviar el mensaje: " + e.getMessage());
        }
    }

    public void mostrarMensajes() {
        System.out.println("MENSAJES DE " + this.getPersona().getNombre() + "\nOrden  Mensaje");
        for (String i : mensajes) {
            System.out.println(String.format("%d   %s", mensajes.indexOf(i), i));
        }
        System.out.println("----------------------------------------------------------------\n");
    }

    @Override
    public void run() {
        System.out
                .println(this.getPersona().getNombre() + " está realizando una llamada desde el número "
                        + this.getPersona().getTelefonoPersona());
        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            System.out.println("La llamada fue interrumpida y no ha sido posible comunicarse");
        }
        System.out.println(persona.getNombre() + " terminó la llamada.");
    }

}
