package com.gowri.quartz.model;

import jakarta.persistence.*;

/**
 * @author NaveenWodeyar
 * @date 18-Oct-2024
 * @time 12:53:08 am
 */
@Entity
public class TestEntity extends AuditableEntity {
	
		@Id
	 	@Column(name = "TID")
		private Integer tId;

	 	@Column(name = "NAME")
	    private String name;

	    @Column(name = "AGE")
	    private int age;

	    public TestEntity() {
	    }

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
