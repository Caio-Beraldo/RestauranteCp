package cp4.cp4.dto;

import java.math.BigDecimal;

public class ItemDTO {
    private String nome;
    private int quantidade;
    private BigDecimal precoUnitario;

    public ItemDTO() {}

    public ItemDTO(String nome, int quantidade, BigDecimal precoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }
}
