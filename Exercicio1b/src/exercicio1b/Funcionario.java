
package exercicio1b;

/**
 *
 * @author 10070361
 */
public class Funcionario {
    private String nome;
    private String cpf;
    private double salario;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }
    public double aumentarSalario( int valor) {
        this.salario = valor;
        return salario;
    }

   public void imprimirDados(){
   System.out.print("Funcionario: nome: "+nome+" CPF: "+cpf+" salario: "+salario);
   }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
