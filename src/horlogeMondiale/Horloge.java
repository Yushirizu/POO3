package horlogeMondiale;

import javax.swing.*;
import java.util.Calendar;
import java.util.TimeZone;

public class Horloge extends Thread {
    private String ville;
    private int delay;
    private View view;

    public Horloge(String ville, int delay,  View view) {
        this.ville = ville;
        this.delay = delay;
        this.view = view;
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(delay);
                if (view.isChecked()) {
                    view.setTxtFieldHour(getHeure());
                    view.setLblVille(ville);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getHeure() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone(ville));
        return cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    }
}