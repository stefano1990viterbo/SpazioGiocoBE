package it.ricci.game.application.ports.output;

import it.ricci.game.domain.stato_gioco.Proiettile;

public interface AggiungiProiettilePort {

  void aggiungiProiettile(Proiettile proiettile);
}
