package companiaDeSeguro;

import java.util.Set;
import java.util.TreeSet;

public class PolizaAccidentesPersonales extends SegurosDeVida {
private Set<Beneficiario> beneficiarios=new TreeSet<>();

    public PolizaAccidentesPersonales(Integer numero_de_poliza, Persona asegurado, Double suma_asegurada, Double prima, Double premio) {
        super(numero_de_poliza, asegurado, suma_asegurada, prima, premio);
    }

    @Override
    public Boolean agregarbien(Vivienda casa) {
        return null;
    }



    @Override
    public Boolean agregarBeneficiario(Beneficiario beneficirio) {
        return beneficiarios.add(beneficirio);
    }

    @Override
    public int obtenerCantidadDeBeneficiarios() {
        return beneficiarios.size();
    }

    @Override
    public Boolean fuerobado() {
        return false;
    }

    @Override
    public Boolean tuvoAlgunAccidente() {
        return true;
    }
}
