
public class Add extends Thread {
    private final int min;
    private final int max;
    Add(int min, int max){
        this.min = min;
        this.max = max;
    }
    @Override
    public void run(){
        for (int i = min; i < max; i++) {
            Main.result[i] = (int) Math.pow(Main.a[i] , Main.b[i]);
        }
    }
}
