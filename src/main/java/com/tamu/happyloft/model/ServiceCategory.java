package com.tamu.happyloft.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by arshi on 4/2/2020.
 */
@Entity
@Table(name = "SERVICE_CATEGORY_TABLE")
public class ServiceCategory {

    @Column(name = "SC_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SERVICE_CATEGORY_NAME")
    private String serviceCategoryName;

    @Column(name = "SERVICE_CATEGORY_DESCRIPTION")
    private String serviceCategoryDescription;

    @OneToMany(mappedBy = "serviceCategoryID", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Service> services;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCategoryName() {
        return serviceCategoryName;
    }

    public void setServiceCategoryName(String serviceCategoryName) {
        this.serviceCategoryName = serviceCategoryName;
    }

    public String getServiceCategoryDescription() {
        return serviceCategoryDescription;
    }

    public void setServiceCategoryDescription(String serviceCategoryDescription) {
        this.serviceCategoryDescription = serviceCategoryDescription;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
