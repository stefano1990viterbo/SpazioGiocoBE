package it.ricci.game.application.ports;

import it.ricci.game.domain.Giocatore;
import java.util.UUID;

public interface RimuoviGiocaoreUseCase {

  Giocatore rimuoviGiocatore(UUID username);

}
