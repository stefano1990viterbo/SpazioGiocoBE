package it.ricci.game.infrastructure.input_websocket_adapter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Builder
//@Getter
public record MouseMoved (int screenX, int screenY){
}
