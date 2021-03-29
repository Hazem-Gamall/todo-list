/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author hazem
 */
public class Entry {
    private Map<String, Object> properties;
    
    public Entry(Map<String, Object> properties){
        if(properties == null){
            this.properties = new LinkedHashMap<>();
        }else{
            this.properties = new LinkedHashMap<>(properties);
        }
        
    }

    public Object getProperty(String propertyName){
        return properties.get(propertyName);
    }
    
    public void setProperty(String propertyName, Object obj){
        properties.put(propertyName, obj);
    }
    
    public Map<String, Object> getProperties(){
        return properties;        
    }
    
    @Override
    public String toString(){
        String result = "";
        for(Object i : properties.keySet()){
            String propertyName = (String)i;
            if(propertyName.equals("type"))  continue;
            result += properties.get(propertyName);
            result += " ";
        }
        return result;
    }
    
}
