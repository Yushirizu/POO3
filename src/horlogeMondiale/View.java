package horlogeMondiale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JTextField txtFieldHour;
    private JCheckBox chkBoxUpdate;
    private JLabel lblVille;
    private JPanel content;
    private boolean checked=false;

    public View(String ville, int delay) {
        Horloge horloge = new Horloge(ville, delay, this);
        chkBoxUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checked = chkBoxUpdate.isSelected();
            }
        });
    }

    public boolean isChecked(){
        return checked;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2,2));
        //create 4 views and add them to the frame
        View view1 = new View("Europe/Paris", 2000);
        View view2 = new View("America/New_York", 1000);
        View view3 = new View("Asia/New_Delhi", 5000);
        View view4 = new View("Asia/Beijing", 3000);

        for (View view : new View[]{view1, view2, view3, view4}) {
            frame.add(view.content);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void setTxtFieldHour(String heure){
        txtFieldHour.setText(heure);
    }

    public void setLblVille(String ville){
        lblVille.setText(ville);
    }
}
