package com.gowri.quartz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author NaveenWodeyar
 * @date 18-Oct-2024
 * @time 12:53:08 am
 */
@Entity
public class TestEntity extends AuditableEntity {
	
		@Id
		private Integer tId;

	 	@Column(name = "name")
	    private String name;

	    @Column(name = "age")
	    private int age;

	    // Constructor
	    public TestEntity() {
	    }

	    // Getters and Setters
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }
}
