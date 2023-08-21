package it.ricci.game.domain;

import java.util.UUID;

public record GiocatoreId(UUID id) {
  public static GiocatoreId from (String uuidString){
    return new GiocatoreId(UUID.fromString(uuidString));
  }
}
