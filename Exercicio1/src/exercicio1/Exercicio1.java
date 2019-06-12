/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;
import exercicio1.Funcionario;
import exercicio1.Vendedor;
/**
 *
 * @author 10070361
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   Funcionario f1 = new Funcionario();
   f1.setNome("alessandro");
   f1.setCpf("000.000.000-01");
   f1.setSalario(998.50);
   
   f1.imprimirDados();
   
   Vendedor v1 = new Vendedor();
   v1.setNome("carlos");
   v1.setCpf("000.000.000-02");
   v1.setSalario(1990.50);
   v1.setNumeroFilial("01");
   v1.imprimirDados();
    }
    
}
