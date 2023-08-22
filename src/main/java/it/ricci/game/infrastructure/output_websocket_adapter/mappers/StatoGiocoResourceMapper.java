package it.ricci.game.infrastructure.output_websocket_adapter.mappers;

import it.ricci.game.domain.stato_gioco.Giocatore;
import it.ricci.game.domain.stato_gioco.Proiettile;
import it.ricci.game.domain.stato_gioco.StatoGioco;
import it.ricci.game.infrastructure.output_websocket_adapter.StatoGioco.GiocatoreResource;
import it.ricci.game.infrastructure.output_websocket_adapter.StatoGioco.ProiettileResource;
import it.ricci.game.infrastructure.output_websocket_adapter.StatoGioco.StatoGiocoResource;
import java.util.List;
import org.mapstruct.Mapper;

//@Mapper(uses = ProiettileResourceMapper.class)
@Mapper
public interface StatoGiocoResourceMapper {

  StatoGiocoResource statoGiocoToResource(StatoGioco statoGioco);

  List<GiocatoreResource> giocatoriToResources(List<Giocatore> giocatori);

  List<ProiettileResource> proiettiliToResources(List<Proiettile> proiettili);

}
