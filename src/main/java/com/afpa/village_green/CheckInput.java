/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.village_green;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author 80010-04-09
 */
public class CheckInput {

    protected TextField txtField;
    protected Label errorLabel;
    protected String errorMessage;
    protected String regexPattern = null;
    protected boolean isNeeded;

    public CheckInput(TextField txtField, Label errorLabel, String errorMessage) {
        this.txtField = txtField;
        this.errorLabel = errorLabel;
        this.errorMessage = String.format("Veuillez renseigner %s", errorMessage);
        this.isNeeded = true;
    }
    
    public CheckInput(TextField txtField, Label errorLabel, String errorMessage, String regexPattern) {
        this(txtField, errorLabel, errorMessage);
        this.regexPattern = regexPattern;
    }

    public String getStringInput(MissFormatException ex){
        if (this.isNeeded) {
            String txt = txtField.getText();
            if (txt.isEmpty()){
                ex.addCheckInput(this);
            }
            if (regexPattern != null) {
                Pattern pattern = Pattern.compile(regexPattern);
                Matcher matcher = pattern.matcher(txt);
                if (!matcher.find()){
                    ex.addCheckInput(this);
                }
            }
            return txt;
        }
        return "";
    }
    
    public int getIntInput(MissFormatException ex) {
        if (this.isNeeded) {
            try {
                return Integer.parseInt(txtField.getText());        
            } catch(NumberFormatException e){
                ex.addCheckInput(this);
            }
        }
        return 0;
    }
        
    public double getDoubleInput(MissFormatException ex){
        if (this.isNeeded) {
            try {
                return Double.parseDouble(txtField.getText());        
            } catch(NumberFormatException e){
                ex.addCheckInput(this);
            }
        }
        return 0;
    }
    
    public void setErrorMode() {
        System.err.println(String.format("Error: %s", errorMessage));
        txtField.setStyle("-fx-border-color:red");
        errorLabel.setText(errorMessage);
    }
    
    public void resetStyle() {
        txtField.setStyle("");
        errorLabel.setText("");
    }
    
    public TextField getTxtField() {
        return txtField;
    }

    public void setTxtField(TextField txtField) {
        this.txtField = txtField;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isIsNeeded() {
        return isNeeded;
    }

    public void setIsNeeded(boolean isNeeded) {
        this.isNeeded = isNeeded;
    }
    
    public static List<CheckInput> createCheckInputList(CheckInput ...inputs){
        ArrayList<CheckInput> outList = new ArrayList<>();
        for (CheckInput ci : inputs) {
            outList.add(ci);
        }
        return outList;
    }
}