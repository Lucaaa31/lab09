package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import it.unibo.mvc.Controller;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private File file = new File("/home/luca/Desktop/lab09/93-simple-mvc-io/Prova.txt");


    public SimpleGUI(Controller controller) {
        JTextArea area = new JTextArea();
        JButton button = new JButton("Save");
        area.setLineWrap(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SimpleGUI");
        frame.setSize(400, 360);
        frame.add(area);
        frame.add(button, BorderLayout.SOUTH);
        
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Controller controller = new Controller();
                

                controller.currentFile(file);
                
                try {
                    controller.saveInFile(area.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
            
        });
    }

    public void display(){
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }


    private static SimpleGUI SimpleGUI() {
        return null;
    }

}
