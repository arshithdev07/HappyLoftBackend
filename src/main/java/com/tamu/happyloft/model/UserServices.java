package com.tamu.happyloft.model;

import javax.persistence.*;

/**
 * Created by arshi on 4/2/2020.
 */
@Entity
@Table(name = "USER_SERVICE_TABLE")
public class UserServices {

    @Column(name = "USER_SERVICE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_service_generator")
    @SequenceGenerator(name="user_service_generator", sequenceName = "user_service_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Service service;

    private Boolean creator;

    private Boolean interested;

    private Boolean performer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Boolean getCreator() {
        return creator;
    }

    public void setCreator(Boolean creator) {
        this.creator = creator;
    }

    public Boolean getInterested() {
        return interested;
    }

    public void setInterested(Boolean interested) {
        this.interested = interested;
    }

    public Boolean getPerformer() {
        return performer;
    }

    public void setPerformer(Boolean performer) {
        this.performer = performer;
    }
}
