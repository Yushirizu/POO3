package synchro.Fichier;

import java.io.IOException;

public class FilesWirteres extends Thread {
    private int id = 0;
    private final Main main;

    public FilesWirteres(int id, Main main) {
        this.id = id;
        this.main = main;
        start();
    }

    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                int random = (int) (Math.random() * 1000);
                Thread.sleep(random);
                String message = "Thread " + id + " " + random + " : Occurrence " + i;
                main.write(message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}