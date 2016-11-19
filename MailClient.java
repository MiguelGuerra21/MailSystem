/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    
    private boolean automatic;
    
    private String automaticMessage;
    
    private String automaticSubject;

    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
        automatic = false;
        automaticMessage = "I can´t receive any message right now";
        automaticSubject = "I´m on holidays";
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {   
        MailItem chisme = server.getNextMailItem(user);
        if (automatic == true){
                System.out.println(automaticMessage + automaticSubject);
            }
        else{
            chisme = server.getNextMailItem(user);
        }
        return chisme;
        }
    
    /**
     * Print the next mail item (if any) for this user to the text 
     * terminal.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else {
            item.print();
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to, String subject, String message)
    {
        MailItem item = new MailItem(user, to, subject, message);
        server.post(item);
    }
    /**
     * Se pide que implementes un método en la clase MailClient que permita saber desde un cliente de correo electrónico cuántos emails tenemos en el servidor para nosotros y que dicha información se muestre por pantalla. Importante: los correos no deben ser descargados del servidor.
     */
    public void getEmails(){
        int mails;
        mails = server.howManyMailItems(user);
        System.out.println("You have" + mails + "Emails");
    }
    public void automaticAnswerOnOff ()
    {
        if(automatic == false){
            automatic = true;
        }
        if (automatic == true){
            automatic = false;
        }
    }

}