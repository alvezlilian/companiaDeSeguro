package companiaDeSeguro;

import java.util.Objects;

public abstract class SegurosGenerales implements FueRobado ,tuvoAlgunAccidente {


    private  Integer numero_de_poliza;
    private Persona asegurado;
    private  final Double PRIMA;
    private final Double SUMA_ASEGURADA;
    private final Double PREMIO;
    private Auto auto;

    public SegurosGenerales(Integer numero_de_poliza, Persona asegurado, Double suma_asegurada, Double prima, Double premio) {

        this.numero_de_poliza = numero_de_poliza;
        this.asegurado = asegurado;
       this.PRIMA  = prima;
        this.SUMA_ASEGURADA = suma_asegurada;
        this.PREMIO = premio;
    }

    public Integer getNumero_de_poliza() {
        return numero_de_poliza;
    }

    public void setNumero_de_poliza(Integer numero_de_poliza) {
        this.numero_de_poliza = numero_de_poliza;
    }

    public Persona getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(Persona asegurado) {
        this.asegurado = asegurado;
    }

    public Double getPRIMA() {
        return PRIMA;
    }

    public Double getSUMA_ASEGURADA() {
        return SUMA_ASEGURADA;
    }

    public Double getPREMIO() {
        return PREMIO;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public  abstract Boolean agregarBienAsegurado(Auto auto);

    public abstract Boolean agregarbien(Vivienda casa);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SegurosGenerales)) return false;
        SegurosGenerales that = (SegurosGenerales) o;
        return getNumero_de_poliza().equals(that.getNumero_de_poliza());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero_de_poliza());
    }
}
