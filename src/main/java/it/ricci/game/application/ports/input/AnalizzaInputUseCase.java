package it.ricci.game.application.ports.input;

import it.ricci.game.infrastructure.input_websocket_adapter.dto.DatiInput;

public interface AnalizzaInputUseCase {

  void analizzaInput(DatiInput input);

}
