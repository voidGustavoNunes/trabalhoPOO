
package classeGeral;

import AgentePatologico.AgentePatologico;

public abstract class Bacteria extends AgentePatologico{
    private static int qt = 0;

    public Bacteria(String identificacao, int energia_Vital, String classe_Especifica) {
        super(identificacao, energia_Vital, "Virus", classe_Especifica);
        qt++;
    }

    public Bacteria() {
        qt++;
    }

    public static int getQt() {
        return qt;
    }
    
    @Override
    public void Atacar(){}
    
    
}
