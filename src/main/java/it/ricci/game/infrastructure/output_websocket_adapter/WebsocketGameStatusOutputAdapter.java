package it.ricci.game.infrastructure.output_websocket_adapter;

import it.ricci.game.application.ports.output.VediStatoAttualeDelGiocoPort;
import it.ricci.game.domain.stato_gioco.StatoGioco;
import it.ricci.game.infrastructure.output_websocket_adapter.StatoGioco.StatoGiocoResource;
import it.ricci.game.infrastructure.output_websocket_adapter.mappers.StatoGiocoResourceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class WebsocketGameStatusOutputAdapter {

  private final SimpMessagingTemplate template;

  private final StatoGiocoResourceMapper statoGiocoMapper;

  private final VediStatoAttualeDelGiocoPort vediStatoAttualeDelGiocoPort;

  public void sendGameStatus() {

//    StatoGiocoResource statoGiocoResource = statoGiocoMapper.statoGiocoToResource(
//        StatoGioco.getStatoAttuale());

    StatoGioco statoGioco = vediStatoAttualeDelGiocoPort.vediStatoGioco();

    if (statoGioco == null) {
      return;
    }

    StatoGiocoResource statoGiocoResource = statoGiocoMapper.statoGiocoToResource(statoGioco);

    template.convertAndSend("/topic/aggiornagioco", statoGiocoResource);
  }

}
