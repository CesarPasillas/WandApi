package com.magonono.wandapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;

/**
 * Created for the WandApi project.
 *
 * @author Cesar "Aran" Pasillas
 */
@SpringBootApplication
public class WandApiApplication {

    public static void main(String[] args) {
       //SpringApplication.run(WandApiApplication.class, args);
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(WandApiApplication.class)
                .headless(false).web(WebApplicationType.NONE).run(args);

        /*EventQueue.invokeLater(() -> {
            WandApiFrame ex = ctx.getBean(WandApiFrame.class);
            ex.setVisible(true);
        });*/

    }

    //@EventListener(ContextRefreshedEvent.class)
    public void launchJFrame() {
        // Run JFrame on the Swing UI thread (Event Dispatch Thread)
        // Launch your JFrame window
        javax.swing.SwingUtilities.invokeLater(WandApiFrame::new);
    }

}
