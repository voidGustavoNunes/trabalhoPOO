
package classeGeral;

import AgentePatologico.AgentePatologico;


public abstract class Virus extends AgentePatologico{
    int qt = 0;
    
    public Virus(String identificacao, int energia_Vital, String classe_Especifica) {
        super(identificacao, energia_Vital, "Virus", classe_Especifica);
        qt++;
    }

}
