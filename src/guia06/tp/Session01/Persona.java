// cSpell:ignore guia telefono 
package guia06.tp.Session01;

public class Persona {
    private String nombre;
    private Telefono telefonoPersona;

    public Persona(String nombre, Telefono telefonoPersona) {
        this.nombre = nombre;
        this.telefonoPersona = telefonoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonoPersona() {
        return telefonoPersona.getNumero();
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona.setNumero(telefonoPersona);
    }

}
