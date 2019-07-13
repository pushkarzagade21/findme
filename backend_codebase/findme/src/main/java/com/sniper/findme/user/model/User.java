package com.sniper.findme.user.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "TBL_USER_ACCOUNT")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_Sequence")
	@SequenceGenerator(name = "user_Sequence", sequenceName = "USER_ACCOUNT_SEQ")
	private long id;

	/** The first name. */
	@Column(name = "FIRST_NAME")
	private String firstName;

	/** The last name. */
	@Column(name = "LAST_NAME")
	private String lastName;

	/** The user name. */
	@Column(name = "USERNAME")
	private String userName;

	/** The password. */
	@Column(name = "PASSWORD")
	private String password;

	/** The email. */
	@Column(name = "EMAIL")
	private String email;

	/** The details. */
	@Column(name = "DETAILS")
	private String details;

	/** The nick name. */
	@Column(name = "NICKNAME")
	private String nickName;

	/** The confirmation code. */
	@Column(name = "CONFIRMATION_CODE")
	private String confirmationCode;

	/** The completeness. */
	@Column(name = "COMPLETENESS")
	private int completeness;

	/** The is facebook login. */
	@Column(name = "IS_FACEBOOK_LOGIN")
	private String isFacebookLogin;

	/** The is google login. */
	@Column(name = "IS_GOOGLE_LOGIN")
	private String isGoogleLogin;

	/** The online status. */
	@Column(name = "ONLINE_STATUS")
	private String onlineStatus;

	/** The status. */
	@Column(name = "STATUS")
	private String status;

	/** The creation date. */
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	/** The modification date. */
	@Column(name = "MODIFICATION_DATE")
	private Date modificationDate;

	/** The jwt token. */
	@Column(name = "JWT_TOKEN")
	private String jwtToken;

	/** The jwt token expiry date. */
	@Column(name = "JWT_TOKEN_EXPIRY_DATE_TIME")
	private Date jwtTokenExpiryDate;

	/** The address. */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
	private Address address;

	/** The gender. */
	@ManyToOne
	@JoinColumn(name = "GENDER_ID", referencedColumnName = "ID")
	private Gender gender;

	/** The religion. */
	@ManyToOne
	@JoinColumn(name = "RELIGION_ID", referencedColumnName = "ID")
	private Religion religion;

	/** The interested gender list. */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "TBL_USER_INTERESTED_GENDER", joinColumns = {
			@JoinColumn(name = "USER_ACCOUNT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "GENDER_ID", referencedColumnName = "ID") })
	private List<Gender> interestedGenderList = new ArrayList<>();

	/** The interested religion list. */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "TBL_USER_INTERESTED_RELIGION", joinColumns = {
			@JoinColumn(name = "USER_ACCOUNT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "RELIGION_ID", referencedColumnName = "ID") })
	private List<Religion> interestedReligionList = new ArrayList<>();

	/** The interested relation list. */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "TBL_USER_INTERESTED_RELATION", joinColumns = {
			@JoinColumn(name = "USER_ACCOUNT_ACCOUNT_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "RELATION_ID", referencedColumnName = "ID") })
	private List<Relation> interestedRelationList = new ArrayList<>();

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Sets the details.
	 *
	 * @param details the new details
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * Gets the nick name.
	 *
	 * @return the nick name
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Sets the nick name.
	 *
	 * @param nickName the new nick name
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Gets the confirmation code.
	 *
	 * @return the confirmation code
	 */
	public String getConfirmationCode() {
		return confirmationCode;
	}

	/**
	 * Sets the confirmation code.
	 *
	 * @param confirmationCode the new confirmation code
	 */
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	/**
	 * Gets the completeness.
	 *
	 * @return the completeness
	 */
	public int getCompleteness() {
		return completeness;
	}

	/**
	 * Sets the completeness.
	 *
	 * @param completeness the new completeness
	 */
	public void setCompleteness(int completeness) {
		this.completeness = completeness;
	}

	/**
	 * Gets the checks if is facebook login.
	 *
	 * @return the checks if is facebook login
	 */
	public String getIsFacebookLogin() {
		return isFacebookLogin;
	}

	/**
	 * Sets the checks if is facebook login.
	 *
	 * @param isFacebookLogin the new checks if is facebook login
	 */
	public void setIsFacebookLogin(String isFacebookLogin) {
		this.isFacebookLogin = isFacebookLogin;
	}

	/**
	 * Gets the checks if is google login.
	 *
	 * @return the checks if is google login
	 */
	public String getIsGoogleLogin() {
		return isGoogleLogin;
	}

	/**
	 * Sets the checks if is google login.
	 *
	 * @param isGoogleLogin the new checks if is google login
	 */
	public void setIsGoogleLogin(String isGoogleLogin) {
		this.isGoogleLogin = isGoogleLogin;
	}

	/**
	 * Gets the online status.
	 *
	 * @return the online status
	 */
	public String getOnlineStatus() {
		return onlineStatus;
	}

	/**
	 * Sets the online status.
	 *
	 * @param onlineStatus the new online status
	 */
	public void setOnlineStatus(String onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the modification date.
	 *
	 * @return the modification date
	 */
	public Date getModificationDate() {
		return modificationDate;
	}

	/**
	 * Sets the modification date.
	 *
	 * @param modificationDate the new modification date
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * Gets the jwt token.
	 *
	 * @return the jwt token
	 */
	public String getJwtToken() {
		return jwtToken;
	}

	/**
	 * Sets the jwt token.
	 *
	 * @param jwtToken the new jwt token
	 */
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	/**
	 * Gets the jwt token expiry date.
	 *
	 * @return the jwt token expiry date
	 */
	public Date getJwtTokenExpiryDate() {
		return jwtTokenExpiryDate;
	}

	/**
	 * Sets the jwt token expiry date.
	 *
	 * @param jwtTokenExpiryDate the new jwt token expiry date
	 */
	public void setJwtTokenExpiryDate(Date jwtTokenExpiryDate) {
		this.jwtTokenExpiryDate = jwtTokenExpiryDate;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the religion.
	 *
	 * @return the religion
	 */
	public Religion getReligion() {
		return religion;
	}

	/**
	 * Sets the religion.
	 *
	 * @param religion the new religion
	 */
	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	/**
	 * Gets the interested gender list.
	 *
	 * @return the interested gender list
	 */
	public List<Gender> getInterestedGenderList() {
		return interestedGenderList;
	}

	/**
	 * Sets the interested gender list.
	 *
	 * @param interestedGenderList the new interested gender list
	 */
	public void setInterestedGenderList(List<Gender> interestedGenderList) {
		this.interestedGenderList = interestedGenderList;
	}

	/**
	 * Gets the interested religion list.
	 *
	 * @return the interested religion list
	 */
	public List<Religion> getInterestedReligionList() {
		return interestedReligionList;
	}

	/**
	 * Sets the interested religion list.
	 *
	 * @param interestedReligionList the new interested religion list
	 */
	public void setInterestedReligionList(List<Religion> interestedReligionList) {
		this.interestedReligionList = interestedReligionList;
	}

	/**
	 * Gets the interested relation list.
	 *
	 * @return the interested relation list
	 */
	public List<Relation> getInterestedRelationList() {
		return interestedRelationList;
	}

	/**
	 * Sets the interested relation list.
	 *
	 * @param interestedRelationList the new interested relation list
	 */
	public void setInterestedRelationList(List<Relation> interestedRelationList) {
		this.interestedRelationList = interestedRelationList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
