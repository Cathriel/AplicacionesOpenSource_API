package com.roomies.roomies.domain.repository;

import com.roomies.roomies.domain.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userr,Long> {
}
