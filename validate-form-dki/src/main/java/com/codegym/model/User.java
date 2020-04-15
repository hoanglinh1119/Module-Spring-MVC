package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User implements Validator {
     @NotEmpty
     @Size(min = 5, max = 45)
    private String lastName;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;

    private String phoneNumber;
    private String email;

    @Min(18)
    private int age;

    public User() {

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public User(@NotEmpty @Size(min = 5, max = 45) String lastName, @NotEmpty @Size(min = 5, max = 45) String firstName, String phoneNumber, String email, @Min(18) int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
     User user=(User) target;
        int age=user.getAge();
       String numberPhone=user.getPhoneNumber();
       String email=user.getEmail();
       if (age<18){ errors.rejectValue("age","age.value");}
        ValidationUtils.rejectIfEmpty(errors,"age","age.empty");


        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
        if (numberPhone.length()>11 || numberPhone.length()<10){
            errors.rejectValue("number", "number.length");
        }
        if (!numberPhone.startsWith("0")){
            errors.rejectValue("number", "number.startWith");
        }
        if (!numberPhone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.regex");
        }
        if (!email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")){
            errors.rejectValue("email","email.regex");
        }
    }
}
