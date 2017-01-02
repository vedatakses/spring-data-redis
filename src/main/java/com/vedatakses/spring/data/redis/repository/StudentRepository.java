package com.vedatakses.spring.data.redis.repository;

import java.util.Map;

import com.vedatakses.spring.data.redis.data.Student;

/**
 * The Interface StudentRepository.
 */
public interface StudentRepository {

	/**
	 * Find student.
	 *
	 * @param id the id
	 * @return the student
	 */
	Student findStudent(String id);

	/**
	 * Find all students.
	 *
	 * @return the map
	 */
	Map<Object, Object> findAllStudents();

	/**
	 * Delete student.
	 *
	 * @param id the id
	 */
	void deleteStudent(String id);

	/**
	 * Save student.
	 *
	 * @param student the student
	 */
	void saveStudent(Student student);

	/**
	 * Update student.
	 *
	 * @param student the student
	 */
	void updateStudent(Student student);
}
