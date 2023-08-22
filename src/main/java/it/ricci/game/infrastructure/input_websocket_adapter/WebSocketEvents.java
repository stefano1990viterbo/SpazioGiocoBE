package it.ricci.game.infrastructure.input_websocket_adapter;

import it.ricci.game.application.ports.input.AggiungiGiocatoreUseCase;
import it.ricci.game.application.ports.input.AggiungiGiocatoreUseCase.AggiungiGiocatoreCommand;
import it.ricci.game.application.ports.input.RimuoviGiocaoreUseCase;
import it.ricci.game.domain.stato_gioco.Giocatore;
import it.ricci.game.infrastructure.esempio.SocketService;
import java.security.Principal;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpAttributesContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Log4j2
@RequiredArgsConstructor
public class WebSocketEvents {

  private final SocketService socketService;

  private final AggiungiGiocatoreUseCase aggiungiGiocatoreUseCase;

  private final RimuoviGiocaoreUseCase rimuoviGiocaoreUseCase;

  @EventListener
  public void handleSessionConnected(SessionConnectEvent event) {
    Principal principal = Objects.requireNonNull(event.getUser());

    log.info("Utente connesso: " + principal.getName());

    String sessionId = SimpAttributesContextHolder.currentAttributes().getSessionId();

    log.info("Client connessso con sessionid: " + sessionId);

    AggiungiGiocatoreCommand command = AggiungiGiocatoreCommand.builder()
        .username(UUID.fromString(principal.getName())).id(UUID.fromString(sessionId)).build();

    aggiungiGiocatoreUseCase.aggiungiGiocatore(
        command);
  }

  @EventListener
  public void onDisconnectEvent(SessionDisconnectEvent event) {

    log.info("Client with session id {} disconnected", event.getSessionId());

    String sessionId = event.getSessionId();

    String name = socketService.getNameBySession(sessionId);

    log.info("Client with name {} has been disconnected ", name);

    socketService.removeSession(sessionId);

    Principal principal = Objects.requireNonNull(event.getUser());
//    giocoService.rimuoviGiocatore(UUID.fromString(principal.getName()));

    rimuoviGiocaoreUseCase.rimuoviGiocatore(
        UUID.fromString(principal.getName()));
  }

}
