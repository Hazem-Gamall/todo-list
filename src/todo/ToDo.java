/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
/**
 *
 * @author hazem
 */
public class ToDo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  


        System.out.println("\t\t\t\tWelcome");
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        
        ToDoList list = new ToDoList(); 
        try{
            list = ListParser.getInstance().parse("test.json");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        Reminder reminder = new Reminder(list);
        reminder.runReminder();
        System.out.println("\nCreate(c)"
                + "\tdate(cd)\tdateTime(ct)"
                + "\tEdit(e)\t\t"
                + "Delete(d)\n");
        
        
        boolean run = true;
        
        while(run){
            
            list.display();
            
            switch(sc.next()){
                case "c":
                    System.out.print("title:");
                    String title = sc.next();
                    list.add(new EntrySpec(title));
                    System.out.println("");
                    break;
                case "cd":
                    System.out.print("title:");
                    title = sc.next();
                    System.out.print("\ndate:");
                    String date = sc.next();
                    list.add(new DateEntrySpec(title, date));
                    break;
                case "ct":
                    System.out.print("title:");
                    title = sc.next();
                    System.out.print("\ndate:");
                    date = sc.next();
                    System.out.print("time:");
                    String time = sc.next();
                    list.add(new TimeEntrySpec(title, date, time));
                    break;
                    
                case "e":
                    System.out.print("index:");
                    int index = sc.nextInt();
                    System.out.print("\ntitle:");
                    title = sc.next();
                    list.edit(index, new EntrySpec(title));
                    break;
                default:
                    System.out.println("Unrecognized command try again.");

            }
            try{
            ListWriter.getInstance().write("test.json", list);
            }catch(IOException e){
            }
            
        }
        
    }
    
}
