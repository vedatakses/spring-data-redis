package com.vedatakses.spring.data.redis.data;

import java.io.Serializable;

import com.vedatakses.spring.data.redis.data.Student.Gender;

/**
 * The Class Student.
 */
public class Student implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8243145429438016231L;

	/**
	 * The Enum Gender.
	 */
	public enum Gender {
		MALE, FEMALE
	}

	/** The id. */
	private String id;

	/** The name. */
	private String name;

	/** The gender. */
	private Gender gender;

	/** The grade. */
	private int grade;

	/**
	 * Instantiates a new student.
	 *
	 * @param id the id
	 * @param name the name
	 * @param gender the gender
	 * @param grade the grade
	 */
	public Student(String id, String name, Gender gender, int grade) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.grade = grade;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
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

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", grade=");
		builder.append(grade);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + grade;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (gender != other.gender)
			return false;
		if (grade != other.grade)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
