package classeEspecifica;

import classeGeral.Virus;
import java.util.LinkedList;
import main.*;

public abstract class Covid19 extends Virus {
    
    String codigo = "4";

    public Covid19(String identificacao) {
        super(identificacao, 100, "Covid19");
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
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
    public String getIdentificacao() {
        return super.getIdentificacao();
    }

    @Override
    public void Atacar() {

    }

}
