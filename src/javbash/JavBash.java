/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javbash;

import com.jcraft.jsch.Session;
import com.pastdev.jsch.DefaultSessionFactory;
import com.pastdev.jsch.command.CommandRunner;

import java.util.HashMap;
import java.util.Map;


// http://www.jcraft.com/jsch/examples de ayuda
public class JavBash {
    public static void main(String[] args) throws Exception {
        
        DefaultSessionFactory sessionFactory = new DefaultSessionFactory(
                "user", "10.24.135.44", 22
        ); 
        
        
        Map props = new HashMap<String, String>();
        props.put("StrictHostKeyChecking", "no");
        sessionFactory.setConfig(props);
        sessionFactory.setPassword("lapassaca");

        CommandRunner runner = new CommandRunner(sessionFactory);

        String command = "ls -al";
        CommandRunner.ExecuteResult result = runner.execute(command);

        if (result.getStderr().isEmpty()) {
            System.out.println(result.getStdout());
        } else {
            System.out.println(result.getStderr());
        }

        runner.close();
    }
}
