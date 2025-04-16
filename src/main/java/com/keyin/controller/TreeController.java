package com.keyin.controller;

import com.keyin.model.TreeData;
import com.keyin.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class TreeController {
    private final TreeService treeService;

    @Autowired
    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping
    public List<TreeData> getAllTrees() {
        return treeService.getAllTrees();
    }

    @PostMapping
    public TreeData saveTree(@RequestBody TreeData treeData) {
        return treeService.saveTree(treeData);
    }
}