package ataque;

import classeEspecifica.Covid19;
import java.util.LinkedList;
import main.*;


public class AtaqueCovid19 extends Covid19{
    private Paciente paciente;

    public AtaqueCovid19(String identificacao) {
        super(identificacao);
    }
    
    public void Ataque() {
        GerarIdentificador gerar = new GerarIdentificador();
        AtaquePaciente ataque = new AtaquePaciente();
        
        LinkedList lista = lerArquivo.lerArquivo1();
        LinkedList listaIdentificacao = new LinkedList();
        
        String codigo = getCodigo(); //valor 4
        
        String parte[] = codigo.split(" ", 2);
        
        String identificacao = lerArquivo.retornaIdentificacao(codigo);
        listaIdentificacao.add(identificacao);
        for(int i = 0; i <= listaIdentificacao.size(); i++){
            if(identificacao.equals(listaIdentificacao.get(i))){
                String identificacao = lerArquivo.retornaIdentificacao(codigo);
            }
        }
        

        Covid19 covid19 = new Covid19(identificacao);
        
        int celulasT = paciente.getQntde_Celulas();
        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();

        paciente.setQntde_Leucocitos(leucocitos - 10);
        paciente.setQntde_Celulas(celulasT - 2);
        paciente.setQntde_Hemacias(hemacias - 15);
        
        ataque.ContraAtaque();
        
        if (hemacias < 200) {
            paciente.setQntde_Leucocitos(leucocitos - 10);
            paciente.setQntde_Celulas(celulasT - 2);
            paciente.setQntde_Hemacias(hemacias - 15);
            ataque.ContraAtaque();
            lista.offer(covid19); //vai pro final da lista 
        }
    }

}
