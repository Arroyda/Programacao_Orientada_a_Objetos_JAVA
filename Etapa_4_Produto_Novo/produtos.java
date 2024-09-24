package Etapa_4_Produto_Novo;

import java.util.Calendar; // Importa a classe Calendar para manipulação de datas
import java.util.Scanner; // Importa a classe Scanner para entrada de dados
import java.text.SimpleDateFormat; // Importa a classe para formatação de datas
import java.util.Date; // Importa a classe Date para trabalhar com datas
import java.time.LocalDate; // Importa a classe LocalDate para manipulação de datas no formato ISO
import java.time.format.DateTimeFormatter; // Importa a classe para formatar datas
import java.time.format.DateTimeParseException; // Importa a exceção para tratamento de erros de parsing de datas

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
        this.Pname = Pname; // Inicializa o nome
        this.surname = surname; // Inicializa o sobrenome
        this.date = date; // Inicializa a data de nascimento
        this.email = email; // Inicializa o email
        this.height = height; // Inicializa a altura
    }

    // Método para obter o nome completo da pessoa
    public String getFullName() {
        return Pname + " " + surname; // Retorna o nome completo
    }

    // Método para obter a data de nascimento
    public String getDate() {
        return date; // Retorna a data de nascimento
    }

    // Método para gerar o email com base no nome e sobrenome
    public String getEmail() {
        return Pname + surname + "@facens.br"; // Retorna o email gerado
    }

    // Método para obter a altura da pessoa
    public Double getHeight() {
        return height; // Retorna a altura
    }

    // Método para definir o nome da pessoa através da entrada do usuário
    public void setPname(Scanner input) {
        System.out.println("Nome ?"); // Solicita o nome
        Pname = input.nextLine(); // Lê o nome do usuário
    }

    // Método para definir o sobrenome da pessoa através da entrada do usuário
    public void setSurname(Scanner input) {
        System.out.println("Sobrenome ?"); // Solicita o sobrenome
        surname = input.nextLine(); // Lê o sobrenome do usuário
    }

    // Método para definir a data de nascimento com validação
    public void setDate(Scanner input) {
        LocalDate currentDate = LocalDate.now(); // Obtém a data atual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato da data
        
        System.out.println("Data de Nascimento (dd/MM/yyyy)?");
        while (true) { // Loop para garantir que a entrada é válida
            String dateInput = input.nextLine(); // Lê a entrada do usuário
            
            try {
                LocalDate birthDate = LocalDate.parse(dateInput, formatter); // Tenta converter a entrada para LocalDate
                
                // Verifica se a data de nascimento não é a mesma que a data atual
                if (birthDate.isEqual(currentDate)) {
                    System.out.println("A data de nascimento não pode ser a mesma que a data atual. Tente novamente.");
                    
                } else {
                    date = dateInput; // Se a data for válida, armazena
                    break; // Sai do loop
                }

            } catch (DateTimeParseException e) { // Captura erro de parsing
                System.out.println("Formato inválido. Por favor, insira a data no formato dd/MM/yyyy."); // Mensagem de erro
            }
        }
    }

    // Método para definir a altura da pessoa através da entrada do usuário
    public void setHeight(Scanner input) {
        System.out.println("Qual a sua Altura?"); // Solicita a altura
        height = input.nextDouble(); // Armazena a altura
        input.nextLine(); // Limpa o buffer do Scanner
    }
}

// Cria a classe responsável pelos Produtos 
class Product {
    // Declaração dos atributos necessários para a classe Product
    String name;      // Nome do produto
    String brand;     // Marca do produto
    Date manuDate;    // Data de Fabricação
    Date expDate;     // Data de Validade
    Double costPrice; // Preço de custo do produto
    Double salePrice; // Preço de venda do produto

    // Construtor da classe Product que inicializa os atributos
    public Product(String name, String brand, Date manuDate, Date expDate, double costPrice, double salePrice) {
        this.name = name; // Inicializa o nome do produto
        this.brand = brand; // Inicializa a marca do produto
        this.manuDate = manuDate; // Inicializa a data de fabricação
        this.expDate = expDate; // Inicializa a data de validade
        this.costPrice = costPrice; // Inicializa o preço de custo
        this.salePrice = salePrice; // Inicializa o preço de venda
    }

    // Método para calcular o lucro a partir do preço de custo e preço de venda
    public double profitCalculator() {
        return salePrice - costPrice; // Calcula e retorna o lucro
    }

    // Métodos para obter os atributos do produto
    public String getName() {
        return name; // Retorna o nome do produto
    }

    public String getBrand() {
        return brand; // Retorna a marca do produto
    }

    public Date getManuDate() {
        return manuDate; // Retorna a data de fabricação
    }

    public Date getExpDate() {
        return expDate; // Retorna a data de validade
    }

    public double getCostPrice() {
        return costPrice; // Retorna o preço de custo
    }

