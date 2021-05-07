package com.roomies.roomies.resource;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;

public class SaveUserResource {
    @NotNull
    @Size(max = 100)
    @NaturalId
    protected String name;

    @NotNull
    @Size(max = 100)
    @NaturalId
    protected String lastName;

    @NotNull
    protected Long cellphone;

    @NotNull
    protected String idCard;

    @Lob
    protected String Description;

    @NotNull
    protected Date birthday;

    @NotNull
    protected String department;

    @NotNull
    protected String province;

    @NotNull
    protected String district;

    @NotNull
    protected String address;

    @NotNull
    protected String email;

    @NotNull
    protected String password;
}
