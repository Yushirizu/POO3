package cuvevide;

public class Process extends Thread {
    private static final long DELAY = 50;
    public Aspiration aspirationThread = new Aspiration(DELAY);
    public boolean force = false;
    public Repressurisation repressurisationThread = new Repressurisation(DELAY, force);
    public Pression pressionThread = new Pression();

    @Override
    public void run() {
        super.run();
        try {
            pressionThread.start();
            aspirationThread.start();
            aspirationThread.join();

            sleep(30);

            repressurisationThread.start();
            repressurisationThread.join();
            pressionThread.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            repressurasationforcee();
        }
    }

    public void repressurasationforcee(){
        force = true;
        repressurisationThread.start();
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

    public void sendStop() {
        this.interrupt();
    }
}