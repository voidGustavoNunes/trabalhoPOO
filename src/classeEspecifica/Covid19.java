
package classeEspecifica;

import classeGeral.Virus;
import main.*;

public class Covid19 extends Virus{
    
    String codigo = "4";
    String identificacao;
    final String CLASSE_GERAL = "Covid-19";


    public String getCodigo() {
        return codigo;
    }

    public String getCLASSE_GERAL() {
        return CLASSE_GERAL;
    }

    public Covid19(String identificacao) {
        this.identificacao = identificacao;
        Covid19.qt++;
    }

    public static int getQt() {
        return qt;
    }
    
}
