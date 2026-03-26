package cp4.cp4.application;

import cp4.cp4.dto.ItemDTO;
import cp4.cp4.dto.PedidoDTO;
import cp4.cp4.model.Item;
import cp4.cp4.model.Pedido;
import cp4.cp4.model.StatusPedido;

import java.util.ArrayList;
import java.util.List;
public class PedidoService {

    public PedidoDTO iniciarPedido() {
        Pedido p = new Pedido();
        return toDto(p);
    }

    public PedidoDTO adicionarItem(PedidoDTO pedidoDto, ItemDTO itemDto) {
        Pedido p = toDomain(pedidoDto);
        Item item = new Item(itemDto.getNome(), itemDto.getQuantidade(), itemDto.getPrecoUnitario());
        p.adicionarItem(item);
        return toDto(p);
    }

    public PedidoDTO removerItem(PedidoDTO pedidoDto, String nomeItem) {
        Pedido p = toDomain(pedidoDto);
        
        List<Item> kept = new ArrayList<>();
        boolean removed = false;
        for (Item it : p.getItens()) {
            if (!removed && it.getNome().equals(nomeItem)) {
                    removed = true;
                continue;
            }
            kept.add(it);
        }
        Pedido novo = new Pedido(p.getId(), p.getStatus(), kept);
        return toDto(novo);
    }

    public PedidoDTO confirmar(PedidoDTO pedidoDto) {
        Pedido p = toDomain(pedidoDto);
        p.confirmar();
        return toDto(p);
    }

    public PedidoDTO iniciarPreparo(PedidoDTO pedidoDto) {
        Pedido p = toDomain(pedidoDto);
        p.iniciarPreparo();
        return toDto(p);
    }

    public PedidoDTO finalizarPreparo(PedidoDTO pedidoDto) {
        Pedido p = toDomain(pedidoDto);
        p.finalizarPreparo();
        return toDto(p);
    }

    public PedidoDTO entregar(PedidoDTO pedidoDto) {
        Pedido p = toDomain(pedidoDto);
        p.entregar();
        return toDto(p);
    }

    public PedidoDTO cancelar(PedidoDTO pedidoDto) {
        Pedido p = toDomain(pedidoDto);
        p.cancelar();
        return toDto(p);
    }

    private Pedido toDomain(PedidoDTO dto) {
        if (dto == null) return new Pedido();
        List<Item> items = new ArrayList<>();
        if (dto.getItens() != null) {
            for (var it : dto.getItens()) {
                items.add(new Item(it.getNome(), it.getQuantidade(), it.getPrecoUnitario()));
            }
        }
        StatusPedido status = dto.getStatus();
        return new Pedido(dto.getId(), status, items);
    }

    private PedidoDTO toDto(Pedido p) {
        List<cp4.cp4.dto.ItemDTO> itens = new ArrayList<>();
        for (Item it : p.getItens()) {
            itens.add(new cp4.cp4.dto.ItemDTO(it.getNome(), it.getQuantidade(), it.getPrecoUnitario()));
        }
        return new PedidoDTO(p.getId(), p.getStatus(), itens);
    }
}
