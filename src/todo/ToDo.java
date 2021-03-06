/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
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
       
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        
        ToDoList list = new ToDoList(); 
        try{
            list = ListParser.getInstance().parse("data.json");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        Reminder reminder = new Reminder(list);
        reminder.runReminder();
        
        
        boolean run = true;
        
        while(run){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  


        System.out.println("\nCreate(c)"
                + "\tDate(cd)\tDateTime(ct)"
                + "\tEdit(e)\t\t"
                + "Delete(d)\t"
                + "Quit(q)\n");
        
            
            list.display();
            try{
                switch(sc.next()){
                    case "c":
                        System.out.print("Title:");
                        String title = sc.next();
                        list.add(new EntrySpec(title));
                        System.out.println("");
                        break;
                    case "cd":
                        System.out.print("Title:");
                        title = sc.next();
                        System.out.print("\nDate:");
                        String date = sc.next();
                        list.add(new DateEntrySpec(title, date));
                        break;
                    case "ct":
                        System.out.print("Title:");
                        title = sc.next();
                        System.out.print("\nDate:");
                        date = sc.next();
                        System.out.print("Time:");
                        String time = sc.next();
                        list.add(new TimeEntrySpec(title, date, time));
                        break;

                    case "e":
                        System.out.print("Index:");
                        int index = sc.nextInt();
                        System.out.print("\nTitle:");
                        title = sc.next();
                        EntrySpec spec = list.get(index).getSpec();
                        title = (("".equals(title) || " ".equals(title))?spec.getTitle() : title);
                        if(spec instanceof DateEntrySpec){
                            System.out.print("\nDate:");
                            date = sc.next();
                            date = (("".equals(date) || " ".equals(date))?((DateEntrySpec)spec).getDate() : date);
                            list.edit(index, new DateEntrySpec(title, date));

                        }else if(spec instanceof TimeEntrySpec){
                            System.out.print("\nDate:");
                            date = sc.next();
                            date = (("".equals(date) || " ".equals(date))?((TimeEntrySpec)spec).getDate() : date);
                            System.out.print("\nTime:");
                            time = sc.next();
                            time = (("".equals(time) || " ".equals(time))?((TimeEntrySpec)spec).getTime(): time);
                            list.edit(index, new TimeEntrySpec(title, date, time));

                        }else{
                            list.edit(index, new EntrySpec(title));
                        }

                        break;

                    case "d":
                        System.out.print("Index:");
                        index = sc.nextInt();
                        list.delete(index);
                        break;
                        
                    case "q":
                        run = false;
                        reminder.cancel();
                        break;
                    default:
                        System.out.println("Unrecognized command try again.");
  
                }
                ListWriter.getInstance().write("data.json", list);
            }
            catch(InputMismatchException e){
                System.out.println("Error: Bad Input");
                sc.next();
            }
            catch(IOException e){
                System.out.println("Error: " + e.getMessage());
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        }
        
    }
    
}
