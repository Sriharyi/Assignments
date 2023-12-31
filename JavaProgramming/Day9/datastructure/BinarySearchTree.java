import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeNode
{
    int data;
    int level;
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
            newNode.level = 0;
            root = newNode;
        }
        else
        {
            BinaryTreeNode currentNode = InsertInBSTFunc(root, newNode);
            newNode.parent = currentNode;
            newNode.level = currentNode.level+1;
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

    void findtheElement(Integer key)
    {
        BinaryTreeNode element = traversetheTreeAndFindElement(root, key);
        if(element != null){
            System.out.println(element.data);
            System.out.println("level of the element "+element.level);
            System.out.println("height of the element "+(element.level+1));
        }
        else
        {
            System.out.println("element not found");
        }
    }

    void inorder()
    {
        ArrayList<Integer> al = new ArrayList<>();
        inorderRecur(root,al);
        for(Integer num:al)
        {
            System.out.print(num+" ");
        }
        System.out.println();
    }
    void inorderRecur(BinaryTreeNode root2,ArrayList<Integer> aList)
    {
        if(root2!=null)
        {
            inorderRecur(root2.left,aList);
            aList.add(root2.data);
            inorderRecur(root2.right,aList);
        }
    }




      void preorder()
    {
        ArrayList<Integer> al = new ArrayList<>();
        preorderRecur(root,al);
        for(Integer num:al)
        {
            System.out.print(num+" ");
        }
        System.out.println();
    }
    void preorderRecur(BinaryTreeNode root2,ArrayList<Integer> aList)
    {
        if(root2!=null)
        {
            aList.add(root2.data);
            preorderRecur(root2.left,aList);
            preorderRecur(root2.right,aList);
        }
    }

    void postorder()
    {
        ArrayList<Integer> al = new ArrayList<>();
        postorderRecur(root,al);
        for(Integer num:al)
        {
            System.out.print(num+" ");
        }
        System.out.println();
    }
    void postorderRecur(BinaryTreeNode root2,ArrayList<Integer> aList)
    {
        if(root2!=null)
        {
            postorderRecur(root2.left,aList);
            postorderRecur(root2.right,aList);
            aList.add(root2.data);
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
      Boolean search(Integer key)
      {
        if(traversetheTreeAndFindElement(root, key)!=null)
            return true;
        else    
            return false;
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
            return traversetheTreeAndFindElement(currentNode.left, key);
        }
        else{
            return traversetheTreeAndFindElement(currentNode.right, key);
        }
    }
    
    public List<List<Integer>> breadthFirstSearch()
    {
        Queue<BinaryTreeNode> q = new LinkedList<>();
        
        List<List<Integer>> level = new ArrayList();
        q.offer(root);
        while(!q.isEmpty())
        {   
            Integer temp = q.size();
            List<Integer> al = new ArrayList<>();
            while(temp-->0)
            {
                BinaryTreeNode popped = q.poll();
                al.add(popped.data);
                if(popped.left!=null)
                    q.add(popped.left);
                if(popped.right!=null)
                    q.add(popped.right);
            }
            level.add(al);
        }
        return level;
    }
   
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.InsertInBST(30);
        bst.InsertInBST(20);
        bst.InsertInBST(10);
        bst.InsertInBST(40);
        bst.InsertInBST(50);
        bst.InsertInBST(75);
        // bst.deleteKey(75);
        // bst.deleteKey(10);
        
        
        System.out.println(bst.breadthFirstSearch().toString());
        bst.findtheElement(75);
        System.out.println(bst.breadthFirstSearch().toString());
    }
    
}
