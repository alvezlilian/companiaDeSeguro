package companiaDeSeguro;

import java.util.HashSet;
import java.util.Set;

public class CompaniaDeSeguro {
    private String nombre;
    private Set<SegurosGenerales> seguros = new HashSet<>();
    private Set<SegurosGenerales> robados = new HashSet<SegurosGenerales>();


    public CompaniaDeSeguro(String nombre) {
        this.nombre = nombre;
    }

    public boolean agregarPoliza(PolizaDeAuto seguro) {
        return this.seguros.add(seguro);
    }

    public boolean agregarPoliza(PolizaCombinadoFamiliar seguro) {
        return this.seguros.add(seguro);
    }

    public boolean agregarPoliza(PolizaAccidentesPersonales seguro) {
        return this.seguros.add(seguro);
    }

    public Integer obtenerLaCantidadDePolizasEmitidas() {
        return seguros.size();
    }

    public Boolean denunciarSiniestro(Integer numero_poliza) throws PolizaInexistenteException {
        for (SegurosGenerales segurostotal : seguros) {
            if (segurostotal.getNumero_de_poliza().equals(numero_poliza)) {
              return   this.robados.add(segurostotal);
            }

        }
        throw  new PolizaInexistenteException() ;
    }

    public Boolean agregarRobado(SegurosGenerales robado) {
        return this.robados.add(robado);
    }

    public Boolean getPoliza(Integer numero_poliza) {
        Boolean fueRobado=false;
        for (SegurosGenerales segurostotal : seguros) {
            if (segurostotal.getNumero_de_poliza().equals(numero_poliza)&& segurostotal.fuerobado().equals(true)) {
                return fueRobado=true;
            }else if(segurostotal.getNumero_de_poliza().equals(numero_poliza)&& segurostotal.tuvoAlgunAccidente().equals(true)){
                return fueRobado=true;
            }
        }
return fueRobado;
    }
}