/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author hazem
 */
public class ListWriter {
    private static ListWriter instance;
    
    public void write(String fileName, ToDoList list) throws IOException{
        JSONObject obj = new JSONObject();
        JSONArray objArray = new JSONArray();
        for(Entry i : list.getEntries()){
            objArray.put(i.getSpec().toObject());
        }
        obj.put("entries", objArray);
        
        FileWriter fw = new FileWriter(fileName);
        fw.write(obj.toString());
        fw.flush();
        fw.close();
        
    }
    
    public static ListWriter getInstance(){
        if(instance == null)
            return instance = new ListWriter(); 
        else
            return instance;
            
    }
}
