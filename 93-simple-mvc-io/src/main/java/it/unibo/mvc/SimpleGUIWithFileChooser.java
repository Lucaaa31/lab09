package it.unibo.mvc;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();

    private File file = new File("/home/luca/Desktop/lab09/93-simple-mvc-io/Prova.txt");


    public SimpleGUIWithFileChooser(Controller controller) {
        JTextArea area = new JTextArea();
        JButton button = new JButton("Save");
        JPanel mainPanel = new JPanel(new BorderLayout());
        area.setLineWrap(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SimpleGUIWithFileChoser");
        frame.setSize(400, 360);
        frame.add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(area);
        mainPanel.add(button, BorderLayout.SOUTH);

        controller.currentFile(file);
        
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                try {
                    controller.saveInFile(area.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
            
        });

        JPanel upperPanel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField();
        JButton browse = new JButton("Browse...");
        upperPanel.add(textField);
        upperPanel.add(browse, BorderLayout.EAST);
        mainPanel.add(upperPanel, BorderLayout.NORTH);
        textField.setText(file.toString());
        textField.setEditable(false);

        JFileChooser chooser = new JFileChooser();

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int result = chooser.showOpenDialog(chooser);
                if (result == JFileChooser.APPROVE_OPTION) {
                    controller.currentFile(chooser.getSelectedFile());
                    textField.setText(controller.getFile().toString());
                }else{
                    if (result != JFileChooser.CANCEL_OPTION) {
                        JOptionPane.showMessageDialog(frame, "un casino", "CAZZO", result);
                    }
                }
                
            }
            
        });
        

    }

    public void display(){
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }

}
