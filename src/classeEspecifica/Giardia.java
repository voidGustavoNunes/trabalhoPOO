package classeEspecifica;

import classeGeral.Protozoario;

public abstract class Giardia extends Protozoario {

    String codigo = "3";

    public Giardia(String identificacao) {
        super(identificacao, 500, "Giardia");
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getIdentificacao() {
        return super.getIdentificacao();
    }

    @Override
    public String getClasse_Especifica() {
        return super.getClasse_Especifica();
    }

    @Override
    public String getClasse_Geral() {
        return super.getClasse_Geral();
    }

    @Override
    public int getEnergia_Vital() {
        return super.getEnergia_Vital();
    }

    @Override
    public void setEnergia_Vital(int energia_Vital) {
        super.setEnergia_Vital(energia_Vital);
    }


    @Override
    public void Atacar() {

    }

}
