package com.rresende.hackerrank;

public class SelfBalanceTree {
	
	/* Class node is defined as : */
	static class Node { 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child
    }
	

    static Node rotateLeft(Node n) {
        Node x = n.right;
        Node z = x.left;
        
        x.left = n;
        n.right = z;
        
        updateHeight(n);
        updateHeight(x);
        
        return x;
    }

    static Node rotateRight(Node n) {
        Node x = n.left;
        Node z = x.right;
        
        x.right = n;
        n.left = z;
        
        updateHeight(n);
        updateHeight(x);
        
        return x;
    }

    static Node rebalance(Node n) {
        updateHeight(n);
        int balance = getBalance(n);
        if (balance > 1){
            if (height(n.right.right) > height(n.right.left)) {
                n = rotateLeft(n);
            } else {
                n.right = rotateRight(n.right);
                n = rotateLeft(n);
            }
        } else if (balance < -1) {
            if (height(n.left.left) > height(n.left.right)) {
                n = rotateRight(n);
            } else {
                n.left = rotateLeft(n.left);
                n = rotateRight(n);
            }
        }
        return n;
    }

    static  void updateHeight(Node n) {
        n.ht = 1 + Math.max(height(n.left), height(n.right));
    }

    static int height(Node n) {
        return n == null ? -1 : n.ht;
    }

    static int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

	static Node insert(Node root,int val)
    {
    	if (root == null) {
            Node n = new Node();
            n.val = val;
            return n;
        }
        if (root.val > val) {
            root.left = insert(root.left, val);
        }
        else if (root.val < val) {
            root.right = insert(root.right, val);
        }
        return rebalance(root);
    }

}
