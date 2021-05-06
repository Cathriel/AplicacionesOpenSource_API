package com.roomies.roomies.domain.repository;

import com.roomies.roomies.domain.model.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan,Long> {

}
