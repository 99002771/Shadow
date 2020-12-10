package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cafeteria")
public class Cafeteria implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	private long id;
	
	@Column
	private String spacetype;
	
	@Column
	private Integer peoplecount;
	
	
	
	@Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
    private Date datetime;
	
	@Column
	private String createdby;
	
	@Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
    private Date modifiedDatetime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpacetype() {
		return spacetype;
	}

	public void setSpacetype(String spacetype) {
		this.spacetype = spacetype;
	}

	public Integer getPeoplecount() {
		return peoplecount;
	}

	public void setPeoplecount(Integer peoplecount) {
		this.peoplecount = peoplecount;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(Date modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	public Cafeteria(long id, String spacetype, Integer peoplecount, Date datetime, String createdby,
			Date modifiedDatetime) {
		super();
		this.id = id;
		this.spacetype = spacetype;
		this.peoplecount = peoplecount;
		this.datetime = datetime;
		this.createdby = createdby;
		this.modifiedDatetime = modifiedDatetime;
	}

	public Cafeteria() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cafeteria [id=" + id + ", spacetype=" + spacetype + ", peoplecount=" + peoplecount + ", datetime="
				+ datetime + ", createdby=" + createdby + ", modifiedDatetime=" + modifiedDatetime + "]";
	}


	
}
