package companiaDeSeguro;

public abstract class SegurosDeVida  extends SegurosGenerales {

    public SegurosDeVida(Integer numero_de_poliza, Persona asegurado, Double suma_asegurada, Double prima, Double premio) {
        super(numero_de_poliza, asegurado, suma_asegurada, prima, premio);
    }

    @Override
    public Boolean agregarBienAsegurado(Auto auto) {
        return null;
    }

    public abstract Boolean agregarBeneficiario(Beneficiario beneficirio1);

    public abstract int obtenerCantidadDeBeneficiarios();
}
