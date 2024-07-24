package com.hackathon.expense_tracking.repository;

import com.hackathon.expense_tracking.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long > {
}
