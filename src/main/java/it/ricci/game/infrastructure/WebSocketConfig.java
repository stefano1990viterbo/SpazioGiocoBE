package it.ricci.game.infrastructure;

import it.ricci.game.application.ports.output.GeneraStanzaPort;
import java.security.Principal;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

@Controller
@RequiredArgsConstructor
@Log4j2
public class WebSocketConfig
    implements WebSocketMessageBrokerConfigurer {

  private final GeneraStanzaPort generaStanzaPort;

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {

    generaStanzaPort.generaStanzaGioco();

    config.enableSimpleBroker("/topic");
    config.setApplicationDestinationPrefixes("/app");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/app");
    registry.addEndpoint("/app").withSockJS();
    registry.addEndpoint("/app").setAllowedOrigins("*");
    registry
        .addEndpoint("/app")
        .setHandshakeHandler(
            new DefaultHandshakeHandler() {
              @Override
              protected Principal determineUser(
                  ServerHttpRequest request,
                  WebSocketHandler wsHandler,
                  Map<String, Object> attributes) {
                // Here you can set and return principal that is used by websocket session.

                HttpHeaders headers = request.getHeaders();
                String username = headers.getFirst("username");
                return () -> username;
              }
            });

  }


}
