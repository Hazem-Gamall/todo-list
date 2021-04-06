/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author hazem
 */
public interface Remindable {
    boolean check(LocalDateTime dt);
    boolean isDone();
    void done();
}
