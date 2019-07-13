package com.sniper.findme.user.model;

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

// TODO: Auto-generated Javadoc
/**
 * The Class City.
 */
@Entity
@Table(name = "TBL_CITY")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class City {

	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_Sequence")
	@SequenceGenerator(name = "city_Sequence", sequenceName = "CITY_SEQ", allocationSize = 1, initialValue = 1)
	private long id;

	/** The name. */
	@Column(name = "CITY_NAME")
	private String name;

	/** The state. */
	@ManyToOne
	@JoinColumn(name = "STATE_ID", referencedColumnName = "ID")
	private State state;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
