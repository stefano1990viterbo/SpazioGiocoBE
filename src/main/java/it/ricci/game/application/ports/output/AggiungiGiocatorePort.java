package it.ricci.game.application.ports.output;

import it.ricci.game.domain.stato_gioco.Giocatore;

public interface AggiungiGiocatorePort {
  Giocatore aggiungiGiocatore(Giocatore giocatore);
}
