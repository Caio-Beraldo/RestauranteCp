package cp4.cp4.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private final String id;
    private StatusPedido status;
    private final List<Item> itens;

    public Pedido() {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.status = StatusPedido.INICIADO;
        this.itens = new ArrayList<>();
    }



    public void adicionarItem(Item item) {
        if (this.status != StatusPedido.INICIADO) {
            throw new IllegalStateException("Só é possível adicionar itens em pedidos iniciados.");
        }
        this.itens.add(item);
    }

    public void confirmar() {
        if (this.itens.isEmpty()) {
            throw new IllegalStateException("Não é possível confirmar um pedido sem itens.");
        }
        if (this.status == StatusPedido.INICIADO) {
            this.status = StatusPedido.CONFIRMADO;
        }
    }

    public void iniciarPreparo() {
        if (this.status == StatusPedido.CONFIRMADO) {
            this.status = StatusPedido.EM_PREPARO;
        }
    }

    public void finalizarPreparo() {
        if (this.status == StatusPedido.EM_PREPARO) {
            this.status = StatusPedido.PRONTO;
        }
    }

    public void entregar() {
        if (this.status == StatusPedido.PRONTO) {
            this.status = StatusPedido.ENTREGUE;
        }
    }

    public void cancelar() {
        if (this.status == StatusPedido.ENTREGUE) {
            throw new IllegalStateException("Um pedido entregue não pode ser cancelado.");
        }
        this.status = StatusPedido.CANCELADO;
    }



    public String getId() {
        return id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<Item> getItens() {

        return Collections.unmodifiableList(itens);
    }
}
