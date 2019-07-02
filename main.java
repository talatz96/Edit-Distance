/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;
import java.util.*;

/**
 *
 * @author Talat Zubair
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
       
      //  while (true)
        //{
            
            String a = input.next();
            String b = input.next();
            
            EditDistance e = new EditDistance();
            Path p = e.Match(a,b);
            p.PrintList();
   //    }
    
    
    }
}
