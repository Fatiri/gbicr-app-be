package com.gbicr.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "event")
public class Event {

    public Event(String id, String title, String date, String detail, String link_photo) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.detail = detail;
        this.link_photo = link_photo;
    }

    public Event() {
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    @NotEmpty(message = "Please provide a title")
    @Size(min = 2, message = "title should have at least 2 characters")
    private String title;

    @Column
    @NotEmpty
    @NotNull
    private String date;

    @Column
    @NotEmpty(message = "Please provide a detail event")
    @Size(min = 5, message = "Please provide a detail at least 5 characters")
    private String detail;

    @Column
    @NotEmpty(message = "Please provide a photo")
    private String link_photo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getLink_photo() {
		return link_photo;
	}

	public void setLink_photo(String link_photo) {
		this.link_photo = link_photo;
	}

  
}