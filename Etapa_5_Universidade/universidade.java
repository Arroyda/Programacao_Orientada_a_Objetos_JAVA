package Etapa_5_Universidade;

import java.util.Scanner;

// Classe que representa um Aluno
class Aluno {
    private String nome; // Nome do aluno
    private String ra;   // Registro Acadêmico do aluno
    private String curso; // Curso do aluno
    private String turma; // Turma do aluno

    // Construtor da classe Aluno
    public Aluno(String nome, String ra, String curso, String turma) {
        this.nome = nome;
        this.ra = ra;
        this.curso = curso;
        this.turma = turma;
    }

    // Métodos para definir as informações do aluno
    public void setNome(Scanner input) {
        System.out.println("Qual o Nome Completo do Aluno?");
        nome = input.nextLine();
    }

    public void setRa(Scanner input) {
        System.out.println("Qual o RA do Aluno?");
        ra = input.nextLine();
    }

    public void setCurso(Scanner input) {
        System.out.println("Qual o Curso do Aluno?");
        curso = input.nextLine();
    }

    public void setTurma(Scanner input) {
        System.out.println("Qual a Turma do Aluno?");
        turma = input.nextLine();
    }

    // Métodos para obter as informações do aluno
    public String getNome() {
        return nome;
    }

    public String getRa() {
        return ra;
    }

    public String getCurso() {
        return curso;
    }

    public String getTurma() {
        return turma;
    }
}

// Classe que representa as Notas do aluno
class Notas {
    double n1; // Nota 1
    double n2; // Nota 2
    double n3; // Nota 3
    double n4; // Nota 4
    private double boletim; // Nota final
    private int prova;      // Número de provas
    private int presenca;   // Porcentagem de presença

    // Construtor da classe Notas
    public Notas(double n1, double n2, double n3, double n4, int prova, int presenca) {
        // Verifica se as notas e a presença são válidas
        if (verificaNotas(n1, n2, n3, n4) && verificaPresenca(presenca)) {
            this.n1 = n1;
            this.n2 = n2;
            this.n3 = n3;
            this.n4 = n4;
            this.prova = prova;
            this.presenca = presenca;
            this.boletim = calcularBoletim(); // Calcular boletim
        } else {
            throw new IllegalArgumentException("Verificar notas ou presença!");
        }
    }

    // Métodos para definir as notas
    public void setN1(Scanner input) {
        System.out.println("Qual o valor da Nota 1?");
        n1 = input.nextDouble();
    }

    public void setN2(Scanner input) {
        System.out.println("Qual o valor da Nota 2?");
        n2 = input.nextDouble();
    }

    public void setN3(Scanner input) {
        System.out.println("Qual o valor da Nota 3?");
        n3 = input.nextDouble();
    }

    public void setN4(Scanner input) {
        System.out.println("Qual o valor da Nota 4?");
        n4 = input.nextDouble();
    }

    // Método para verificar se as notas estão entre 0 e 10
    private boolean verificaNotas(double... notas) {
        for (double nota : notas) {
            if (nota < 0 || nota > 10) {
                return false; // Nota inválida
            }
        }
        return true; // Todas as notas são válidas
    }

    // Método para verificar se a presença está entre 0 e 100
    private boolean verificaPresenca(int presenca) {
        return presenca >= 0 && presenca <= 100; // Presença válida
    }

    // Método para calcular a média das notas
    private double calcularBoletim() {
        return (n1 + n2 + n3 + n4) / 4; // Média simples
    }

    // Método para obter a nota final
    public double getBoletim() {
        return boletim;
    }
}

// Classe principal da aplicação
public class universidade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Inicializa o Scanner para entrada de dados

        try {
            // Cria um novo objeto Aluno
            Aluno aluno = new Aluno("", "", "", "");

            // Coleta informações do aluno
            aluno.setNome(input);
            aluno.setRa(input);
            aluno.setCurso(input);
            aluno.setTurma(input);

            // Exibe os dados do aluno
            System.out.println("\n\nDados Aluno:" +
                    "\n Nome: " + aluno.getNome() +
                    "\n RA: " + aluno.getRa() +
                    "\n Curso: " + aluno.getCurso() +
                    "\n Turma: " + aluno.getTurma());

            // Pergunta ao usuário quantas notas serão avaliadas
            System.out.println("\n\nQuantas notas serão avaliadas?" +
                    "\n [1] 1 Nota" +
                    "\n [2] 2 Notas" +
                    "\n [3] 3 Notas" +
                    "\n [4] 4 Notas");
            int quantidadeNotas = input.nextInt(); // Lê a escolha do usuário

            // Cria uma nova instância de Notas com valores iniciais
            Notas notas = new Notas(0, 0, 0, 0, quantidadeNotas, 0);

            // Solicita as notas com base na escolha do usuário
            switch (quantidadeNotas) {
                case 1:
                    notas.setN1(input);
                    break;
                case 2:
                    notas.setN1(input);
                    notas.setN2(input);
                    break;
                case 3:
                    notas.setN1(input);
                    notas.setN2(input);
                    notas.setN3(input);
                    break;
                case 4:
                    notas.setN1(input);
                    notas.setN2(input);
                    notas.setN3(input);
                    notas.setN4(input);
                    break;
                default:
                    System.out.println("Número de notas inválido."); // Mensagem de erro para entrada inválida
                    break;
            }

            // Coleta a porcentagem de presença do aluno
            System.out.println("Qual a porcentagem de presença do aluno?");
            int presenca = input.nextInt();

            // Cria uma nova instância de Notas com as notas coletadas e a presença
            Notas notasFinal = new Notas(notas.n1, notas.n2, notas.n3, notas.n4, quantidadeNotas, presenca);
            System.out.println("Boletim: " + notasFinal.getBoletim()); // Exibe o boletim

        } catch (IllegalArgumentException e) {
            System.err.println("Ocorreu um Erro! " + e.getMessage()); // Mensagem de erro
        } finally {
            input.close(); // Fecha o Scanner
        }
    }
}
