/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hazem
 */
public class TimeEntrySpec extends EntrySpec implements Remindable{
    private LocalDateTime dateTime;
    private DateTimeFormatter format;
    
    public TimeEntrySpec(String title, String dt){
        super(title);
        format = DateTimeFormatter.ofPattern("d/M/yyyy H:m");
        dateTime = LocalDateTime.parse(dt, format);
    }
    
    @Override
    public boolean check(LocalDateTime dt){
        LocalDateTime d = LocalDateTime.parse(dt.format(format),format);
        return dateTime.isEqual(d);
    }
    
    @Override
    public String toString(){
        return super.toString() + dateTime;
    }
}
