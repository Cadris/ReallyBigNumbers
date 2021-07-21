/**
   * A class to help benchmark code
   * It simulates a real stop watch
   */
  public class Stopwatch_Nano {

    private long startTime = -1;
    private long stopTime = -1;
    private boolean running = false;

    public Stopwatch_Nano start() {
       startTime = System.nanoTime();
       running = true;
       return this;
    }
    public Stopwatch_Nano stop() {
       stopTime = System.nanoTime();
       running = false;
       return this;
    }
    /** returns elapsed time in Nanoseconds
      * if the watch has never been started then
      * return zero
      */
    public long getElapsedTime() {
       if (startTime == -1) {
          return 0;
       }
       if (running){
       return System.nanoTime() - startTime;
       } else {
       return stopTime-startTime;
       } 
    }

    public Stopwatch_Nano reset() {
       startTime = -1;
       stopTime = -1;
       running = false;
       return this;
    }
}