package cuvevide;

public class Pression extends Thread{
    private final long DELAY = 200;
    private int pression = 0;

    @Override
    public void run() {
        super.run();
        //nombre entre 0 et 100
        while (true){
            pression = (int) (Math.random() * 100);
            try {
                sleep(DELAY);
            } catch (InterruptedException e) {
                System.out.println("Pression interrompue");
            }
        }
    }

    public int getPression() {
        return pression;
    }
}
