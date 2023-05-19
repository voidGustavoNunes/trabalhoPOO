
package classeEspecifica;

import classeGeral.Protozoario;


public class Giardia extends Protozoario{
    int codigo = 3;
    int energia_Vital = 100;
    String identificacao;


    public String getIdentificacao() {
        return identificacao;
    }
    String classe_Especifica = "Giardia";

    public Giardia(String identificacao) {
        this.identificacao = identificacao;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public int getenergia_Vital() {
        return energia_Vital;
    }

    public String getclasse_Especifica() {
        return classe_Especifica;
    }

    public void setEnergia_Vital(int energia_Vital) {
        this.energia_Vital = energia_Vital;
    }
    
    
}
