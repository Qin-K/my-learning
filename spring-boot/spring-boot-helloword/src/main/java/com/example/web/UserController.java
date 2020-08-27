package com.example.web;

import com.example.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("")
    public List<User> getUserList() {
        List<User> list = new ArrayList<>(users.values());

        return list;
    }

    @PostMapping("")
    public String addUser(User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        User user = users.get(id);
        return user;
    }

    @PutMapping("")
    public String updateUser(User user) {
        Long id = user.getId();
        users.put(id, user);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }


}
