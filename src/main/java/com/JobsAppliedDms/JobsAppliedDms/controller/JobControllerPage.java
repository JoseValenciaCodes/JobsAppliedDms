package com.JobsAppliedDms.JobsAppliedDms.controller;

/* Controller to get job pages the user can interact to */

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobs")
public class JobControllerPage
{
    @GetMapping
    public String jobsPage(HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "jobs";
    }

    @GetMapping("{id}")
    public String jobDetailsPage(@PathVariable("id") Long id, HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "job-details";
    }

    @GetMapping("/new")
    public String addNewCategory(HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "job-details";
    }
}
