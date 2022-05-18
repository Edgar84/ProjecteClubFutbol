
package utils;

import java.io.Serializable;


public class Email implements Serializable{
    
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public Email() {
    }

    public void setEmail(String email) {
        if(validarEmail(email)){
            this.email = email;
        }else {
            System.out.println("Email incorrecte");
        }
        
    }
    

    public String getEmail() {
        return email;
    }
    
    public boolean validarEmail(String email){
        return email.contains("@") && email.substring(email.indexOf("@")).contains(".");
    }
    
    // Override

    @Override
    public String toString() {
        return this.getEmail();
    }
    
}
