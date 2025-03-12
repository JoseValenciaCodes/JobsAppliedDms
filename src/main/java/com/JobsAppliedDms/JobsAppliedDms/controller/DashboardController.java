package com.JobsAppliedDms.JobsAppliedDms.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* Let the authenticated user access the dashboard */

@Controller
@RequestMapping("/dashboard")
public class DashboardController
{
    @GetMapping
    public String dashboardPage(HttpSession session)
    {
        // If there is no session, go to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        System.out.println(session.getAttribute("userId"));

        return "dashboard";
    }
}
