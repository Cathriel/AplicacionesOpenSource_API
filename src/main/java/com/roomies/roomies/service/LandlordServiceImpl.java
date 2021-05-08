package com.roomies.roomies.service;

import com.roomies.roomies.domain.model.Landlord;
import com.roomies.roomies.domain.repository.LandlordRepository;
import com.roomies.roomies.domain.service.LandlordService;
import com.roomies.roomies.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    private LandlordRepository landlordRepository;

    @Override
    public Page<Landlord> getAllLandlords(Pageable pageable) {
        return landlordRepository.findAll(pageable);
    }

    @Override
    public Landlord getLandlordById(Long landlordId) {
        return landlordRepository.findById(landlordId)
                .orElseThrow(()->new ResourceNotFoundException("Landlord","Id",landlordId));
    }

    @Override
    public Landlord createLandlord(Landlord landlord) {
        return landlordRepository.save(landlord);
    }

    @Override
    public Landlord updateLandlord(Long landlordId, Landlord landlordRequest) {
        Landlord landlord = landlordRepository.findById(landlordId)
                .orElseThrow(()->new ResourceNotFoundException("Landlord","Id",landlordId));
        landlord.setAddress(landlordRequest.getAddress())
                .setBirthday(landlordRequest.getBirthday())
                .setCellphone(landlordRequest.getCellphone())
                .setDepartment(landlordRequest.getDepartment())
                .setDescription(landlordRequest.getDescription())
                //.setIdCard(landlordRequest.getIdCard())
                .setName(landlordRequest.getName())
                .setProvince(landlordRequest.getProvince())
                .setLastName(landlordRequest.getLastName())
                .setDistrict(landlordRequest.getDistrict());
        return landlordRepository.save(landlord);
    }

    @Override
    public ResponseEntity<?> deleteLandlord(Long landlordId) {
        Landlord landlord= landlordRepository.findById(landlordId)
                .orElseThrow(()->new ResourceNotFoundException("Landlord","Id",landlordId));
        landlordRepository.delete(landlord);
        return ResponseEntity.ok().build();
    }

    @Override
    public Landlord getLandlordByName(String name) {
        return landlordRepository.findByName(name)
                .orElseThrow(()->new ResourceNotFoundException("Landlord","Name",name));
    }
}
