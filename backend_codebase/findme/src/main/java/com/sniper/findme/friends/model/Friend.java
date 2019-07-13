package com.sniper.findme.friends.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.sniper.findme.user.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Friend.
 */
@Entity
@Table(name = "TBL_FRIEND")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Friend implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friend_Sequence")
	@SequenceGenerator(name = "friend_Sequence", sequenceName = "FRIEND_SEQ", allocationSize = 1, initialValue = 1)
	private long id;

	/** The user id. */
	@Column(name = "USER_ID")
	private String userId;

	/** The friend. */
	@ManyToOne
	@JoinColumn(name = "FRIEND_ID", referencedColumnName = "ID")
	private User friend;

	/** The status. */
	@Column(name = "STATUS")
	private String status;

	/** The block status. */
	@Column(name = "BLOCK_STATUS")
	private String blockStatus;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the friend.
	 *
	 * @return the friend
	 */
	public User getFriend() {
		return friend;
	}

	/**
	 * Sets the friend.
	 *
	 * @param friend the new friend
	 */
	public void setFriend(User friend) {
		this.friend = friend;
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
	 * Gets the block status.
	 *
	 * @return the block status
	 */
	public String getBlockStatus() {
		return blockStatus;
	}

	/**
	 * Sets the block status.
	 *
	 * @param blockStatus the new block status
	 */
	public void setBlockStatus(String blockStatus) {
		this.blockStatus = blockStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friend == null) ? 0 : friend.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Friend other = (Friend) obj;
		if (friend == null) {
			if (other.friend != null)
				return false;
		} else if (!friend.equals(other.friend))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Friend [id=" + id + ", userId=" + userId + ", friend=" + friend + ", status=" + status
				+ ", blockStatus=" + blockStatus + "]";
	}

}
