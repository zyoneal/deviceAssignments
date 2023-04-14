package com.viktor.deviceassignments.repository;

import com.viktor.deviceassignments.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByTitle(String title);

}
