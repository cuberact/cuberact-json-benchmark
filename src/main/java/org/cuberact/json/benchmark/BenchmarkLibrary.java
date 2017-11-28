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

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cuberact.json.parser.JsonParser;

import java.io.IOException;

/**
 * @author Michal Nikodim (michal.nikodim@gmail.com)
 */
public enum BenchmarkLibrary {

    CUBERACT_JSON(new JsonLibrary() {
        JsonParser jsonParser = new JsonParser();

        @Override
        public Object deserialize(String jsonAsString) throws IOException {
            return jsonParser.parse(jsonAsString);
        }
    }),
    FAST_JSON(JSON::parse),
    JACKSON_DATABIND(new JsonLibrary() {
        ObjectMapper mapper = new ObjectMapper();

        @Override
        public Object deserialize(String jsonAsString) throws IOException {
            return mapper.readTree(jsonAsString);
        }
    }),
    GSON(new JsonLibrary() {
        com.google.gson.JsonParser gsonParser = new com.google.gson.JsonParser();

        @Override
        public Object deserialize(String jsonAsString) throws Throwable {
            return gsonParser.parse(jsonAsString);
        }
    });

    private final JsonLibrary jsonLibrary;
    private String indentedName = null;

    BenchmarkLibrary(JsonLibrary jsonLibrary) {
        this.jsonLibrary = jsonLibrary;
    }

    public JsonLibrary getJsonLibrary() {
        return jsonLibrary;
    }

    public String indentedName() {
        if (indentedName == null) {
            int maxLen = 0;
            for (BenchmarkLibrary lib : BenchmarkLibrary.values()) {
                if (lib.name().length() > maxLen) {
                    maxLen = lib.name().length();
                }
            }
            for (BenchmarkLibrary lib : BenchmarkLibrary.values()) {
                StringBuilder sb = new StringBuilder("  ");
                for (int i = lib.name().length(); i < maxLen; i++) {
                    sb.append(" ");
                }
                sb.append(lib.name());
                lib.indentedName = sb.toString();
            }
        }
        return indentedName;
    }

    public interface JsonLibrary {

        Object deserialize(String jsonAsString) throws Throwable;
    }

}
