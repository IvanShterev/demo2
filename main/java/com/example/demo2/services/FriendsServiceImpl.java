package com.example.demo2.services;

import com.example.demo2.entities.Friend;
import com.example.demo2.repositories.base.GenericRepository;
import com.example.demo2.services.base.FriendsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendsServiceImpl implements FriendsService {

    private final GenericRepository<Friend> friendRepository;

    public FriendsServiceImpl(GenericRepository<Friend> friendsRepository){
        this.friendRepository = friendsRepository;
    }

    @Override
    public List<Friend> getAll() {
        return friendRepository.getAll();
    }
}
