package me.kinaz.tourserviceplatform.dto;

import java.sql.Timestamp;

public class ReservationDTO {
    private Long id;
    private Long userId;
    private Long scenicSpotId;
    private Timestamp reservationTime;
    private String scenicSpotName;
    private String scenicSpotDescription;
    private String scenicSpotImageUrl;

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

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Timestamp reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getScenicSpotName() {
        return scenicSpotName;
    }

    public void setScenicSpotName(String scenicSpotName) {
        this.scenicSpotName = scenicSpotName;
    }

    public String getScenicSpotDescription() {
        return scenicSpotDescription;
    }

    public void setScenicSpotDescription(String scenicSpotDescription) {
        this.scenicSpotDescription = scenicSpotDescription;
    }

    public String getScenicSpotImageUrl() {
        return scenicSpotImageUrl;
    }

    public void setScenicSpotImageUrl(String scenicSpotImageUrl) {
        this.scenicSpotImageUrl = scenicSpotImageUrl;
    }
}
