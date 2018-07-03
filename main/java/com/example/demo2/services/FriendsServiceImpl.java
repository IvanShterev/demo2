package com.example.demo2.services;

import com.example.demo2.entities.Friend;
import com.example.demo2.repositories.base.GenericRepository;
import com.example.demo2.services.base.FriendsService;
import com.example.demo2.utils.validator.base.Validator;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;
import java.util.List;
@Service
public class FriendsServiceImpl implements FriendsService {

    private final GenericRepository<Friend> friendRepository;
    private final Validator<Friend> friendValidator;

    public FriendsServiceImpl(GenericRepository<Friend> friendsRepository, Validator<Friend> friendValidator){
        this.friendRepository = friendsRepository;
        this.friendValidator = friendValidator;
    }

    @Override
    public List<Friend> getAll() {
        return friendRepository.getAll();
    }
    @Override
    public void createFriend(Friend friend) throws InvalidObjectException {
        if (!friendValidator.isValid(friend)) {
            throw new InvalidObjectException("Invalid product");
        }

        friendRepository.create(friend);
    }
}
