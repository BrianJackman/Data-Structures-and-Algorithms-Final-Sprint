package com.keyin.service;

import com.keyin.model.TreeData;
import com.keyin.repository.TreeRepository;
import com.keyin.util.BinarySearchTree;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeService {
    private final TreeRepository treeRepository;

    public TreeService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    // Process input numbers, create a binary search tree, and save it
    public TreeData processAndSaveTree(String inputNumbers) {
        // Parse the input numbers
        List<Integer> numbers = parseInputNumbers(inputNumbers);

        // Create and populate the binary search tree
        BinarySearchTree bst = new BinarySearchTree();
        numbers.forEach(bst::insert);

        // Serialize the tree structure
        String treeStructure = bst.serialize();

        // Save the tree data to the database
        TreeData treeData = new TreeData();
        treeData.setInputNumbers(inputNumbers);
        treeData.setTreeStructure(treeStructure);
        return treeRepository.save(treeData);
    }

    // Retrieve all previously stored trees
    public List<TreeData> getAllTrees() {
        return treeRepository.findAll();
    }

    // Helper method to parse input numbers from a comma-separated string
    private List<Integer> parseInputNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}