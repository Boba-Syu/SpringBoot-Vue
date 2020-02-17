package cn.bobasyu

import cn.bobasyu.entity.Student
import cn.bobasyu.repository.StudentRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringBootTestApplicationTests(
        @Autowired
        private val studentRepository: StudentRepository) {

    @Test
    fun save() {
        val student = Student()
        student.cname = "nameTest"
        student.cgrade = "test"
        student.clevel = "test"
        student.cpower = "test"
        student.cpower = "test"
        student.csex = "test"
        val student1 = studentRepository.save(student)
        println(student1)
    }
}
