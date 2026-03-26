package cp4.cp4.controller.requests;

import cp4.cp4.dto.PedidoDTO;

public class RemoverItemRequest {
    private PedidoDTO pedido;
    private String nomeItem;

    public RemoverItemRequest() {}

    public PedidoDTO getPedido() { return pedido; }
    public void setPedido(PedidoDTO pedido) { this.pedido = pedido; }

    public String getNomeItem() { return nomeItem; }
    public void setNomeItem(String nomeItem) { this.nomeItem = nomeItem; }
}
