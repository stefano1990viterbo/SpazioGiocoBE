package it.ricci.game.infrastructure.output_websocket_adapter.StatoGioco;

import java.util.UUID;
import lombok.Builder;

@Builder

public class GiocatoreResource {
  private UUID id;
  private UUID username;

  private Double x;
  private Double y;
  private Double angoloDiDirezione;
}
