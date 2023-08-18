package it.ricci.game.infrastructure.websocket_adapter;

import it.ricci.game.application.ports.ModificaPosizioneGiocatoreUseCase;
import it.ricci.game.application.ports.ModificaStatoGiocoUseCase;
import it.ricci.game.application.ports.TrovaGiocatoreDaUsernameUseCase;
import it.ricci.game.domain.Giocatore;
import it.ricci.game.domain.StatoGioco;
import it.ricci.game.infrastructure.websocket_adapter.dto.DatiInput;
import it.ricci.game.infrastructure.websocket_adapter.esempio.SocketService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Log4j2
public class GiocoController {

  private final SocketService socketService;
  private final ModificaStatoGiocoUseCase modificaStatoGiocoUseCase;
  private final TrovaGiocatoreDaUsernameUseCase trovaGiocatoreDaUsernameUseCase;
  private final ModificaPosizioneGiocatoreUseCase modificaPosizioneGiocatoreUseCase;

  private final WebsocketGameStatusOutputAdapter websocketGameStatusOutputAdapter;
  //private final StatoGiocoService giocoService;

//  private StatoGioco statoGioco;


  @MessageMapping("/key-input")
//  @SendTo("/topic/aggiornagioco")
  public StatoGioco datiInput(@Payload DatiInput input) {
    log.info("Ricevuto messaggio: " + input);

    Giocatore giocatore = trovaGiocatoreDaUsernameUseCase.giocatoreFromUserName(
        UUID.fromString(input.getUsername()));

    Giocatore giocatoreConPosizioneCambiata = modificaPosizioneGiocatoreUseCase.modificaPosizione(
        giocatore, input);

    modificaStatoGiocoUseCase.aggiornaStatoGioco(giocatoreConPosizioneCambiata);

    websocketGameStatusOutputAdapter.sendGameStatus(StatoGioco.getInstance());

    return StatoGioco.getInstance();
  }


}
