package Paralelo;

import Paralelo.pi4;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		double tiempo1, tiempo2, total;
		tiempo1 = System.currentTimeMillis();
		
		for(int threadCount = 40; threadCount <= 800; threadCount += 40)
		{
			int N = 1000000;
		    pi4[] threads = new pi4[threadCount];
		    for (int i = 0; i < threadCount; i++) {
		        threads[i] = new pi4(threadCount, i, N);
		        threads[i].start();
		    }
		    for (int i = 0; i < threadCount; i++) {
		        threads[i].join();
		    }
		    double pi = 0;
		    for (int i = 0; i < threadCount; i++) {
		        pi += threads[i].getSum();
		    }
		    
		    tiempo2 = System.currentTimeMillis();
		    total = tiempo2 - tiempo1;
		    
		    System.out.println("# de hilos " + threadCount + "; La integral paralela tardó " + total + " millis");
		}
		
	    
 
	    //System.out.print("PI/4 = " + pi);

	}

}
