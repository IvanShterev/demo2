package com.example.demo2.web;

import com.example.demo2.entities.Friend;
import com.example.demo2.repositories.HibernateRepository;
import com.example.demo2.repositories.base.GenericRepository;
import com.example.demo2.services.base.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final HibernateRepository<Friend> friendsRepository;

    @Autowired
    public HomeController() {
        this.friendsRepository = new HibernateRepository<>(Friend.class);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/friends.html")
    public String friends(Model model) {
        List<Friend> friends = friendsRepository.getAll();
        model.addAttribute("message", "Hello!");
        model.addAttribute("friends", friends);
        return "friends";
    }

    @GetMapping("/new friend.html")
    public String newFriend() {
        return "new friend";
    }
//
//@GetMapping("/login")
//public String login() {
//        return "login";
//        }

}
