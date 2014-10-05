/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgsuper;

/**
 *
 * @author Danna
 */



public class Super {
     public static void throwit() 
    {
        throw new RuntimeException();
    }

  public static void main (String [] args) 
    {
        Object o = new Object() /* Line 5 */
        {
            public boolean equals(Object obj) 
            {
                return true;
            } 
        }      
        
        System.out.println(o.equals("Fred"));
    }
    
}
