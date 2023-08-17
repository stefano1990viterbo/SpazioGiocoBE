package it.ricci.game.infrastructure.websocket_adapter.esempio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageDto {

  private String text;

  private String name;

}