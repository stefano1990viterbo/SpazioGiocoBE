package it.ricci.game.infrastructure.websocket_adapter.esempio;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Log4j2
public class TestWebsocketController {
  private final SocketService socketService;

  @MessageMapping("/sendMessage")
  @SendTo("/topic/messages")
  public String broadcastNews(@Payload String message) {
    log.info("Ricevuto messaggio: "+message);
    return message;
  }
}
