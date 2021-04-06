/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author hazem
 */
public class Reminder {
    private ToDoList list;
    private Timer timer;

    
    public Reminder(ToDoList list){
        this.list = list;
        timer = new Timer();
    }
    
    public void runReminder(){
        timer.scheduleAtFixedRate(new TimerTask(){

        @Override
        public void run(){
            for(Entry i : list.getEntries()){
                if(i.getSpec() instanceof Remindable){
                    Remindable entrySpec = (Remindable)i.getSpec();
                    long rate = 0;
                    if(entrySpec instanceof TimeEntrySpec){
                        LocalTime l = LocalTime.parse(((TimeEntrySpec)i.getSpec()).getTime(), DateTimeFormatter.ofPattern("H:m"));
                        rate = LocalTime.now().until(l, ChronoUnit.SECONDS);
                    }
                    if(rate == 1800  || rate == 600 || rate == 0 && !entrySpec.isDone()){
//                        if(entrySpec instanceof DateEntrySpec || entrySpec.check(LocalDateTime.now()) ) entrySpec.done();
                        if(rate == 0)
                            entrySpec.done();
                        alert(i.getSpec().getTitle(), rate/60);
                    }
                }
            }
        }
    }, 0, 1000);
        
    }
    
    
    public void alert(String title, long rate){
        try{
//            Runtime.getRuntime().exec("notify-send -u critical " + "\"" + " minutes left for " + title + " \"");
            Runtime.getRuntime().exec(new String[]{"notify-send", "-u", "critical", "todo", rate + " minutes " + " until " + title});
            Runtime.getRuntime().exec("aplay " + "notification.wav");
        }catch(Exception e){}
    }
}
