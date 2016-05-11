package com.kevin.model.structure;

/**
 * Created by spirit on 2016/3/24.
 */
public class TreeNode<T> {
    private T data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(T data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }
}
