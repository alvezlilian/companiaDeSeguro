package companiaDeSeguro;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PolizaCombinadoFamiliar extends SegurosDeVida {
    private Set< Vivienda> casas=new HashSet<>();
    private Set<Beneficiario> beneficiarios=new TreeSet<>();

    public PolizaCombinadoFamiliar(Integer numero_de_poliza, Persona asegurado, Double suma_asegurada, Double prima, Double premio) {
        super(numero_de_poliza, asegurado, suma_asegurada, prima, premio);
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
    public Boolean agregarbien(Vivienda casa) {
        return casas.add(casa);
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
