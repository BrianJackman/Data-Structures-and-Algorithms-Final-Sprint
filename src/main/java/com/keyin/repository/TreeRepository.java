package com.keyin.repository;

import com.keyin.model.TreeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<TreeData, Long> {
}