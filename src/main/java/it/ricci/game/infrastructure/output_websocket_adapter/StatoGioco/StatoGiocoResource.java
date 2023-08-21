package it.ricci.game.infrastructure.output_websocket_adapter.StatoGioco;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;

@Builder
public class StatoGiocoResource {

  List<ProiettileResource> proiettiliResources=new ArrayList<>();
  List<GiocatoreResource> giocatoriResources=new ArrayList<>();

}
