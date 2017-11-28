# cuberact-json-benchmark

### sample result

```

--------------------------------------------
BENCHMARK - JSON DESERIALIZATION FROM STRING
--------------------------------------------
Warm up:
INPUT: JSON as String - data type: RANDOM, size: 1812474 chars
       CUBERACT_JSON - 0.010352135 sec [175.082 MegaChar/s] min/avg/max = 0.007892000 / 0.010351800 / 0.040319000 sec
           FAST_JSON - 0.015853464 sec [114.327 MegaChar/s] min/avg/max = 0.010264000 / 0.015852800 / 0.113023000 sec
    JACKSON_DATABIND - 0.017654380 sec [102.664 MegaChar/s] min/avg/max = 0.012824000 / 0.017654533 / 0.067135000 sec
                GSON - 0.018759408 sec [ 96.617 MegaChar/s] min/avg/max = 0.014088000 / 0.018759600 / 0.068671000 sec

System.gc() and sleep for 5 sec

BENCHMARK - iteration 1/1 ************************************************************
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: FROM RESOURCE /small-real-data.json, size: 14572 chars
       CUBERACT_JSON - 0.000128292 sec [113.585 MegaChar/s] min/avg/max = 0.000069000 / 0.000127820 / 0.001270000 sec
           FAST_JSON - 0.000179259 sec [ 81.290 MegaChar/s] min/avg/max = 0.000105000 / 0.000178770 / 0.001185000 sec
    JACKSON_DATABIND - 0.000192493 sec [ 75.701 MegaChar/s] min/avg/max = 0.000080000 / 0.000191990 / 0.001813000 sec
                GSON - 0.000137627 sec [105.880 MegaChar/s] min/avg/max = 0.000096000 / 0.000137130 / 0.000660000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: FROM RESOURCE /middle-real-data.json, size: 169076 chars
       CUBERACT_JSON - 0.000657264 sec [257.242 MegaChar/s] min/avg/max = 0.000586000 / 0.000656770 / 0.001035000 sec
           FAST_JSON - 0.000754074 sec [224.217 MegaChar/s] min/avg/max = 0.000700000 / 0.000753560 / 0.001068000 sec
    JACKSON_DATABIND - 0.000597147 sec [283.140 MegaChar/s] min/avg/max = 0.000543000 / 0.000596650 / 0.000828000 sec
                GSON - 0.000979642 sec [172.590 MegaChar/s] min/avg/max = 0.000900000 / 0.000979170 / 0.001753000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: FROM RESOURCE /big-real-data.json, size: 1861784 chars
       CUBERACT_JSON - 0.006472725 sec [287.635 MegaChar/s] min/avg/max = 0.005804000 / 0.006472960 / 0.013191000 sec
           FAST_JSON - 0.007767694 sec [239.683 MegaChar/s] min/avg/max = 0.007280000 / 0.007767660 / 0.015839000 sec
    JACKSON_DATABIND - 0.005946811 sec [313.073 MegaChar/s] min/avg/max = 0.005196000 / 0.005946660 / 0.016135000 sec
                GSON - 0.009251017 sec [201.252 MegaChar/s] min/avg/max = 0.008792000 / 0.009250960 / 0.013223000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 118 chars
       CUBERACT_JSON - 0.000012669 sec [  9.314 MegaChar/s] min/avg/max = 0.000003000 / 0.000012140 / 0.000111000 sec
           FAST_JSON - 0.000014451 sec [  8.166 MegaChar/s] min/avg/max = 0.000004000 / 0.000013930 / 0.000058000 sec
    JACKSON_DATABIND - 0.000039371 sec [  2.997 MegaChar/s] min/avg/max = 0.000016000 / 0.000038900 / 0.000120000 sec
                GSON - 0.000015589 sec [  7.569 MegaChar/s] min/avg/max = 0.000004000 / 0.000015090 / 0.000061000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 2002 chars
       CUBERACT_JSON - 0.000026591 sec [ 75.289 MegaChar/s] min/avg/max = 0.000014000 / 0.000026170 / 0.000067000 sec
           FAST_JSON - 0.000036523 sec [ 54.815 MegaChar/s] min/avg/max = 0.000020000 / 0.000035950 / 0.000118000 sec
    JACKSON_DATABIND - 0.000058797 sec [ 34.049 MegaChar/s] min/avg/max = 0.000030000 / 0.000058300 / 0.000255000 sec
                GSON - 0.000036357 sec [ 55.065 MegaChar/s] min/avg/max = 0.000022000 / 0.000035800 / 0.000074000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 14595 chars
       CUBERACT_JSON - 0.000089916 sec [162.318 MegaChar/s] min/avg/max = 0.000067000 / 0.000089350 / 0.000156000 sec
           FAST_JSON - 0.000115184 sec [126.710 MegaChar/s] min/avg/max = 0.000090000 / 0.000114700 / 0.000223000 sec
    JACKSON_DATABIND - 0.000134309 sec [108.667 MegaChar/s] min/avg/max = 0.000097000 / 0.000133790 / 0.000312000 sec
                GSON - 0.000148614 sec [ 98.207 MegaChar/s] min/avg/max = 0.000123000 / 0.000148160 / 0.000230000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 1488247 chars
       CUBERACT_JSON - 0.006602290 sec [225.414 MegaChar/s] min/avg/max = 0.006268000 / 0.006602420 / 0.010903000 sec
           FAST_JSON - 0.008725486 sec [170.563 MegaChar/s] min/avg/max = 0.008312000 / 0.008725520 / 0.012631000 sec
    JACKSON_DATABIND - 0.009168465 sec [162.322 MegaChar/s] min/avg/max = 0.008480000 / 0.009168600 / 0.017679000 sec
                GSON - 0.011858860 sec [125.497 MegaChar/s] min/avg/max = 0.011336000 / 0.011858760 / 0.016895000 sec
-------------------------------------------------------------------------------------
INPUT: JSON as String - data type: RANDOM, size: 14464760 chars
       CUBERACT_JSON - 0.065815141 sec [219.779 MegaChar/s] min/avg/max = 0.063232000 / 0.065813760 / 0.092223000 sec
           FAST_JSON - 0.085865471 sec [168.458 MegaChar/s] min/avg/max = 0.082368000 / 0.085864960 / 0.112191000 sec
    JACKSON_DATABIND - 0.108329867 sec [133.525 MegaChar/s] min/avg/max = 0.103616000 / 0.108328320 / 0.130303000 sec
                GSON - 0.118484032 sec [122.082 MegaChar/s] min/avg/max = 0.113920000 / 0.118481280 / 0.145919000 sec

RESULT: *****************************************************************************

1. [wins: 6]          CUBERACT_JSON - 0.079804888 sec [225.740 MegaChar/s]
2. [wins: 0]              FAST_JSON - 0.103458142 sec [174.130 MegaChar/s]
3. [wins: 2]       JACKSON_DATABIND - 0.124467260 sec [144.738 MegaChar/s]
4. [wins: 0]                   GSON - 0.140911738 sec [127.847 MegaChar/s]
```