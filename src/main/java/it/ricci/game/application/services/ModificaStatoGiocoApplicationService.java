package it.ricci.game.application.services;

import it.ricci.game.application.ports.ModificaStatoGiocoUseCase;
import it.ricci.game.domain.Giocatore;
import it.ricci.game.domain.StatoGioco;
import it.ricci.game.infrastructure.websocket_adapter.dto.DatiInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ModificaStatoGiocoApplicationService implements ModificaStatoGiocoUseCase {

  //private final StatoGiocoService giocoService;

  @Override
  public StatoGioco aggiornaStatoGioco(Giocatore giocatoreResource) {
    return null;
  }

//  @Override
//  public StatoGioco aggiornaStatoGioco(DatiInput input) {
//    return null;
//  }
}
