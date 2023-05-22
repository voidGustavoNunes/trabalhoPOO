
package classeGeral;

import AgentePatologico.AgentePatologico;


public abstract class Protozoario extends AgentePatologico{
    int qt = 0;

    public Protozoario(String identificacao, int energia_Vital, String classe_Especifica) {
        super(identificacao, energia_Vital, "Protozoário", classe_Especifica);
        qt++;
    }
    
}
