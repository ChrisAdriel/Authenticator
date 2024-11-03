import java.util.HashMap;
import java.util.Scanner;

public class Authenticator {
    private HashMap<String, String> usuarios = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> removerUsuario();
                case 3 -> buscarUsuario();
                case 4 -> autenticarUsuario();
                case 5 -> System.out.println("\nSaindo... Obrigado por utilizar o Unit Authenticator!\n");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private void exibirMenu() {
        System.out.println("");
        System.out.println("\n===*** Unit Authenticator ***===");
        System.out.println("\n1 - Inserir usuário");
        System.out.println("2 - Remover usuário");
        System.out.println("3 - Buscar usuário");
        System.out.println("4 - Login");
        System.out.println("5 - Sair\n");
        System.out.print("Escolha uma opção: ");
    }

    private void cadastrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (usuarios.containsKey(usuario)) {
            System.out.println("\nUsuário já existe!");
        } else {
            usuarios.put(usuario, senha);
            System.out.println("\nUsuário " + usuario + " cadastrado com sucesso! :D");
        }
    }

    private void removerUsuario() {
        System.out.print("Digite o nome do usuário a ser removido: ");
        String usuario = scanner.nextLine();

        if (usuarios.containsKey(usuario)) {
            usuarios.remove(usuario);
            System.out.println("\nUsuário " + usuario + "removido com sucesso!");
        } else {
            System.out.println("\nUsuário não encontrado!");
        }
    }

    private void buscarUsuario() {
        System.out.print("Digite o nome do usuário para busca: ");
        String usuario = scanner.nextLine();

        if (usuarios.containsKey(usuario)) {
            System.out.println("\nUsuário " + usuario + " existe no sistema.");
        } else {
            System.out.println("\nUsuário não encontrado.");
        }
    }

    private void autenticarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)) {
            System.out.println("\nLogin bem-sucedido!");
        } else {
            System.out.println("\nUsuário ou senha incorretos.");
        }
    }

    public static void main(String[] args) {
        Authenticator sistema = new Authenticator();
        sistema.iniciar();
    }
}
