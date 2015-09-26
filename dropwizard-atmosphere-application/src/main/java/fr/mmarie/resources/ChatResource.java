package fr.mmarie.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mmarie.Message;
import fr.mmarie.Response;
import org.atmosphere.cache.UUIDBroadcasterCache;
import org.atmosphere.config.service.AtmosphereHandlerService;
import org.atmosphere.cpr.AtmosphereResponse;
import org.atmosphere.handler.OnMessage;
import org.atmosphere.interceptor.AtmosphereResourceLifecycleInterceptor;
import org.atmosphere.interceptor.BroadcastOnPostAtmosphereInterceptor;
import org.atmosphere.interceptor.HeartbeatInterceptor;

import java.io.IOException;

@AtmosphereHandlerService(path = "/chat",
        broadcasterCache = UUIDBroadcasterCache.class,
        interceptors = {AtmosphereResourceLifecycleInterceptor.class,
                BroadcastOnPostAtmosphereInterceptor.class,
                HeartbeatInterceptor.class
        })
public class ChatResource extends OnMessage<String> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onMessage(AtmosphereResponse atmosphereResponse, String message) throws IOException {
        Message deserializedMessage = mapper.readValue(message, Message.class);

        String messageResponse = mapper.writeValueAsString(new Response(deserializedMessage.getMessage(),
                deserializedMessage.getAuthor()));
        atmosphereResponse.write(messageResponse);
    }
}