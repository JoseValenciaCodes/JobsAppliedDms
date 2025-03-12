package com.JobsAppliedDms.JobsAppliedDms.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/* Let the user interact with the company controller page */

@Controller
@RequestMapping("/companies")
public class CompanyControllerPage
{
    @GetMapping
    public String companiesPage(HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "companies";
    }

    // Show an existing company in the system
    @GetMapping("{id}")
    public String companyDetailsPage(@PathVariable("id") Long id, HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "company-details";
    }

    // Create a new company
    @GetMapping("/new")
    public String addNewCompany(HttpSession session)
    {
        // If no user session, redirect to login page
        if (session.getAttribute("userId") == null)
        {
            return "redirect:/login";
        }

        return "company-details";
    }
}
