package companiaDeSeguro;

public class PolizaInexistenteException extends Exception {
    public PolizaInexistenteException() {
        super("El siniestro no fue robado");
    }
}
