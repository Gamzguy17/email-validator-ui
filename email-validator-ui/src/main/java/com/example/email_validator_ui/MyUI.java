package com.example.email_validator_ui;

import javax.servlet.annotation.WebServlet;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
//Import ContentMode for HTML support for labels
import com.vaadin.shared.ui.label.ContentMode;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        //Short greeting and declaration of my four rules
        Label welcome = new Label("<h1>Welcome!</h1><h2>The rules are as follows:</h2>", ContentMode.HTML);
        Label rule1 = new Label("1. Contains ONLY one @");
        Label rule2 = new Label("2. Contains at least one \".\"");
        Label rule3 = new Label("3. Contains no spaces");
        Label rule4 = new Label("4. Contains no number from 0-9 at the beginning");
        layout.addComponent(welcome);
        layout.addComponent(rule1);
        layout.addComponent(rule2);
        layout.addComponent(rule3);
        layout.addComponent(rule4);
        
        //Textbox
        final TextField inputAddress = new TextField();
        inputAddress.setCaption("Type your email address here:");
        
        //Submit Button
        Button button = new Button("Submit Address");
        //Per each submission, display the input address and how many rules it passed
        button.addClickListener( e -> {
            layout.addComponent(new Label("<b>" + '"' + inputAddress.getValue() + '"' + " passed a total of " + 
            		validEmail.validate(inputAddress.getValue()) + "/4 rules.</b>", ContentMode.HTML));
            layout.addComponent(new Label(""));
        });
        
        layout.addComponents(inputAddress, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
