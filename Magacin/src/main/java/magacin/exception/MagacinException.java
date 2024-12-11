/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.exception;

/**
 *
 * @author Lazar Lazarevic
 */
public class MagacinException extends Exception {
    
    public MagacinException(String message) {
        super(message);
    }
    
    public MagacinException(String message, Throwable cause) {
        super(message, cause);
    }
}