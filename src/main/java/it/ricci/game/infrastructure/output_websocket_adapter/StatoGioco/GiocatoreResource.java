package it.ricci.game.infrastructure.output_websocket_adapter.StatoGioco;

import it.ricci.game.domain.stato_gioco.Giocatore;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GiocatoreResource {
  private UUID id;
  private UUID username;

  private Double x;
  private Double y;
  private Double angoloDiDirezione;

  private int width;
  private int height;

//  private final int WIDTH = Giocatore.WIDTH;
//  private final int HEIGHT = Giocatore.HEIGHT;
}
