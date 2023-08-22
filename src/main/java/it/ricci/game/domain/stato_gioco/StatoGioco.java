package it.ricci.game.domain.stato_gioco;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@ToString
@Log4j2
public class StatoGioco {

//  private static StatoGioco INSTANCE;
//
//  private StatoGioco() {
//  }
//
//  public static StatoGioco getInstance() {
//    if (INSTANCE == null) {
//      INSTANCE = new StatoGioco();
//    }
//    return INSTANCE;
//  }

  private UUID id;
  private List<Giocatore> giocatori = new ArrayList<>();
  private List<Proiettile> proiettili = new ArrayList<>();

  public StatoGioco getStatoAttuale() {
//    StatoGioco statoGioco = StatoGioco.getInstance();

    List<Proiettile> proiettiliAggiornati = getProiettiles(
        this);

    this.setProiettili(proiettiliAggiornati);

    controlloCollisioneGiocatoriConProiettili(proiettiliAggiornati, this.getGiocatori());

    return this;
  }

  public void addGiocatore(Giocatore giocatoreDaAggiungere) {
    giocatori.add(giocatoreDaAggiungere);
  }

  public void rimuoviGiocatore(UUID usernameGiocatoreDaRimuovere) {

    Optional<Giocatore> giocatoreInElenco = giocatori.stream()
        .filter(g -> g.getUsername().equals(usernameGiocatoreDaRimuovere)).findFirst();

    if (!giocatoreInElenco.isPresent()) {
      log.warn("Giocatore da eliminare non trovato");
      //TODO
//      throw new NoSuchElementException();
      return;
    }

    giocatori.remove(giocatoreInElenco.get());
  }

  public Giocatore trovaGiocatoreFromUsername(UUID username) {
    Optional<Giocatore> giocatoreInElenco = giocatori.stream()
        .filter(g -> g.getUsername().equals(username)).findFirst();

    if (!giocatoreInElenco.isPresent()) {
      log.warn("Giocatore non trovato");
      //TODO
//      throw new NoSuchElementException();
      return null;
    }
    return giocatoreInElenco.get();
  }

  public void aggiungiProiettileAlGioco(Proiettile proiettile) {
    proiettili.add(proiettile);
  }


  private  void controlloCollisioneGiocatoriConProiettili(
      List<Proiettile> proiettiliAggiornati, List<Giocatore> giocatori) {

    for (Giocatore g : giocatori) {
      for (Proiettile p : proiettiliAggiornati) {
        if (!g.getUsername().equals(p.getGiocatoreSparante()) && g.collideCon(p)) {
//          StatoGioco.getInstance().rimuoviGiocatore(g.getUsername());
          this.rimuoviGiocatore(g.getUsername());
        }
      }
    }
  }

  private static List<Proiettile> getProiettiles(StatoGioco statoGioco) {
    List<Proiettile> proiettiliAggiornati = new ArrayList<>();
    for (Proiettile p : statoGioco.proiettili) {
      LocalDateTime ora = LocalDateTime.now();
      Duration duration = Duration.between(p.getInizioSparo(), ora);

      if (duration.getSeconds() <= 3) {
        p.aggiornaCoordinateDelProiettile(p);
        proiettiliAggiornati.add(p);
      }
    }
    return proiettiliAggiornati;
  }


}
