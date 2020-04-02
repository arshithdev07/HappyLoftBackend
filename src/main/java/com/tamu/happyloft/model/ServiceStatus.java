package com.tamu.happyloft.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by arshi on 4/2/2020.
 */
@Entity
@Table(name = "SERVICE_STATUS_TABLE")
public class ServiceStatus {

    @Column(name = "STATUS_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String statusName;

    private String statusDescription;

    @OneToMany(mappedBy = "serviceStatus", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Service> services;

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

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
