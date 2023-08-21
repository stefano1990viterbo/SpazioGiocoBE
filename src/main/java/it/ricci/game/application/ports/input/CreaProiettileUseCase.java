package it.ricci.game.application.ports.input;

import it.ricci.game.domain.Giocatore;
import it.ricci.game.infrastructure.input_websocket_adapter.dto.DatiInput;

public interface CreaProiettileUseCase {

  void creaProiettile(Giocatore giocatore, DatiInput input);

}
