/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

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
    
    public void add(EntrySpec spec){
        entries.add(new Entry(spec));
    }
    
    public void edit(int index, EntrySpec spec){
        entries.set(index-1, new Entry(spec));
    }
    public void delete(int index){
        entries.remove(index-1);
    }
    
    public List<Entry> getEntries(){
        return entries;
    }
    
    public void display(){
        for(int i = 0; i < entries.size(); i++){
            System.out.print(i+1 + "-");
            System.out.println(entries.get(i).getSpec());
        }
    }
    public JSONObject getObject(){
        JSONObject obj = new JSONObject();
        JSONArray objArray = new JSONArray();
        
        for(Entry entry : entries){
            
            JSONObject tmpObj = new JSONObject();
            EntrySpec spec = entry.getSpec();
            tmpObj.put("title", spec.getTitle());
            if(spec instanceof DateEntrySpec){
                tmpObj.put("date", ((DateEntrySpec) spec).getDate());
            }else if(spec instanceof TimeEntrySpec){
                tmpObj.put("date", ((TimeEntrySpec) spec).getDate());
                tmpObj.put("time", ((TimeEntrySpec) spec).getTime());
            }
            objArray.put(tmpObj);
        }
        obj.put("entries", objArray);
        return obj;
    }
}
