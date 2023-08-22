package it.ricci.game.domain.stato_gioco;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Builder
public class Rettangolo {

  private int width;
  private int height;

  private Double x;
  private Double y;

  public boolean collideCon(Rettangolo r){

    return x < r.x + r.width && x + width > r.x && y < r.y + r.height && y + height > r.y;
  }

}
