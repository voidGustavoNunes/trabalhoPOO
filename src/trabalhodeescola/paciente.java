
package trabalhodeescola;


public class paciente {
    private String nome;
    private double peso;
    private double altura;
    private int idade;
    private int qntde_Leucocitos;
    private int qntde_Hemacias;
    private int qntde_Celulas;
    private int qntde_K;

    public paciente(String nome, double peso, double altura, int idade, int qntde_Leucocitos, int qntde_Hemacias, int qntde_Celulas, int qntde_K) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.qntde_Leucocitos = qntde_Leucocitos;
        this.qntde_Hemacias = qntde_Hemacias;
        this.qntde_Celulas = qntde_Celulas;
        this.qntde_K = qntde_K;
    }
    
}
