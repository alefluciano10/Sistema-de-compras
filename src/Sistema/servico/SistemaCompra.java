package Sistema.servico;

import Sistema.modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaCompra {

    /* Listas de produtos e clientes */
    private List<Produto> produtos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    /* Cliente logado */
    private Cliente clienteLogado = null;

    /* Scanner */
    private Scanner sc = new Scanner(System.in);

    /* Administrador fixo */
    private final String ADMIN_USER = "admin";
    private final String ADMIN_PASS = "admin123";

    /* Menu principal */
    public void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Login Cliente");
            System.out.println("2 - Login Administrador");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> menuLoginCliente();
                case 2 -> menuLoginAdmin();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("\n❌ Opção inválida! Digite 0, 1 ou 2.");
            }
        } while (opcao != 0);
    }

    /* ===== LOGIN ADMINISTRADOR ===== */
    private void menuLoginAdmin() {
        System.out.println("\n*** Login Administrador ***");
        System.out.print("Usuário: ");
        String user = sc.nextLine();
        System.out.print("Senha: ");
        String pass = sc.nextLine();

        /* Lógica de acesso */
        if (ADMIN_USER.equals(user) && ADMIN_PASS.equals(pass)) {
            System.out.println("\n✅ Sistema liberado!");

            // Cria o administrador e inicializa com as listas do sistema
            Administrador admin = new Administrador(ADMIN_USER, ADMIN_PASS);
            admin.setProdutos(this.produtos);
            admin.setClientes(this.clientes);

            // Redireciona para o menu do administrador
            admin.acessarMenuAdmin();

        } else {
            System.out.println("\n❌ Acesso negado!");
        }
    }

    /* ===== LOGIN CLIENTE ===== */
    private void menuLoginCliente() {
        int opcao;
        do {
            System.out.println("\n=== LOGIN CLIENTE ===");
            System.out.println("1 - Já tenho cadastro (Login)");
            System.out.println("2 - Quero me cadastrar");
            System.out.println("0 - Voltar");
            System.out.print("\nEscolha uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> loginCliente();
                case 2 -> cadastrarCliente();
                case 0 -> System.out.println("\nVoltando ao menu principal...");
                default -> System.out.println("\n❌ Opção inválida! Digite 0, 1 ou 2.");
            }
        } while (opcao != 0 && clienteLogado == null);
    }

    private void loginCliente() {
        System.out.println("\n*** Login Cliente ***");
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf) && c.getSenha().equals(senha)) {
                clienteLogado = c;
                System.out.println("\n✅ Bem-vindo, " + c.getNome() + "!");
                // Redireciona para menu do cliente
                clienteLogado.acessarMenuCliente(produtos);
                clienteLogado = null; // logout automático após menu
                return;
            }
        }
        System.out.println("\n❌ CPF ou senha incorretos!");
    }

    private void cadastrarCliente() {
        System.out.println("\n*** Cadastro de Cliente ***");
        System.out.print("Nome completo: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        // Verifica se CPF já existe
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                System.out.println("❌ CPF já cadastrado!");
                return;
            }
        }

        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Número do cartão: ");
        String numeroCartao = sc.nextLine();
        System.out.print("Limite do cartão: ");
        double limite = Double.parseDouble(sc.nextLine());

        CartaoDeCredito cartao = new CartaoDeCredito(numeroCartao, limite);
        Cliente cliente = new Cliente(nome, cpf, senha, email, telefone, endereco, cartao);
        clientes.add(cliente);

        System.out.println("\n✅ Cliente cadastrado com sucesso!");
    }
}
