package it.ricci.game.infrastructure.websocket_adapter.esempio;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TestWebsocketController {
  private final SocketService socketService;

  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public MessageDto sendMessage(MessageDto message, @Header("simpSessionId") String sessionId) {

    socketService.saveSession(sessionId, message.getName());

    return new MessageDto("Message with text : " + message.getText()
        + " received ", " from " + message.getName());
  }
}
