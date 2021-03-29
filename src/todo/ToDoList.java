/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hazem
 */
public class ToDoList {
    private List<Entry> entries;
    
    public ToDoList(List entries){
        this.entries = entries;
    }
    public ToDoList(){
        entries = new ArrayList<Entry>();
    }
    
    public void add(Entry entry){
        entries.add(entry);
    }
    
    public void edit(int index, Entry entry){
        entries.set(index-1, entry);
    }
    public void delete(int index){
        entries.remove(index-1);
    }
    
    public Entry getEntry(int index){
        return entries.get(index-1);
    }
    
    public List<Entry> getEntries(){
        return entries;
    }
}
