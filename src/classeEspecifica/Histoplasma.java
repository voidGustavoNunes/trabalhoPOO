
package classeEspecifica;

import classeGeral.Fungo;


public class Histoplasma extends Fungo{  
    private String identificacao;
    final String CODIGO = "5";
    int energia_Vital = 100;
    final String CLASSE_ESPECÍFICA = "Histoplasma";
    
    public Histoplasma(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public int getenergia_Vital() {
        return energia_Vital;
    }

    public String getCLASSE_ESPECÍFICA() {
        return CLASSE_ESPECÍFICA;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public String getCLASSE_GERAL() {
        return CLASSE_GERAL;
    }

    public void setEnergia_Vital(int energia_Vital) {
        this.energia_Vital = energia_Vital;
    }
    
    
    
}
