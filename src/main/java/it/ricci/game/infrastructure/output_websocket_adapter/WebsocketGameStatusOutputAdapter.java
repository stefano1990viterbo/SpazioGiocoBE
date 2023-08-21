package it.ricci.game.infrastructure.output_websocket_adapter;

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

  public void sendGameStatus() {
    template.convertAndSend("/topic/aggiornagioco", StatoGioco.getStatoAttuale());
  }

}
