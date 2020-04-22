package com.tamu.happyloft.model;

import javax.persistence.*;

/**
 * Created by arshi on 4/2/2020.
 */
@Entity
@Table(name = "SERVICE_STATUS_TABLE")
public class ServiceStatus {

    @Column(name = "STATUS_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_status_generator")
    @SequenceGenerator(name="service_status_generator", sequenceName = "service_status_seq")
    private Long id;

    private String statusName;

    private String statusDescription;

    public ServiceStatus() {

    }

    public ServiceStatus(String statusName, String statusDescription) {
        this.statusName = statusName;
        this.statusDescription = statusDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

}
