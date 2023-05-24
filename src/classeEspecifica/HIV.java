
package classeEspecifica;

import classeGeral.Virus;
import main.Paciente;
import main.lerArquivo;

public abstract class HIV extends Virus{
    String codigo = "1";
    
    public HIV(String identificacao) {
        super(identificacao, 0, "HIV");
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    
    
    @Override
    public String getClasse_Especifica() {
        return super.getClasse_Especifica(); 
    }

    @Override
    public String getClasse_Geral() {
        return super.getClasse_Geral();
    }

    @Override
    public int getEnergia_Vital() {
        return super.getEnergia_Vital(); 
    }

    @Override
    public void setEnergia_Vital(int energia_Vital) {
        super.setEnergia_Vital(energia_Vital);
    }

    @Override
    public String getIdentificacao() {
        return super.getIdentificacao();
    }
    

    Paciente paciente = new Paciente();

    @Override
    public void Atacar() {

        String  identificacao1 = getIdentificacao();
        
        boolean p = paciente.verificaPaciente();

        if(p == false) { //se o paciente nao morreu
            int leucocitos = paciente.getQntde_Leucocitos();
            int celulasK = paciente.getQntde_K();
            int celulasT = paciente.getQntde_CelulasT();
            
            
            //ATAQUE DO HIV
            paciente.setQntde_K(celulasK - 5);
            paciente.setQntde_Leucocitos(leucocitos - 10);
            paciente.setQntde_CelulasT(celulasT - 3);
            
            //CONTRA ATAQUE
            double contrataque = paciente.ContraAtaque();
            setEnergia_Vital((int) contrataque);
            
            lerArquivo.ultimoLista(identificacao1); //joga ele pra ultimo

        }

    }
    
}
