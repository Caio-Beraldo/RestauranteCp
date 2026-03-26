package cp4.cp4.controller.requests;

import cp4.cp4.dto.ItemDTO;
import cp4.cp4.dto.PedidoDTO;

public class AdicionarItemRequest {
    private PedidoDTO pedido;
    private ItemDTO item;

    public AdicionarItemRequest() {}

    public PedidoDTO getPedido() { return pedido; }
    public void setPedido(PedidoDTO pedido) { this.pedido = pedido; }

    public ItemDTO getItem() { return item; }
    public void setItem(ItemDTO item) { this.item = item; }
}
