/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.raja.niruraji.pa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Rajaram Kaliyaperumal
 * @since 2016-05-09
 * @version 0.1
 */

public class SenderTest {    
    
    private final static Logger LOGGER = LogManager.getLogger(SenderTest.class);
     
    static void writeToFile(String msg) {         
        BufferedWriter output = null;         
        try {
            URL url = Resources.getResource("pa");
            output = new BufferedWriter(new FileWriter(url.getPath())); 
            output.write(msg);      
            output.close(); 
        } catch (IOException ex) { 
            LOGGER.error("Error writing file, Msg = " + ex.getMessage());
        }
     }
    
    public static void main(String args[]) {         
        ConnectionConfiguration connConfig = new ConnectionConfiguration(            
                 "talk.google.com", 5222, "gmail.com"); 
        XMPPConnection connection = new XMPPConnection(connConfig);
        try {
            connection.connect(); 
            System.out.println("Connected to " + connection.getHost());
        } catch (XMPPException ex) { 
            System.out.println("Failed to connect to " + connection.getHost());
            System.exit(1);        
         } 
        try { 
            connection.login("rajireturn@gmail.com", "seegmail"); 
            System.out.println("Logged in as " + connection.getUser());
            Presence presence = new Presence(Presence.Type.available); 
            connection.sendPacket(presence);
        } catch (XMPPException ex) {  
            System.out.println("Failed to log in as " + connection.getUser());
            System.exit(1);
        }
        ChatManager chatmanager = connection.getChatManager();
        Chat paChat = chatmanager.createChat("rr.kaliyaperumal@gmail.com",
                new MessageListener() {
                    public void processMessage(Chat chat, Message message) { 
                        if(message.getType() == Message.Type.chat) { 
                            String msgBody = message.getBody();
                            System.out.println(
                                    chat.getParticipant() + " says: " + 
                                            message.getBody());
                            if(msgBody != null && 
                                    (msgBody.toLowerCase()).contains("hello")){
                                writeToFile("true");
                            }
                        }
                    }
                });
        
        try {        
            boolean stopService = false;        
            while(!stopService) {            
                URL url = Resources.getResource("pa");            
                String text = Resources.toString(url, Charsets.UTF_8);  
                boolean sendMsg = Boolean.parseBoolean(text);
                if(sendMsg) {
                    writeToFile("false");
                    paChat.sendMessage("Test message from NiruRajiPA");
                    System.out.println("Message Sent...");
            }
        }
    }
    catch (Exception e) {
        System.out.println("Error Delivering block");
    }   

    }
}