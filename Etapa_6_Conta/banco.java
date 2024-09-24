package Etapa_6_Conta;

import java.util.Scanner; // Importa a classe Scanner para entrada de dados

// Classe que representa um banco
class Bank {
    private static double saque; // Valor do saque
    private static double deposito; // Valor do depósito
    private double consulta; // Valor da consulta (não utilizado atualmente)
    private static double extratoAtual; // Saldo atual da conta
    private int consultaNumero; // Contador de consultas

    // Construtor da classe Bank
    public Bank(double saque, double deposito, double consulta, double extratoAtual, int consultaNumero) {
        this.saque = saque; // Inicializa o valor do saque
        this.deposito = deposito; // Inicializa o valor do depósito
        this.consulta = consulta; // Inicializa o valor da consulta
        this.extratoAtual = extratoAtual; // Inicializa o saldo atual
        this.consultaNumero = consultaNumero; // Inicializa o contador de consultas
    }

    // Método para obter o valor do saque
    public static double getSaque() {
        return saque; // Retorna o valor do saque
    }

    // Método para realizar um saque
    public void setSaque(Scanner input) {
        double taxa = 0.005; // Taxa de saque (0.5%)

        System.out.println("Valor desejado a ser sacado:"); // Solicita o valor do saque
        saque = input.nextDouble(); // Lê o valor do saque

        // Calcula a taxa sobre o valor do saque
        double taxaCobrada = saque * taxa;

        System.out.println("Será cobrado R$ " + taxaCobrada + " de taxa no valor sacado!"); // Exibe a taxa

        // Atualiza o extrato, descontando o saque e a taxa
        extratoAtual -= (saque + taxaCobrada);
        System.out.println("Valor total de: R$ " + (saque + taxaCobrada)); // Exibe o valor total
    }

    // Método para obter o valor do depósito
    public static double getDeposito() {
        return deposito; // Retorna o valor do depósito
    }

    // Método para realizar um depósito
    public void setDeposito(Scanner input) {
        double taxa = 0.01; // Taxa de depósito (1%)

        System.out.println("Valor a ser Depositado?"); // Solicita o valor do depósito
        this.deposito = input.nextDouble(); // Lê o valor do depósito

        // Calcula a taxa sobre o valor do depósito
        double taxaCobrada = this.deposito * taxa;

        System.out.println("Será cobrado R$ " + taxaCobrada + " de taxa no valor do Depósito!"); // Exibe a taxa

        // Atualiza o extrato, considerando a taxa
        extratoAtual += (deposito - taxaCobrada);
        System.out.println("\n\nValor total após depósito: R$ " + (deposito - taxaCobrada)); // Exibe o saldo após o depósito
    }

    // Método para obter o extrato (não utilizado atualmente)
    public double getExtrato() {
        return consulta; // Retorna o valor da consulta
    }

    // Método para consultar o extrato
    public void setExtrato() {
        double taxaConsulta = 0.1; // Taxa de consulta (R$0,10)

        consultaNumero++; // Incrementa o contador de consultas
        System.out.println("Saldo disponível atual é de R$ " + extratoAtual + 
            ". Realizou " + consultaNumero + 
            " consultas, e a cada 5 consultas feitas, será cobrado R$0,10."); // Informa o saldo e o número de consultas

        // Verifica se a quantidade de consultas excedeu o limite gratuito
        if (consultaNumero % 5 == 0) {
            extratoAtual -= taxaConsulta; // Deduz a taxa do extrato
            System.out.println("Consultas gratuitas excedidas. Será cobrado R$0,10! Extrato Atual: R$ " + extratoAtual); // Informa sobre a cobrança
        }
    }

    // Método para obter o saldo atual
    public static double getExtratoAtual() {
        return extratoAtual; // Retorna o saldo atual
    }

    // Método para definir o extrato atual (não utilizado atualmente)
    public void setExtratoAtual() {
        this.extratoAtual = extratoAtual; // Define o saldo atual
    }
}

// Classe principal que executa o programa
public class banco {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Inicializa o Scanner para entrada de dados

        // Cria uma nova instância de Bank com saldo inicial
        Bank banco = new Bank(0, 0, 0, 1000, 0);

        while (true) { // Loop contínuo para as operações do banco
            // Exibe as opções de operação
            System.out.println("\n\nEscolha a Operação que deseja realizar:" + 
                "\n [1] Saque" +
                "\n [2] Depósito" +
                "\n [3] Consultar Extrato");
            int escolha = input.nextInt(); // Lê a escolha do usuário

            // Realiza a operação de acordo com a escolha
            if (escolha == 1) {
                banco.setSaque(input); // Chama o método de saque
            } else if (escolha == 2) {
                banco.setDeposito(input); // Chama o método de depósito
            } else if (escolha == 3) {
                banco.setExtrato(); // Chama o método de consulta de extrato
            } else {
                System.err.println("Erro! Escolha a Opção Correta!"); // Mensagem de erro para entrada inválida
            }
        }
        // input.close(); // O Scanner só deve ser fechado ao fim do programa, se necessário.
    }
}
