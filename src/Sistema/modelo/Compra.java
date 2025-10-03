package Sistema.modelo;

/* Criação da classe Compra */

public class Compra {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    /* Construtor */

    public Compra(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getPreco() * quantidade;
    }

    /* Getters */

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    /* Sobrescrever */

    @Override
    public String toString() {
        return produto.getNome() + " | Qtd: " + quantidade + " | Total: R$ " + valorTotal;
    }
}
