package it.ricci.game.domain;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@Builder
@ToString
public class Giocatore {

  public Giocatore() {
  }

  private UUID id;
  private UUID username;

  private Double x;
  private Double y;
  private Double angoloDiDirezione;

  public Giocatore(UUID id, UUID username) {
    this.id=id;
    this.username=username;
  }


}
