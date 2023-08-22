package it.ricci.game.application.services;

import it.ricci.game.application.ports.input.ModificaPosizioneGiocatoreUseCase;
import it.ricci.game.domain.ConfigurazioneGioco;
import it.ricci.game.domain.stato_gioco.Giocatore;
import it.ricci.game.domain.KeysMap;
import it.ricci.game.infrastructure.input_websocket_adapter.dto.DatiInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ModificaPosizioneGiocatoreApplicationService implements
    ModificaPosizioneGiocatoreUseCase {

  private static final int spostamento = 50;
  private static final double velocita = 1;


  @Override
  public Giocatore modificaPosizione(Giocatore giocatore, DatiInput input) {
    if(input.getMouseMoved()!=null){
      double angoloDiRotazione = calcoloAngoloDiRotazione(input, giocatore);
      giocatore.setAngoloDiDirezione(angoloDiRotazione);
    }
    if(input.getKeyDown()!=null){
      giocatore=cambiaPosizione(input.getKeyDown().keycode(), giocatore);
    }
    return giocatore;
  }

  public static final int WIDTH = 32;
  public static final int HEIGHT = 32;

  private double calcoloAngoloDiRotazione(DatiInput input, Giocatore giocatore) {

//    double yInvertita= ConfigurazioneGioco.ALTEZZA_SCHERMO_GIOCO -input.getMouseMoved().getScreenY();

    int mouseY = input.getMouseMoved() == null ? 0 : input.getMouseMoved().screenY();
    int mouseX = input.getMouseMoved() == null ? 0 : input.getMouseMoved().screenX();

    double yInvertita = ConfigurazioneGioco.ALTEZZA_SCHERMO_GIOCO - mouseY;

    double x = (giocatore.getX() + WIDTH);
    double y = (giocatore.getY() + HEIGHT);

    double dy = (yInvertita - y);
    double dx = (x - mouseX);

    // Calcola l'angolazione in radianti
    double angleRadians = Math.atan2(dx, dy);
    // Converti l'angolo in gradi
    return Math.toDegrees(angleRadians);
  }


  private Giocatore cambiaPosizione(int inputKey, Giocatore giocatore) {

    if (inputKey == KeysMap.A) {

      giocatore.setX(giocatore.getX() - spostamento * velocita);
    }
    if (inputKey == KeysMap.D) {
      giocatore.setX(giocatore.getX() + spostamento * velocita);
    }

    if (inputKey == KeysMap.W) {
      giocatore.setY(giocatore.getY() + spostamento * velocita);
    }

    if (inputKey == KeysMap.S) {
      giocatore.setY(giocatore.getY() - spostamento * velocita);
    }
    return giocatore;
  }
}
