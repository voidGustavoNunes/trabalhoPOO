
package classeGeral;

import AgentePatologico.AgentePatologico;
<<<<<<< HEAD
import java.util.LinkedList;
import main.Paciente;
=======
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9


public abstract class Virus extends AgentePatologico{
    private static int qt = 0;
    
    public Virus(String identificacao, int energia_Vital, String classe_Especifica) {
        super(identificacao, energia_Vital, "Virus", classe_Especifica);
        qt++;
    }

    public Virus() {
        qt++;
    }
<<<<<<< HEAD
=======
    
    
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9

    public static int getQt() {
        return qt;
    }
<<<<<<< HEAD
    
    @Override
    public void Atacar(LinkedList<AgentePatologico> listaPatologicos, Paciente patiente){};
=======
    @Override
    public void Atacar(){}
>>>>>>> 6710c81fa9059dabe56ad02f551ff791533c0bb9

}
