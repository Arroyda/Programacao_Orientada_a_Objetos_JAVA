package Aula3;

import java.util.Scanner;

class Film { // Renomeado para iniciar com letra maiúscula por convenção
    private String nomeF; // Variável de instância
    private int genero; // Variável de instância
    private int duracao; // Variável de instância

    // Construtor da classe Film
    public Film(String nomeF, int genero, int duracao) {
        this.nomeF = nomeF; // Inicializa nomeF
        this.genero = genero; // Inicializa genero
        this.duracao = duracao; // Inicializa duracao
    }

    public void setNomeF(Scanner input) { // Recebe o Scanner como parâmetro
        System.out.println("Nome do Filme:");
        this.nomeF = input.nextLine(); // Atribui o valor à variável de instância
    }

    public void setGenero(Scanner input) { // Recebe o Scanner como parâmetro
        System.out.println("\n\nQual gênero do Filme:" +
                "\n[1] Romance" +
                "\n[2] Comédia" +
                "\n[3] Terror");
        int genero = input.nextInt(); // Lê o gênero do usuário

        // Verifica a entrada e atribui à variável de instância
        if (genero >= 1 && genero <= 3) {
            this.genero = genero;
        } else {
            System.out.println("Gênero incorreto! Atribuindo gênero como 0.");
            this.genero = 0; // Atribui valor padrão
        }
    }

    public void setTempo(Scanner input) { // Recebe o Scanner como parâmetro
        System.out.println("Duração do Filme (em minutos):");
        this.duracao = input.nextInt(); // Atribui a duração à variável de instância
    }

    public String getNomeF() {
        return nomeF; // Retorna nomeF
    }

    public String getGenero() {
        // Retorna o gênero como string
        switch (genero) {
            case 1: return "Romance";
            case 2: return "Comédia";
            case 3: return "Terror";
            default: return "Gênero desconhecido";
        }
    }

    public String getDuracao() {
        int h = duracao / 60; // Calcula horas
        int min = duracao % 60; // Calcula minutos
        return String.format("%d:%02d", h, min); // Formata horas e minutos
    }
}

public class filmes { // Renomeado para iniciar com letra maiúscula por convenção
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Cria o Scanner

        Film filme = new Film("", 0, 0); // Cria um novo objeto Film

        filme.setNomeF(input); // Chama o método para definir o nome
        filme.setGenero(input); // Chama o método para definir o gênero
        filme.setTempo(input); // Chama o método para definir a duração

        // Exibe as informações do filme
        System.out.println("\n\nNome do Filme: " + filme.getNomeF() +
                "\nGênero: " + filme.getGenero() +
                "\nDuração: " + filme.getDuracao());

        input.close(); // Fecha o Scanner
    }
}
