package Aula2;

import java.util.Scanner; // Importa a classe Scanner para entrada de dados
import java.lang.Math; // Importa a classe Math para operações matemáticas

// Classe para calcular o fatorial
class fat {
    private double n8; // Número para calcular o fatorial

    // Construtor da classe fat
    public fat(double n8) {
        this.n8 = n8; // Inicializa o número
    }

    // Método privado que calcula o fatorial
    private double Fatorial() {
        double multiplica = 1; // Inicializa a multiplicação em 1
        for (double i = n8; i > 1; i--) {
            multiplica *= i; // Multiplica os números até n8
        }
        return multiplica; // Retorna o resultado do fatorial
    }

    // Método público que retorna o fatorial
    public double getFatorial() {
        return Fatorial(); // Chama o método Fatorial
    }
}

// Classe para converter minutos em horas
class Minutos {
    private int minutos; // Número de minutos

    // Construtor da classe Minutos
    public Minutos(int minutos) {
        this.minutos = minutos; // Inicializa os minutos
    }

    // Método privado que converte minutos em horas e minutos
    private String MinutosHoras() {
        int horas = minutos / 60; // Calcula as horas
        int mins = minutos % 60; // Calcula os minutos restantes
        return String.format("%d:%02d", horas, mins); // Formata horas e minutos
    }

    // Método público que retorna a representação em horas e minutos
    public String getHorasMinutos() {
        return MinutosHoras(); // Chama o método MinutosHoras
    }
}

// Classe para calcular a potência de A elevado a B
class numAB {
    private double A; // Base
    private double B; // Expoente

    // Construtor da classe numAB
    public numAB(double a2, double b2) {
        this.A = a2; // Inicializa a base
        this.B = b2; // Inicializa o expoente
    }

    // Método privado que calcula A elevado a B
    private double multi() {
        return Math.pow(A, B); // Retorna o resultado da potência
    }

    // Método público que retorna a potência
    public double getMulti() {
        return multi(); // Chama o método multi
    }
}

// Classe para encontrar o maior número entre três
class numMaior {
    private double n5; // Primeiro número
    private double n6; // Segundo número
    private double n7; // Terceiro número

    // Construtor da classe numMaior
    public numMaior(double n5, double n6, double n7) {
        this.n5 = n5; // Inicializa o primeiro número
        this.n6 = n6; // Inicializa o segundo número
        this.n7 = n7; // Inicializa o terceiro número
    }

    // Método privado que verifica qual número é o maior
    private double verificaNum() {
        return Math.max(n5, Math.max(n6, n7)); // Usa Math.max para encontrar o maior
    }

    // Método público que retorna o maior número
    public double getVerificaNum() {
        return verificaNum(); // Chama o método verificaNum
    }
}

// Classe para calcular a média aritmética
class media {
    private double n2; // Primeiro número
    private double n3; // Segundo número
    private double n4; // Terceiro número

    // Construtor da classe media
    public media(double n2, double n3, double n4) {
        this.n2 = n2; // Inicializa o primeiro número
        this.n3 = n3; // Inicializa o segundo número
        this.n4 = n4; // Inicializa o terceiro número
    }

    // Método que calcula e retorna a média aritmética
    public double divisao() {
        return (n2 + n3 + n4) / 3; // Retorna a média
    }
}

// Classe para verificar se um número é positivo ou negativo
class positivo_negativo {
    private int n1; // Número a ser verificado

    // Construtor da classe positivo_negativo
    public positivo_negativo(int n1) {
        this.n1 = n1; // Inicializa o número
    }

    // Método que verifica se o número é positivo ou negativo
    public String positivo_negativo_verificacao() {
        return (n1 >= 0) ? "O Número é Positivo!" : "O Número é Negativo!"; // Retorna a verificação
    }
}

// Classe que controla a seleção de métodos
class respostaMetodo {
    private int respostaMet; // Armazena a escolha do usuário

    // Construtor da classe respostaMetodo
    public respostaMetodo(int respostaMet) {
        this.respostaMet = respostaMet; // Inicializa a escolha
    }

