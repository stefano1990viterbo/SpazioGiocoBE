package it.ricci.game.application.services;

import it.ricci.game.application.ports.input.CreaProiettileUseCase;
import it.ricci.game.application.ports.output.AggiungiProiettilePort;
import it.ricci.game.domain.ConfigurazioneGioco;
import it.ricci.game.domain.stato_gioco.Giocatore;
import it.ricci.game.domain.stato_gioco.Proiettile;
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

  private final AggiungiProiettilePort aggiungiProiettilePort;

  @Override
  public void creaProiettile(Giocatore giocatore, DatiInput input) {

    Proiettile proiettile = Proiettile.builder().id(UUID.randomUUID())
        .giocatoreSparante(giocatore.getUsername())
        .xDirezione((double) input.getTouchDown().screenX())
        .yDirezione(
            (double) ConfigurazioneGioco.ALTEZZA_SCHERMO_GIOCO - input.getTouchDown().screenY())
        .angoloDiDirezione(giocatore.getAngoloDiDirezione())
        .inizioSparo(LocalDateTime.now())

        .build();

    proiettile.setY(giocatore.getY());
    proiettile.setX(giocatore.getX());
    proiettile.setHeight(Proiettile.HEIGHT);
    proiettile.setWidth(Proiettile.WIDTH);

//    StatoGioco.getInstance().aggiungiProiettileAlGioco(proiettile);

    aggiungiProiettilePort.aggiungiProiettile(proiettile);
  }

}
