package com.example.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**  
 * <p>@开发版本  	：1.0</p>
 *
 * <p>@Copyright   :abyss-xd @ 2021 </p>
 *
 */
@Data
@Entity
@Table(name = "push")
public class Push implements Serializable {

	/**   
	 * @Fields serialVersionUID : TODO(这个变量表示什么)   
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "title")
	private String title;

}
