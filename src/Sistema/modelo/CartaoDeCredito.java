package Sistema.modelo;

/* Criação da classe CartãoDeCredito */

public class CartaoDeCredito {
    private int numero;
    private double limite;
    private double saldo;

    /* Construtor da classe */

    public CartaoDeCredito(int numero, double limite, double saldo) {
        this.numero = numero;
        this.limite = limite;
        this.saldo = limite;
    }

    /* Getter */

    public int getNumero() {
        return numero;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    /* Metódo para realizar a compra */

    public boolean autorizarCompra(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }  else {
            return false;
        }
    }

    /* Metódo para mostar o cartão */

    public void exibirCartãoDeCredito() {
        System.out.println("=== Cartão de Credito ===");
        System.out.println("Cartão: " + numero + " | Limite: " + limite + " | Saldo: " + saldo);
    }
}
