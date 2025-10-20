package com.arafat.hospital.repositories;

import com.arafat.hospital.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
