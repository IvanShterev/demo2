package com.example.demo2.web;

import com.example.demo2.entities.Friend;
import com.example.demo2.repositories.HibernateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendsController {

    private final HibernateRepository<Friend> friendsRepository;

    @Autowired
    public FriendsController() {
        this.friendsRepository = new HibernateRepository<>(Friend.class);
    }
    @RequestMapping("/Friends")
    public List<Friend> getFriends(){
        List<Friend> friends = friendsRepository.getAll();
    return friends;
    }
}