    public double getSalePrice() {
        return salePrice; // Retorna o preço de venda
    }

    // Métodos para definir os atributos do produto através da entrada do usuário
    public void setName(Scanner input) {
        System.out.println("\nQual o Nome do Produto?"); // Solicita o nome do produto
        name = input.nextLine(); // Lê o nome do produto
    }

    public void setBrand(Scanner input) {
        System.out.println("Qual a Marca do Produto?"); // Solicita a marca do produto
        brand = input.nextLine(); // Lê a marca do produto
    }

    // Método para definir a data de fabricação com validação
    public void setManuDate() {
        Scanner input = new Scanner(System.in); // Cria um novo Scanner
        boolean validDate = false; // Flag para controlar a validade da data

        while (!validDate) { // Loop até que uma data válida seja fornecida
            System.out.println("\n\nQual a data de Fabricação? (dia/mês/ano / apenas os números)");
            String startDate = input.nextLine(); // Lê a entrada do usuário
            
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy"); // Define o formato da data
                manuDate = sdf.parse(startDate); // Tenta converter a entrada para Date

                // Verifica se a data de fabricação é posterior à data atual
                if (manuDate.after(new Date())) {
                    System.out.println("ERRO! A data de Fabricação posterior à data atual, por favor insira data válida!");

                } else {
                    validDate = true; // Marca a data como válida
                }

            } catch (Exception e) { // Captura qualquer exceção
                System.out.println("ERRO! Por favor tente novamente!"); // Mensagem de erro
            }
        }
    }

    // Método para definir a data de validade baseada na data de fabricação
    public void setExpDate() {

        if (manuDate != null) { // Verifica se a data de fabricação foi definida
            Calendar calendar = Calendar.getInstance(); // Cria uma instância de Calendar
            calendar.setTime(manuDate); // Define a data de fabricação
            calendar.add(Calendar.MONTH, 1); // Adiciona 1 mês à data de fabricação
            expDate = calendar.getTime(); // Armazena a data de validade
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Define o formato da data
            System.out.println("Data de Validade: " + sdf.format(expDate)); // Exibe a data de validade

        } else {
            System.out.println("ERRO! Defina a Data de Fabricação!"); // Mensagem de erro se a data não estiver definida
        }
    }

    public void setCostPrice(Scanner input) {
        System.out.println("Qual o Preço de Custo do Produto?"); // Solicita o preço de custo
        costPrice = input.nextDouble(); // Armazena o preço de custo
        input.nextLine(); // Limpa o buffer
    }

    public void setSalePrice(Scanner input) {
        System.out.println("Qual o Preço de Venda do Produto?"); // Solicita o preço de venda
        salePrice = input.nextDouble(); // Armazena o preço de venda
        input.nextLine(); // Limpa o buffer
    }
}

// Classe principal para execução do programa
public class produtos { // Renomeado para iniciar com letra maiúscula por convenção
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Inicializa o Scanner para entrada de dados

        // Cria uma nova instância de Person com atributos vazios
        Person person = new Person("", "", "", "", 0);

        // Chama os métodos para definir os atributos da pessoa
        person.setPname(input); // Define o nome
        person.setSurname(input); // Define o sobrenome
        person.setDate(input); // Define a data de nascimento
        person.setHeight(input); // Define a altura

        // Cria uma nova instância de Product com atributos vazios
        Product product = new Product("", "", null, null, 0, 0);
        
        // Chama os métodos para definir os atributos do produto
        product.setName(input); // Define o nome do produto
        product.setBrand(input); // Define a marca do produto
        product.setManuDate(); // Define a data de fabricação
        product.setExpDate(); // Define a data de validade
        product.setCostPrice(input); // Define o preço de custo
        product.setSalePrice(input); // Define o preço de venda

        // Exibe os dados da pessoa cadastrada
        System.out.println(" \n\n Quem Cadastrou:" +
            "\n Nome: " + person.getFullName() + // Nome completo
            "\n Data de Nascimento: " + person.getDate() + // Data de nascimento
            "\n Email: " + person.getEmail() + // Email gerado
            "\n Altura: " + person.getHeight()); // Altura

        // Exibe os dados do produto cadastrado e calcula o lucro
        System.out.println(" \n\n Produto:" +
            "\n Nome: " + product.getName() + // Nome do produto
            "\n Marca: " + product.getBrand() + // Marca do produto
            "\n Data Fabricação: " + product.getManuDate() + // Data de fabricação
            "\n Data Validade: " + product.getExpDate() + // Data de validade
            "\n Preço de Custo: " + product.getCostPrice() + // Preço de custo
            "\n Preço de Venda: " + product.getSalePrice() + // Preço de venda
            "\n\n Lucro de Venda: " + product.profitCalculator()); // Lucro calculado

        input.close(); // Fecha o Scanner para liberar recursos
    }
}
