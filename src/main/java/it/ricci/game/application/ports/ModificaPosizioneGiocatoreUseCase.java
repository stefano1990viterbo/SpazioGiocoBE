package it.ricci.game.application.ports;

import it.ricci.game.domain.Giocatore;
import it.ricci.game.infrastructure.websocket_adapter.dto.DatiInput;

public interface ModificaPosizioneGiocatoreUseCase {

  Giocatore modificaPosizione(Giocatore giocatore, DatiInput input);

}
