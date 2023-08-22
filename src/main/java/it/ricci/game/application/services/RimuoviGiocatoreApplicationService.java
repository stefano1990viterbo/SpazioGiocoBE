package it.ricci.game.application.services;

import it.ricci.game.application.ports.input.RimuoviGiocaoreUseCase;
import it.ricci.game.application.ports.output.RimuoviGiocatorePort;
import it.ricci.game.domain.stato_gioco.Giocatore;
import it.ricci.game.domain.stato_gioco.StatoGioco;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class RimuoviGiocatoreApplicationService implements RimuoviGiocaoreUseCase {

  private final RimuoviGiocatorePort rimuoviGiocatorePort;

  @Override
  public void rimuoviGiocatore(UUID username) {
    rimuoviGiocatorePort.rimuoviGiocatoreDalGioco(username);
  }
}
