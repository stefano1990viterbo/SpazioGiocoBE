package it.ricci.game.infrastructure.output_base_adapter.repositories;

import it.ricci.game.domain.stato_gioco.StatoGioco;
import java.util.UUID;

public interface StatoGiocoBaseRepositorie {


  void generaStanza(StatoGioco statoGiocoDaAggiungere);

  StatoGioco vediStato();

  void updateStato(StatoGioco statoGioco);
}
