package ataque;

import main.Paciente;

public class AtaquePaciente extends Paciente{

    public double ContraAtaque() {
        int leucocitos = getQntde_Leucocitos();
        double peso = getPeso();
        double altura = getAltura();
        int idade = getIdade();
        
        double ataque = (((double) leucocitos)/ peso * altura * (double) idade);
        
        return ataque;   
    }
    
}
