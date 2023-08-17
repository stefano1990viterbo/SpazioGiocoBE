package it.ricci.game.infrastructure.websocket_adapter.esempio;

import java.security.Principal;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpAttributesContextHolder;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
@Log4j2
@RequiredArgsConstructor
public class WebSocketEvents {

  private final SocketService socketService;

  @EventListener
  public void handleSessionConnected(SessionConnectEvent event) {
    Principal principal = Objects.requireNonNull(event.getUser());

    String sessionId = SimpAttributesContextHolder.currentAttributes().getSessionId();

    log.info("Client connessso con sessionid: "+sessionId);
  }

  @EventListener
  public void onDisconnectEvent(SessionDisconnectEvent event) {

    log.info("Client with session id {} disconnected", event.getSessionId());

    String sessionId = event.getSessionId();

    String name = socketService.getNameBySession(sessionId);

    log.info("Client with name {} has been disconnected ", name);

    socketService.removeSession(sessionId);

  }

}
