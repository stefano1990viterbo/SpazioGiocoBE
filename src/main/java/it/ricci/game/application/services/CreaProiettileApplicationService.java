package it.ricci.game.application.services;

import it.ricci.game.application.ports.input.CreaProiettileUseCase;
import it.ricci.game.domain.ConfigurazioneGioco;
import it.ricci.game.domain.Giocatore;
import it.ricci.game.domain.Proiettile;
import it.ricci.game.domain.StatoGioco;
import it.ricci.game.infrastructure.input_websocket_adapter.dto.DatiInput;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CreaProiettileApplicationService implements CreaProiettileUseCase {

  @Override
  public void creaProiettile(Giocatore giocatore, DatiInput input) {

    Proiettile proiettile = Proiettile.builder().id(UUID.randomUUID())
        .xPartenza(giocatore.getX())
        .yPartenza(giocatore.getY())
        .xDirezione((double) input.getTouchDown().screenX())
        .yDirezione((double) ConfigurazioneGioco.ALTEZZA_SCHERMO_GIOCO - input.getTouchDown().screenY())
        .angoloDiDirezione(giocatore.getAngoloDiDirezione())
        .inizioSparo(LocalDateTime.now())
        .build();

    StatoGioco.getInstance().aggiungiProiettileAlGioco(proiettile);
  }

}
