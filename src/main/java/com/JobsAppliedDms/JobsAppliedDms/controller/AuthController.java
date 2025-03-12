package com.JobsAppliedDms.JobsAppliedDms.controller;

/* Authentication Controller
*
* Handles Thymeleaf templates to let the user interact with authentication mechanisms
* */

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController
{
    @GetMapping("/register")
    public String registerPage(HttpSession session)
    {
        // If user is logged in, go to the dasboard page
        if (session.getAttribute("userId") != null)
        {
            return "redirect:/dashboard";
        }

        return "register";
    }

    @GetMapping("/login")
    public String loginPage(HttpSession session)
    {
        // If user is logged in, go to the dasboard page
        if (session.getAttribute("userId") != null)
        {
            return "redirect:/dashboard";
        }

        return "login";
    }
}
