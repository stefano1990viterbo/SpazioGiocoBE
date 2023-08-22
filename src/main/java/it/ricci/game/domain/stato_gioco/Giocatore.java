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

  private UUID id;
  //  private GiocatoreId id;
  private UUID username;
  @Setter
  private Double angoloDiDirezione;

//  public Giocatore(GiocatoreId id, UUID username) {
//    this.id=id;
//    this.username=username;
//  }



}
