package Sistema.principal;

import Sistema.servico.SistemaCompra;

public class Principal {
    public static void main(String[] args) {
        SistemaCompra sistema = new SistemaCompra();
        sistema.menuPrincipal();
    }
}
