package it.ricci.game.infrastructure.input_websocket_adapter.dto;

import it.ricci.game.application.ports.input.CreaProiettileUseCase;
import it.ricci.game.application.ports.ModificaPosizioneGiocatoreUseCase;
import it.ricci.game.application.ports.TrovaGiocatoreDaUsernameUseCase;
import it.ricci.game.domain.Giocatore;
import it.ricci.game.infrastructure.esempio.SocketService;
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
  private final TrovaGiocatoreDaUsernameUseCase trovaGiocatoreDaUsernameUseCase;
  private final ModificaPosizioneGiocatoreUseCase modificaPosizioneGiocatoreUseCase;
  private final CreaProiettileUseCase creaProiettileUseCase;


  @MessageMapping("/key-input")
  public void datiInput(@Payload DatiInput input) {
//    log.info("Ricevuto messaggio: " + input);

    Giocatore giocatore = trovaGiocatoreDaUsernameUseCase.giocatoreFromUserName(
        UUID.fromString(input.getUsernameKeyboard()));

    if(input.getKeyDown()!=null || input.getMouseMoved()!=null){
      Giocatore giocatoreConPosizioneCambiata = modificaPosizioneGiocatoreUseCase.modificaPosizione(
          giocatore, input);
    }

    if(input.getTouchDown()!=null){
      log.info("TEST proiettile: "+input);
      creaProiettileUseCase.creaProiettile(giocatore,input);
    }


  }


}
