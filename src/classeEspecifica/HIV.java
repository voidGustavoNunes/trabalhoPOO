
package classeEspecifica;

import classeGeral.Virus;

public class HIV extends Virus{
    final int CODIGO = 1;
    final int ENERGIA_VITAL = 100;
    String identificacao;
    final String CLASSE_ESPECÍFICA = "HIV";

    public HIV(String identificacao) {
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
