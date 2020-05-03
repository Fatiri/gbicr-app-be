package com.gbicr.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "community")
public class Community {

    public Community(String id, String name, String detail, String contact, String link_photo) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.contact = contact;
        this.link_photo = link_photo;
    }

    public Community() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public String getContact() {
        return contact;
    }

    public String getLink_photo() {
        return link_photo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setLink_photo(String link_photo) {
        this.link_photo = link_photo;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    @NotEmpty(message = "Please provide a name")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Column
    @NotEmpty(message = "Please provide a detail")
    private String detail;

    @Column
    @NotEmpty(message = "Please provide a contact")
    private String contact;

    @Column
    @NotEmpty(message = "Please provide a link photo")
    private String link_photo;
}
