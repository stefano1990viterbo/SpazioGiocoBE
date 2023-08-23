package it.ricci.game.application.services;

import it.ricci.game.application.ports.input.RietraGiocatoreUsecase;
import it.ricci.game.application.ports.output.RientraGiocatorePort;
import it.ricci.game.domain.stato_gioco.Giocatore;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class RientraGiocatoreApplicationService implements RietraGiocatoreUsecase {

  private final RientraGiocatorePort rientraGiocatorePort;

  @Override
  public void rientraGiocatore(RientraGiocatoreCommand command) {

    Giocatore giocatore = Giocatore.builder().id(command.id()).username(command.username()).vite(4)
        .build();

    giocatore.setY(150.0);
    giocatore.setX(150.0);
    giocatore.setWidth(Giocatore.WIDTH);
    giocatore.setHeight(Giocatore.HEIGHT);

    rientraGiocatorePort.faiRientrareIlGiocatoreNellaPartita(giocatore);
  }
}
