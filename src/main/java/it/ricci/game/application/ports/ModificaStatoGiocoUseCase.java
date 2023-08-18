package it.ricci.game.application.ports;

import it.ricci.game.domain.Giocatore;
import it.ricci.game.domain.StatoGioco;
import it.ricci.game.infrastructure.websocket_adapter.dto.DatiInput;

public interface ModificaStatoGiocoUseCase {
//  StatoGioco aggiornaStatoGioco(Giocatore giocatoreResource);

  StatoGioco aggiornaStatoGioco(Giocatore giocatoreResource);

//  StatoGioco aggiornaStatoGioco(DatiInput input);
}
