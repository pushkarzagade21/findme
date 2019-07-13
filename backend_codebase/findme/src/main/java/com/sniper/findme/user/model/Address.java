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
 * The Class Address.
 */
@Entity
@Table(name = "TBL_USER_ADDRESS")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Address {

	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_Sequence")
	@SequenceGenerator(name = "address_Sequence", sequenceName = "ADDRESS_SEQ", allocationSize = 1, initialValue = 1)
	private long id;

	/** The city. */
	@ManyToOne
	@JoinColumn(name = "CITY_ID", referencedColumnName = "ID")
	private City city;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(City city) {
		this.city = city;
	}

}
