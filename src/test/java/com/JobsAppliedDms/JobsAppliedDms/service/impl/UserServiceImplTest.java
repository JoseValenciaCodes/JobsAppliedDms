package com.JobsAppliedDms.JobsAppliedDms.service.impl;

import com.JobsAppliedDms.JobsAppliedDms.dto.LoginDto;
import com.JobsAppliedDms.JobsAppliedDms.dto.UserDto;
import com.JobsAppliedDms.JobsAppliedDms.entity.User;
import com.JobsAppliedDms.JobsAppliedDms.exception.IncorrectCredentials;
import com.JobsAppliedDms.JobsAppliedDms.exception.UserAlreadyRegistered;
import com.JobsAppliedDms.JobsAppliedDms.exception.UserNotFound;
import com.JobsAppliedDms.JobsAppliedDms.payload.MessagePayload;
import com.JobsAppliedDms.JobsAppliedDms.payload.UserPayload;
import com.JobsAppliedDms.JobsAppliedDms.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/* UserServiceImplTest
* Unit Tests to test the UserService Implementation
* */

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest
{
    // Mock dependencies and attributes
    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private HttpSession httpSession;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private User user;
    private UserDto userDto;
    private LoginDto loginDto;

    // Set up data in order to make unit tests on user
    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@example.com");
        user.setPassword("Password5");
        user.setAge(25);
        user.setIsEmployed(true);

        userDto = new UserDto();
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("john@example.com");
        userDto.setPassword("Password5");
        userDto.setAge(25);
        userDto.setIsEmployed(true);

        loginDto = new LoginDto("john@example.com", "Password5");
    }

    // Test out we can successfully register a user
    @Test
    void registerUser_ShouldRegisterSuccessfully() {
        when(userRepository.existsByEmail(userDto.getEmail())).thenReturn(false);
        when(passwordEncoder.encode(userDto.getPassword())).thenReturn("hashedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserPayload result = userService.registerUser(userDto, httpSession);

        assertNotNull(result);
        assertEquals(user.getEmail(), result.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
        verify(httpSession, times(1)).setAttribute("userId", user.getId());
    }

    // Test out an exception is thrown if the user tries to register again
    @Test
    void registerUser_ShouldThrowUserAlreadyRegistered() {
        when(userRepository.existsByEmail(userDto.getEmail())).thenReturn(true);

        assertThrows(UserAlreadyRegistered.class, () -> userService.registerUser(userDto, httpSession));

        verify(userRepository, never()).save(any(User.class));
    }

    // Test out successful login
    @Test
    void loginUser_ShouldLoginSuccessfully() {
        when(userRepository.findByEmail(loginDto.getEmail())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(loginDto.getPassword(), user.getPassword())).thenReturn(true);

        UserPayload result = userService.loginUser(loginDto, httpSession);

        assertNotNull(result);
        assertEquals(user.getEmail(), result.getEmail());
        verify(httpSession, times(1)).setAttribute("userId", user.getId());
    }

    // Test out user not found for login attempt
    @Test
    void loginUser_ShouldThrowUserNotFound() {
        when(userRepository.findByEmail(loginDto.getEmail())).thenReturn(Optional.empty());

        assertThrows(UserNotFound.class, () -> userService.loginUser(loginDto, httpSession));

        verify(httpSession, never()).setAttribute(anyString(), any());
    }

    // Test out user cannot log in with incorrect credentials
    @Test
    void loginUser_ShouldThrowIncorrectCredentials() {
        when(userRepository.findByEmail(loginDto.getEmail())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(loginDto.getPassword(), user.getPassword())).thenReturn(false);

        assertThrows(IncorrectCredentials.class, () -> userService.loginUser(loginDto, httpSession));

        verify(httpSession, never()).setAttribute(anyString(), any());
    }

    // Check out session invalidates when the user logs out
    @Test
    void logout_ShouldInvalidateSession() {
        MessagePayload result = userService.logout(httpSession);

        assertEquals("You have successfully logged out", result.getMessage());
        verify(httpSession, times(1)).invalidate();
    }

    // Check out we can get the user that is logged in
    @Test
    void getLoggedInUser_ShouldReturnUserIfLoggedIn() {
        when(httpSession.getAttribute("userId")).thenReturn(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        System.out.println("User ID in session: " + httpSession.getAttribute("userId")); // Debugging line

        UserPayload result = userService.getLoggedInUser(httpSession);

        assertNotNull(result, "Expected user to be found, but got null");
        assertEquals(user.getId(), result.getId());
    }

    // Check out we cannot get user data when no user is logged in
    @Test
    void getLoggedInUser_ShouldReturnNullIfNotLoggedIn() {
        when(httpSession.getAttribute("userId")).thenReturn(null);

        UserPayload result = userService.getLoggedInUser(httpSession);

        assertNull(result);
    }
}
