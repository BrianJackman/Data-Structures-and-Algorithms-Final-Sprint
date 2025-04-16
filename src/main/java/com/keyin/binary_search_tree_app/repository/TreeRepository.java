package com.keyin.binary_search_tree_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyin.binary_search_tree_app.model.TreeData;

@Repository
public interface TreeRepository extends JpaRepository<TreeData, Long> {
}