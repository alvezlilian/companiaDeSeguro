package companiaDeSeguro;

import java.util.HashSet;
import java.util.Set;

public class PolizaDeAuto extends SegurosGenerales {

    private Set<Auto> autos = new HashSet<>();

    public PolizaDeAuto(Integer numero_de_poliza, Persona asegurado, Double suma_asegurada, Double prima, Double premio) {
        super(numero_de_poliza, asegurado, suma_asegurada, prima, premio);


    }

    @Override
    public Boolean agregarBienAsegurado(Auto auto) {
        return autos.add(auto);
    }

    @Override
    public Boolean agregarbien(Vivienda casa) {
        return null;
    }


    @Override
    public Boolean fuerobado() {
        return true;
    }

    @Override
    public Boolean tuvoAlgunAccidente() {
        return false;
    }
}