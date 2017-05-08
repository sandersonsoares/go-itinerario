/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Sanderson
 */
public class Main {

    public static void main(String[] args) {
        
        // Porcentagem de rentabilidade mensal
        double valorPorcentagem = 0.9;
        // Valor do Investimento
        double valorInvestimento = 1000;
        // Com quantos meses quer retirar?
        double quantMeses = 1;
        
        
        double totalPorcentagem = (valorPorcentagem/100)*valorInvestimento;
        double total = valorInvestimento;
        
        for (int i = 0; i < quantMeses; i++) {
            total = (total + totalPorcentagem);
        }
        double lucro = total - valorInvestimento;
        double porcentagemLucro = (lucro/10);
        
        System.out.println("Valor total após a retirada do investimento em " + quantMeses + " Meses " + total);
        System.out.println("Valor total ganho em " + quantMeses + " Meses: " + (total - valorInvestimento));
        System.out.println("Porcentagem de lucro ganho em " + quantMeses + " Meses: " + porcentagemLucro + "%");
    }
}
