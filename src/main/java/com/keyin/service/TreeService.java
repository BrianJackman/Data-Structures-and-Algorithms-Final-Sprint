package com.keyin.service;

import com.keyin.model.TreeData;
import com.keyin.repository.TreeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TreeService {
    private final TreeRepository treeRepository;

    public TreeService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    public List<TreeData> getAllTrees() {
        return treeRepository.findAll();
    }

    public TreeData saveTree(TreeData treeData) {
        return treeRepository.save(treeData);
    }
}