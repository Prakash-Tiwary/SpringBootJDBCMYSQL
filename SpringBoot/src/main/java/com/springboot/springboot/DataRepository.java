package com.springboot.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Employee, Integer> {

}
