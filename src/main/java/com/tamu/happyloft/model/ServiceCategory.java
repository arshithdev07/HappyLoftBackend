package com.tamu.happyloft.model;

import javax.persistence.*;

/**
 * Created by arshi on 4/2/2020.
 */
@Entity
@Table(name = "SERVICE_CATEGORY_TABLE")
public class ServiceCategory {

    @Column(name = "SC_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_category_generator")
    @SequenceGenerator(name="service_category_generator", sequenceName = "service_category_seq")
    private Long id;

    @Column(name = "SERVICE_CATEGORY_NAME")
    private String serviceCategoryName;

    @Column(name = "SERVICE_CATEGORY_DESCRIPTION")
    private String serviceCategoryDescription;


    public ServiceCategory() {
    }

    public ServiceCategory(String serviceCategoryName, String serviceCategoryDescription) {
        this.serviceCategoryName = serviceCategoryName;
        this.serviceCategoryDescription = serviceCategoryDescription;
    }

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

}
