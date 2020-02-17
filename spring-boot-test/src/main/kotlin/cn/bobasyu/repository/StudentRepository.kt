package cn.bobasyu.repository

import cn.bobasyu.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Int>