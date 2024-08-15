package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dto.TrafficInfoDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class TrafficClientService {

    private static final String BASE_URL = "http://localhost:8080/TourServicePlatform-1.0-SNAPSHOT/rest";

    public TrafficInfoDTO getTrafficInfo(Long scenicSpotId) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URL).path("traffic").queryParam("scenicSpotId", scenicSpotId);

        return target.request(MediaType.APPLICATION_JSON).get(TrafficInfoDTO.class);
    }
}
