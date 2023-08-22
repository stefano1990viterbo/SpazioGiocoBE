package it.ricci.game.application.ports.output;

import it.ricci.game.domain.stato_gioco.Giocatore;
import java.util.UUID;

public interface FindGiocatorePort {

  Giocatore trovaGiocatoreDaUsername(UUID username);

}
