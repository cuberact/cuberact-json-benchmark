/*
 * Copyright 2017 Michal Nikodim
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cuberact.json.benchmark;

/**
 * @author Michal Nikodim (michal.nikodim@gmail.com)
 */
class BenchmarkText {

    static String benchmarkHeader() {
        return "--------------------------------------------\n" +
                "BENCHMARK - JSON DESERIALIZATION FROM STRING\n" +
                "--------------------------------------------\n" +
                "Warm up:";
    }

    static String gcAndWaitText() {
        return "\nSystem.gc() and sleep for 5 sec\n";
    }

    static String benchmarkIterationHeader(int iteration, int max) {
        return "BENCHMARK - iteration " + iteration + "/" + max + " ************************************************************";
    }

    static String separatorLine() {
        return "-------------------------------------------------------------------------------------";
    }

    static String resultHeader() {
        return "\nRESULT: *****************************************************************************\n";
    }
}
