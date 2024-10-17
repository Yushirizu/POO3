package cuvevide;

import javax.swing.*;
import java.awt.event.FocusAdapter;

public class View extends Thread {
    private JButton startButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panel;
    private JTextField textField3;
    private JButton stopButton;
    private Process process = new Process();
    private final JFrame frame = new JFrame("View");

    public void creatUi() {
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
        startButton.addActionListener(_ -> {
            if (process.getState() == Thread.State.NEW) {
                process.start();
            } else {
                if (process.getState() == Thread.State.TERMINATED) {
                    process = new Process();
                    process.start();
                } else {
                    JOptionPane.showMessageDialog(null, "Process already started");
                }
            }
        });
        panel.addFocusListener(new FocusAdapter() {
        });
        stopButton.addActionListener(_ -> {
                    process.sendStop();
                }
        );
    }

    public void refreshUi() {
        textField3.setText(process.getProccesType());
        if (process.getProccesType().equals("Aspiration"))
            textField1.setText(process.aspirationThread.getName());
        else
            textField1.setText(process.repressurisationThread.getName());
        textField2.setText(process.pressionThread.getPression() + "");
        frame.repaint();
    }

    @Override
    public void run() {
        creatUi();
        while (true) {
            refreshUi();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public View() {

    }

    public static void main(String[] args) {
        View thread = new View();
        thread.start();
    }
}