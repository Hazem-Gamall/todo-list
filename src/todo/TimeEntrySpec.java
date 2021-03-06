/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.JSONObject;

/**
 *
 * @author hazem
 */
public class TimeEntrySpec extends EntrySpec implements Remindable{
    private LocalDateTime dateTime;
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("d/M/yyyy H:m");
    private final Type type = Type.DATETIME;
    private boolean called;
    
    public TimeEntrySpec(String title, String date, String time){
        super(title);
        called = false;
        
        dateTime = LocalDateTime.parse(date + " " + time, format);
    }
    
    public String getDate(){
        return dateTime.format(DateTimeFormatter.ofPattern("d/M/yyyy"));
    }
    
    public String getTime(){
        return dateTime.format(DateTimeFormatter.ofPattern("H:m"));
    }
    
    @Override
    public boolean check(LocalDateTime dt){
        LocalDateTime d = LocalDateTime.parse(dt.format(format),format);
        return dateTime.isEqual(d);
    }
    
    @Override 
    public void done(){
        called = true;
    }
    
    @Override 
    public boolean isDone(){
        return called;
    }
    
    @Override
    public String toString(){
        return super.toString() + " " + dateTime;
    }
    
    @Override
    public JSONObject toObject(){
        JSONObject obj = super.toObject();
        obj.put("date", getDate());
        obj.put("time", getTime());
        obj.put("type", type.ordinal());
        return obj;
    }
}
