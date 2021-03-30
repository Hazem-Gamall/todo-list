/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

/**
 *
 * @author hazem
 */
public class EntrySpec {
    String title;
    
    public EntrySpec(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }
    
    @Override
    public String toString(){
        return title;
    }
}
