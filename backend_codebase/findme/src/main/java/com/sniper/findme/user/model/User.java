package com.sniper.findme.user.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "USER_ACCOUNT")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_Sequence")
	@SequenceGenerator(name = "user_Sequence", sequenceName = "USER_ACCOUNT_SEQ")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DETAILS")
	private String details;

	@Column(name = "NICKNAME")
	private String nickName;

	@Column(name = "CONFIRMATION_CODE")
	private String confirmationCode;

	@Column(name = "COMPLETENESS")
	private int completeness;

	@Column(name = "IS_FACEBOOK_LOGIN")
	private String isFacebookLogin;

	@Column(name = "IS_GOOGLE_LOGIN")
	private String isGoogleLogin;

	@Column(name = "ONLINE_STATUS")
	private String onlineStatus;

	@Column(name = "STATUS")
	private String status;

	@ManyToOne
	@JoinColumn(name = "GENDER_ID", referencedColumnName = "ID")
	private Gender gender;

	@ManyToOne
	@JoinColumn(name = "RELIGION_ID", referencedColumnName = "ID")
	private Religion religion;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "USER_INTERESTED_GENDER", joinColumns = {
			@JoinColumn(name = "USER_ACCOUNT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "GENDER_ID", referencedColumnName = "ID") })
	private List<Gender> interestedGenderList = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "USER_INTERESTED_RELIGION", joinColumns = {
			@JoinColumn(name = "USER_ACCOUNT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "RELIGION_ID", referencedColumnName = "ID") })
	private List<Religion> interestedReligionList = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "USER_INTERESTED_RELATION", joinColumns = {
			@JoinColumn(name = "USER_ACCOUNT_ACCOUNT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "RELATION_ID", referencedColumnName = "ID") })
	private List<Relation> interestedRelationList = new ArrayList<>();

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	public int getCompleteness() {
		return completeness;
	}

	public void setCompleteness(int completeness) {
		this.completeness = completeness;
	}

	public String getIsFacebookLogin() {
		return isFacebookLogin;
	}

	public void setIsFacebookLogin(String isFacebookLogin) {
		this.isFacebookLogin = isFacebookLogin;
	}

	public String getIsGoogleLogin() {
		return isGoogleLogin;
	}

	public void setIsGoogleLogin(String isGoogleLogin) {
		this.isGoogleLogin = isGoogleLogin;
	}

	public String getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(String onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Religion getReligion() {
		return religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public List<Gender> getInterestedGenderList() {
		return interestedGenderList;
	}

	public void setInterestedGenderList(List<Gender> interestedGenderList) {
		this.interestedGenderList = interestedGenderList;
	}

	public List<Religion> getInterestedReligionList() {
		return interestedReligionList;
	}

	public void setInterestedReligionList(List<Religion> interestedReligionList) {
		this.interestedReligionList = interestedReligionList;
	}

	public List<Relation> getInterestedRelationList() {
		return interestedRelationList;
	}

	public void setInterestedRelationList(List<Relation> interestedRelationList) {
		this.interestedRelationList = interestedRelationList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", email=" + email + ", details=" + details + ", nickName=" + nickName + ", confirmationCode="
				+ confirmationCode + ", completeness=" + completeness + ", isFacebookLogin=" + isFacebookLogin
				+ ", isGoogleLogin=" + isGoogleLogin + ", onlineStatus=" + onlineStatus + ", status=" + status
				+ ", gender=" + gender + ", religion=" + religion + ", interestedGenderList=" + interestedGenderList
				+ ", interestedReligionList=" + interestedReligionList + ", interestedRelationList="
				+ interestedRelationList + "]";
	}

}
