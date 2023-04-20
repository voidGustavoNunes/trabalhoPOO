
package trabalhodeescola;


public class Covid19 extends Virus{
    final int energia_Vital = 100;
    
    String classe_Geral;
    String classe_Especifica;

    public Covid19(String identificacao) {
        lerArquivo()
        
        super(identificacao);
        this.classe_Geral = getClass().getSuperclass().getSimpleName(); // quero que a classe geral pegue automaticamente o nome virus, o getsimplename
                                                                        // e usado para obter o nome da classe extendida Virus
        this.classe_Especifica = getClass().getSimpleName();
    }
}
