package it.ricci.game.application.ports.input;

import it.ricci.game.domain.stato_gioco.Giocatore;
import java.util.UUID;
import lombok.Builder;
import lombok.NonNull;

public interface RietraGiocatoreUsecase {

  void rientraGiocatore(RientraGiocatoreCommand command);

  @Builder
  record RientraGiocatoreCommand(
      @NonNull UUID id,
      @NonNull UUID username

  ) {

  }
}
