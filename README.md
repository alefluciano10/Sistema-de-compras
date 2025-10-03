# Sistema de Compras

Bem-vindo ao **Sistema de Compras**!

Este sistema foi desenvolvido para empresas que buscam eficiência, controle e segurança na gestão de compras, produtos, clientes e métodos de pagamento. Com arquitetura modular, foco em escalabilidade e facilidade de integração, o projeto se destaca pela organização profissional e pela robustez dos recursos.

---

## Visão Geral

O Sistema de Compras oferece uma plataforma completa para o gerenciamento de processos de aquisição, cadastro de clientes, administração de produtos e gestão de pagamentos, tornando as operações comerciais mais ágeis e confiáveis.

---

## Principais Recursos

- **Cadastro de Produtos:** Controle detalhado de informações dos produtos, como nome, preço, estoque e fornecedor.
- **Gestão de Clientes:** Registro e atualização de dados dos clientes, com consultas rápidas e histórico de compras.
- **Administração de Compras:** Integração entre produtos, clientes e métodos de pagamento nas operações de compra.
- **Pagamento via Cartão de Crédito:** Controle seguro e integrado para transações via cartão.
- **Gestão de Usuários Administradores:** Segurança aprimorada por meio de controle de acesso de administradores.
- **Relatórios e Consultas:** Visualização estratégica de dados, como histórico de compras e situação do estoque.

---

## Estrutura do Projeto

O projeto está organizado em módulos que facilitam manutenção, evolução e integração:

```
src/Sistema/
├── modelo/
│   ├── Administrador.java
│   ├── CartaoDeCredito.java
│   ├── Cliente.java
│   ├── Compra.java
│   └── Produto.java
├── principal/
│   └── Principal.java
└── servico/
    └── SistemaCompra.java
```

- **modelo/**: Classes de entidade e estrutura de dados principais.
  - [Administrador.java](https://github.com/alefluciano10/Sistema-de-compras/blob/main/src/Sistema/modelo/Administrador.java)
  - [CartaoDeCredito.java](https://github.com/alefluciano10/Sistema-de-compras/blob/main/src/Sistema/modelo/CartaoDeCredito.java)
  - [Cliente.java](https://github.com/alefluciano10/Sistema-de-compras/blob/main/src/Sistema/modelo/Cliente.java)
  - [Compra.java](https://github.com/alefluciano10/Sistema-de-compras/blob/main/src/Sistema/modelo/Compra.java)
  - [Produto.java](https://github.com/alefluciano10/Sistema-de-compras/blob/main/src/Sistema/modelo/Produto.java)
- **principal/**:  
  - [Principal.java](https://github.com/alefluciano10/Sistema-de-compras/blob/main/src/Sistema/principal/Principal.java)
- **servico/**:  
  - [SistemaCompra.java](https://github.com/alefluciano10/Sistema-de-compras/blob/main/src/Sistema/servico/SistemaCompra.java)

---

## Tecnologias Utilizadas

- **Java:** Linguagem principal do sistema.
- **Paradigma Orientado a Objetos:** Facilita a manutenção e escalabilidade.
- **Estrutura Modular:** Separação entre entidades, lógica de negócio e interface principal.

> O sistema foi projetado para fácil integração com banco de dados e interface gráfica.

---

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/alefluciano10/Sistema-de-compras.git
   ```
2. Importe o projeto na sua IDE Java preferida (Eclipse, IntelliJ IDEA, NetBeans).
3. Compile e execute a classe `Principal.java` localizada em `src/Sistema/principal/Principal.java`.

---

## Contribuição

Contribuições são bem-vindas! Abra issues ou pull requests com sugestões, correções ou melhorias.

---

## Desenvolvedor

<div align="center">
  <img src="https://avatars.githubusercontent.com/u/211544625?v=4" alt="Alef Luciano" width="150" height="150" style="border-radius:50%;"/>
  <br/>
  <strong>Alef Luciano</strong><br/>
  Desenvolvedor do Projeto
</div>

---
