package it.ricci.game.application.services;

import it.ricci.game.application.ports.RimuoviGiocaoreUseCase;
import it.ricci.game.domain.Giocatore;
import it.ricci.game.domain.StatoGioco;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class RimuoviGiocatoreApplicationService implements RimuoviGiocaoreUseCase {

//  private StatoGioco statoGioco;

  @Override
  public Giocatore rimuoviGiocatore(UUID username) {
    return StatoGioco.getInstance().rimuoviGiocatore(username);
  }
}
