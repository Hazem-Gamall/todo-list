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
    private EntrySpec spec;
    
    public Entry(EntrySpec spec){
        this.spec = spec;
    }

    public EntrySpec getSpec(){
        return spec;
    }
    
}
