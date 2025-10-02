package Sistema.modelo;

import java.util.List;

/* Criação da classe Cliente */

public class Cliente {
    private String nome;
    private int cpf;
    private String senha;
    private String email;
    private int telefone;
    private String endereco;
    private CartaoDeCredito cartao;
    private List<Compra> compras;

    /* Construtor da classe Cliente */

    public Cliente(String nome, int cpf, String senha, String email, int telefone, String endereco, CartaoDeCredito cartao, List<Compra> compras) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cartao = cartao;
        this.compras = compras;
    }

    /* Getters */

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public CartaoDeCredito getCartao() {
        return cartao;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    /* Metodo para adicionar a compra do cliente */

    public void adicionarCompra(Compra compra) {
        compras.add(compra);
    }
}
