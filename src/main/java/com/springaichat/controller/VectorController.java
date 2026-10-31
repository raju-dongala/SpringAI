package com.springaichat.controller;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springaichat.service.VectorService;

@RestController
@RequestMapping("/vector")
public class VectorController {

    private final VectorService vectorService;

    public VectorController(VectorService vectorService) {
        this.vectorService = vectorService;
    }

    @PostMapping("/load")
    public String load() {

        vectorService.loadData();

        return "Documents loaded successfully";
    }

    @GetMapping("/search")
    public List<Document> search(
            @RequestParam String question) {

        return vectorService.search(question);
    }
}