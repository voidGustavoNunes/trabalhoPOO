package ataque;

import classeEspecifica.Histoplasma;
import main.Paciente;
import main.lerArquivo;

public class AtaqueHistoPlasma extends Histoplasma{
    private Paciente paciente;
    Histoplasma histoplasma = new Histoplasma();
    
    public AtaqueHistoPlasma(String identificacao) {
        super(identificacao);
    }
    
    
    public void Ataque(){
        AtaquePaciente ataque = new AtaquePaciente();
        
        String identificacao1 = histoplasma.getIdentificacao();
        int hemacias = paciente.getQntde_Hemacias();
        int energiaH = histoplasma.getENERGIA_VITAL();
        
        boolean p = paciente.verificaPaciente();
        
        
        paciente.setQntde_Hemacias(hemacias - 50);
        
        lerArquivo.verificar_Fila_Histoplasma();//validacao fila
        
        ataque.ContraAtaque();
        
        
        if(energiaH == 0){
            lerArquivo.removerDaLista(identificacao1);
        
        
        }
    }
}
