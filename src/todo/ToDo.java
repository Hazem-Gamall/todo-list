/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
        
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("name", "Sayed");
        map.put("type", Type.NONE);
        
        list.add(new Entry(map));
        
        System.out.println("\nto Create a new entry use the command c or cd for date, ct for datetime"
                + "\nto Edit an entry use the command e followed by entry number"
                + "\nto Delete an entry use the command d followed by the entry number\n");
        
        
        boolean run = true;
        
        while(run){
            
            displayer.display();
            LinkedHashMap<String, Object> entryMap = new LinkedHashMap<>();
            switch(sc.next()){
                case "c":
                    System.out.println("please enter the name of the entry");
                    entryMap.put("name", sc.next());
                    entryMap.put("type", Type.NONE);
                    list.add(new Entry(entryMap));
                    break;
                case "cd":
                    System.out.println("please enter the name of the entry and the date(yyyy-MM-dd)");
                    entryMap.put("name", sc.next());
                    entryMap.put("date", sc.next());
                    entryMap.put("type", Type.DATE);
                    list.add(new Entry(entryMap));
                    break;
                case "ct":
                    System.out.println("please enter the name of the entry, the date and the time(yyyy-MM-ddThh:mm:ss)");
                    entryMap.put("name", sc.next());
                    entryMap.put("date", sc.next());
                    entryMap.put("time", sc.next());
                    entryMap.put("type", Type.DATETIME);

                    list.add(new Entry(entryMap));
                    break;
                case "e":
                    System.out.println("please enter the number of the entry");
                    int index = sc.nextInt();
                    Entry temp = list.getEntry(index);
                    switch((Type)temp.getProperty("type")){
                        
                        case NONE:
                            System.out.println("please enter the new name");
                            temp.setProperty("name", sc.next());
                            break;
                        case DATE:
                            System.out.println("please enter the new name and date");
                            temp.setProperty("name", sc.next());
                            temp.setProperty("date", sc.next());
                        case DATETIME:
                            System.out.println("please enter new name, date and time");
                            temp.setProperty("name", sc.next());
                            temp.setProperty("date", sc.next());
                            temp.setProperty("time", sc.next());
                            break;
                        default:
                            System.out.println("Unrecognized type");
                    }
                    break;
                    
                case "d":
                    System.out.println("please enter the index of the entry");
                    list.delete(sc.nextInt());
                    break;
                case "q":
                    run = false;
                    break;
                default:
                    System.out.println("Unrecognized command try again.");

            }
        }
        
    }
    
}
