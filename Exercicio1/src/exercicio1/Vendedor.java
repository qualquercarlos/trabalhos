/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

/**
 *
 * @author 10070361
 */
public class Vendedor {

    private String nome;
    private String cpf;
    private double salario;
    private String numeroFilial;

    
    public String getNumeroFilial() {
        return numeroFilial;
    }

    public double aumentarSalario(int valor) {
        this.salario = valor;
        return salario;
    }

    public void imprimirDados() {
        System.out.print("Vendedor: ");
        System.out.println("nome: " + nome + " CPF: " + cpf + " salario: " + salario+" filial: "+numeroFilial);
    }
    
    
    /*Vendedor() {
   this.nome = "jão"; 
   this.cpf = "000.000.000-01";
   this.salario= 998*2;
   this.numeroFilial = "01";
   }*/

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNumeroFilial(String numeroFilial) {
        this.numeroFilial = numeroFilial;
    }

}
