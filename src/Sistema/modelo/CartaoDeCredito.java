package Sistema.modelo;

/* Criação da classe CartãoDeCredito */

public class CartaoDeCredito {
    private String numero;
    private double limite;
    private double saldo;

    /* Construtor da classe */

    public CartaoDeCredito(String numero, double limite) {
        this.numero = numero;
        this.limite = limite;
        this.saldo = limite;
    }

    /* Getter */

    public String getNumero() {
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

    /* Metodo para mostar o cartão */

    public void exibirCartaoDeCredito() {
        System.out.println("\n=== Cartão de Credito ===");
        System.out.println("Cartão: " + numero + " | Limite: " + limite + " | Saldo: " + saldo);
    }
}
