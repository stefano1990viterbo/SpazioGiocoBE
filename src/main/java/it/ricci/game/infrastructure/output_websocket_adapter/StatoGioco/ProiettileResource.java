package it.ricci.game.infrastructure.output_websocket_adapter.StatoGioco;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProiettileResource {
  private UUID id;
  private double x;
  private double y;
  private double rotazioneInGradi;
}
