package com.tamu.happyloft.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by arshi on 4/2/2020.
 */
@Entity
@Table(name = "SERVICE_TABLE")
public class Service {

    @Column(name = "SERVICE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_generator")
    @SequenceGenerator(name="service_generator", sequenceName = "service_seq")
    private Long id;

    private String serviceName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SC_ID", nullable = false)
    private ServiceCategory serviceCategoryID;

    private String serviceCategoryOther;

    private String serviceDescription;

    private String serviceLocation;

    private Double servicePrice;

    private Date serviceDate;

    private String serviceTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STATUS_ID", nullable = false)
    private ServiceStatus serviceStatus;

    @OneToMany(mappedBy = "service")
    private Set<UserServices> userServices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public ServiceCategory getServiceCategoryID() {
        return serviceCategoryID;
    }

    public void setServiceCategoryID(ServiceCategory serviceCategoryID) {
        this.serviceCategoryID = serviceCategoryID;
    }

    public String getServiceCategoryOther() {
        return serviceCategoryOther;
    }

    public void setServiceCategoryOther(String serviceCategoryOther) {
        this.serviceCategoryOther = serviceCategoryOther;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}
