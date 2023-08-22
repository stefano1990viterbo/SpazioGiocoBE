package it.ricci.game.infrastructure.output_websocket_adapter.mappers;

import it.ricci.game.domain.stato_gioco.Proiettile;
import it.ricci.game.infrastructure.output_websocket_adapter.StatoGioco.ProiettileResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper
public interface ProiettileResourceMapper {

  /**
   * Notare che è stato necessario costruire questo mapper per problemi nel mappaggio nelle proprietà
   * "xPosizione" e "yPosizione".
   * A quanto pare nel source non le trova se sono con la prima lettera minuscola
   * TODO indagare
   *
   * @param proiettile
   * @return
   */
//  @Mapping(target = "xPosizione",source = "XPosizione")
//  @Mapping(target = "yPosizione",source = "YPosizione")
  ProiettileResource poriettileToResource(Proiettile proiettile);

}
