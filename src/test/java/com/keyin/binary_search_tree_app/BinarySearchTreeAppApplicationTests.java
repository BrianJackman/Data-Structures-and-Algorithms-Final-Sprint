package com.keyin.binary_search_tree_app;

import com.keyin.binary_search_tree_app.util.BinarySearchTree;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BinarySearchTreeAppApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testInsertAndInOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        List<Integer> result = bst.inOrderTraversal();
        assertEquals(List.of(2, 3, 4, 5, 7), result);
    }

    @Test
    void testSerialize() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        String serialized = bst.serialize();
        assertEquals("5,3,2,null,null,4,null,null,7,null,null,", serialized);
    }

    @Test
    void testSerializeReadable() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        String serializedReadable = bst.serializeReadable();
        assertEquals("5(3(2,4),7)", serializedReadable);
    }
}