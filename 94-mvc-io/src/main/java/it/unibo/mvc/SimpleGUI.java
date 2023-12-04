package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    SimpleController controller = new SimpleController();

  

    public SimpleGUI(SimpleController controller) {
        this.controller = controller;
        JTextField textField = new JTextField();
        JTextArea textArea = new JTextArea();
        JPanel panel = new JPanel(new BorderLayout());
        JPanel lowerPanel = new JPanel(new BorderLayout());
        JButton print = new JButton("Print");
        JButton history = new JButton("Show history");


        textArea.setLineWrap(true);
        textArea.setEditable(false);

        lowerPanel.add(print, BorderLayout.WEST);
        lowerPanel.add(history, BorderLayout.EAST);

        panel.add(textField, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(lowerPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setTitle("SimpleGUI");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                SimpleGUI.this.controller.setNextStringToPrint(textField.getText());
                SimpleGUI.this.controller.printCurrentString();
            }
            
        });

        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            for (String string : controller.getHistory()) {
                textArea.append(string);
                textArea.append("\n");
            }
            }
            
        });

    }


    public static void main(String[] args) {
        SimpleGUI gui = new SimpleGUI(new SimpleController());
        gui.display();
    }

    public void display(){
        frame.setVisible(true);
    }

}
