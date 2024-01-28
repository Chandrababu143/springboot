package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="userbike")
public class User {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		private String name;
		private String price;
		private String mail;
		private String password;
		private String phone;
		public long getId() {
			return id;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
	
		public void setId(long id) {
			this.id = id;
		}
		public String getname() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
		}
		public String getprice() {
			return price;
		}
		public void setprice(String price) {
			this.price = price;
		}
		

}