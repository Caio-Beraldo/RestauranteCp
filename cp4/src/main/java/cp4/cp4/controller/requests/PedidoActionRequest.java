package cp4.cp4.controller.requests;

import cp4.cp4.dto.PedidoDTO;

public class PedidoActionRequest {
    private PedidoDTO pedido;

    public PedidoActionRequest() {}

    public PedidoDTO getPedido() { return pedido; }
    public void setPedido(PedidoDTO pedido) { this.pedido = pedido; }
}
