
package trabalhodeescola;


public class paciente {
    String nome;
    double peso;
    double altura;
    int idade;
    int qntde_Leucocitos;
    int qntde_Hemacias;
    int qntde_Celulas;
    int qntde_K;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getQntde_Leucocitos() {
        return qntde_Leucocitos;
    }

    public void setQntde_Leucocitos(int qntde_Leucocitos) {
        this.qntde_Leucocitos = qntde_Leucocitos;
    }

    public int getQntde_Hemacias() {
        return qntde_Hemacias;
    }

    public void setQntde_Hemacias(int qntde_Hemacias) {
        this.qntde_Hemacias = qntde_Hemacias;
    }

    public int getQntde_Celulas() {
        return qntde_Celulas;
    }

    public void setQntde_Celulas(int qntde_Celulas) {
        this.qntde_Celulas = qntde_Celulas;
    }

    public int getQntde_K() {
        return qntde_K;
    }

    public void setQntde_K(int qntde_K) {
        this.qntde_K = qntde_K;
    }

    paciente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
