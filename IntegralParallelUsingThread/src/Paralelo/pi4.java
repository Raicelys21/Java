package Paralelo;

class pi4 extends Thread{
	
	private final int threadCount;
    private final int threadRemainder;
    private final int N;
    private double sum  = 0;

    public pi4(int threadCount, int threadRemainder, int n) {
        this.threadCount = threadCount;
        this.threadRemainder = threadRemainder;
        N = n;
    }


    @Override
    public void run() {
        for (int i = 0; i <= N; i++) {
            if (i % threadCount == threadRemainder) {
                sum += Math.pow(-1, i) / (2 * i + 1);
            }
        }
    }

    public double getSum() {
        return sum;
    }

}


