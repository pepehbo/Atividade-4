import java.util.Scanner;

public class ValidaDados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Validação da Nota
        double nota;
        while (true) {
            System.out.print("Informe a nota (0 a 10): ");
            nota = scanner.nextDouble();
            if (nota >= 0 && nota <= 10) {
                System.out.println("Nota válida!");
                break;
            } else {
                System.out.println("Nota inválida. Tente novamente.");
            }
        }

        // Validação do Salário
        double salario;
        while (true) {
            System.out.print("Informe o salário (maior que zero): ");
            salario = scanner.nextDouble();
            if (salario > 0) {
                System.out.println("Salário válido!");
                break;
            } else {
                System.out.println("Salário inválido. Tente novamente.");
            }
        }

        // Validação do Sexo
        char sexo;
        while (true) {
            System.out.print("Informe o sexo (m ou f): ");
            sexo = scanner.next().charAt(0);
            if (sexo == 'm' || sexo == 'f') {
                System.out.println("Sexo válido!");
                break;
            } else {
                System.out.println("Sexo inválido. Tente novamente.");
            }
        }

        // Validação da Idade
        int idade;
        while (true) {
            System.out.print("Informe a idade (0 a 120): ");
            idade = scanner.nextInt();
            if (idade >= 0 && idade <= 120) {
                System.out.println("Idade válida!");
                break;
            } else {
                System.out.println("Idade inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}