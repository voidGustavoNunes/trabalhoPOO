package classeEspecifica;

import classeGeral.Bacteria;

public class Estreptococos extends Bacteria {

    final int CODIGO = 2;
    final int ENERGIA_VITAL = 100;
    String identificacao;
    final String CLASSE_ESPECÍFICA = "Estreptococos";
    

    public Estreptococos(String identificacao) {
        this.identificacao = identificacao;
        Estreptococos.qt++;
    }

    public static int getQt() {
        return qt;
    }
    
    
}
