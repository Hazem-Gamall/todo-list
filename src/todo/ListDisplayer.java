/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.util.List;

/**
 *
 * @author hazem
 */
public class ListDisplayer {
    ToDoList list;
    
    public ListDisplayer(ToDoList list){
        this.list = list;
    }
    
    public void display(){
        List entries = list.getEntries();
        for(int i = 0; i < entries.size(); i++){
            System.out.println(i+1 + "-" + entries.get(i));
        }
    }
}
