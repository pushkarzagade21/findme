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
 * The Class State.
 */
@Entity
@Table(name = "TBL_STATE")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class State {

	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_Sequence")
	@SequenceGenerator(name = "state_Sequence", sequenceName = "STATE_SEQ", allocationSize = 1, initialValue = 1)
	private long id;

	/** The name. */
	@Column(name = "STATE_NAME")
	private String name;

	/** The country. */
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
	private Country country;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(Country country) {
		this.country = country;
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