    // Método que verifica a resposta e executa o método correspondente
    public void resposta_metodo_verificacao() {
        Scanner input = new Scanner(System.in); // Cria um Scanner para entrada

        // Verifica qual método foi escolhido
        if (respostaMet == 1) { // Positivo ou Negativo
            System.out.println("Digite o Número que deseja verificar:");
            int n1 = input.nextInt(); // Lê o número do usuário

            positivo_negativo Positivo_Negativo = new positivo_negativo(n1); // Cria objeto

            // Exibe a verificação
            System.out.println("Este número: " + n1 + " é " + Positivo_Negativo.positivo_negativo_verificacao());
            
        } else if (respostaMet == 2) { // Média Aritmética

            System.out.println("Escreva o Primeiro Número:");
            double n2 = input.nextDouble(); // Lê o primeiro número

            System.out.println("Escreva o Segundo Número:");
            double n3 = input.nextDouble(); // Lê o segundo número

            System.out.println("Escreva o Terceiro Número:");
            double n4 = input.nextDouble(); // Lê o terceiro número

            media media_aritimetica = new media(n2, n3, n4); // Cria objeto

            // Exibe a média
            System.out.println("A Média Aritimética é: " + media_aritimetica.divisao());

        } else if (respostaMet == 3) { // Número Maior
            System.out.println("Escreva o Primeiro Número:");
            double n5 = input.nextDouble(); // Lê o primeiro número

            System.out.println("Escreva o Segundo Número:");
            double n6 = input.nextDouble(); // Lê o segundo número

            System.out.println("Escreva o Terceiro Número:");
            double n7 = input.nextDouble(); // Lê o terceiro número

            numMaior num = new numMaior(n5, n6, n7); // Cria objeto

            // Exibe o maior número
            System.out.println("O maior Número digitado é: " + num.getVerificaNum());

        } else if (respostaMet == 4) { // Elevado
            System.out.println("Escreva o Número Base:");
            double A = input.nextDouble(); // Lê a base

            System.out.println("Escreva o Número Expoente:");
            double B = input.nextDouble(); // Lê o expoente

            numAB numeroElevado = new numAB(A, B); // Cria objeto

            // Exibe o resultado da potência
            System.out.println("O Número " + A + " elevado a " + B + " é " + numeroElevado.getMulti());

        } else if (respostaMet == 5) { // Minutos para Horas
            System.out.println("Escreva a quantia de minutos:");

            int minutos = input.nextInt(); // Lê a quantidade de minutos
            Minutos horaMinutos = new Minutos(minutos); // Cria objeto

            // Exibe a conversão de minutos para horas
            System.out.println("Transformando " + minutos + "mins em horas: " + horaMinutos.getHorasMinutos());

        } else if (respostaMet == 6) { // Fatorial
            System.out.println("Digite o Número:");

            double n8 = input.nextDouble(); // Lê o número para cálculo do fatorial
            fat fatorial = new fat(n8); // Cria objeto

            // Exibe o resultado do fatorial
            System.out.println("O Fatorial de " + n8 + " é " + fatorial.getFatorial());

        } else {
            System.out.println("Método inválido."); // Mensagem para opção inválida
        }

        input.close(); // Fecha o Scanner após usar
    }
}

// Classe principal que executa o programa
public class metodos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Cria um Scanner para entrada

        // Exibe o menu de opções
        System.out.println("\n\nQual Método deseja utilizar?" +
                "\n [1] Positivo e Negativos" +
                "\n [2] Média Aritmética" +
                "\n [3] Número Maior" +
                "\n [4] Elevado" +
                "\n [5] Minuto para Horas" +
                "\n [6] Fatorial");
        int respostaMet = input.nextInt(); // Lê a escolha do usuário

        respostaMetodo metodo = new respostaMetodo(respostaMet); // Cria objeto com a escolha
        metodo.resposta_metodo_verificacao(); // Chama o método para verificar a resposta

        input.close(); // Fecha o Scanner
    }
}
