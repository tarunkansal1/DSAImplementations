package BinaryTree;

import java.util.*;

public class BinaryTreeImplementation {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        Node(int data,Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class BinaryTree{
        int idx = -1;
        public Node buildTree(int [] nodes){
            idx++;
            if (nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);

            return;
        }

        public void inOrder(Node root){
            if(root == null){
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);

            return;
        }
        public void postOrder(Node root){
            if(root == null){
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");

            return;
        }
        public void levelOrder(Node root){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        System.out.println();
                        q.add(null);
                        continue;
                    }
                }
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

        public int countNodes(Node root){
            if(root == null){
                return 0;
            }

            return (countNodes(root.left) + countNodes(root.right) + 1);
        }

        public int height(Node root){
            if(root == null){
                return 0;
            }

            return (Math.max(height(root.left),height(root.right)) + 1);
        }

        public int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }

            return (sumOfNodes(root.left) + sumOfNodes(root.right) + root.data);
        }

        public int diameterN2(Node root){
            if(root==null){
                return 0;
            }

            int d1 = diameterN2(root.left);
            int d2 = diameterN2(root.right);
            int d3 = height(root.left) + height(root.right) + 1;

            return(Math.max(Math.max(d1,d2),d3));
        }

        public TreeInfo diameterN(Node root){
            if(root==null){
                return new TreeInfo(0, 0);
            }

            TreeInfo leftTI = diameterN(root.left);
            TreeInfo rightTI = diameterN(root.right);

            int myHeight = Math.max(leftTI.h,rightTI.h) + 1;
            int d1 = leftTI.h + rightTI.h + 1;
            int d2 = leftTI.d;
            int d3 = rightTI.d;

            int myDiam = Math.max(Math.max(d2,d3),d1);

            return new TreeInfo(myHeight, myDiam);

        }
    }

    static class TreeInfo{
        int d;
        int h;
        TreeInfo(int h,int d){
            this.d = d;
            this.h = h;
        }
    }

    public static void main(String[] args){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        //System.out.println(root.data);

        BinaryTree tree2 = new BinaryTree();
        Node root2 = tree2.buildTree(nodes);

        //System.out.println(root2.left.data);
        /*System.out.println("preOrder traversal");
        tree.preOrder(root);
        System.out.println();
        System.out.println("inOrder traversal");
        tree.inOrder(root);
        System.out.println();
        System.out.println("postOrder traversal");
        tree.postOrder(root);*/

        //tree.levelOrder(root);

        System.out.println("Number of Nodes " + tree.countNodes(root));
        System.out.println("Height of tree " + tree.height(root));
        System.out.println("Sum of tree " + tree.sumOfNodes(root));
        System.out.println("Diameter of tree is : " + tree.diameterN2(root));
        TreeInfo Ti = tree.diameterN(root);
        System.out.println("Diameter of tree in O(N) is : " + Ti.d);
    }
}
