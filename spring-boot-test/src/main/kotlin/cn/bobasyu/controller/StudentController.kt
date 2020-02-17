package cn.bobasyu.controller

import cn.bobasyu.entity.Student
import cn.bobasyu.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController(@Autowired private val studentService: StudentService) {

    @GetMapping("/{pages}/{size}")
    fun findAll(@PathVariable pages: Int, @PathVariable size: Int): Page<Student> {
        return studentService.findAll(pages, size)
    }

    @PostMapping
    fun save(@RequestBody student: Student): String {
        val result: Student = studentService.save(student)
        return if (result != null) "success" else "error"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Student {
        return studentService.findById(id)
    }

    @PutMapping
    fun update(@RequestBody student: Student): String {
        val result: Student = studentService.update(student)
        return if (result != null) "success" else "error"
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Int) {
        studentService.deleteById(id)
    }
}
