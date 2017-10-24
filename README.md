# cuberact-json-benchmark

### sample result

```

--------------------------------------------
BENCHMARK - JSON DESERIALIZATION FROM STRING
--------------------------------------------
Warm up:
INPUT: JSON as String - data type: RANDOM, size: 1812474 chars
       CUBERACT_JSON - 0.010662250 sec [169.990 mega chars per sec]
           FAST_JSON - 0.016002646 sec [113.261 mega chars per sec]
    JACKSON_DATABIND - 0.016784381 sec [107.986 mega chars per sec]
                GSON - 0.017258877 sec [105.017 mega chars per sec]
         JSON_SIMPLE - 0.030768406 sec [ 58.907 mega chars per sec]
            ORG_JSON - 0.025169284 sec [ 72.011 mega chars per sec]
             JSON_IO - 0.035626075 sec [ 50.875 mega chars per sec]

System.gc() and sleep for 5 sec

BENCHMARK - iteration 1/1 ************************************************************
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: FROM RESOURCE /small-real-data.json, size: 14572 chars
       CUBERACT_JSON - 0.000409047 sec [ 35.624 mega chars per sec]
           FAST_JSON - 0.000591518 sec [ 24.635 mega chars per sec]
    JACKSON_DATABIND - 0.000512743 sec [ 28.420 mega chars per sec]
                GSON - 0.000535281 sec [ 27.223 mega chars per sec]
         JSON_SIMPLE - 0.000892117 sec [ 16.334 mega chars per sec]
            ORG_JSON - 0.000609454 sec [ 23.910 mega chars per sec]
             JSON_IO - 0.001405697 sec [ 10.366 mega chars per sec]
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: FROM RESOURCE /middle-real-data.json, size: 169076 chars
       CUBERACT_JSON - 0.002351061 sec [ 71.915 mega chars per sec]
           FAST_JSON - 0.003138803 sec [ 53.866 mega chars per sec]
    JACKSON_DATABIND - 0.002259944 sec [ 74.814 mega chars per sec]
                GSON - 0.002729274 sec [ 61.949 mega chars per sec]
         JSON_SIMPLE - 0.002867767 sec [ 58.957 mega chars per sec]
            ORG_JSON - 0.003619767 sec [ 46.709 mega chars per sec]
             JSON_IO - 0.006759855 sec [ 25.012 mega chars per sec]
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: FROM RESOURCE /big-real-data.json, size: 1861784 chars
       CUBERACT_JSON - 0.008588806 sec [216.769 mega chars per sec]
           FAST_JSON - 0.009685167 sec [192.230 mega chars per sec]
    JACKSON_DATABIND - 0.010195061 sec [182.616 mega chars per sec]
                GSON - 0.011403896 sec [163.259 mega chars per sec]
         JSON_SIMPLE - 0.021617549 sec [ 86.124 mega chars per sec]
            ORG_JSON - 0.022362945 sec [ 83.253 mega chars per sec]
             JSON_IO - 0.031810984 sec [ 58.526 mega chars per sec]
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 118 chars
       CUBERACT_JSON - 0.000046305 sec [  2.548 mega chars per sec]
           FAST_JSON - 0.000065603 sec [  1.799 mega chars per sec]
    JACKSON_DATABIND - 0.000138220 sec [  0.854 mega chars per sec]
                GSON - 0.000061878 sec [  1.907 mega chars per sec]
         JSON_SIMPLE - 0.000052069 sec [  2.266 mega chars per sec]
            ORG_JSON - 0.000053238 sec [  2.216 mega chars per sec]
             JSON_IO - 0.000280525 sec [  0.421 mega chars per sec]
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 2002 chars
       CUBERACT_JSON - 0.000091828 sec [ 21.802 mega chars per sec]
           FAST_JSON - 0.000136975 sec [ 14.616 mega chars per sec]
    JACKSON_DATABIND - 0.000217382 sec [  9.210 mega chars per sec]
                GSON - 0.000146331 sec [ 13.681 mega chars per sec]
         JSON_SIMPLE - 0.000205131 sec [  9.760 mega chars per sec]
            ORG_JSON - 0.000189621 sec [ 10.558 mega chars per sec]
             JSON_IO - 0.000409714 sec [  4.886 mega chars per sec]
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 14595 chars
       CUBERACT_JSON - 0.000313228 sec [ 46.595 mega chars per sec]
           FAST_JSON - 0.000452160 sec [ 32.278 mega chars per sec]
    JACKSON_DATABIND - 0.000499887 sec [ 29.197 mega chars per sec]
                GSON - 0.000600597 sec [ 24.301 mega chars per sec]
         JSON_SIMPLE - 0.000963125 sec [ 15.154 mega chars per sec]
            ORG_JSON - 0.000828713 sec [ 17.612 mega chars per sec]
             JSON_IO - 0.001170695 sec [ 12.467 mega chars per sec]
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 1488247 chars
       CUBERACT_JSON - 0.010771607 sec [138.164 mega chars per sec]
           FAST_JSON - 0.011875252 sec [125.323 mega chars per sec]
    JACKSON_DATABIND - 0.012153909 sec [122.450 mega chars per sec]
                GSON - 0.011785881 sec [126.274 mega chars per sec]
         JSON_SIMPLE - 0.021607191 sec [ 68.877 mega chars per sec]
            ORG_JSON - 0.022741264 sec [ 65.443 mega chars per sec]
             JSON_IO - 0.024147720 sec [ 61.631 mega chars per sec]
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 14464760 chars
       CUBERACT_JSON - 0.059638150 sec [242.542 mega chars per sec]
           FAST_JSON - 0.082849969 sec [174.590 mega chars per sec]
    JACKSON_DATABIND - 0.100856644 sec [143.419 mega chars per sec]
                GSON - 0.114471596 sec [126.361 mega chars per sec]
         JSON_SIMPLE - 0.211939209 sec [ 68.250 mega chars per sec]
            ORG_JSON - 0.173017021 sec [ 83.603 mega chars per sec]
             JSON_IO - 0.239503663 sec [ 60.395 mega chars per sec]

RESULT: *****************************************************************************

1. [wins: 7]          CUBERACT_JSON - 0.082210032 sec [219.136 mega chars per sec]
2. [wins: 0]              FAST_JSON - 0.108795447 sec [165.587 mega chars per sec]
3. [wins: 1]       JACKSON_DATABIND - 0.126833790 sec [142.037 mega chars per sec]
4. [wins: 0]                   GSON - 0.141734734 sec [127.105 mega chars per sec]
5. [wins: 0]               ORG_JSON - 0.223422023 sec [ 80.633 mega chars per sec]
6. [wins: 0]            JSON_SIMPLE - 0.260144158 sec [ 69.251 mega chars per sec]
7. [wins: 0]                JSON_IO - 0.305488853 sec [ 58.972 mega chars per sec]
```