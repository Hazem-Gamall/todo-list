/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONObject;
import java.nio.file.*;
import org.json.JSONArray;
/**
 *
 * @author hazem
 */
public class ListParser {
    private static ListParser parser;
    private ListParser(){}
    
    public ToDoList parse(String fileName) throws FileNotFoundException, IOException{
              
        ToDoList list = new ToDoList();
        
        JSONObject object = readObject(fileName);
        
        JSONArray entries = (JSONArray)object.get("entries");

        for(Object i : entries){
            list.add(toEntrySpec((JSONObject)i));
        }
        return list;
    }
    
    private JSONObject readObject(String fileName) throws FileNotFoundException, IOException{
        
        File file = new File(fileName);
        if(Files.notExists(Paths.get(fileName))){
            file.createNewFile();
        }
        
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\z");
        
        JSONObject object = new JSONObject(scanner.next());
        
        return object;
        
    }
    
    private EntrySpec toEntrySpec(JSONObject obj){
        if(obj.getInt("type") == Type.NONE.ordinal())
                return new EntrySpec(obj.getString("title"));
        if(obj.getInt("type") == Type.DATE.ordinal())
                return new DateEntrySpec(obj.getString("title"), obj.getString("date"));
        if(obj.getInt("type") == Type.DATETIME.ordinal())
                return new TimeEntrySpec(obj.getString("title"), obj.getString("date"), obj.getString("time"));
        return null;
    }
    
    public static ListParser getInstance(){
        if(parser == null)
            return parser = new ListParser();
        
        return parser;
    }
    
}
