package com.roomies.roomies.domain.repository;

import com.roomies.roomies.domain.model.Leaseholder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseholderRepository extends JpaRepository<Leaseholder,Long> {
}
