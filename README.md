# cuberact-json-benchmark

### sample result

```

   CUBERACT_JSON - org.cuberact:cuberact-json:1.2.0
       FAST_JSON - com.alibaba:fastjson:1.2.38
JACKSON_DATABIND - com.fasterxml.jackson.core:jackson-databind:2.9.1
            GSON - com.google.code.gson:gson:2.8.2

--------------------------------------------
BENCHMARK - JSON DESERIALIZATION FROM STRING
--------------------------------------------
Warm up:
INPUT: JSON as String - data type: RANDOM, size: 1812474 chars
       CUBERACT_JSON - 0.012589924 sec [143.962 MegaChar/s] min/avg/max = 0.008140000 / 0.012590600 / 0.049663000 sec
           FAST_JSON - 0.018723549 sec [ 96.802 MegaChar/s] min/avg/max = 0.010384000 / 0.018723600 / 0.128447000 sec
    JACKSON_DATABIND - 0.018185014 sec [ 99.669 MegaChar/s] min/avg/max = 0.012872000 / 0.018183733 / 0.076671000 sec
                GSON - 0.019798526 sec [ 91.546 MegaChar/s] min/avg/max = 0.014816000 / 0.019798133 / 0.067647000 sec

System.gc() and sleep for 5 sec

BENCHMARK - iteration 1/1 ************************************************************
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: FROM RESOURCE /small-real-data.json, size: 14572 chars
       CUBERACT_JSON - 0.000371144 sec [ 39.262 MegaChar/s] min/avg/max = 0.000088000 / 0.000370680 / 0.002837000 sec
           FAST_JSON - 0.000587461 sec [ 24.805 MegaChar/s] min/avg/max = 0.000118000 / 0.000586990 / 0.008287000 sec
    JACKSON_DATABIND - 0.000405503 sec [ 35.936 MegaChar/s] min/avg/max = 0.000107000 / 0.000405040 / 0.004747000 sec
                GSON - 0.000474259 sec [ 30.726 MegaChar/s] min/avg/max = 0.000199000 / 0.000473740 / 0.001601000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: FROM RESOURCE /middle-real-data.json, size: 169076 chars
       CUBERACT_JSON - 0.002286637 sec [ 73.941 MegaChar/s] min/avg/max = 0.000617000 / 0.002286560 / 0.003069000 sec
           FAST_JSON - 0.003363936 sec [ 50.261 MegaChar/s] min/avg/max = 0.001503000 / 0.003363970 / 0.004139000 sec
    JACKSON_DATABIND - 0.002269286 sec [ 74.506 MegaChar/s] min/avg/max = 0.000621000 / 0.002269270 / 0.002905000 sec
                GSON - 0.003581370 sec [ 47.210 MegaChar/s] min/avg/max = 0.001815000 / 0.003581290 / 0.004115000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: FROM RESOURCE /big-real-data.json, size: 1861784 chars
       CUBERACT_JSON - 0.008477870 sec [219.605 MegaChar/s] min/avg/max = 0.006064000 / 0.008477680 / 0.025167000 sec
           FAST_JSON - 0.011212709 sec [166.042 MegaChar/s] min/avg/max = 0.008100000 / 0.011212380 / 0.031647000 sec
    JACKSON_DATABIND - 0.008776398 sec [212.135 MegaChar/s] min/avg/max = 0.005804000 / 0.008776280 / 0.021807000 sec
                GSON - 0.010682445 sec [174.284 MegaChar/s] min/avg/max = 0.008208000 / 0.010682560 / 0.031103000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 118 chars
       CUBERACT_JSON - 0.000033453 sec [  3.527 MegaChar/s] min/avg/max = 0.000011000 / 0.000032950 / 0.000091000 sec
           FAST_JSON - 0.000049809 sec [  2.369 MegaChar/s] min/avg/max = 0.000010000 / 0.000049250 / 0.000164000 sec
    JACKSON_DATABIND - 0.000113331 sec [  1.041 MegaChar/s] min/avg/max = 0.000036000 / 0.000112780 / 0.000259000 sec
                GSON - 0.000054996 sec [  2.146 MegaChar/s] min/avg/max = 0.000022000 / 0.000054570 / 0.000450000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 2002 chars
       CUBERACT_JSON - 0.000078550 sec [ 25.487 MegaChar/s] min/avg/max = 0.000030000 / 0.000078050 / 0.000184000 sec
           FAST_JSON - 0.000120039 sec [ 16.678 MegaChar/s] min/avg/max = 0.000084000 / 0.000119490 / 0.000283000 sec
    JACKSON_DATABIND - 0.000194682 sec [ 10.283 MegaChar/s] min/avg/max = 0.000102000 / 0.000194230 / 0.000477000 sec
                GSON - 0.000128877 sec [ 15.534 MegaChar/s] min/avg/max = 0.000048000 / 0.000128390 / 0.000309000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 14595 chars
       CUBERACT_JSON - 0.000301602 sec [ 48.392 MegaChar/s] min/avg/max = 0.000160000 / 0.000301100 / 0.000451000 sec
           FAST_JSON - 0.000434465 sec [ 33.593 MegaChar/s] min/avg/max = 0.000232000 / 0.000433950 / 0.000563000 sec
    JACKSON_DATABIND - 0.000522994 sec [ 27.907 MegaChar/s] min/avg/max = 0.000295000 / 0.000522510 / 0.001057000 sec
                GSON - 0.000597080 sec [ 24.444 MegaChar/s] min/avg/max = 0.000304000 / 0.000596570 / 0.004279000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 1488247 chars
       CUBERACT_JSON - 0.009662127 sec [154.029 MegaChar/s] min/avg/max = 0.006552000 / 0.009662320 / 0.027615000 sec
           FAST_JSON - 0.010298010 sec [144.518 MegaChar/s] min/avg/max = 0.008776000 / 0.010298120 / 0.028655000 sec
    JACKSON_DATABIND - 0.013591926 sec [109.495 MegaChar/s] min/avg/max = 0.008616000 / 0.013591760 / 0.034975000 sec
                GSON - 0.016073377 sec [ 92.591 MegaChar/s] min/avg/max = 0.011448000 / 0.016073680 / 0.036799000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 14464760 chars
       CUBERACT_JSON - 0.069896075 sec [206.947 MegaChar/s] min/avg/max = 0.064192000 / 0.069898080 / 0.115967000 sec
           FAST_JSON - 0.093160949 sec [155.266 MegaChar/s] min/avg/max = 0.088000000 / 0.093162880 / 0.116991000 sec
    JACKSON_DATABIND - 0.112016577 sec [129.131 MegaChar/s] min/avg/max = 0.104768000 / 0.112014400 / 0.143231000 sec
                GSON - 0.126488492 sec [114.356 MegaChar/s] min/avg/max = 0.117248000 / 0.126489920 / 0.149887000 sec

RESULT: *****************************************************************************

1. [wins: 7]          CUBERACT_JSON - 0.091107458 sec [197.735 MegaChar/s] 
2. [wins: 0]              FAST_JSON - 0.119227378 sec [151.099 MegaChar/s] 
3. [wins: 1]       JACKSON_DATABIND - 0.137890697 sec [130.648 MegaChar/s] 
4. [wins: 0]                   GSON - 0.158080896 sec [113.962 MegaChar/s]
```