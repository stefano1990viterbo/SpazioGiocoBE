package it.ricci.game.domain.stato_gioco;

import static java.lang.Math.abs;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
//@Setter
public class Proiettile extends Rettangolo {

  public static int WIDTH = 12;
  public static int HEIGHT = 12;
  public static final int VELOCITA = 25;

  private UUID id;
  private UUID giocatoreSparante;

  private LocalDateTime inizioSparo;

  private Double xDirezione;
  private Double yDirezione;

  private Double angoloDiDirezione;
  private int velocita;



  public void aggiornaCoordinateDelProiettile(Proiettile proiettile) {

    double xConosciuta = 0;
    double yCalcolata = 0;

    int unitaX = 1;
    double rapportoY = calcolaRapportoY(proiettile);

    double nSegmenti = unitaX + rapportoY;
    double veloCitaAlSegmento = VELOCITA / nSegmenti;

    if (xDirezione >= super.getX()) {
      xConosciuta = super.getX() + veloCitaAlSegmento;
      xDirezione = xDirezione + veloCitaAlSegmento;
    } else {
      xConosciuta = super.getX() - veloCitaAlSegmento;
      xDirezione = xDirezione - veloCitaAlSegmento;
    }

    if (yDirezione >= super.getY()) {
      yCalcolata = super.getY() + (veloCitaAlSegmento * rapportoY);
      yDirezione = yDirezione + (veloCitaAlSegmento * rapportoY);
    } else {
      yCalcolata = super.getY() - (veloCitaAlSegmento * rapportoY);
      yDirezione = yDirezione - (veloCitaAlSegmento * rapportoY);
    }

    super.setX(xConosciuta);
    super.setY(yCalcolata);
  }

  private double calcolaRapportoY(Proiettile proiettile) {
    return abs(
        (yDirezione - super.getY()) / (xDirezione - super.getX()));
  }


}
