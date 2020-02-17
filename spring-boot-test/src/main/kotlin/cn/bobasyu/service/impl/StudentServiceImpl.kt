package cn.bobasyu.service.impl

import cn.bobasyu.entity.Student
import cn.bobasyu.repository.StudentRepository
import cn.bobasyu.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(@Autowired private val studentRepository: StudentRepository) : StudentService {
    override fun findAll(pages: Int, size: Int): Page<Student> {
        val pageRequest: PageRequest = PageRequest.of(pages, size)
        return studentRepository.findAll(pageRequest)
    }

    override fun save(student: Student): Student {
        return studentRepository.save(student)
    }

    override fun findById(id: Int): Student {
        return studentRepository.findById(id).get()
    }

    override fun update(student: Student): Student {
        return studentRepository.save(student)
    }

    override fun deleteById(id: Int) {
        studentRepository.deleteById(id)
    }
}
