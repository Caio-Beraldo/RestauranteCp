package cp4.cp4.model;

import java.math.BigDecimal;

public class Item {
    private String nome;
    private int quantidade;
    private BigDecimal precoUnitario;

    public Item(String nome, int quantidade, BigDecimal precoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }


    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }


    public BigDecimal getSubtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}