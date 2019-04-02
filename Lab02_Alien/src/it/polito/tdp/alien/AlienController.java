package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary model;
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
        
    
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    	model = new AlienDictionary();
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	    	
    	String s = this.txtWord.getText().toLowerCase();
    	
    	String p[] = s.split(" ");
    	
    	boolean  ok = true;
    	
    	
    	int pos = -1;
    	
    	for(int i=0; i<p.length;i++) {
    		
    		char let[]  = p[i].toCharArray();
    		
    	   for(int j=0; j<let.length; j++) {
    		   
    		  
    		   if(let[j]=='?' && p.length==1 && pos==-1) {
    			   pos=j;
    			   
    		   }
    			   
    		   else if(!(let[j]>='a' && let[j]<='z')) {
    			   ok = false;
    		   }
    			   
    	   }
    		
    	}
    	
    	if(!ok) {
    		this.txtResult.appendText("Errore, inserire solo " + 
    				"le lettere alfabetiche, siano essere maiuscole o minuscole. \n"
    				+ "Si ricorda inoltre di inserire al massimo un '?' all'interno della parola aliena");
    	}
    	
    	else {
    		
    		if(p.length>2)
    			this.txtResult.appendText("Errore, inserire solo " + 
        				"la parola ricercata o la coppia <parolaAliene> <traduzione> \n");
    		
    		else if(p.length==2) {
    			this.model.addWord(p[0], p[1]);
    			    
    		}
    		else if(p.length==1) {
    		if(pos!=-1) {
    			
    			this.txtResult.appendText(this.model.parolaMisteriosa(p[0],pos)+"\n");
    			
    		}
    		else
    		   this.txtResult.appendText(this.model.translateWord(p[0])+"\n");
    		}	
    	}
    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {

    	this.txtResult.clear();
    	
    }


	public void setModel(AlienDictionary model) {
		this.model=model;
		
	}
    
}
