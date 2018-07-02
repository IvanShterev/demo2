//package com.example.demo2.config;
//
//import com.example.demo2.entities.Friend;
//import com.example.demo2.entities.User;
//import com.example.demo2.repositories.HibernateRepository;
//import com.example.demo2.repositories.base.GenericRepository;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//    @Bean
//    @Autowired
//    GenericRepository<Friend> provideFriendsGenericRepository(SessionFactory sessionFactory) {
//        HibernateRepository<Friend> repo = new HibernateRepository<>(sessionFactory);
//        repo.setEntityClass(Friend.class);
//
//        return repo;
//    }
//
//
//    @Bean
//    @Autowired
//    GenericRepository<User> provideUsersGenericRepository(SessionFactory sessionFactory) {
//        HibernateRepository<User> repo = new HibernateRepository<>(sessionFactory);
//        repo.setEntityClass(User.class);
//
//        return repo;
//    }
//
//    @Bean
//    SessionFactory provideSessionFactory() {
//        return HibernateUtils.getSessionFactory();
//    }
////
////    @Bean
////    Validator<Friend> provideProductValidator() {
////        return new ProductValidator();
////    }
//}