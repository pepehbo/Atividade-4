import java.util.Scanner;

public class ContaCorrente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada;
        
        while (true) {
            System.out.print("Informe o número da conta corrente (3 dígitos) ou 'sair' para encerrar: ");
            entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("sair")) break;

            // Verifica se a entrada tem 3 dígitos
            if (entrada.length() != 3 || !entrada.matches("\\d{3}")) {
                System.out.println("Entrada inválida. Por favor, insira 3 dígitos.");
                continue;
            }

            // Calcula o dígito verificador
            int conta = Integer.parseInt(entrada);
            int inverso = Integer.parseInt(new StringBuilder(entrada).reverse().toString());
            int soma = conta + inverso;

            int[] digitos = String.valueOf(soma).chars().map(c -> c - '0').toArray();
            int resultadoMultiplicacao = 0;

            // Multiplica cada dígito pela sua posição
            for (int i = 0; i < digitos.length; i++) {
                resultadoMultiplicacao += digitos[i] * i;
            }

            // O dígito verificador é o último dígito da soma
            int digitoVerificador = resultadoMultiplicacao % 10;

            System.out.println("Dígito verificador da conta " + entrada + ": " + digitoVerificador);
        }

        scanner.close();
    }
}