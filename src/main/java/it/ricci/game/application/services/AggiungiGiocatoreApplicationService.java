package it.ricci.game.application.services;

import it.ricci.game.application.ports.input.AggiungiGiocatoreUseCase;
import it.ricci.game.application.ports.output.AggiungiGiocatorePort;
import it.ricci.game.domain.stato_gioco.Giocatore;
import it.ricci.game.domain.stato_gioco.StatoGioco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AggiungiGiocatoreApplicationService implements AggiungiGiocatoreUseCase {

  private final AggiungiGiocatorePort aggiungiGiocatorePort;

  private static final Double POSIZIONE_Y_DEFAULT = 150.0;
  private static final Double POSIZIONE_X_DEFAULT = 150.0;
//  private StatoGioco statoGioco;

  @Override
  public void aggiungiGiocatore(AggiungiGiocatoreCommand command) {

    Giocatore giocatoreDaAggiungere = Giocatore.builder()

        .id(command.id()).username(command.username()).vite(Giocatore.VITE_DEFAULT).build();

    giocatoreDaAggiungere.setY(POSIZIONE_Y_DEFAULT);
    giocatoreDaAggiungere.setX(POSIZIONE_X_DEFAULT);
    giocatoreDaAggiungere.setWidth(Giocatore.WIDTH);
    giocatoreDaAggiungere.setHeight(Giocatore.HEIGHT);

    aggiungiGiocatorePort.aggiungiGiocatore(giocatoreDaAggiungere);
  }
}
