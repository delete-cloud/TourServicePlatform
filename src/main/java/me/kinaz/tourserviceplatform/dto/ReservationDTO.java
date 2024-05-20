package me.kinaz.tourserviceplatform.dto;

public class ReservationDTO {
    private Long id;
    private Long userId;
    private Long scenicSpotId;
    private String visitTime;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id, Long userId, Long scenicSpotId, String visitTime) {
        this.id = id;
        this.userId = userId;
        this.scenicSpotId = scenicSpotId;
        this.visitTime = visitTime;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScenicSpotId() {
        return scenicSpotId;
    }

    public void setScenicSpotId(Long scenicSpotId) {
        this.scenicSpotId = scenicSpotId;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
}
