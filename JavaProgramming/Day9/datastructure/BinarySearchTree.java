class BinaryTreeNode
{
    int data;
    BinaryTreeNode left,right,parent;
    BinaryTreeNode(Integer data)
    {
        this.data = data;
    }
}


public class BinarySearchTree {

    private BinaryTreeNode root;

    void InsertInBST(Integer value)
    {
        BinaryTreeNode newNode = new BinaryTreeNode(value);
        if(root == null)
        {
            root = newNode;
        }
        else
        {
            BinaryTreeNode currentNode = InsertInBSTFunc(root, newNode);
            newNode.parent = currentNode;
        }
    }
    void findtheElement(Integer key)
    {
        BinaryTreeNode element = traversetheTreeAndFindElement(root, key);
        System.out.println(element.data);
    }
    void inorder()
    {
        inorderRecur(root);
    }
    void inorderRecur(BinaryTreeNode root2)
    {
        if(root2!=null)
        {
            inorderRecur(root2.left);
            System.out.println(root2.data);
            inorderRecur(root2.right);
        }
    }
    void deleteKey(int key) {
        root = deleteRec(root, key);
      }
    
      BinaryTreeNode deleteRec(BinaryTreeNode root, int key) {
        
        if (root == null)
          return root;
        if (key < root.data)
          root.left = deleteRec(root.left, key);
        else if (key > root.data)
          root.right = deleteRec(root.right, key);
        else {
          
          if (root.left == null)
            return root.right;
          else if (root.right == null)
            return root.left;

          root.data = minValue(root.right);
    
          root.right = deleteRec(root.right, root.data);
        }
    
        return root;
      }
    
      
      Integer minValue(BinaryTreeNode root) {
        int minv = root.data;
        while (root.left != null) {
          minv = root.left.data;
          root = root.left;
        }
        return minv;
      }
    BinaryTreeNode traversetheTreeAndFindElement(BinaryTreeNode currentNode,Integer key)
    {
        if(currentNode==null)
        {
            return currentNode;
        }
        if(currentNode.data == key)
        {
            return currentNode;
        }
        else if(currentNode.data>key)
        {
            System.out.println(currentNode.data);
            return traversetheTreeAndFindElement(currentNode.left, key);
        }
        else{
            System.out.println(currentNode.data);
            return traversetheTreeAndFindElement(currentNode.right, key);
        }
    }
    
    BinaryTreeNode InsertInBSTFunc(BinaryTreeNode currentNode,BinaryTreeNode elementtobeInsert)
    {
        if(currentNode.data>elementtobeInsert.data)
        {
            if(currentNode.left == null)
            {
                currentNode.left = elementtobeInsert;
                return currentNode;
            }
            else{
                return InsertInBSTFunc(currentNode.left, elementtobeInsert);
            }
        }
        else{
            if(currentNode.right == null)
            {
                currentNode.right = elementtobeInsert;
                return currentNode;
            }
            else
            {
                return InsertInBSTFunc(currentNode.right, elementtobeInsert);
            }
        }
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.InsertInBST(50);
        bst.InsertInBST(100);
        bst.InsertInBST(25);
        bst.InsertInBST(12);
        bst.InsertInBST(35);
        bst.InsertInBST(75);
        bst.findtheElement(75);
        bst.deleteKey(75);
        bst.inorder();

    }
    
}
