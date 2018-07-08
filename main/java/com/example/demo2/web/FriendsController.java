package com.example.demo2.web;

import com.example.demo2.entities.Friend;
import com.example.demo2.entities.User;
import com.example.demo2.repositories.HibernateRepository;
import com.example.demo2.services.base.FriendsService;
import com.example.demo2.services.base.UsersService;
import com.example.demo2.utils.loggers.base.LoggerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.security.Principal;
import java.util.List;

@RestController
public class FriendsController {

    private final FriendsService friendsService;
    private final UsersService usersService;


    @Autowired
    public FriendsController(FriendsService friendsService,
                             UsersService usersService
    ) {
        this.friendsService = friendsService;
        this.usersService = usersService;
    }

    //
////    @GetMapping("/{id}")
////    public String details(@PathVariable String id, Model model) {
////        logger.info("In product details");
////
////        Friend friend = friendsService.getProductById();
////        model.addAttribute("product", friend);
////
////        return "products/details";
////    }
//
//    @GetMapping("/friends/add")
//    public String add(Model model) {
//        Friend friend = new Friend();
//        model.addAttribute("friend", friend);
//        return "friends/add";
//    }

    @PostMapping("/friends/add")
    public String add(
            @ModelAttribute Friend friend,
            Principal principal
    ) {
        try {
            friendsService.createFriend(friend);
            return "index";
        } catch (InvalidObjectException e) {
            return "index";
        }
    }

}
//
////}
////
////    private final HibernateRepository<Friend> friendsRepository;
////
////    @Autowired
////    public FriendsController() {
////        this.friendsRepository = new HibernateRepository<>(Friend.class);
////    }
////    @RequestMapping("/Friends")
////    public List<Friend> getFriends(){
////        List<Friend> friends = friendsRepository.getAll();
////    return friends;
////    }
////}
