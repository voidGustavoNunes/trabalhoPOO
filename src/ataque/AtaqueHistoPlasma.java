package ataque;

import classeEspecifica.Histoplasma;
import main.Paciente;
import main.lerArquivo;

public class AtaqueHistoPlasma extends Histoplasma {

    private Paciente paciente;
    private Histoplasma histoplasma;

    public AtaqueHistoPlasma(String identificacao) {
        super(identificacao);
    }

    public void Ataque() {
        AtaquePaciente ataque = new AtaquePaciente();

        String identificacao1 = histoplasma.getIdentificacao();
        int hemacias = paciente.getQntde_Hemacias();
        int energiaH = histoplasma.getenergia_Vital();

        boolean p = paciente.verificaPaciente();

        if(p == false) { //se paciente nao morreu
            paciente.setQntde_Hemacias(hemacias - 50);

            lerArquivo.verificar_Fila_Histoplasma();//validacao fila

            double contraataque = ataque.ContraAtaque();
            histoplasma.setEnergia_Vital(energiaH - (int)contraataque);
            
            
            lerArquivo.ultimoLista(identificacao1); //joga ele pra ultimo

            if (energiaH == 0) {
                lerArquivo.removerDaLista(identificacao1);
            }
        }
    }
}
