package classeEspecifica;

import classeGeral.Bacteria;

public class Escherichia extends Bacteria {

    final int CODIGO = 6;
    final int ENERGIA_VITAL = 100;
    String identificacao;
    final String CLASSE_ESPECÍFICA = "Escherichia";

    public Escherichia(String identificacao) {
        this.identificacao = identificacao;
    }
    
    
}
