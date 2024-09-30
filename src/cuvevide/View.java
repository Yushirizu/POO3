package cuvevide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

public class View extends Thread {
    private JButton startButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panel;
    private JTextField textField3;
    private JButton refreshButton;
    public Process process = new Process();
    public JFrame frame = new JFrame("View");

    public void creatUi() {
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                process.start();
            }
        });
        panel.addFocusListener(new FocusAdapter() {
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshUi();
            }
        });
    }

    public void refreshUi() {
        textField3.setText(process.getProccesType());
        if (process.getProccesType().equals("Aspiration"))
            textField1.setText(process.aspirationThread.getName());
        else
            textField1.setText(process.repressurisationThread.getName());
        frame.repaint();
    }

    @Override
    public void run() {
        creatUi();
    }

    public View() {

    }

    public static void main(String[] args) {
        View thread = new View();
        thread.start();
    }
}