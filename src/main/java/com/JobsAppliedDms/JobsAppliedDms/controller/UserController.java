package com.JobsAppliedDms.JobsAppliedDms.controller;


import com.JobsAppliedDms.JobsAppliedDms.dto.LoginDto;
import com.JobsAppliedDms.JobsAppliedDms.dto.UserDto;
import com.JobsAppliedDms.JobsAppliedDms.payload.MessagePayload;
import com.JobsAppliedDms.JobsAppliedDms.payload.UserPayload;
import com.JobsAppliedDms.JobsAppliedDms.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/*
* User Controller
* Handle HTTP Interactions related with the User Entity
* */

@RestController
@RequestMapping("/api/auth")
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* Make a POST Request to Register */
    @PostMapping("/register")
    public ResponseEntity<UserPayload> registerUser(@Validated @RequestBody UserDto userDto, HttpSession httpSession)
    {
        UserPayload userPayload = userService.registerUser(userDto, httpSession);
        return ResponseEntity.ok(userPayload);
    }

    /* Make a POST Request to Login */
    @PostMapping("/login")
    public ResponseEntity<UserPayload> loginUser(@Validated @RequestBody LoginDto loginDto, HttpSession httpSession)
    {
        UserPayload userPayload = userService.loginUser(loginDto, httpSession);
        return ResponseEntity.ok(userPayload);
    }

    /* Make a POST Request to Logout */
    @PostMapping("/logout")
    public ResponseEntity<MessagePayload> logoutUser(HttpSession httpSession)
    {
        MessagePayload messagePayload = userService.logout(httpSession);
        return ResponseEntity.ok(messagePayload);
    }

    /* Make a GET Request to Get Logged In User*/
    @GetMapping("/user-session")
    public ResponseEntity<UserPayload> getLoggedInUser(HttpSession httpSession)
    {
        UserPayload payload = userService.getLoggedInUser(httpSession);
        return ResponseEntity.ok(payload);
    }

    /* Make a PUT Request to Update Logged In User */
    @PutMapping("/update-profile")
    public ResponseEntity<UserPayload> updateLoggedInUser(HttpSession httpSession, @Validated @RequestBody UserDto userDto)
    {
        UserPayload userPayload = userService.updateLoggedInUser(httpSession, userDto);
        return ResponseEntity.ok(userPayload);
    }

    /* Make a DELETE Request to Delete Logged In User */
    @DeleteMapping("/delete-account")
    public ResponseEntity<MessagePayload> deleteLoggedInUser(HttpSession httpSession)
    {
        MessagePayload messagePayload = userService.deleteLoggedInUser(httpSession);
        return ResponseEntity.ok(messagePayload);
    }
}
