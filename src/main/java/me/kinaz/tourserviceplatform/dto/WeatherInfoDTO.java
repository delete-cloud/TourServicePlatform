package me.kinaz.tourserviceplatform.dto;

public class WeatherInfoDTO {
    private Long id;
    private Long scenicSpotId;
    private String temperature;
    private String condition;

    public WeatherInfoDTO() {
    }

    public WeatherInfoDTO(Long id, Long scenicSpotId, String temperature, String condition) {
        this.id = id;
        this.scenicSpotId = scenicSpotId;
        this.temperature = temperature;
        this.condition = condition;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScenicSpotId() {
        return scenicSpotId;
    }

    public void setScenicSpotId(Long scenicSpotId) {
        this.scenicSpotId = scenicSpotId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
