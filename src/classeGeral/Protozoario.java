
package classeGeral;

import AgentePatologico.AgentePatologico;


public abstract class Protozoario extends AgentePatologico{
    private static int qt = 0;

    public Protozoario(String identificacao, int energia_Vital, String classe_Especifica) {
        super(identificacao, energia_Vital, "Protozoário", classe_Especifica);
        qt++;
    }

    public Protozoario() {
        qt++;
    }
    
    

    public static int getQt() {
        return qt;
    }
    @Override
    public void Atacar(){}
    
}
