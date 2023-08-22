package it.ricci.game.infrastructure.output_websocket_adapter.StatoGioco;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StatoGiocoResource {

  @Builder.Default
  List<ProiettileResource> proiettili = new ArrayList<>();
  @Builder.Default
  List<GiocatoreResource> giocatori = new ArrayList<>();

}
