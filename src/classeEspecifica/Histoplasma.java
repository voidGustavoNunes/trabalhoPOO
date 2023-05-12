
package classeEspecifica;

import classeGeral.Fungo;


public class Histoplasma extends Fungo{  
    private String identificacao;
    final String CODIGO = "5";
    final int ENERGIA_VITAL = 100;
    final String CLASSE_ESPECÍFICA = "Histoplasma";
    
    public Histoplasma(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public int getENERGIA_VITAL() {
        return ENERGIA_VITAL;
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
    
    
    
}
