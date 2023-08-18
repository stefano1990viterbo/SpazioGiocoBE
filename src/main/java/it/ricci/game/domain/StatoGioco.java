package it.ricci.game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
//@Service
@Log4j2
public class StatoGioco {

  private static StatoGioco INSTANCE;

  private StatoGioco() {}

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

    if(!giocatoreInElenco.isPresent()){
      log.warn("Giocatore da eliminare non trovato");
      //TODO
//      throw new NoSuchElementException();
    }

    giocatori.remove(giocatoreInElenco.get());

    return giocatoreInElenco.get();
  }

  public Giocatore trovaGiocatoreFromUsername(UUID username){
    Optional<Giocatore> giocatoreInElenco = giocatori.stream()
        .filter(g -> g.getUsername().equals(username)).findFirst();

    if(!giocatoreInElenco.isPresent()){
      log.warn("Giocatore non trovato");
      //TODO
//      throw new NoSuchElementException();
    }
    return giocatoreInElenco.get();
  }

//  public StatoGioco aggiornaStatoGioco(Giocatore giocatoreResource) {
//
//    Optional<Giocatore> elementoPresente = giocatoreResources.stream()
//        .filter(g -> g.getUsername().equals(giocatoreResource.getUsername()))
//        .findFirst();
//
//    List<Giocatore> listAggiornata = new ArrayList<>();
//
//    if (!elementoPresente.isPresent()) {
//      giocatoreResources.add(giocatoreResource);
//      listAggiornata = giocatoreResources;
//    } else {
//      List<Giocatore> list = giocatoreResources.stream()
//          .filter(g -> !g.getUsername().equals(giocatoreResource.getUsername()))
//          .collect(Collectors.toList());
//
//      elementoPresente.get().setY(giocatoreResource.getY());
//      elementoPresente.get().setX(giocatoreResource.getX());
//
//      list.add(elementoPresente.get());
//      listAggiornata = list;
//    }
//
//    StatoGioco sg = new StatoGioco();
//    sg.setGiocatori(listAggiornata);
//
//    websocketGameStatusOutputAdapter.sendGameStatus(sg);
//
////    List<GiocatoreResource> giocatoreResources = statoGioco.getGiocatoreResources();
////
////    for (GiocatoreResource giocatoreReource : giocatoreResources) {
////      Giocatore giocatore = new Giocatore(giocatoreReource);
////      giocatori.add(giocatore);
////    }
//    return sg;
//  }

}
