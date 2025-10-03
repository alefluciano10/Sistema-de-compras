package Sistema.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private final String cpf;
    private String senha;
    private String email;
    private String telefone;
    private String endereco;
    private CartaoDeCredito cartao;
    private List<Compra> compras;

    private Scanner sc = new Scanner(System.in);

    public Cliente(String nome, String cpf, String senha, String email,
                   String telefone, String endereco, CartaoDeCredito cartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cartao = cartao;
        this.compras = new ArrayList<>();
    }

    /* Getters e Setters */
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public CartaoDeCredito getCartao() { return cartao; }
    public List<Compra> getCompras() { return compras; }

    /* ==== MENU DO CLIENTE ==== */
    public void acessarMenuCliente(List<Produto> produtos) {
        int opcao;
        do {
            System.out.println("\n=== MENU CLIENTE ===");
            System.out.println("1 - Listar Produtos Disponíveis por Categoria");
            System.out.println("2 - Realizar Compra");
            System.out.println("3 - Listar Compras");
            System.out.println("4 - Mostrar Cartão");
            System.out.println("5 - Logout");
            System.out.print("\nEscolha uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> listarProdutosPorCategoria(produtos);
                case 2 -> realizarCompra(produtos);
                case 3 -> listarCompras();
                case 4 -> mostrarCartao();
                case 5 -> System.out.println("\n👋 Logout realizado. Até logo, " + nome);
                default -> System.out.println("\n❌ Opção inválida! Digite de 1 a 5.");
            }
        } while (opcao != 5);
    }

    /* Métodos funcionais */
    private void listarCompras() {
        if (compras.isEmpty()) {
            System.out.println("\n❌ Nenhuma compra registrada.");
        } else {
            System.out.println("\n=== COMPRAS ===");
            for (Compra c : compras) {
                System.out.println(c);
            }
        }
    }

    private void listarProdutosPorCategoria(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("\n❌ Nenhum produto encontrado!");
            return;
        }

        List<String> categorias = new ArrayList<>();
        for (Produto p : produtos) {
            if (!categorias.contains(p.getCategoria())) {
                categorias.add(p.getCategoria());
            }
        }

        System.out.println("\n=== PRODUTOS DISPONÍVEIS POR CATEGORIAS ===");
        for (String categoria : categorias) {
            System.out.println("\nCategoria: " + categoria);
            int count = 1;
            for (Produto p : produtos) {
                if (p.getCategoria().equalsIgnoreCase(categoria)) {
                    System.out.println(count + " | " + p);
                    count++;
                }
            }
        }
    }

    public void adicionarCompra(Compra compra) {
        compras.add(compra);
    }

    public void realizarCompra(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("\n❌ Nenhum produto encontrado!");
            return;
        }

        // Mostra os produtos disponíveis
        listarProdutosPorCategoria(produtos);

        // Solicita o produto
        System.out.print("\nDigite o nome do produto: ");
        String nomeProd = sc.nextLine();
        Produto produtoEscolhido = null;

        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nomeProd)) {
                produtoEscolhido = p;
                break;
            }
        }

        if (produtoEscolhido == null) {
            System.out.println("\n❌ Produto não encontrado!");
            return;
        }

        // Solicita a quantidade
        System.out.print("Quantidade desejada: ");
        int qtd;
        try {
            qtd = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\n❌ Quantidade inválida!");
            return;
        }

        // Verifica estoque
        if (qtd > produtoEscolhido.getQuantidade()) {
            System.out.println("\n❌ Estoque insuficiente!");
            return;
        }

        // Verifica saldo do cartão
        double total = produtoEscolhido.getPreco() * qtd;
        if (!cartao.autorizarCompra(total)) {
            System.out.println("\n❌ Saldo insuficiente no cartão!");
            return;
        }

        // Realiza a compra
        produtoEscolhido.reduzirEstoque(qtd);
        adicionarCompra(new Compra(produtoEscolhido, qtd));

        System.out.println("\n✅ Compra realizada com sucesso! Total: R$ " + total);
        System.out.println("Saldo restante: R$ " + cartao.getSaldo());
    }



    public void mostrarCartao() {
        cartao.exibirCartaoDeCredito();
    }
}
