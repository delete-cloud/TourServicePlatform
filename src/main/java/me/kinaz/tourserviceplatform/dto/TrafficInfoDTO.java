package me.kinaz.tourserviceplatform.dto;

public class TrafficInfoDTO {
    private Long scenicSpotId;
    private String route;

    // Getters and Setters
    public Long getScenicSpotId() {
        return scenicSpotId;
    }

    public void setScenicSpotId(Long scenicSpotId) {
        this.scenicSpotId = scenicSpotId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
