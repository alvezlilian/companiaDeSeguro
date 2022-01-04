package companiaDeSeguro;

public class Persona {
    private  Integer anios;
    private  String nombre;
    private  Integer dni;

    public Persona(String nombre, int dni, int anios) {
        this.nombre =nombre;
        this.dni=dni;
        this.anios=anios;
    }

    public Integer getAnios() {
        return anios;
    }

    public void setAnios(Integer anios) {
        this.anios = anios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }
}
