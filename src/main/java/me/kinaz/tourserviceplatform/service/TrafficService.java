package me.kinaz.tourserviceplatform.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.kinaz.tourserviceplatform.dto.TrafficInfoDTO;

@Path("/traffic")
public class TrafficService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrafficInfo(@QueryParam("scenicSpotId") Long scenicSpotId) {
        // Mocked traffic information
        TrafficInfoDTO trafficInfo = new TrafficInfoDTO();
        trafficInfo.setScenicSpotId(scenicSpotId);
        trafficInfo.setRoute("Route information to scenic spot");

        return Response.ok(trafficInfo).build();
    }
}
