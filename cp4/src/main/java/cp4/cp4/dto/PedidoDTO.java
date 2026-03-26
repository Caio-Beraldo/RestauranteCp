package cp4.cp4.dto;

import cp4.cp4.model.StatusPedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
    private String id;
    private StatusPedido status;
    private List<ItemDTO> itens = new ArrayList<>();

    public PedidoDTO() {}

    public PedidoDTO(String id, StatusPedido status, List<ItemDTO> itens) {
        this.id = id;
        this.status = status;
        if (itens != null) this.itens = itens;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public StatusPedido getStatus() { return status; }
    public void setStatus(StatusPedido status) { this.status = status; }

    public List<ItemDTO> getItens() { return itens; }
    public void setItens(List<ItemDTO> itens) { this.itens = itens; }
}
