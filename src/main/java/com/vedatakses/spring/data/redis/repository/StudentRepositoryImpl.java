package com.vedatakses.spring.data.redis.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.vedatakses.spring.data.redis.data.Student;

/**
 * The Class StudentRepositoryImpl.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

	/** The Constant KEY. */
	private static final String KEY = "Student";

	/** The redis template. */
	private RedisTemplate<String, Student> redisTemplate;

	/**
	 * Instantiates a new student repository impl.
	 *
	 * @param redisTemplate the redis template
	 */
	@Autowired
	public StudentRepositoryImpl(RedisTemplate<String, Student> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/* (non-Javadoc)
	 * @see com.baeldung.spring.data.redis.repository.StudentRepository#saveStudent(com.baeldung.spring.data.redis.data.Student)
	 */
	public void saveStudent(Student student) {
		this.redisTemplate.opsForHash().put(KEY, student.getId(), student);
	}

	/* (non-Javadoc)
	 * @see com.baeldung.spring.data.redis.repository.StudentRepository#updateStudent(com.baeldung.spring.data.redis.data.Student)
	 */
	public void updateStudent(Student student) {
		this.redisTemplate.opsForHash().put(KEY, student.getId(), student);
	}

	/* (non-Javadoc)
	 * @see com.baeldung.spring.data.redis.repository.StudentRepository#findStudent(java.lang.String)
	 */
	public Student findStudent(String id) {
		return (Student) this.redisTemplate.opsForHash().get(KEY, id);
	}

	/* (non-Javadoc)
	 * @see com.baeldung.spring.data.redis.repository.StudentRepository#findAllStudents()
	 */
	public Map<Object, Object> findAllStudents() {
		return this.redisTemplate.opsForHash().entries(KEY);
	}

	/* (non-Javadoc)
	 * @see com.baeldung.spring.data.redis.repository.StudentRepository#deleteStudent(java.lang.String)
	 */
	public void deleteStudent(String id) {
		this.redisTemplate.opsForHash().delete(KEY, id);
	}

	/**
	 * Gets the redis template.
	 *
	 * @return the redis template
	 */
	public RedisTemplate<String, Student> getRedisTemplate() {
		return redisTemplate;
	}

	/**
	 * Sets the redis template.
	 *
	 * @param redisTemplate the redis template
	 */
	public void setRedisTemplate(RedisTemplate<String, Student> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

}
