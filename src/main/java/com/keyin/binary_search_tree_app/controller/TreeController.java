package com.keyin.binary_search_tree_app.controller;

import com.keyin.binary_search_tree_app.model.TreeData;
import com.keyin.binary_search_tree_app.service.TreeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TreeController {
    private final TreeService treeService;

    @Autowired
    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    // Display the form to enter numbers
    @GetMapping
    public String showEnterNumbersPage() {
        return "enter-numbers";
    }

    // Process the input numbers and display the resulting tree
    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam("numbers") String numbers, Model model) {
        TreeData treeData = treeService.processAndSaveTree(numbers);
        model.addAttribute("treeStructure", treeData.getTreeStructure());
        model.addAttribute("inputNumbers", treeData.getInputNumbers());
        return "enter-numbers";
    }

    // Display all previously stored trees
    @GetMapping("/previous-trees")
    public String showPreviousTreesPage(Model model) {
        List<TreeData> allTrees = treeService.getAllTrees();
        model.addAttribute("trees", allTrees);
        return "previous-trees";
    }
}