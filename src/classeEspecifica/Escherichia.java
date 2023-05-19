package classeEspecifica;

import classeGeral.Bacteria;

public class Escherichia extends Bacteria {

    private final String CODIGO = "6";
    int energia_Vital = 64;
    String identificacao;
    private final String CLASSE_ESPECÍFICA = "Escherichia";
    

    public Escherichia(String identificacao) {
        this.identificacao = identificacao;
        Escherichia.qt++;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public static int getQt() {
        return qt;
    }

    public int getenergia_Vital() {
        return energia_Vital;
    }

    public void setEnergia_Vital(int energia_Vital) {
        this.energia_Vital = energia_Vital;
    }

    public String getCLASSE_ESPECÍFICA() {
        return CLASSE_ESPECÍFICA;
    }
    
    
    
}
