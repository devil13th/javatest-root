package com.thd.spring.transaction.annotation.pojo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the sort table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="sort"
 */

public abstract class BaseSort  implements Serializable {

	public static String REF = "Sort";
	public static String PROP_SORT_ID = "sortId";
	public static String PROP_SORT_NAME = "sortName";


	// constructors
	public BaseSort () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSort (java.lang.String sortId) {
		this.setSortId(sortId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String sortId;

	// fields
	private java.lang.String sortName;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="uuid.hex"
     *  column="sort_id"
     */
	public java.lang.String getSortId () {
		return sortId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param sortId the new ID
	 */
	public void setSortId (java.lang.String sortId) {
		this.sortId = sortId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: sort_name
	 */
	public java.lang.String getSortName () {
		return sortName;
	}

	/**
	 * Set the value related to the column: sort_name
	 * @param sortName the sort_name value
	 */
	public void setSortName (java.lang.String sortName) {
		this.sortName = sortName;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.thd.spring.transaction.annotation.pojo.Sort)) return false;
		else {
			com.thd.spring.transaction.annotation.pojo.Sort sort = (com.thd.spring.transaction.annotation.pojo.Sort) obj;
			if (null == this.getSortId() || null == sort.getSortId()) return false;
			else return (this.getSortId().equals(sort.getSortId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSortId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSortId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}