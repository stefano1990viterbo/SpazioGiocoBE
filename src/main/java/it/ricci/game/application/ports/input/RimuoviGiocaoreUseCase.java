package it.ricci.game.application.ports.input;

import it.ricci.game.domain.stato_gioco.Giocatore;
import java.util.UUID;

public interface RimuoviGiocaoreUseCase {

  void rimuoviGiocatore(UUID username);

}
