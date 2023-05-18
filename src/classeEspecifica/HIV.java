
package classeEspecifica;

import classeGeral.Virus;

public class HIV extends Virus{
    final int CODIGO = 1;
    int energia_Vital = 100;
    String identificacao;
    final String CLASSE_ESPECÍFICA = "HIV";

    public HIV(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getCODIGO() {
        return CODIGO;
    }

    public int getenergia_Vital() {
        return energia_Vital;
    }

    public String getCLASSE_ESPECÍFICA() {
        return CLASSE_ESPECÍFICA;
    }

    public void setEnergia_Vital(int energia_Vital) {
        this.energia_Vital = energia_Vital;
    }
    
    
}
