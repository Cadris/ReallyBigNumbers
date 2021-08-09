# ReallyBigNumbers

## About
Java Programs for handling Really Big Numbers. That is number of characters it can interact with is <br>
1. At default is : 100 characters 
2. It can also take in Custom sizes if decided by the user.
3. It is also auto-tuned to match the user's need as passed on during creation.
<br>

Special Classes  **For Benchmarking Time**
1. Stopwatch_Milli - For Measuring In **Miliseconds**
2. Stopwatch_Nano - For Measuring In **Nanoseconds**
<br>

 **Classes In Stopwatch Classes** (Same For Both the classes)

|Function Signature|Use|
|--------|-------------|
|start()|To Start the Stopwatch|
|stop()|To Stop the Stopwatch|
|getElapsedTime()|returns elapsed time in Nanoseconds if the watch has never been started then return zero|

**Constructors of ReallyBigDecimal**
|Constructor Signature|Its Function|
|----------|--------------|
|ReallyBigDecimal()|Innitalises a ReallyBigDecimal with 0(Zero) value.|
|ReallyBigDecimal(String _number)|Innitalises a ReallyBigDecimal With the Number Passed As the (_number). If it is not a number it throws a NumberFormatException. |
|ReallyBigDecimal(ReallyBigDecimal obj)|Innitalises a ReallyBigDecimal Creates a Clone of the Really Big number Passed as the Parameter.|

**Note** : Any Kind of Help is very useful and rewarding.

**Devoloper's Notes** : add(number1, number2) works. Yea !!!!!!!!
