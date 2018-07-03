package com.example.demo2.services.base;

import com.example.demo2.entities.Friend;

import java.io.InvalidObjectException;
import java.util.List;

public interface FriendsService {
    List<Friend> getAll();
    void createFriend(Friend friend) throws InvalidObjectException;
}
