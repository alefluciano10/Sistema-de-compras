package Sistema.modelo;

/* Criação da clssse produto */

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private String categoria;

    /* Construtor da classe */

    public Produto(String nome, double preco, int quantidade,  String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    /* Geters */

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    /* Setter */

    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    /* Metodo para reduz o estoque */

    public boolean reduzirEstoque(int qtd) {
        if (qtd <= quantidade) {
            quantidade -= qtd;
            return true;
        } else  {
            return false;
        }
    }

    /* Sobrescrever */

    @Override
    public String toString() {
        return nome + " - R$ " + preco + " | Disponível: " + quantidade;
    }
}
