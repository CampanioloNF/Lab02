package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    private AlienDictionary dizionario;
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    	dizionario = new AlienDictionary();
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	    	
    	String s = this.txtWord.getText().toLowerCase();
    	
    	String p[] = s.split(" ");
    	
    	boolean  ok = true;
    	
    	for(int i=0; i<p.length;i++) {
    		
    		char let[]  = p[i].toCharArray();
    		
    	   for(int j=0; j<let.length; j++) {
    		   
    		   if(!(let[j]>='a' && let[j]<='z')) {
    			   ok = false;
    		   }
    			   
    	   }
    		
    	}
    	
    	if(!ok) {
    		this.txtResult.appendText("Errore, inserire solo " + 
    				"le lettere alfabetiche, siano essere maiuscole o minuscole \n");
    	}
    	
    	else {
    		
    		if(p.length>2)
    			this.txtResult.appendText("Errore, inserire solo " + 
        				"la parola ricercata o la coppia <parolaAliene> <traduzione> \n");
    		
    		else if(p.length==2) {
    			this.dizionario.addWord(p[0], p[1]);
    			    
    		}
    		else if(p.length==1)
    		this.txtResult.appendText(this.dizionario.translateWord(p[0])+"\n");
    		
    	}
    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {

    	this.txtResult.clear();
    	
    }
    
}
