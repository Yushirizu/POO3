package synchro.Fichier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    File fichier = new File("src/synchro/Fichier/output.txt");
    private boolean canWrite = true;

    public Main() throws IOException {
        if(fichier.exists()) {
            fichier.delete();
        }
        if(fichier.createNewFile()) {
            System.out.println("Fichier créé");
            for (int i = 0; i < 10; i++) {
                new FilesWirteres((i+1), this);
            }
        } else {
            System.out.println("Fichier non créé");
        }
    }

    public static void main(String[] args) {
        try {
            new Main();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void write(String message) throws IOException {
        while(!canWrite){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        canWrite = false;
        FileWriter fw = new FileWriter(fichier, true);
        fw.write(message + "\n");
        fw.flush();
        fw.close();
        
        canWrite = true;
        notify();
    }
}
