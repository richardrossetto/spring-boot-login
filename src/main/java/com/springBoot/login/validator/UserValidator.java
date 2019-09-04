package com.springBoot.login.validator;

import com.springBoot.login.model.User;
import com.springBoot.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Richard Rossetto on 03/09/19.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aclass) {
        return User.class.equals(aclass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "notEmpty");

        if (!regexAlphaNumericValidation(user.getUsername())) {
            errors.rejectValue("username", "regex.aphanumeric.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "notEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "diff.userForm.passwordConfirm");
        }

        if (!regexPasswordValidation(user.getPassword())) {
            errors.rejectValue("password", "regex.userForm.password");
        }
        if (!regexPasswordValidation(user.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "regex.userForm.password");
        }
    }

    public boolean regexPasswordValidation(String pwd) {
        return pwd.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
    }

    public boolean regexAlphaNumericValidation(String userName){
        return userName.matches("^[a-zA-Z0-9]*$");
    }
}
