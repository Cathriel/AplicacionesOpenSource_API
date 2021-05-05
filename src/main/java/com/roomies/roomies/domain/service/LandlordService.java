package com.roomies.roomies.domain.service;

import com.roomies.roomies.domain.model.Landlord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface LandlordService {
    Page<Landlord> getAllLandlords(Pageable pageable);
    Landlord getLandlordById(Long landlordId);
    Landlord createLandlord(Landlord landlord);
    Landlord updateLandlord(Long landlordId,Landlord landlordRequest);
    ResponseEntity<?> deleteLandlord(Long landlordId);

}
