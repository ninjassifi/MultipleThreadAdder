import java.util.ArrayList;
public class Main {
    // Point of this project is to see if doing single thread or multiple thread is better
    static long startTime;
    static int threads = 8;
    static int sizeOfArr = 200_000_000;
    public static int[] a = new int[sizeOfArr];
    public static int[] b = new int[sizeOfArr];
    public static int[] result = new int[sizeOfArr];

    public static void main(String[] args) throws InterruptedException {

        // Init a and b

        start();
        for(int i = 0; i < sizeOfArr; i++) {
            a[i] = (int)(Math.random() * 10);
            b[i] = (int)(Math.random() * 9);
        }
        end("Init vars: ");

        // Start multiple thread timer
        start();
        ArrayList<Add> add = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            add.add(new Add(i * (sizeOfArr / threads),  (i + 1) * (sizeOfArr / threads)));
            add.get(i).start();
        }
        for (int i = 0; i < threads; i++) {
            add.get(i).join();
        }
        //System.out.println(Arrays.toString(result));
        end("Multiple threads: ");

        // Start single thread timer
        start();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < sizeOfArr; i++) {
            result[i] = (int) Math.pow(a[i] , b[i]);
        }
        //System.out.println(Arrays.toString(result));
        end("Single thread: ");
    }

    static void start(){
        startTime = System.currentTimeMillis();
    }
    static void end(String prompt){
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(prompt + " (" + elapsedTime + "ms)");
    }
}