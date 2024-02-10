package com.example.productservice;


/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;
public class Main
{
    public static void main(String[] args) {
        ArrayList<Integer>keys=new ArrayList<>();
        keys.add(2);
        keys.add(1);
        keys.add(3);
        keys.add(4);
   keys.add(5);
       keys.add(6);
        keys.add(7);
        creatBst(keys);
    }

    public static void creatBst(List<Integer>keys)
    {
        TreeNode root=new TreeNode(keys.get(0));
        for(int i=1;i<keys.size();i++)
            System.out.println(findcount(root,keys.get(i)));
    }
    public static int findcount(TreeNode root, int val)
    {
        TreeNode temp=root,prev=null;
        int count=0;
        while(temp!=null)
        {
            prev=temp;
            if(temp.val>val)
                temp=temp.left;
            else
                temp=temp.right;
            count+=1;
        }
        TreeNode node=new TreeNode(val);
        if(prev.val>val)
            prev.left=node;
        else prev.right=node;
        return count;
    }
}
