/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import assignment.pkg2.Path.Node;




/**
 *
 * @author Talat Zubair
 */
public class EditDistance 
{
     /**
     *
     */
    private static Path p;
    private static int[][] table;
    
    public static Path Match(String a, String b)
    {
        int m = a.length();
        int n = b.length(); 
        int cost = 0;
        
        if ( m == 0 || n == 0)
        {
            System.exit(0);                      //if either string is empty
        }
        
        p = new Path();                         //initialize new linkedlist
        table = new int [m+1][n+1];             //initialize new 2-D array
       
        for (int i = 0; i <= m; i++)            
        {
            table[i][0] = i;                    //to fill the first row 
        }
        for (int i = 0; i <= n; i++)
        {
            table[0][i] = i;                    //to fill the first column
        }
        
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (a.charAt(i-1) == b.charAt(j-1))
                {
                    table[i][j] = table[i-1][j-1];              
                    //when characters are same, cost = cost(diagonal)
                }
                else if (a.charAt(i-1) != b.charAt(j-1))
                {                    
                    table[i][j] = 1 + GetMinimum(table[i-1][j-1], table[i-1][j], table[i][j-1]);
                    //when characters are not same, pick the minimum element and add 1
                }
           }            
        } 
 
        //BACKTRACKING
        int i = m;
        int j = n;
        while(i > 0 || j> 0)
        {
            if(i > 0 && j > 0 && a.charAt(i-1) == b.charAt(j-1))
            {
                //if there is no change; both elements are same
                p.AddNode(i-1, j-1, 0, a.charAt(i-1), b.charAt(j-1));
                i = i - 1;
                j = j - 1;
            }
            else if(j > 0 && table[i][j] == table[i][j-1]+1)
            {
                //deletion with cost 1;
                //p.AddNode(i, j, 1, ' ', ' ');
                cost = cost + 1;
                j = j - 1;
            }
            else if(i > 0 && j > 0 && table[i][j] == table[i-1][j-1]+1)
            {
                //substitute b[j-1] with a[i-1] with cost 1;
                cost = cost + 1;
                p.AddNode(i, j, 1, a.charAt(i-1), b.charAt(j-1));
                i = i - 1;
                j = j - 1;
            }
            else if(i > 0 && table[i][j] == table[i-1][j]+1)
            {
                //insertion with cost 2
                cost = cost + 2;
                p.AddNode(i, j, 2, a.charAt(i-1), '_');
                i = i - 1;
            }
        }
        System.out.println("Edit Distance: " + cost);
        return p;
    }

    
    private static int GetMinimum(int num1, int num2, int num3) 
    {
       int num = Math.min(num1, num2);
       int minimum = (Math.min(num3, num));
       return minimum;
    }
   
}




