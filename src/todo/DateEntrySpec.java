/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hazem
 */
public class DateEntrySpec extends EntrySpec implements Remindable{
    private LocalDate date;
    private DateTimeFormatter format;
    
    public DateEntrySpec(String title, String date){
        super(title);
        format = DateTimeFormatter.ofPattern("d/M/yyyy");
        this.date = LocalDate.parse(date, format);
    }
    
    @Override
    public boolean check(LocalDateTime dt){
        return date.equals(dt.toLocalDate());
    }
    
    @Override
    public String toString(){
        return super.toString() + " " + date;
    }
}
