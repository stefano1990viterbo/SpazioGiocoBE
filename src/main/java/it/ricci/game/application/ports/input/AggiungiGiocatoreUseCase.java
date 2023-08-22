package it.ricci.game.application.ports.input;

import java.util.UUID;
import lombok.Builder;
import lombok.NonNull;

public interface AggiungiGiocatoreUseCase {

  void aggiungiGiocatore(AggiungiGiocatoreCommand giocatore);

  @Builder
  record AggiungiGiocatoreCommand(
      @NonNull UUID id,
      @NonNull UUID username

  ) {

  }

}
