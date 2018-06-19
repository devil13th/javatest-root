package com.thd.spring.transaction.annotation.pojo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the product table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="product"
 */

public abstract class BaseProduct  implements Serializable {

	public static String REF = "Product";
	public static String PROP_SORT_ID = "sortId";
	public static String PROP_PRO_ID = "proId";
	public static String PROP_PRO_NAME = "proName";


	// constructors
	public BaseProduct () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProduct (java.lang.String proId) {
		this.setProId(proId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String proId;

	// fields
	private java.lang.String proName;
	private java.lang.String sortId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="uuid.hex"
     *  column="pro_id"
     */
	public java.lang.String getProId () {
		return proId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param proId the new ID
	 */
	public void setProId (java.lang.String proId) {
		this.proId = proId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: pro_name
	 */
	public java.lang.String getProName () {
		return proName;
	}

	/**
	 * Set the value related to the column: pro_name
	 * @param proName the pro_name value
	 */
	public void setProName (java.lang.String proName) {
		this.proName = proName;
	}



	/**
	 * Return the value associated with the column: sort_id
	 */
	public java.lang.String getSortId () {
		return sortId;
	}

	/**
	 * Set the value related to the column: sort_id
	 * @param sortId the sort_id value
	 */
	public void setSortId (java.lang.String sortId) {
		this.sortId = sortId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.thd.spring.transaction.annotation.pojo.Product)) return false;
		else {
			com.thd.spring.transaction.annotation.pojo.Product product = (com.thd.spring.transaction.annotation.pojo.Product) obj;
			if (null == this.getProId() || null == product.getProId()) return false;
			else return (this.getProId().equals(product.getProId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getProId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getProId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}