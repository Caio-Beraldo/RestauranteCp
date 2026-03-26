package cp4.cp4.controller;

import cp4.cp4.application.PedidoService;
import cp4.cp4.controller.requests.AdicionarItemRequest;
import cp4.cp4.controller.requests.PedidoActionRequest;
import cp4.cp4.controller.requests.RemoverItemRequest;
import cp4.cp4.dto.ItemDTO;
import cp4.cp4.dto.PedidoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private final PedidoService service = new PedidoService();

	@PostMapping("/iniciar")
	public ResponseEntity<PedidoDTO> iniciar() {
		PedidoDTO criado = service.iniciarPedido();
		return ResponseEntity.status(HttpStatus.CREATED).body(criado);
	}
	@PostMapping("/itens")
	public ResponseEntity<?> adicionarItem(@RequestBody AdicionarItemRequest req) {
		try {
			PedidoDTO atualizado = service.adicionarItem(req.getPedido(), req.getItem());
			return ResponseEntity.ok(atualizado);
		} catch (IllegalStateException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/itens")
	public ResponseEntity<?> removerItem(@RequestBody RemoverItemRequest req) {
		try {
			PedidoDTO atualizado = service.removerItem(req.getPedido(), req.getNomeItem());
			return ResponseEntity.ok(atualizado);
		} catch (IllegalStateException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/confirmar")
	public ResponseEntity<?> confirmar(@RequestBody PedidoActionRequest req) {
		try {
			PedidoDTO atualizado = service.confirmar(req.getPedido());
			return ResponseEntity.ok(atualizado);
		} catch (IllegalStateException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/preparo/iniciar")
	public ResponseEntity<?> iniciarPreparo(@RequestBody PedidoActionRequest req) {
		PedidoDTO atualizado = service.iniciarPreparo(req.getPedido());
		return ResponseEntity.ok(atualizado);
	}

	@PostMapping("/preparo/finalizar")
	public ResponseEntity<?> finalizarPreparo(@RequestBody PedidoActionRequest req) {
		PedidoDTO atualizado = service.finalizarPreparo(req.getPedido());
		return ResponseEntity.ok(atualizado);
	}

	@PostMapping("/entregar")
	public ResponseEntity<?> entregar(@RequestBody PedidoActionRequest req) {
		PedidoDTO atualizado = service.entregar(req.getPedido());
		return ResponseEntity.ok(atualizado);
	}

	@PostMapping("/cancelar")
	public ResponseEntity<?> cancelar(@RequestBody PedidoActionRequest req) {
		try {
			PedidoDTO atualizado = service.cancelar(req.getPedido());
			return ResponseEntity.ok(atualizado);
		} catch (IllegalStateException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
