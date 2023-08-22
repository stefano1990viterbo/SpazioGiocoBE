package it.ricci.game.application.services;

import it.ricci.game.application.ports.input.TrovaGiocatoreDaUsernameUseCase;
import it.ricci.game.application.ports.output.FindGiocatorePort;
import it.ricci.game.domain.stato_gioco.Giocatore;
import it.ricci.game.domain.stato_gioco.StatoGioco;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TrovaGiocatoreDaUsernameApplicationService implements TrovaGiocatoreDaUsernameUseCase {

//  private StatoGioco statoGioco;
private final FindGiocatorePort findGiocatorePort;

  @Override
  public Giocatore giocatoreFromUserName(UUID username) {
    return findGiocatorePort.trovaGiocatoreDaUsername(username);
  }
}
