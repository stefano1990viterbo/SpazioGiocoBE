package it.ricci.game.domain;

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

  private static StatoGioco INSTANCE;

  private StatoGioco() {
  }

  public static StatoGioco getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new StatoGioco();
    }
    return INSTANCE;
  }

  private List<Giocatore> giocatori = new ArrayList<>();

  public void addGiocatore(Giocatore giocatoreDaAggiungere) {
    giocatori.add(giocatoreDaAggiungere);
  }

  public Giocatore rimuoviGiocatore(UUID usernameGiocatoreDaRimuovere) {

    Optional<Giocatore> giocatoreInElenco = giocatori.stream()
        .filter(g -> g.getUsername().equals(usernameGiocatoreDaRimuovere)).findFirst();

    if (!giocatoreInElenco.isPresent()) {
      log.warn("Giocatore da eliminare non trovato");
      //TODO
//      throw new NoSuchElementException();
    }

    giocatori.remove(giocatoreInElenco.get());

    return giocatoreInElenco.get();
  }

  public Giocatore trovaGiocatoreFromUsername(UUID username) {
    Optional<Giocatore> giocatoreInElenco = giocatori.stream()
        .filter(g -> g.getUsername().equals(username)).findFirst();

    if (!giocatoreInElenco.isPresent()) {
      log.warn("Giocatore non trovato");
      //TODO
//      throw new NoSuchElementException();
    }
    return giocatoreInElenco.get();
  }


}
