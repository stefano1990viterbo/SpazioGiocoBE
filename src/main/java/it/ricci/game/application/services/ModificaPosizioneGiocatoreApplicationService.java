package it.ricci.game.application.services;

import it.ricci.game.application.ports.ModificaPosizioneGiocatoreUseCase;
import it.ricci.game.domain.Giocatore;
import it.ricci.game.domain.KeysMap;
import it.ricci.game.infrastructure.websocket_adapter.dto.DatiInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ModificaPosizioneGiocatoreApplicationService implements
    ModificaPosizioneGiocatoreUseCase {

  private static final int spostamento = 50;


  @Override
  public Giocatore modificaPosizione(Giocatore giocatore, DatiInput input) {
    return cambiaPosizione(input.getKeyDown(), giocatore);
  }


  private Giocatore cambiaPosizione(int inputKey, Giocatore giocatore) {

    if (inputKey == KeysMap.A) {
      giocatore.setX(giocatore.getX() - spostamento);
//      this.x -= velocitaNavicella * Gdx.graphics.getDeltaTime();
    }
    if (inputKey == KeysMap.D) {
      giocatore.setX(giocatore.getX() + spostamento);
//      this.x += velocitaNavicella * Gdx.graphics.getDeltaTime();
    }

    if (inputKey == KeysMap.W) {
      giocatore.setY(giocatore.getY() + spostamento);
//      this.y += velocitaNavicella * Gdx.graphics.getDeltaTime();
    }

    if (inputKey == KeysMap.S) {
      giocatore.setY(giocatore.getY() - spostamento);
//      this.y -= velocitaNavicella * Gdx.graphics.getDeltaTime();
    }
    return giocatore;
  }
}
