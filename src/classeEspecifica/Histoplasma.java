
package classeEspecifica;

import classeGeral.Fungo;


public class Histoplasma extends Fungo{  
    String identificacao;
    final int CODIGO = 5;
    final int ENERGIA_VITAL = 100;
    final String CLASSE_ESPECÍFICA = "Histoplasma";
    
    public Histoplasma(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getCODIGO() {
        return CODIGO;
    }

    public int getENERGIA_VITAL() {
        return ENERGIA_VITAL;
    }

    public String getCLASSE_ESPECÍFICA() {
        return CLASSE_ESPECÍFICA;
    }
    
}
