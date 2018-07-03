package com.example.demo2.utils.validator;

import com.example.demo2.entities.Friend;
import com.example.demo2.utils.validator.base.Validator;
import org.springframework.stereotype.Service;

@Service
public class FriendValidator implements Validator<Friend> {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 20;

    @Override
    public boolean isValid(Friend friend) {
        return friend != null &&
                isNameValid(friend.getName())
                ;}
    private boolean isNameValid(String name) {
        return name != null &&
                name.length() >= MIN_NAME_LENGTH &&
                name.length() <= MAX_NAME_LENGTH;
    }
}
