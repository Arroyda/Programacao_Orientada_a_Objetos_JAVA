package Aula1.Product;

// Importa o Scanner para registrar os dados
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Person {
    String Pname;
    String surname;
    String date;
    String email;
    Double height;

    public Person(String Pname, String surname, String date, String email, double height) {
        this.Pname = Pname;
        this.surname = surname;
        this.date = date;
        this.email = email;
        this.height = height;
    }

    public String getFullName() {
        return Pname + " " + surname;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return Pname + surname + "@facens.br";
    }

    public Double getHeight() {
        return height;
    }

    public void setPname(Scanner input) {
        System.out.println("Nome ?");
        Pname = input.nextLine();
    }

    public void setSurname(Scanner input) {
        System.out.println("Sobrenome ?");
        surname = input.nextLine();
    }

    public void setDate(Scanner input) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Data de Nascimento (dd/MM/yyyy)?");
        while (true) {
            String dateInput = input.nextLine();
            
            try {
                LocalDate birthDate = LocalDate.parse(dateInput, formatter);
                
                if (birthDate.isEqual(currentDate)) {
                    System.out.println("A data de nascimento não pode ser a mesma que a data atual. Tente novamente.");
                } else {
                    date = dateInput;
                    break; // Sai do loop se a data for válida
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Por favor, insira a data no formato dd/MM/yyyy.");
            }
        }
    }

    public void setHeight(Scanner input) {
        System.out.println("Qual a sua Altura?");
        height = input.nextDouble();
        input.nextLine(); // Limpa o buffer
    }
}

// Cria classe responsável pelos Produtos 
class Product {
    String name;
    String brand;
    Double costPrice;
    Double salePrice;

    // Inicia o Construtor de atributos de Produtos 
    public Product(String name, String brand, double costPrice, double salePrice) {
        this.name = name;
        this.brand = brand;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }

    // Calculadora de Lucro
    public double profitCalculator() {
        return salePrice - costPrice;
    }

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
        costPrice = input.nextDouble();
        input.nextLine(); // Limpa o buffer
    }

    public void setSalePrice(Scanner input) {
        System.out.println("Qual o Preço de Venda do Produto?");
        salePrice = input.nextDouble();
        input.nextLine(); // Limpa o buffer
    }
}

public class product_and_person {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Person person = new Person("", "", "", "", 0);

        person.setPname(input);
        person.setSurname(input);
        person.setDate(input);
        person.setHeight(input);

        Product product = new Product("", "", 0, 0);
        
        product.setName(input);
        product.setBrand(input);
        product.setCostPrice(input);
        product.setSalePrice(input);

        System.out.println(" \n\n Quem Cadastrou:" +
            "\n Nome: " + person.getFullName() +
            "\n Data de Nascimento: " + person.getDate() +
            "\n Email: " + person.getEmail() +
            "\n Altura: " + person.getHeight());

        System.out.println(" \n\n Produto:" +
            "\n Nome: " + product.getName() +
            "\n Marca: " + product.getBrand() +
            "\n Preço de Custo: " + product.getCostPrice() +
            "\n Preço de Venda: " + product.getSalePrice() +
            "\n\n Lucro de Venda: " + product.profitCalculator());

        input.close(); // Fecha o Scanner
    }
}
