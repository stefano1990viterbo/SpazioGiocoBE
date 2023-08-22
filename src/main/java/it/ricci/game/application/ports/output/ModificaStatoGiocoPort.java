package it.ricci.game.application.ports.output;

import it.ricci.game.domain.stato_gioco.StatoGioco;

public interface ModificaStatoGiocoPort {

  void modificaStatoGioco(StatoGioco statoModificato);

}
