package it.ricci.game.infrastructure.websocket_adapter;

import it.ricci.game.domain.StatoGioco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class WebsocketGameStatusOutputAdapter {
  private final SimpMessagingTemplate template;

  public void sendGameStatus(StatoGioco giocoResource) {
    log.info("invio stato gioco "+giocoResource);
    template.convertAndSend("/topic/aggiornagioco", giocoResource);
  }
}
