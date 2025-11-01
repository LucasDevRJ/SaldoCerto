package conta;

import java.util.Scanner;

public class Conta {

    private String titular;
    private Tipo tipo;
    private double saldo;

    private void setTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            System.out.println("O nome do títular é nulo ou vázio.");
        } else {
            this.titular = titular;
        }
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

    private void setSaldo(double saldo) {
        if (saldo <= 0) {
            System.out.println("Saldo inválido.");
        } else {
            this.saldo = saldo;
        }
    }

    public void criarConta() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        setTitular(entrada.nextLine());

        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.print("Selecione o tipo de conta: ");
        setTipo(entrada.nextInt());

        System.out.print("Digite seu saldo inicial: R$ ");
        setSaldo(entrada.nextDouble());
    }

    public void exibeInformacoesDaConta() {
        String informacoes = """
                --------------------|Informações da Conta|--------------------
                Nome: %s
                Tipo de conta: %s
                Saldo inicial: R$ %.2f
                --------------------------------------------------------------
                """.formatted(this.titular, this.tipo, this.saldo);
        System.out.println(informacoes);
    }

    public void consultarSaldo() {
        System.out.println("--------------------|Seu Saldo Atual|--------------------");
        System.out.println(String.format("O saldo atual é R$ %.2f", this.saldo));
        System.out.println("---------------------------------------------------------");
    }

    public void receberValor() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("--------------------|Valor a Receber|--------------------");
        System.out.print("Digite o valor a receber: R$ ");
        double valorAReceber = entrada.nextDouble();

        double novoSaldo = this.saldo + valorAReceber;
        setSaldo(novoSaldo);
        System.out.println("Saldo atualizado R$ " + this.saldo);
        System.out.println("--------------------------------------------------------");
    }
}
