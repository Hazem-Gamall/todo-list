/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.JSONObject;

/**
 *
 * @author hazem
 */
public class DateEntrySpec extends EntrySpec implements Remindable{
    private LocalDate date;
    private DateTimeFormatter format;
    private Type type;
    private boolean called;
    
    public DateEntrySpec(String title, String date){
        super(title);
        type = Type.DATE;
        called = false;
        format = DateTimeFormatter.ofPattern("d/M/yyyy");
        this.date = LocalDate.parse(date, format);
    }
    
    public String getDate(){
        return date.format(format);
    }
    
    @Override
    public boolean check(LocalDateTime dt){
        return date.isEqual(dt.toLocalDate());
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
        return super.toString() + " " + date;
    }
    
    @Override
    public JSONObject toObject(){
        JSONObject obj = super.toObject();
        obj.put("date", getDate());
        obj.put("type", type.ordinal());

        return obj;
    }
}
