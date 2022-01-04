package companiaDeSeguro;

public class Beneficiario implements Comparable<Beneficiario> {


    private Persona persona;
    private TipoDeBeneficiario tipoDeBeneficiario;

    public Beneficiario(Persona persona, TipoDeBeneficiario tipoDeBeneficiario) {
        this.persona = persona;
        this.tipoDeBeneficiario = tipoDeBeneficiario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoDeBeneficiario getTipoDeBeneficiario() {
        return tipoDeBeneficiario;
    }

    public void setTipoDeBeneficiario(TipoDeBeneficiario tipoDeBeneficiario) {
        this.tipoDeBeneficiario = tipoDeBeneficiario;
    }

    @Override
    public int compareTo(Beneficiario o) {
        return this.persona.getDni().compareTo(o.persona.getDni());
    }
}
