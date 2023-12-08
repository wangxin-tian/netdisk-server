package com.dhx.config;

public class HashNode {
    private static final int NUM_NODES = 6; // 存储节点数
    private static final String[] NODES = {"node1", "node2", "node3", "node4", "node5", "node6"}; // 存储节点名称

    public static String getNode(String fileName) {
        int hash = fileName.hashCode(); // 计算哈希值
        int nodeIndex = Math.abs(hash % NUM_NODES); // 取模得到存储节点编号

        return NODES[nodeIndex]; // 返回存储节点名称
    }
}
