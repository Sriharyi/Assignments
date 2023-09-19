import java.util.*;

class TreeNode{
    Integer data;
    TreeNode parent;
    ArrayList<TreeNode> children;
    TreeNode(Integer data)
    {
        this.data = data;
        this.children = new ArrayList<>();
    }
    void addChild(TreeNode child)
    {
        children.add(child);
    }
}

class NaryTree{
    private TreeNode root;
    Scanner sc = new Scanner(System.in);
    
    public void insert(Integer parentVal,Integer inputVal)
    {
        TreeNode newNode = new TreeNode(inputVal);
        if(root == null)
        {
            newNode.parent = null;
            root = newNode;
            System.out.println("Inserted as root node because tree in empty");
        }
        else{
            TreeNode parentNode = findParentNode(root,parentVal);
            if(parentNode!=null){
                newNode.parent = parentNode;
                parentNode.addChild(newNode);
            }
            else
                System.out.println("Parent Not Found");
        }
    }

    public void breadthFirstTraversal()
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        bft(root,al);
        System.out.println(al.toString());   
    }

    private void bft(TreeNode root2, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.data);
            for (TreeNode child : node.children){
                queue.offer(child);
            }
        }
    }

    public void depthFirstTraversal()
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        dft(root,al);
        System.out.println(al.toString());
    }

    private void dft(TreeNode root2,ArrayList<Integer> list) {
        if(root2 == null)
        {
            return;
        }
        list.add(root2.data);
        for (TreeNode child : root2.children) {
            dft(child, list);
        }
    }

    public TreeNode findParentNode(TreeNode currentNode,Integer key) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.data == key) {
                return currentNode; 
        }
        for (TreeNode child : currentNode.children) {
            TreeNode result = findParentNode(child, key);
            if (result != null) {
                return result; 
            }
        }
        return null; 
    }

    public void delete(Integer key)
    {
        TreeNode tobeDeletedNode = findNode(root,key);
        if(tobeDeletedNode!=null)
        {
            if(tobeDeletedNode == root)
            {
                Integer index = 0;
                for(TreeNode child : tobeDeletedNode.children)
                {
                    System.out.println("index : "+index+"value : "+child.data);
                    index++;
                }
                System.out.println("Enter the index of above node the which is going to replace the deleted node");
                Integer ind = sc.nextInt();
                TreeNode swapNode = tobeDeletedNode.children.get(ind);
                for(TreeNode child : tobeDeletedNode.children)
                {
                   if(child!=swapNode)
                   {
                        swapNode.children.add(child);
                   }
                }  
                root = swapNode;
            }
            else if(tobeDeletedNode.children.size()==0)
            {
                TreeNode parent  = tobeDeletedNode.parent;
                parent.children.remove(tobeDeletedNode);
            }
            else if(tobeDeletedNode.children.size()==1)
            {
                TreeNode parent = tobeDeletedNode.parent;
                int index=0;
                for(TreeNode child : parent.children)
                {
                    if(child == tobeDeletedNode)
                    {
                        break;
                    }
                    index++;
                }
                parent.children.set(index, tobeDeletedNode.children.get(0));
            }
            else
            {
                int index=0;
                for(TreeNode child : tobeDeletedNode.children)
                {
                    System.out.println("index :"+index+"value"+child.data);
                    index++;
                }   
                System.out.println("Enter the index of above node the which is going to replace the deleted node");
                Integer ind = sc.nextInt();
                TreeNode parent = tobeDeletedNode.parent;
                TreeNode swapNode = tobeDeletedNode.children.get(ind);
                for(TreeNode child : tobeDeletedNode.children)
                {
                   if(child!=swapNode)
                   {
                        swapNode.children.add(child);
                   }
                }   
                index=0;
                for(TreeNode child : parent.children)
                {
                    if(child == tobeDeletedNode)
                    {
                        break;
                    }
                    index++;
                }
                parent.children.set(index, swapNode);
            }
        }else
        {
            System.out.println("deleted node cannot found in the list");
        }
    }
    private TreeNode findNode(TreeNode currentNode ,Integer key) {
        if(currentNode == null)
        {
            return currentNode;
        }
        if(currentNode.data == key)
        {
            return currentNode;
        }
        for(TreeNode child:currentNode.children)
        {
            TreeNode result = findNode(child, key);
            if(result!=null){
                return result;
            }
        }
        return null;
    }

    public int heightOfTree()
    {
        return calculateHeight(root);
    }
    public int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxHeight = 0;

        for (TreeNode child : node.children) {
            int childHeight = calculateHeight(child);
            maxHeight = Math.max(maxHeight, childHeight);
        }

        return maxHeight + 1;
    }

    public static void main(String[] args) {
        NaryTree tree = new NaryTree();
        tree.insert(1, 10);
        tree.insert(10, 4);
        tree.insert(10, 6);
        tree.insert(10, 5);
        tree.insert(4, 22);
        tree.insert(4, 54);
        tree.insert(22, 9);
        tree.breadthFirstTraversal();
        tree.delete(10);
        tree.breadthFirstTraversal();
        System.out.println(tree.heightOfTree());
    }
}




//     int Height(TreeNode root) {
//                if (root == null) {
//             return 0; 
//         }

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int height = 0;

//         while (!queue.isEmpty()) {
//             int level = queue.size(); 
//             while (level > 0) {
//                 TreeNode currentNode = queue.poll();
//                 for (TreeNode child : currentNode.children) {
//                     queue.add(child);
//                 }
//                 level--;
//             }
//             height++; 
//         }

//         return height;
//     }


//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int choice;
// //         while(true){
// //             System.out.println("\n1.Insert Tree");
// //             System.out.println("2.Preorder traversal");
// //             System.out.println("3.Inorder traversal");
// //             System.out.println("4.Postorder traversal");
// //             System.out.println("5.Level order traversal");
// //             System.out.println("6.Delete Tree");
// //             System.out.println("7.Height of tree");
// //             System.out.println("8.Exit");         
// //             choice=sc.nextInt();
// //             switch(choice){
// //                 case 1:
// //                     System.out.println("Enter key value : ");
// //                     int inputKey=sc.nextInt();
// //                     System.out.println("Enter parent key value : ");
// //                     int parentkey=sc.nextInt();
// //                     if(tree.root==null){
// //                         tree.root=new Tree(inputKey);
// //                         System.out.println("Element inserted as root as the tree is null");
// //                         root=tree.root;
// //                     }
// //                     else
// //                         tree.addNode(root, parentkey, inputKey);
// //                     break;
// //                 case 2:
// //                     tree.preorder(root);
// //                     break;
// //                 case 3:
// //                     tree.inorder(root);
// //                     break;
// //                 case 4:
// //                     tree.postorder(root);
// //                     break;
// //                 case 5:
// //                     tree.levelOrderTraversal();
// //                     break;
// //                 case 6:
// //                     System.out.println("Enter a value to be deleted : ");
// //                     int val=sc.nextInt();
// //                     //tree.delete(root, val);
// //                     break;
// //                 case 7:
// //                     System.out.println("The height is : "+tree.Height(root));
//                     break;
//                 case 8:
//                     return;                    
//                 default:
//                     System.out.println("invalid choice");
//             }
//         System.out.println("hello world");
//     }



  


   

