/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import org.json.JSONObject;

/**
 *
 * @author hazem
 */
public class EntrySpec {
    String title;
    Type type;
    
    public EntrySpec(String title){
        this.title = title;
        type = Type.NONE;
    }
    
    public String getTitle(){
        return title;
    }
    
    @Override
    public String toString(){
        return title;
    }
    
    public JSONObject toObject(){
        JSONObject obj = new JSONObject();
        obj.put("title", title);
        obj.put("type", type.ordinal());

        return obj;
    }
}
