package com.learning.boot.util;

import com.learning.boot.model.PortalUser;
import com.learning.boot.service.PortalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Component
public class PortalUserValidator implements Validator {
    @Autowired
    private PortalUserService portalUserService;

    @Override
    public boolean supports(Class<?> aClass) {
        return PortalUser.class.equals(aClass);
    }


    public void simpleValidate(Object o, Errors errors){
        PortalUser portalUser = (PortalUser) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portalUserEmail", "Email cannot be empty");
        if(!isEmailValid(portalUser.getPortalUserEmail())){
            errors.rejectValue("portalUserEmail", "Invalid.newUser.PortalUserEmail");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portalUserFirstName", "First Name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portalUserLastName", "Last Name cannot be empty");
    }

    @Override
    public void validate(Object o, Errors errors) {
        PortalUser portalUser = (PortalUser) o;

        simpleValidate(o, errors);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portalUserPassword", "Password cannot be empty");
        if(portalUser.getPortalUserPassword().length() < 4 || portalUser.getPortalUserPassword().length() > 32){
            errors.rejectValue("portalUserPassword", "Size.newUser.portalUserPassword");
        }

        if(!portalUser.getPortalUserPasswordConfirm().equals(portalUser.getPortalUserPassword())){
            errors.rejectValue("portalUserPasswordConfirm", "Diff.newUser.PortalUserPasswordConfirm");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portalUserLogin", "NotEmpty");
        if(portalUser.getPortalUserLogin().length() < 4 || portalUser.getPortalUserLogin().length() > 32){
            errors.rejectValue("portalUserLogin", "Size.newUser.portalUserName");
        }
        if(portalUserService.findByLogin(portalUser.getPortalUserLogin()) != null){
            errors.rejectValue("portalUserLogin", "Duplicate.newUser.portalUserName");
        }

    }


    public boolean isEmailValid(String email){
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        }
        catch (AddressException ex){
            return false;
        }
        return true;
    }
}
