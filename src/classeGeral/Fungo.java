package classeGeral;

import AgentePatologico.AgentePatologico;


public abstract class Fungo extends AgentePatologico{
    private static int qt = 0;

    public Fungo(String identificacao, int energia_Vital, String classe_Especifica) {
        super(identificacao, energia_Vital, "Fungo", classe_Especifica);
        qt++;
    }

    public Fungo() {
        qt++;
    }

    
    
    public static int getQt() {
        return qt;
    }
    @Override
    public void Atacar(){}
    
    
}
