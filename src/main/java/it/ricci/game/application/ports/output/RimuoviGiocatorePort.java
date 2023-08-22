package it.ricci.game.application.ports.output;

import java.util.UUID;

public interface RimuoviGiocatorePort {

  void rimuoviGiocatoreDalGioco(UUID username);
}
