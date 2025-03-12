package com.JobsAppliedDms.JobsAppliedDms.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* Provide the main page of the application*/

@Controller
@RequestMapping("/")
public class HomeController
{
    @GetMapping
    public String home(HttpSession session)
    {
        // If user is logged in, go to the dashboard page
        if (session.getAttribute("userId") != null)
        {
            return "redirect:/dashboard";
        }

        // Otherwise go to the logged in page
        return "redirect:/login";
    }
}
