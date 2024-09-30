package cuvevide;

public class Process extends Thread {
    public long delay = 5000;
    public Aspiration aspirationThread = new Aspiration(delay);
    public Repressurisation repressurisationThread = new Repressurisation(delay);

    @Override
    public void run() {
        aspirationThread.start();
        try {
            aspirationThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Aspiration terminée");

        try {
            sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        repressurisationThread.start();
        try {
            repressurisationThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProccesType() {
        if (aspirationThread.isAlive()) {
            return "Aspiration";
        } else if (repressurisationThread.isAlive()) {
            return "Repressurisation";
        } else {
            return "Unknown";
        }
    }
}