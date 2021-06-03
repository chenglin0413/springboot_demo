package com.fet.springboot.baseapp.repo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Data Trasfer Object
 * 欄位與資料庫對應
 * 
 * @author jamLin
 *
 */
@Entity
@Table(name="blc_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="challenge_answer")
	private String challengeAnswer;
	
	@Column(name="external_id")
	private String externalId;
	
	
	@Column(name="password")
	private String password;
	

	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, String emailAddress,Date dateCreated,
			String challengeAnswer,String externalId,String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.dateCreated = dateCreated;
		this.challengeAnswer = challengeAnswer;
		this.externalId = externalId;
		this.password = password;
	}
	
	
	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getChallengeAnswer() {
		return challengeAnswer;
	}

	public void setChallengeAnswer(String challengeAnswer) {
		this.challengeAnswer = challengeAnswer;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", dateCreated=" + dateCreated + ", challengeAnswer=" + challengeAnswer
				+ ", externalId=" + externalId + ", password=" + password + "]";
	}
	
	
}
