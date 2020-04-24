package com.tamu.happyloft.dto;

/**
 * Created by arshi on 4/24/2020.
 */
public class ServiceRequestDto {

    private int serviceId;
    private String requesterEmail;
    private String serviceCreatorEmail;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    public String getServiceCreatorEmail() {
        return serviceCreatorEmail;
    }

    public void setServiceCreatorEmail(String serviceCreatorEmail) {
        this.serviceCreatorEmail = serviceCreatorEmail;
    }
}
