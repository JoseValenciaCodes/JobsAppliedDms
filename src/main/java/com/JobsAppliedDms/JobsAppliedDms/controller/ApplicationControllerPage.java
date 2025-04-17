package com.JobsAppliedDms.JobsAppliedDms.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applications")
public class ApplicationControllerPage
{
    @GetMapping
    public String applicationsPage(HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "applications";
    }

    @GetMapping("{id}")
    public String applicationDetailsPage(@PathVariable("id") Long id, HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "application-details";
    }

    @GetMapping("/new")
    public String addNewApplication(HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "application-details";
    }
}
