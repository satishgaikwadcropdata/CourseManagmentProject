package com.cource.management.runner;

import com.cource.management.Entity.ERole;
import com.cource.management.Entity.Role;
import com.cource.management.Entity.User;
import com.cource.management.repo.RoleRepository;
import com.cource.management.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RoleRunner implements CommandLineRunner {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private UserRepository UserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void run(String... args) throws Exception {

        Set<Role> roles = new HashSet<>();
        List<User> Users = new ArrayList<>();
        if (repository.count() == 0) {
            if (!repository.findByName(ERole.ROLE_USER).isPresent()) {
                Role user = new Role();
                user.setName(ERole.ROLE_USER);
                repository.save(user);
                roles.add(user);
                Users.add(new User("Jane", "janedoe", "janedoe@email.com", passwordEncoder.encode("password"), Collections.singleton(user)));
                Users.add(new User("Bob",  "bobsmith", "bobsmith@email.com", passwordEncoder.encode("password"), Collections.singleton(user)));
                Users.add(new User("Alice", "alicejohnson", "alicejohnson@email.com", passwordEncoder.encode("password"), Collections.singleton(user)));
                Users.add(new User("Mark", "markbrown", "markbrown@email.com", passwordEncoder.encode("password"), Collections.singleton(user)));
                Users.add(new User("Sarah" ,"sarahdavis", "sarahdavis@email.com", passwordEncoder.encode("password"), Collections.singleton(user)));
            }
            if (!repository.findByName(ERole.ROLE_ADMIN).isPresent()) {
                Role admin = new Role();
                admin.setName(ERole.ROLE_ADMIN);
                repository.save(admin);
                roles.add(admin);
                Users.add(new User("Jennifer",  "jenniferlee", "jenniferlee@email.com", passwordEncoder.encode("password"), Collections.singleton(admin)));
                Users.add(new User("John", "Doe",  "johndoe@email.com", passwordEncoder.encode("password"), Collections.singleton(admin)));
                Users.add(new User("Brock",  "brock", "brock@email.com", passwordEncoder.encode("password"), Collections.singleton(admin)));
                Users.add(new User("Bill", "bill", "bill@email.com", passwordEncoder.encode("password"), Collections.singleton(admin)));
            }
            if (!repository.findByName(ERole.ROLE_MANAGER).isPresent()) {
                Role manager = new Role();
                manager.setName(ERole.ROLE_MANAGER);
                repository.save(manager);
                roles.add(manager);
                Users.add(new User("Tom" ,"tomwilson", "tomwilson@email.com", passwordEncoder.encode("password"), Collections.singleton(manager)));
                Users.add(new User("Naina","naina", "naina@email.com", passwordEncoder.encode("password"), Collections.singleton(manager)));
            }

            Users.add(new User("David",  "davidnguyen", "davidnguyen@email.com", passwordEncoder.encode("password"), roles));
            Users.add(new User("Emily", "emilygarcia", "emilygarcia@email.com", passwordEncoder.encode("password"), roles));
            UserRepo.saveAll(Users);
        }
    }
}
