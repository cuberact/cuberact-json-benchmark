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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author Michal Nikodim (michal.nikodim@gmail.com)
 */
class BenchmarkInput {

    private String jsonAsString;
    private String type;

    BenchmarkInput(int randomSize) {
        jsonAsString = new RandomJson(randomSize).generate();
        type = "RANDOM";
    }

    BenchmarkInput(String resource) {
        jsonAsString = readAsString(resource);
        type = "FROM RESOURCE " + resource;
    }

    String getJsonAsString() {
        return jsonAsString;
    }

    @Override
    public String toString() {
        return "INPUT: JSON as String - data type: " + type + ", size: " + jsonAsString.length() + " chars";
    }

    private static String readAsString(String resource) {
        Reader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(BenchmarkInput.class.getResourceAsStream(resource), "utf-8"));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } catch (Throwable t) {
            throw new RuntimeException("Failed read resource '" + resource + "'", t);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Throwable t) {
                throw new RuntimeException("Unable to close stream", t);
            }
        }
    }
}
