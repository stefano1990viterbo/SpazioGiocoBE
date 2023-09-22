package it.ricci.game.domain.stato_gioco;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Giocatore extends Rettangolo {

  public static final int WIDTH = 32;
  public static final int HEIGHT = 32;
  public static final int VITE_DEFAULT=4;

  private UUID id;
  //  private GiocatoreId id;
  private UUID username;
  @Setter
  private Double angoloDiDirezione;

  private int vite;
  private int punteggio;

  private boolean funzioniBloccate=false;

//  public Giocatore(GiocatoreId id, UUID username) {
//    this.id=id;
//    this.username=username;
//  }

  public void diminuisciVita(int viteDaRimuovere){
    this.vite = vite-viteDaRimuovere;
  }

  public boolean isDead(){
    return this.getVite() <= 0;
  }

  public boolean haSparatoIlProiettile(Proiettile proiettile){
    return this.getUsername().equals(proiettile.getGiocatoreSparante());
  }

  public boolean isFunzioniBloccate() {
    return funzioniBloccate;
  }

  public void rimuoviFunzioni() {
    funzioniBloccate=true;
  }
}
