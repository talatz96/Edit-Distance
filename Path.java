/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

/**
 *
 * @author Talat Zubair
 */
public class Path 
{
    private Node head;
    
    public class Node
    {
        public int row, col;        // the row and column this node represents
        public int cost;            // the matching cost upto this point
        public Node next;           // the next node in the optimal path  
        public char elememtA;       // element from string 1
        public char elememtB;       // element from string 2
    
        
        public Node(int row, int col, int cost, char elementA, char elementB)
        {
            this.row = row;
            this.col = col;
            this.cost = cost;
            this.elememtA = elementA;
            this.elememtB = elementB;
            this.next = null;
        }
    }
    
    
    public void AddNode(int row, int col, int cost, char elementA, char elementB)
    {
        Node current = new Node(row, col, cost, elementA, elementB);
        current.next = head;
        head = current;
    }
        
    
    public void PrintList()
    {
       Node temp = head; 
       while (temp != null) 
       { 
            System.out.println(temp.elememtA + "   " + temp.elememtB + "   " + temp.cost); 
            temp = temp.next; 
       } 
    }
}
