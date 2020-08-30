package com.we.springmvcboot.Validator;

import com.we.springmvcboot.Repository.UserRepository;
import com.we.springmvcboot.exception.NotesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {
    @Autowired
    private static UserRepository userrepo;

    public static void EmailIDValidate(String email) {
        if (email == null)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_EMAIL);
    }

    public static void UserIDValidate(long userID) {
        if (userID == 0)
            throw new NotesException(NotesException.NotesExceptionEnum.MISSING_USER_ID);
     }

}
