package Sistema.modelo;

import java.util.List;
import java.util.Scanner;

public class Administrador {
    private String usuario;
    private String senha;

    private List<Produto> produtos;
    private List<Cliente> clientes;

    private Scanner sc = new Scanner(System.in);

    /* Construtor */
    public Administrador(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    /* Getters */
    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    /* Setters para passar listas do sistema */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /* Método para autenticação */
    public boolean autenticar(String user, String pass) {
        return usuario.equals(user) && senha.equals(pass);
    }

    /* Menu do administrador */
    public void acessarMenuAdmin() {
        int opcao;
        do {
            System.out.println("\n=== MENU ADMINISTRADOR ===");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Logout\n");
            System.out.print("Escolha uma opcao: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> listarProdutos();
                case 3 -> listarClientes();
                case 4 -> System.out.println("\n👋 Saindo do sistema...");
                default -> System.out.println("\n❌ Opção inválida! Digite de 1 a 4.");
            }
        } while (opcao != 4);
    }

    /* ==== MÉTODOS DO ADMIN ==== */

    private void cadastrarProduto() {
        System.out.println("\n*** Cadastro de Produtos ***");
        System.out.print("Nome do produto: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(sc.nextLine());
        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(sc.nextLine());
        System.out.print("Categoria: ");
        String categoria = sc.nextLine();

        produtos.add(new Produto(nome, preco, qtd, categoria));
        System.out.println("\n✅ Produto cadastrado!");
    }

    private void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("\n❌ Nenhum produto encontrado!");
        } else {
            System.out.println("\n=== PRODUTOS DISPONÍVEIS ===");
            for (Produto p : produtos) {
                System.out.println(p.getNome() + " | R$ " + p.getPreco() +
                        " | Estoque: " + p.getQuantidade() +
                        " | Categoria: " + p.getCategoria());
            }
        }
    }

    private void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("\n❌ Nenhum cliente cadastrado.");
        } else {
            System.out.println("\n=== CLIENTES CADASTRADOS ===");
            for (Cliente c : clientes) {
                System.out.println("Nome: " + c.getNome() +
                        " | CPF: " + c.getCpf() +
                        " | Compras: " + c.getCompras().size());
            }
        }
    }
}
