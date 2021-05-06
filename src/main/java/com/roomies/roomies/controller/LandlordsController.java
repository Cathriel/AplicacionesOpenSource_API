package com.roomies.roomies.controller;

import com.roomies.roomies.domain.model.Landlord;
import com.roomies.roomies.domain.service.LandlordService;
import com.roomies.roomies.resource.LandlordResource;
import com.roomies.roomies.resource.SaveLandlordResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LandlordsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private LandlordService landlordService;

    @GetMapping("/landlords")
    public Page<LandlordResource> getAllLandlords(Pageable pageable){
        Page<Landlord> landlordPage =landlordService.getAllLandlords(pageable);
        List<LandlordResource> resources = landlordPage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @GetMapping("/landlords/{landlordId}")
    public LandlordResource getLandlordById(@PathVariable Long landlordId){
        return convertToResource(landlordService.getLandlordById(landlordId));
    }

    @PostMapping("/landlords")
    public LandlordResource createLandlord(@Valid @RequestBody SaveLandlordResource resource)
    {
        return convertToResource(landlordService.createLandlord(convertToEntity(resource)));
    }

    @PutMapping("/landlords/{landlordId}")
    public LandlordResource updateLandlord(@PathVariable Long landlordId,@Valid @RequestBody SaveLandlordResource resource){
        return convertToResource(landlordService.updateLandlord(landlordId,convertToEntity(resource)));
    }

    @DeleteMapping("/landlords/{landlordId}")
    public ResponseEntity<?> deleteLandlord(@PathVariable Long landlordId) {
        return landlordService.deleteLandlord(landlordId);
    }

    private Landlord convertToEntity(SaveLandlordResource resource) {
        return mapper.map(resource, Landlord.class);
    }

    private LandlordResource convertToResource(Landlord entity) {
        return mapper.map(entity, LandlordResource.class);
    }
}
