package com.roomies.roomies.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="users")
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @Size(max = 100)
    @NaturalId
    protected String name;

    @Size(max = 100)
    @NaturalId
    protected String lastName;

    @NotNull
    protected Long cellphone;

    @NotNull
    protected String idCard;

    @NotNull
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

    @ManyToMany(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST,CascadeType.MERGE},
    mappedBy = "users")
    private List<PaymentMethod> userPaymentMethods;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "plan_id",nullable = true)
    @JsonIgnore
    private Plan plan;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public User setCellphone(Long cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getIdCard() {
        return idCard;
    }

    public User setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public User setDescription(String description) {
        Description = description;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public User setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public User setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public User setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Plan getPlan() {
        return plan;
    }

    public User setPlan(Plan plan) {
        this.plan = plan;
        return this;
    }

    public boolean isAssignedWithPm(PaymentMethod paymentMethod){
        return this.getUserPaymentMethods().contains(paymentMethod);
    }

    public List<PaymentMethod> getUserPaymentMethods() {
        return userPaymentMethods;
    }

    public User assignWithPm(PaymentMethod paymentMethod){
        if(!this.isAssignedWithPm(paymentMethod))
            this.getUserPaymentMethods().add(paymentMethod);
        return this;
    }

    public User unAssignWithPm(PaymentMethod paymentMethod){
        if(this.isAssignedWithPm(paymentMethod))
            this.getUserPaymentMethods().remove(paymentMethod);
        return this;
    }
}
