package Etapa_1_Produto;

// Importa o Scanner para registrar os dados do usuário
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Cria a classe responsável pelas Pessoas
class Person {
    // Declaração dos atributos necessários para a classe Person
    String Pname;   // Nome da pessoa
    String surname; // Sobrenome da pessoa
    String date;    // Data de nascimento
    String email;   // Email da pessoa
    Double height;  // Altura da pessoa

    // Construtor da classe Person que inicializa os atributos
    public Person(String Pname, String surname, String date, String email, double height) {
        this.Pname = Pname;
        this.surname = surname;
        this.date = date;
        this.email = email;
        this.height = height;
    }

    // Método para obter o nome completo da pessoa
    public String getFullName() {
        return Pname + " " + surname;
    }

    // Método para obter a data de nascimento
    public String getDate() {
        return date;
    }

    // Método para gerar o email com base no nome e sobrenome
    public String getEmail() {
        return Pname + surname + "@facens.br";
    }

    // Método para obter a altura da pessoa
    public Double getHeight() {
        return height;
    }

    // Método para definir o nome da pessoa através da entrada do usuário
    public void setPname(Scanner input) {
        System.out.println("Nome ?");
        Pname = input.nextLine();
    }

    // Método para definir o sobrenome da pessoa através da entrada do usuário
    public void setSurname(Scanner input) {
        System.out.println("Sobrenome ?");
        surname = input.nextLine();
    }

    // Método para definir a data de nascimento com validação
    public void setDate(Scanner input) {
        LocalDate currentDate = LocalDate.now(); // Obtém a data atual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato da data
        
        System.out.println("Data de Nascimento (dd/MM/yyyy)?");
        while (true) { // Loop para garantir que a entrada é válida
            String dateInput = input.nextLine();
            
            try {
                LocalDate birthDate = LocalDate.parse(dateInput, formatter); // Tenta converter a entrada para LocalDate
                
                // Verifica se a data de nascimento não é a mesma que a data atual
                if (birthDate.isEqual(currentDate)) {
                    System.out.println("A data de nascimento não pode ser a mesma que a data atual. Tente novamente.");
                } else {
                    date = dateInput; // Se a data for válida, armazena
                    break; // Sai do loop
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Por favor, insira a data no formato dd/MM/yyyy.");
            }
        }
    }

    // Método para definir a altura da pessoa através da entrada do usuário
    public void setHeight(Scanner input) {
        System.out.println("Qual a sua Altura?");
        height = input.nextDouble(); // Armazena a altura
        input.nextLine(); // Limpa o buffer do Scanner
    }
}

// Cria a classe responsável pelos Produtos 
class Product {
    // Declaração dos atributos necessários para a classe Product
    String name;      // Nome do produto
    String brand;     // Marca do produto
    Double costPrice; // Preço de custo do produto
    Double salePrice; // Preço de venda do produto

    // Construtor da classe Product que inicializa os atributos
    public Product(String name, String brand, double costPrice, double salePrice) {
        this.name = name;
        this.brand = brand;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }

    // Método para calcular o lucro a partir do preço de custo e preço de venda
    public double profitCalculator() {
        return salePrice - costPrice;
    }

    // Métodos para obter os atributos do produto
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    // Métodos para definir os atributos do produto através da entrada do usuário
    public void setName(Scanner input) {
        System.out.println("\nQual o Nome do Produto?");
        name = input.nextLine();
    }

    public void setBrand(Scanner input) {
        System.out.println("Qual a Marca do Produto?");
        brand = input.nextLine();
    }

    public void setCostPrice(Scanner input) {
        System.out.println("Qual o Preço de Custo do Produto?");
        costPrice = input.nextDouble(); // Armazena o preço de custo
        input.nextLine(); // Limpa o buffer
    }

    public void setSalePrice(Scanner input) {
        System.out.println("Qual o Preço de Venda do Produto?");
        salePrice = input.nextDouble(); // Armazena o preço de venda
        input.nextLine(); // Limpa o buffer
    }
}

// Classe principal para execução do programa
public class product_and_person {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Inicializa o Scanner para entrada de dados

        // Cria uma nova instância de Person com atributos vazios
        Person person = new Person("", "", "", "", 0);

        // Chama os métodos para definir os atributos da pessoa
        person.setPname(input);
        person.setSurname(input);
        person.setDate(input);
        person.setHeight(input);

        // Cria uma nova instância de Product com atributos vazios
        Product product = new Product("", "", 0, 0);
        
        // Chama os métodos para definir os atributos do produto
        product.setName(input);
        product.setBrand(input);
        product.setCostPrice(input);
        product.setSalePrice(input);

        // Exibe os dados da pessoa cadastrada
        System.out.println(" \n\n Quem Cadastrou:" +
            "\n Nome: " + person.getFullName() +
            "\n Data de Nascimento: " + person.getDate() +
            "\n Email: " + person.getEmail() +
            "\n Altura: " + person.getHeight());

        // Exibe os dados do produto cadastrado e calcula o lucro
        System.out.println(" \n\n Produto:" +
            "\n Nome: " + product.getName() +
            "\n Marca: " + product.getBrand() +
            "\n Preço de Custo: " + product.getCostPrice() +
            "\n Preço de Venda: " + product.getSalePrice() +
            "\n\n Lucro de Venda: " + product.profitCalculator());

        input.close(); // Fecha o Scanner para liberar recursos
    }
}
