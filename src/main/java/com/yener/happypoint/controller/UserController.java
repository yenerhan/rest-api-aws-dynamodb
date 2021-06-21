package com.yener.happypoint.controller;

import com.yener.happypoint.dto.user.SaveUserRequestDTO;
import com.yener.happypoint.dto.user.SearchUserRequestDTO;
import com.yener.happypoint.dto.user.UserResponseDTO;
import com.yener.happypoint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/searchUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    UserResponseDTO searchUser(@RequestBody SearchUserRequestDTO searchUserRequestDTO) {
        return userService.searchUser(searchUserRequestDTO);
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    UserResponseDTO createUser(@RequestBody SaveUserRequestDTO saveUserRequestDTO) {
        return userService.createUser(saveUserRequestDTO);
    }

    @PutMapping
    public String updateUser() {
        return "Update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete user was called";
    }
}
