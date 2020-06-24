package Servico;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Denner Dias
 */
public class EmailTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        
        Email email = new Email("Senha e Usuário Sistema Service Desk", 
                "Segue usuário e senha para acesso ao sistema BarberShop.\n"+"Usuario:user\n"+"Senha: user", 
                "carlosferreira.jlle@gmail.com");
        
        email.enviar();
        

    }
    
}
