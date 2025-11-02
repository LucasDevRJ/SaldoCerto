package conta;

import java.util.Scanner;

public class Conta {

    private String titular;
    private Tipo tipo;
    private double saldo;
    private boolean usuarioValido;

    private void setTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            System.out.println("O nome do títular é nulo ou vázio.");
            this.usuarioValido = false;
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
                this.usuarioValido = false;
        }
    }

    private void setSaldo(double saldo) {
        if (saldo <= 0) {
            System.out.println("Saldo inválido.");
            usuarioValido = false;
        } else {
            this.saldo = saldo;
        }
    }

    public void criarConta() {
        do {
            this.usuarioValido = true;
            Scanner entrada = new Scanner(System.in);
            System.out.print("Digite o seu nome: ");
            setTitular(entrada.nextLine());

            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Poupança");
            System.out.print("Selecione o tipo de conta: ");
            setTipo(entrada.nextInt());

            System.out.print("Digite seu saldo inicial: R$ ");
            setSaldo(entrada.nextDouble());
        } while (usuarioValido == false);
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

        if (valorAReceber <= 0) {
            System.out.println("Valor inválido.");
        } else {
            double novoSaldo = this.saldo + valorAReceber;
            setSaldo(novoSaldo);
            System.out.println(String.format("O saldo atual é R$ %.2f", this.saldo));
            System.out.println("--------------------------------------------------------");
        }
    }

    public void transferirValor() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("--------------------|Transferir Valor|--------------------");
        System.out.print("Digite o valor que deseja transferir: R$ ");
        double valorATransferir = entrada.nextDouble();

        if (valorATransferir > this.saldo || valorATransferir <= 0) {
            System.out.println("Saldo insuficiente ou valor inválido.");
        } else {
            double novoSaldo = this.saldo - valorATransferir;
            setSaldo(novoSaldo);
            System.out.println(String.format("O saldo atual é R$ %.2f", this.saldo));
        }
        System.out.println("--------------------------------------------------------");
    }

    public void finalizarPrograma() {
        System.out.println("--------------------|Programa Finalizado|--------------------");
        System.out.println("Nós agradecemos por você estar conosco.");
        System.out.println("Muito obrigado e volte sempre.");
        System.out.println("-------------------------------------------------------------");
    }
}
