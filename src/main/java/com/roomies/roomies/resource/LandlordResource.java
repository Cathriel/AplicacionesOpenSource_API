package com.roomies.roomies.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.roomies.roomies.domain.model.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class LandlordResource extends UserResource {
    private List<PostResource> posts;
}
