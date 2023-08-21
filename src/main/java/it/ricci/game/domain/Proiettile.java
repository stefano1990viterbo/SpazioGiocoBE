package it.ricci.game.domain;

import static java.lang.Math.abs;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class Proiettile {

  private UUID id;

  private LocalDateTime inizioSparo;

  private Double xPartenza;
  private Double yPartenza;

  private Double xDirezione;
  private Double yDirezione;

  private Double angoloDiDirezione;
  private int velocita;


  public static final int VELOCITA = 25;

  public  void aggiornaCoordinateDelProiettile(Proiettile proiettile) {




    double xConosciuta = 0;
    double yCalcolata = 0;

    int unitaX = 1;
    double rapportoY = calcolaRapportoY(proiettile);

    double nSegmenti = unitaX + rapportoY;
    double veloCitaAlSegmento = VELOCITA / nSegmenti;


    if (xDirezione >= xPartenza) {
      xConosciuta = xPartenza + veloCitaAlSegmento;
      xDirezione = xDirezione+veloCitaAlSegmento;
    } else {
      xConosciuta = xPartenza - veloCitaAlSegmento;
      xDirezione = xDirezione-veloCitaAlSegmento;
    }

    if (yDirezione >= yPartenza) {
      yCalcolata =yPartenza + (veloCitaAlSegmento * rapportoY);
      yDirezione = yDirezione+ (veloCitaAlSegmento * rapportoY);
    } else {
      yCalcolata = yPartenza - (veloCitaAlSegmento * rapportoY);
      yDirezione = yDirezione- (veloCitaAlSegmento * rapportoY);
    }

    this.xPartenza = xConosciuta;
    this.yPartenza = yCalcolata;
  }

  private  double calcolaRapportoY(Proiettile proiettile) {
    return abs(
        (yDirezione - yPartenza) / (xDirezione - xPartenza));
  }


}
