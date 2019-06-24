package com.web.main.validator;

import com.web.main.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class arg0) {
        return User.class.equals(arg0);
    }

    @Override
    public void validate(Object object, Errors errors) {
    }

}
