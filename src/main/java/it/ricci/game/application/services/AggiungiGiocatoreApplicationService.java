package it.ricci.game.application.services;

import it.ricci.game.application.ports.input.AggiungiGiocatoreUseCase;
import it.ricci.game.domain.Giocatore;
import it.ricci.game.domain.StatoGioco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AggiungiGiocatoreApplicationService implements AggiungiGiocatoreUseCase {

  private static final Double POSIZIONE_Y_DEFAULT = 150.0;
  private static final Double POSIZIONE_X_DEFAULT = 150.0;
//  private StatoGioco statoGioco;

  @Override
  public Giocatore aggiungiGiocatore(Giocatore giocatore) {
    giocatore.setY(POSIZIONE_Y_DEFAULT);
    giocatore.setX(POSIZIONE_X_DEFAULT);
    StatoGioco.getInstance().addGiocatore(giocatore);

    return giocatore;
  }
}
