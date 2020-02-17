package cn.bobasyu.service

import cn.bobasyu.entity.Student
import org.springframework.data.domain.Page

interface StudentService {

    fun findAll(pages: Int, size: Int): Page<Student>

    fun save(student: Student): Student

    fun findById(id: Int): Student

    fun update(student: Student): Student

    fun deleteById(id: Int)
}