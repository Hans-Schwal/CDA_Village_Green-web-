/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.village_green;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 80010-04-09
 */
public class MissFormatException extends Exception{
    protected ArrayList<CheckInput> errorCheckInputs = new ArrayList<CheckInput>();
    

    
    public List<CheckInput> getErrorCheckInputs() {
        return errorCheckInputs;
    }
    
    public void addCheckInput(CheckInput checkInput) {
        errorCheckInputs.add(checkInput);
    }
    
    public boolean isEmpty() {
        return errorCheckInputs.isEmpty();
    }     
}
