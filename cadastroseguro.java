import java.util.Scanner;

public class CadastroSeguro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome = lerString("Digite seu nome (mínimo 3 letras): ", sc, 3, 50);
        int idade = lerInt("Digite sua idade (1 a 120): ", sc, 1, 120);
        String email = lerEmail("Digite seu e-mail válido: ", sc);
        String senha = lerSenha("Crie uma senha (mínimo 8 caracteres, com letra e número): ", sc);

        System.out.println("\nCadastro concluído com sucesso!");
        System.out.printf("Nome: %s%nIdade: %d%nE-mail: %s%n", nome, idade, email);
    }

    private static String lerString(String msg, Scanner sc, int min, int max) {
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.length() >= min && input.length() <= max && input.matches("[a-zA-ZÀ-ÿ ]+")) break;
            System.out.println("Entrada inválida. Digite novamente.");
        }
        return input;
    }

    private static int lerInt(String msg, Scanner sc, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num >= min && num <= max) return num;
                System.out.println("Valor fora do intervalo permitido.");
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
    }

    private static String lerEmail(String msg, Scanner sc) {
        String email;
        while (true) {
            System.out.print(msg);
            email = sc.nextLine().trim();
            if (email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) break;
            System.out.println("E-mail inválido. Tente novamente.");
        }
        return email;
    }

    private static String lerSenha(String msg, Scanner sc) {
        String senha;
        while (true) {
            System.out.print(msg);
            senha = sc.nextLine();
            if (senha.length() >= 8 && senha.matches(".*[A-Za-z].*") && senha.matches(".*[0-9].*")) break;
            System.out.println("Senha fraca. Use letras e números (mínimo 8 caracteres).");
        }
        return senha;
    }
}
