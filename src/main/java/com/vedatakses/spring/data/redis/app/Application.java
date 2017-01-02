package com.vedatakses.spring.data.redis.app;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.vedatakses.spring.data.redis.config.RedisConfiguration;
import com.vedatakses.spring.data.redis.data.Student;
import com.vedatakses.spring.data.redis.repository.StudentRepositoryImpl;

/**
 * The Class Application.
 */
public class Application {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfiguration.class);

		try {
			RedisTemplate redisTemplate = (RedisTemplate) ctx.getBean("redisTemplate");
			StudentRepositoryImpl studentRepository = new StudentRepositoryImpl(redisTemplate);
			ValueOperations values = redisTemplate.opsForValue();

			Student s1 = new Student("15", "Steve", Student.Gender.MALE, 1);
			Student s2 = new Student("3", "Jane", Student.Gender.FEMALE, 3);
			values.set("mike", s1);

			// Add students to db
			System.out.println("Employee added: " + values.get("student"));
			studentRepository.saveStudent(s1);
			studentRepository.saveStudent(s2);

			// Read only the student with id-15
			System.out.println("Student with id-15: " + studentRepository.findStudent("15"));
			Map<Object, Object> students = studentRepository.findAllStudents();

			// Read all students from db
			System.out.println("All students:");
			for (Map.Entry<Object, Object> student : students.entrySet()) {
			    System.out.println(student);
			}

		} finally {
			ctx.close();
		}
	}
}
