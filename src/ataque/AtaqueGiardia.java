package ataque;

import classeEspecifica.Escherichia;
import classeEspecifica.Giardia;
import main.Paciente;
import main.lerArquivo;

public class AtaqueGiardia extends Giardia {

    private Paciente paciente;
    private Giardia giardia;

    public AtaqueGiardia(String identificacao) {
        super(identificacao);
    }

    public void Ataque() {
        AtaquePaciente ataquePaciente = new AtaquePaciente();

        final int RECUPERA = 50;

        int celulasK = paciente.getQntde_K();
        int celulasT = paciente.getQntde_CelulasT();

        paciente.setQntde_K(celulasK - 9);
        paciente.setQntde_CelulasT(celulasT - 8);

        int hemacias = paciente.getQntde_Hemacias();
        int leucocitos = paciente.getQntde_Leucocitos();

        int energia_Vital = giardia.getenergia_Vital();

        boolean p = paciente.verificaPaciente();
        String identificacao = giardia.getIdentificacao();

        if (p == false) {
            if ((leucocitos * 2) < hemacias) {
                giardia.setEnergia_Vital(energia_Vital + RECUPERA);
            }
            ataquePaciente.ContraAtaque();
            if (giardia.getenergia_Vital() == 0) {
                lerArquivo.removerDaLista(identificacao);

            }
        }

    }
}
