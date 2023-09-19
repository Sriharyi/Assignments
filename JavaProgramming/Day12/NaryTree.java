import java.util.*;

class TreeNode{
    Integer data;
    ArrayList<TreeNode> children;
    TreeNode(Integer data)
    {
        this.data = data;
    }
}

class NaryTree{
    private TreeNode root;

    public void insert(Integer parentVal,Integer inputVal)
    {
      if(root==null){
            System.out.println("parent not found");
            return;
        }
        else if (root.data==parentVal) {
            TreeNode newTree = new TreeNode(inputVal);
            root.children.add(newTree);
            return;
        }
        for (TreeNode child : root.children) {
            insert(parentVal, inputVal);
    }
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        for (TreeNode child : root.children) {
            inorder(child);
            System.out.print(root.data + " ");
        }
    }
    void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        for (TreeNode child : root.children) {
            preorder(child);
        }
    }
     void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        for (TreeNode child : root.children) {
            postorder(child);
        }
         System.out.print(root.data + " ");
    }

    void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.data + " ");

            for (TreeNode child : currentNode.children) {
                queue.add(child);
            }
        }
    }
    int Height(TreeNode root) {
               if (root == null) {
            return 0; 
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int level = queue.size(); 
            while (level > 0) {
                TreeNode currentNode = queue.poll();
                for (TreeNode child : currentNode.children) {
                    queue.add(child);
                }
                level--;
            }
            height++; 
        }

        return height;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode tree= new TreeNode(null);
        TreeNode root=null;
        int choice;
        while(true){
            System.out.println("\n1.Insert Tree");
            System.out.println("2.Preorder traversal");
            System.out.println("3.Inorder traversal");
            System.out.println("4.Postorder traversal");
            System.out.println("5.Level order traversal");
            System.out.println("6.Delete Tree");
            System.out.println("7.Height of tree");
            System.out.println("8.Exit");         
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter key value : ");
                    int inputKey=sc.nextInt();
                    System.out.println("Enter parent key value : ");
                    int parentkey=sc.nextInt();
                    if(tree.root==null){
                        tree.root=new Tree(inputKey);
                        System.out.println("Element inserted as root as the tree is null");
                        root=tree.root;
                    }
                    else
                        tree.addNode(root, parentkey, inputKey);
                    break;
                case 2:
                    tree.preorder(root);
                    break;
                case 3:
                    tree.inorder(root);
                    break;
                case 4:
                    tree.postorder(root);
                    break;
                case 5:
                    tree.levelOrderTraversal();
                    break;
                case 6:
                    System.out.println("Enter a value to be deleted : ");
                    int val=sc.nextInt();
                    //tree.delete(root, val);
                    break;
                case 7:
                    System.out.println("The height is : "+tree.Height(root));
                    break;
                case 8:
                    return;                    
                default:
                    System.out.println("invalid choice");
            }
        System.out.println("hello world");
    }
}
}



  


   

