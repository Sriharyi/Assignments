/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1,inorderIndexMap);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right,Map<Integer,Integer>  inorderIndexMap) {
       
        if (left > right) {
            return null;
        }
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1,inorderIndexMap);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right,inorderIndexMap);
        return root;
    }
}