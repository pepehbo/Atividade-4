import javax.swing.JOptionPane;

public class Principal {
    public static void main(String args[]) {
        String entrada;

        do {
            String resultado = realizarPesquisa();
            JOptionPane.showMessageDialog(null, resultado);

            entrada = JOptionPane.showInputDialog("Deseja realizar uma nova pesquisa? (S)im ou (N)ão");
        } while (entrada.equalsIgnoreCase("s") || entrada.equalsIgnoreCase("sim"));

        System.exit(0);
    }

    private static String realizarPesquisa() {
        int totalPessoas = 0;
        int[] audiencia = new int[5]; // Para canais 2, 4, 5, 7, 12
        int[] canais = {2, 4, 5, 7, 12};
        StringBuilder resultado = new StringBuilder();

        while (true) {
            String entrada = JOptionPane.showInputDialog("Digite o número do canal (2, 4, 5, 7, 12) ou 0 para encerrar: ");
            int canal = Integer.parseInt(entrada);
            if (canal == 0) break;

            if (canal == 2 || canal == 4 || canal == 5 || canal == 7 || canal == 12) {
                entrada = JOptionPane.showInputDialog("Digite o número de pessoas assistindo ao canal: ");
                int pessoas = Integer.parseInt(entrada);
                totalPessoas += pessoas;

                for (int i = 0; i < canais.length; i++) {
                    if (canais[i] == canal) {
                        audiencia[i] += pessoas;
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Canal inválido. Tente novamente.");
            }
        }

        for (int i = 0; i < canais.length; i++) {
            double percentual = totalPessoas > 0 ? (audiencia[i] / (double) totalPessoas) * 100 : 0;
            resultado.append(String.format("Canal %d: %.2f%%\n", canais[i], percentual));
        }

        return resultado.toString();
    }
}