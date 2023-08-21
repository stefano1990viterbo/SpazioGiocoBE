package it.ricci.game.infrastructure.input_websocket_adapter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class DatiInput {
  private String usernameKeyboard;
  private KeyDown keyDown;
  private MouseMoved mouseMoved;
  private TouchDown touchDown;


  public void analizzaInput(){

    if(touchDown!=null){
      creaProiettile();
    }

  }

  private void creaProiettile() {

  }

}
