package com.entity;

import javax.persistence.*;


@Entity
@Table(name = "image_model")
public class Image {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
     private long id;
     private String name;
     private String type;
     public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicbyte() {
		return picbyte;
	}

	public void setPicbyte(byte[] picbyte) {
		this.picbyte = picbyte;
	}

	public Image(String name, String type, byte[] picbyte) {
		super();
		this.name = name;
		this.type = type;
		this.picbyte = picbyte;
	}

	@Column(length = 5000000)
     private byte[] picbyte;
     
     public Image() {
    	 
     }
 
}
