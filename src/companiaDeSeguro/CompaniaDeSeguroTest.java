package companiaDeSeguro;

import org.junit.Test;
import static org.junit.Assert.*;

public class CompaniaDeSeguroTest {

    @Test
    public void queSePuedaEmitirUnaPolizaDeAutos() {
        final Integer NUMERO_DE_POLIZA = 1;
        final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;

        Persona asegurado = new Persona("Camila", 45987345, 24);
        Auto auto = new Auto("Ford", "Fiesta", 2010, SUMA_ASEGURADA);
        SegurosGenerales poliza = new PolizaDeAuto(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA,PREMIO);
        poliza.agregarBienAsegurado(auto);
        poliza.setAuto(auto);

        assertEquals(NUMERO_DE_POLIZA, poliza.getNumero_de_poliza());
        assertEquals(auto, poliza.getAuto());
        assertEquals(asegurado, poliza.getAsegurado());
        assertEquals(PREMIO, poliza.getPREMIO());
    }

    @Test
    public void queSePuedaEmitirUnaPolizaDeVida() {
        final Integer NUMERO_DE_POLIZA = 1;
        final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;

        Persona asegurado = new Persona("Camila", 45987345, 24);
        Persona hijo = new Persona("Arturo", 65456232, 2);
        Persona conyuge = new Persona("Arturo", 65456231, 2);

        SegurosDeVida poliza = new PolizaAccidentesPersonales(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA,PREMIO);
        Beneficiario beneficiario1=new Beneficiario(hijo, TipoDeBeneficiario.HIJO);
        Beneficiario beneficiario2=new Beneficiario(conyuge,TipoDeBeneficiario.CONYUGE);
        poliza.agregarBeneficiario(beneficiario1);
        poliza.agregarBeneficiario(beneficiario2);


        assertEquals(2, poliza.obtenerCantidadDeBeneficiarios());
        assertEquals(asegurado, poliza.getAsegurado());
        assertEquals(PREMIO, poliza.getPREMIO());
    }


    @Test
    public void queSePuedaEmitirUnaPolizaDeCombinadoFamiliar() {
        final Integer NUMERO_DE_POLIZA = 1;
        final Double SUMA_ASEGURADA = 20000000.0, PRIMA = 50000.0, PREMIO = 60000.0;

        Vivienda casa = new Vivienda("Florencio Varela 1800", "San Justo", "La Matanza", "Buenos Aires");
        Persona asegurado = new Persona("Camila", 45987345, 24);
        Persona hijo = new Persona("jose", 65477231, 2);
        Persona hija = new Persona("Maia", 65445231, 4);
        Persona conyuge = new Persona("Arturo", 65456231, 2);

        PolizaCombinadoFamiliar poliza = new PolizaCombinadoFamiliar(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA,PREMIO);
        Beneficiario beneficiario1=new Beneficiario(hijo, TipoDeBeneficiario.HIJO);
        Beneficiario beneficiario2=new Beneficiario(conyuge,TipoDeBeneficiario.CONYUGE);
        Beneficiario beneficiario3=new Beneficiario(hija, TipoDeBeneficiario.HIJA);

        poliza.agregarBeneficiario(beneficiario1);
        poliza.agregarBeneficiario(beneficiario2);
        poliza.agregarBeneficiario(beneficiario3);

        poliza.agregarbien(casa);

        assertEquals(3, poliza.obtenerCantidadDeBeneficiarios());
        assertEquals(asegurado, poliza.getAsegurado());
        assertEquals(PREMIO, poliza.getPREMIO());
    }
    @Test
    public void queSePuedanAdministrarDistintosTiposDePolizas() {
        Integer numeroDePoliza = 1;
        CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");

        libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0, 6000.0));
        libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0,6000.0));
        libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0,6000.0));
        libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0,6000.0));
        libra.agregarPoliza(new PolizaDeAuto(4, new Persona("Victor", 652354, 24), 2000000.0, 5000.0,6000.0));


        assertEquals((Integer)4, libra.obtenerLaCantidadDePolizasEmitidas());
    }

    @Test
    public void queSePuedaDenunciarElRoboDeUnAuto() throws PolizaInexistenteException {
        Integer numeroDePoliza = 1;
        CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");

        libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0,6000.0));

        libra.denunciarSiniestro(1);

        assertTrue(libra.getPoliza(1));

    }
    @Test
    public void queSePuedaDenunciarUnSiniestroParaUnaPolizaDeVida() throws PolizaInexistenteException {
        Integer numeroDePoliza = 1;
        CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");

        libra.agregarPoliza(new PolizaAccidentesPersonales(numeroDePoliza, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0,6000.0 ));

        libra.denunciarSiniestro(1);

        assertTrue(libra.getPoliza(1));

    }

    @Test (expected = PolizaInexistenteException.class)
    public void verificarQueNoSePuedaDenunciarUnSiniestroParaUnaPolizaQueNoExista() throws PolizaInexistenteException {
        Integer numeroDePoliza = 1;
        CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
        libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0, 6000.0));
        libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0,6000.0));
        libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0,6000.0));
        libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0,6000.0));
        libra.denunciarSiniestro(5);

    }

}
