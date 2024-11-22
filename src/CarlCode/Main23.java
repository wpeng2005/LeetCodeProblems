package CarlCode;

import sun.reflect.generics.tree.Tree;

// 23题  二叉树高度
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main23 {
    static Map<Character,Integer> map;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int nodeNum=sc.nextInt();
            sc.nextLine();
            char[] preorder=sc.nextLine().toCharArray();
            char[] inorder=sc.nextLine().toCharArray();
            System.out.println(mergeCode(preorder,inorder));
        }
    }
    public static  int mergeCode(char[] preorder,char[] inorder){
       map=new HashMap<Character,Integer>();
       for(int i=0;i<inorder.length;i++){
           map.put(inorder[i],i);
       }
       TreeNode root=generateTree(preorder,0, preorder.length, inorder,0,inorder.length,map);
       return getHeight(root);
    }

    public static TreeNode generateTree(char[] preorder,int prebeign,int preend,char[] inorder,int inbegin,int inend,Map<Character,Integer> map){
        if(prebeign>=preend || inbegin>=preend){
            return null;
        }
        int rootIndex=map.get(preorder[prebeign]);
        TreeNode root=new TreeNode(inorder[rootIndex]);
        int lengthOfLeft=rootIndex-inbegin;
        root.left=generateTree(preorder,prebeign+1,prebeign+1+lengthOfLeft,inorder,inbegin,rootIndex,map);
        root.right=generateTree(preorder,prebeign+1+lengthOfLeft,preend,inorder,rootIndex+1,inend,map);
        return root;
    }
    public static  int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }else if(root.right==null){
            return getHeight(root.left)+1;
        } else if (root.left==null) {
            return getHeight(root.right)+1;
        }else{
            return Math.max(getHeight(root.left),getHeight(root.right))+1;
        }
    }

}

class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val){
        this.val= val;
    }
    public TreeNode(char val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

