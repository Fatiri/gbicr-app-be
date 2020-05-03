package com.gbicr.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "leader")
public class Leader {

    public Leader() {
    }

    public Leader(String id, @NotEmpty(message = "Please provide a name") @Size(min = 2, message = "Name should have at least 2 characters") String name, @NotEmpty(message = "Please provide a position") String position, @NotEmpty(message = "Please provide a link_photo") String link_photo) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.link_photo = link_photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLink_photo() {
        return link_photo;
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
    @NotEmpty(message = "Please provide a position")
    private String position;

    @Column
    @NotEmpty(message = "Please provide a link_photo")
    private String link_photo;
}
