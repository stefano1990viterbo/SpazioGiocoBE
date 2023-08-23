package it.ricci.game.infrastructure.output_base_adapter;

import it.ricci.game.application.ports.output.AggiungiGiocatorePort;
import it.ricci.game.application.ports.output.AggiungiProiettilePort;
import it.ricci.game.application.ports.output.FindGiocatorePort;
import it.ricci.game.application.ports.output.GeneraStanzaPort;
import it.ricci.game.application.ports.output.ModificaStatoGiocoPort;
import it.ricci.game.application.ports.output.RientraGiocatorePort;
import it.ricci.game.application.ports.output.RimuoviGiocatorePort;
import it.ricci.game.application.ports.output.VediStatoAttualeDelGiocoPort;
import it.ricci.game.domain.stato_gioco.Giocatore;
import it.ricci.game.domain.stato_gioco.Proiettile;
import it.ricci.game.domain.stato_gioco.StatoGioco;
import it.ricci.game.infrastructure.output_base_adapter.repositories.StatoGiocoBaseRepositorie;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StatoGiocoBaseAdapter implements GeneraStanzaPort, VediStatoAttualeDelGiocoPort,
    ModificaStatoGiocoPort, AggiungiGiocatorePort, RimuoviGiocatorePort , AggiungiProiettilePort ,
    FindGiocatorePort , RientraGiocatorePort {

  private final StatoGiocoBaseRepositorie statoGiocoBaseRepositorie;

  @Override
  public void generaStanzaGioco() {
    UUID id = UUID.randomUUID();
    StatoGioco statoGiocoDaCreare = new StatoGioco();
    statoGiocoDaCreare.setId(id);
    statoGiocoBaseRepositorie.generaStanza(statoGiocoDaCreare);
  }

  @Override
  public StatoGioco vediStatoGioco() {
    return statoGiocoBaseRepositorie.vediStato();
  }

  @Override
  public void modificaStatoGioco(StatoGioco statoModificato) {
    statoGiocoBaseRepositorie.updateStato(statoModificato);
  }

  @Override
  public Giocatore aggiungiGiocatore(Giocatore giocatore) {
    StatoGioco statoGioco = statoGiocoBaseRepositorie.vediStato();
    statoGioco.addGiocatore(giocatore);
    statoGiocoBaseRepositorie.updateStato(statoGioco);
    return giocatore;
  }

  @Override
  public void rimuoviGiocatoreDalGioco(UUID username) {
    StatoGioco statoGioco = statoGiocoBaseRepositorie.vediStato();
    statoGioco.rimuoviGiocatore(username);
    statoGiocoBaseRepositorie.updateStato(statoGioco);
  }

  @Override
  public void aggiungiProiettile(Proiettile proiettile) {
    StatoGioco statoGioco = statoGiocoBaseRepositorie.vediStato();
    statoGioco.aggiungiProiettileAlGioco(proiettile);
    statoGiocoBaseRepositorie.updateStato(statoGioco);
  }

  @Override
  public Giocatore trovaGiocatoreDaUsername(UUID username) {
    StatoGioco statoGioco = statoGiocoBaseRepositorie.vediStato();
    return statoGioco.trovaGiocatoreFromUsername(username);
  }

  @Override
  public void faiRientrareIlGiocatoreNellaPartita(Giocatore giocatore) {
    StatoGioco statoGioco = statoGiocoBaseRepositorie.vediStato();
    statoGioco.faiRientrareIlGiocatore(giocatore);
    statoGiocoBaseRepositorie.updateStato(statoGioco);
  }
}
