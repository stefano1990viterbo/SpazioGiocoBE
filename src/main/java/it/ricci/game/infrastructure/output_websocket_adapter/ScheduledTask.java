package it.ricci.game.infrastructure.output_websocket_adapter;

import it.ricci.game.infrastructure.output_websocket_adapter.WebsocketGameStatusOutputAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledTask {

  private final WebsocketGameStatusOutputAdapter websocketGameStatusOutputAdapter;
  @Scheduled(fixedRate = 16) // Esegui ogni 60 millisecondi
//@Scheduled(fixedRate = 2000) // Esegui ogni 60 millisecondi
  public void eseguiAggiornamento() {
    websocketGameStatusOutputAdapter.sendGameStatus();
  }
}
