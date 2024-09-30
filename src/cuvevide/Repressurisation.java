package cuvevide;

public class Repressurisation extends Thread{
    private final long delay;

    public Repressurisation(long delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                this.setName("Repressurisation " + (i+1));
                System.out.println(getName() + " commence la repressurisation");
                sleep(delay);
                System.out.println(getName()+ " a fini la repressurisation");
                sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
