/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.time.LocalDateTime;
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
                    if(entrySpec.check(LocalDateTime.now()) && !entrySpec.isCalled()){
                        entrySpec.call();
                        alarm(i.getSpec().getTitle());
                    }
                }
            }
        }
    }, 0, 1000);
        
    }
    
    public void alarm(String title){
        try{
        Runtime.getRuntime().exec("notify-send -t 1000 -u critical " + title);
        }catch(Exception e){}
    }
}
