package com.ga.Spring_profile.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController

@RequestMapping("/api")
public class Spring_profileController {
    ArrayList<String> projects = new ArrayList<String>();

    {
        projects.add("Spring Boot REST API");
        projects.add("Java Calculator App");
        projects.add("Task Management App");
        projects.add("Weather API");
        projects.add("Elora Saloon System");
        projects.add("Car Rent App");
    }

    //    1. Welcome / Introduction
    @GetMapping("/welcome")
    public LinkedHashMap<String, String> greeting() {
        LinkedHashMap<String, String> response = new LinkedHashMap<String, String>();
        response.put("Application name", "Create My Spring Profile!");
        response.put("My name", "Hasan Ali");
        response.put("Description", "Spring Boot and REST API Development");
        response.put("Theme", "Software Development");
        return response;
    }

    //    2. Get All Items
    @GetMapping("/projects")
    public ArrayList<String> projects() {
        return projects;
    }

    //    3. Get One Item
    @GetMapping("/projects/{id}")
    public String project(@PathVariable int id) {

        if (id == 1) {
            return "Spring Boot REST API";
        } else if (id == 2) {
            return "Java Calculator";
        } else if (id == 3) {
            return "Task Management App";
        } else if (id == 4) {
            return "Weather API";
        } else if (id == 5) {
            return "Elora Saloon";
        } else if (id == 6) {
            return "Car Rent System";
        }
        return "Project not found";
    }

    //4. Search
    @GetMapping("/projects/search")
    public ArrayList<String> search(@RequestParam String name) {
        ArrayList<String> response = new ArrayList<String>();

        if ("Spring Boot REST API".contains(name)) {
            response.add("Spring Boot REST API");
        }

        if ("Java Calculator".contains(name)) {
            response.add("Java Calculator");
        }

        if ("Task Management App".contains(name)) {
            response.add("Task Management App");
        }

        if ("Weather API".contains(name)) {
            response.add("Weather API");
        }

        if ("Elora Saloon".contains(name)) {
            response.add("Elora Saloon");
        }

        if ("Car Rent System".contains(name)) {
            response.add("Car Rent System");
        }
        return response;
    }

    //    5. Filter
    @GetMapping("/projects/filter")
    public ArrayList<String> filter(@RequestParam String type) {

        ArrayList<String> response = new ArrayList<String>();

        for (String project : projects) {
            if (project.contains(type)) {
                response.add(project);
            }
        }

        return response;
    }

    //    6. Create Something New
    @PostMapping("/projects")
    public String add_Project(@RequestBody String name) {
        projects.add(name);
        return "Added successfully";
    }

    //    7. Update Something
    @PutMapping("/projects/{id}")
    public String update_Project(@PathVariable int id, @RequestBody String name) {
        projects.set(id - 1, name);
        return "Updated successfully";
    }

    //    8. Delete Something
    @DeleteMapping("/projects/{id}")
    public String delete_Project(@PathVariable int id) {
        projects.remove(id - 1);
        return "Deleted successfully";
    }

    //    9. Statistics / Summary
    @GetMapping("/projects/size")
    public int projectsSize() {
        return projects.size();
    }

    //    10. Your Own Feature
//
    @GetMapping("/projects/favourite")
    public String favourite() {
        return "My favourite project is : Elora Saloon ";
    }

}
