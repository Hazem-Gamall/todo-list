/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.util.Scanner;

/**
 *
 * @author hazem
 */
public class ToDo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\t\tWelcome");
        Scanner sc = new Scanner(System.in);
        ToDoList list = new ToDoList();
        ListDisplayer displayer = new ListDisplayer(list);
        
        list.add(new Entry("Sayed", "25/6/2021"));
        
        System.out.println("\nto Add an entry use the command a"
                + "\nto Edit an entry use the command e followed by entry number"
                + "\nto Delete an entry use the command d followed by the entry number\n");
        
        displayer.display();
        
    }
    
}
