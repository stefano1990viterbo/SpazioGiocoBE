package it.ricci.game.infrastructure.output_base_adapter.repositories;

import it.ricci.game.domain.stato_gioco.StatoGioco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StatoGiocoBaseRepositoriImpl implements StatoGiocoBaseRepositorie {

  private StatoGioco statoGioco;

  @Override
  public void generaStanza(StatoGioco statoGiocoDaAggiungere) {
    statoGioco = new StatoGioco();
  }

  @Override
  public StatoGioco vediStato() {
    return statoGioco.getStatoAttuale();
  }

  @Override
  public void updateStato(StatoGioco statoGioco) {
    this.statoGioco=statoGioco;
  }
}
