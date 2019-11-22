/**
 * 
 */
package com.aric.samples.springbootkafkasample.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author dursunkoc
 *
 */
@Data
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7667652442406469866L;
	private Long id;
	private String first;
	private String last;
	private String country;
}
