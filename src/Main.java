import conta.Conta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main principal = new Main();
        principal.exibeMensagemInicial();

        Conta conta = new Conta();
        conta.criarConta();
        conta.exibeInformacoesDaConta();
        principal.exibeMenuPrincipal(conta);
    }

    public void exibeMensagemInicial() {
        System.out.println("Bem-vindo ao Saldo Certo.");
        System.out.println("O nosso sistema bancário de sucesso.");
        System.out.println();
    }

    public void exibeMenuPrincipal(Conta conta) {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("--------------------|Menu Principal|--------------------");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Receber Valor");
            System.out.println("3 - Transferir Valor");
            System.out.println("4 - Sair");
            System.out.print("Digite sua opção desejada: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    conta.receberValor();
                    break;
                case 3:
                    conta.transferirValor();
                    break;
                case 4:
                    conta.finalizarPrograma();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
        System.out.println("-----------------------------------------------------------");
    }
}