package conta;

import java.util.Scanner;

public class Conta {

    private String titular;
    private Tipo tipo;
    private double saldo;

    public String getTitular() {
        return this.titular;
    }

    private void setTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            System.out.println("O nome do títular é nulo ou vázio.");
        } else {
            this.titular = titular;
        }
    }

    public Conta criarConta() {
        Conta conta = new Conta();
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        conta.setTitular(entrada.nextLine());

        return conta;
    }
}
