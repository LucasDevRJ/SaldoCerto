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

    public Tipo getTipo() {
        return this.tipo;
    }

    private void setTipo(int tipoContaDesejada) {
        switch (tipoContaDesejada) {
            case 1:
                this.tipo = Tipo.CORRENTE;
                break;
            case 2:
                this.tipo = Tipo.POUPANCA;
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public Conta criarConta() {
        Conta conta = new Conta();
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        conta.setTitular(entrada.nextLine());

        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.print("Selecione o tipo de conta: ");
        conta.setTipo(entrada.nextInt());

        return conta;
    }
}
