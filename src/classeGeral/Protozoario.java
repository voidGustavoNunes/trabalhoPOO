
package classeGeral;

import AgentePatologico.AgentePatologico;
<<<<<<< HEAD
import java.util.LinkedList;
import main.Paciente;
=======
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9


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
<<<<<<< HEAD
    public void Atacar(LinkedList<AgentePatologico> listaPatologicos, Paciente patiente){}
=======
    public void Atacar(){}
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9
    
}
