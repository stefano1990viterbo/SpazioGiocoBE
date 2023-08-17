package it.ricci.game.infrastructure.websocket_adapter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GiocoController {
  @MessageMapping("/prova")
  @SendTo("/ricevente/prova")
  public String greeting(String message) throws Exception {

    return "Ciao";
  }
}
