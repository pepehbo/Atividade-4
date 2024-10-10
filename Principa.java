
import javax.swing.JOptionPane;

public class Principa {
    public static void main(String[] args) {
        String entrada;

        do {
            calcularDigitoVerificador();
            entrada = JOptionPane.showInputDialog("Deseja calcular um novo dígito verificador? (S)im ou (N)ão");
        } while (entrada.equalsIgnoreCase("s") || entrada.equalsIgnoreCase("sim"));

        System.exit(0);
    }

    private static void calcularDigitoVerificador() {
        String entrada;
        while (true) {
            entrada = JOptionPane.showInputDialog("Informe o número da conta corrente (3 dígitos): ");
            if (entrada.length() != 3 || !entrada.matches("\\d{3}")) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira 3 dígitos.");
                continue;
            }

            int conta = Integer.parseInt(entrada);
            int inverso = Integer.parseInt(new StringBuilder(entrada).reverse().toString());
            int soma = conta + inverso;

            int[] digitos = String.valueOf(soma).chars().map(c -> c - '0').toArray();
            int resultadoMultiplicacao = 0;

            for (int i = 0; i < digitos.length; i++) {
                resultadoMultiplicacao += digitos[i] * i;
            }

            int digitoVerificador = resultadoMultiplicacao % 10;
            JOptionPane.showMessageDialog(null, "Dígito verificador da conta " + entrada + ": " + digitoVerificador);
            break;
        }
    }
}