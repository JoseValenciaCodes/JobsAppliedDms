package com.JobsAppliedDms.JobsAppliedDms.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/* Let the user interact with the categories page*/

@Controller
@RequestMapping("/categories")
public class CategoryControllerPage
{
    @GetMapping
    public String categoriesPage(HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "categories";
    }

    // Show an existing category in the system
    @GetMapping("{id}")
    public String categoryDetailsPage(@PathVariable("id") Long id, HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "category-details";
    }

    // Create new category
    @GetMapping("/new")
    public String addNewCategory(HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "category-details";
    }
}
