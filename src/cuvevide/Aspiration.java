package cuvevide;

public class Aspiration extends Thread{
    private final long delay;

    public Aspiration(long delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                this.setName("Aspiration " + (i+1));
                System.out.println(getName() + " commence l'aspiration");
                sleep(delay);
                System.out.println(getName()+ " a fini l'aspiration");
                sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
