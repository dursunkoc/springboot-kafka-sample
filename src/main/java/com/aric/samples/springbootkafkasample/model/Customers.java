/**
 * 
 */
package com.aric.samples.springbootkafkasample.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dursunkoc
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customers {
	private List<Customer> items;
}
