package com.roomies.roomies.domain.repository;

import com.roomies.roomies.domain.model.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandlordRepository extends JpaRepository<Landlord,Long> {
}
