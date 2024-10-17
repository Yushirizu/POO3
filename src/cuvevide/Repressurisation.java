package cuvevide;

public class Repressurisation extends Thread{
    private final long delay;
    private static final int STEPS = 10;
    private boolean force = false;
    public Repressurisation(long delay, boolean force) {
        this.force = force;
        this.delay = delay;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < STEPS; i++) {
            try {
                this.setName("Repressurisation " + (i+1));
                System.out.println(getName() + " commence la repressurisation");
                if(!force){
                    sleep(delay);
                    System.out.println(getName()+ " a fini la repressurisation");
                    sleep(delay);
                }
                else {
                    System.out.println(getName()+ " a fini la repressurisation");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
