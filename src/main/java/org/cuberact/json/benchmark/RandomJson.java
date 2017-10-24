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

import org.cuberact.json.JsonArray;
import org.cuberact.json.JsonObject;
import org.cuberact.json.formatter.JsonFormatter;

import java.util.Random;

/**
 * @author Michal Nikodim (michal.nikodim@gmail.com)
 */
class RandomJson {

    private final static char[] randomStringChars = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789 !@#$%^&*()\b\f\n\r\t ".toCharArray();
    private final static char[] randomAttrNameChars = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789 ".toCharArray();

    private final Random random = new Random(1); //fixed seed
    private final int targetBytes;
    private int bytes = 0;

    RandomJson(int targetBytes) {
        this.targetBytes = targetBytes;
    }

    String generate() {
        JsonArray root = new JsonArray();
        bytes += 2;
        randomizeArray(root, 0);
        String result = root.toString(JsonFormatter.PRETTY());
        return replaceSomeCharsWithUnicodeEquivalent(result);
    }

    private String replaceSomeCharsWithUnicodeEquivalent(String result) {
        result = result.replace("B", "\\u0042");
        result = result.replace("V", "\\u0056");
        result = result.replace("X", "\\u0058");
        return result;
    }

    private void randomizeArray(JsonArray array, int deep) {
        int count = random.nextInt(50) + 50;
        for (int i = 0; i < count; i++) {
            int rndType = random.nextInt(80);
            if (rndType < 10 && deep < 10) {
                JsonArray child = new JsonArray();
                array.add(child);
                randomizeArray(child, deep + 1);
                bytes += 3;
            } else if (rndType < 20 & deep < 10) {
                JsonObject child = new JsonObject();
                array.add(child);
                randomizeObject(child, deep + 1);
                bytes += 3;
            } else if (rndType < 30) {
                String value = randomString();
                array.add(value);
                bytes += value.length() + 3;
            } else if (rndType < 40) {
                String value = randomString();
                array.add(value);
                bytes += value.length() + 3;
            } else if (rndType < 50) {
                Long value = (long) random.nextInt(100000);
                array.add(value);
                bytes += value.toString().length() + 1;
            } else if (rndType < 60) {
                Double value = random.nextDouble() * 10000;
                array.add(value);
                bytes += value.toString().length() + 1;
            } else if (rndType < 70) {
                Boolean value = random.nextInt(100) < 50;
                array.add(value);
                bytes += value.toString().length() + 1;
            } else if (rndType < 80) {
                array.add(null);
                bytes += 4;
            }
            if (bytes > targetBytes) break;
        }
    }

    private void randomizeObject(JsonObject object, int deep) {
        int count = random.nextInt(50) + 50;
        for (int i = 0; i < count; i++) {
            int rndType = random.nextInt(80);
            String attrName = randomAttrName();
            if (rndType < 10 && deep < 10) {
                JsonArray child = new JsonArray();
                object.add(attrName, child);
                randomizeArray(child, deep + 1);
                bytes += attrName.length() + 6;
            } else if (rndType < 20 && deep < 10) {
                JsonObject child = new JsonObject();
                object.add(attrName, child);
                randomizeObject(child, deep + 1);
                bytes += attrName.length() + 6;
            } else if (rndType < 30) {
                String value = randomString();
                object.add(attrName, value);
                bytes += attrName.length() + value.length() + 6;
            } else if (rndType < 40) {
                String value = randomAttrName();
                object.add(attrName, value);
                bytes += attrName.length() + value.length() + 6;
            } else if (rndType < 50) {
                Long value = (long) random.nextInt(100000);
                object.add(attrName, value);
                bytes += attrName.length() + value.toString().length() + 4;
            } else if (rndType < 60) {
                Double value = random.nextDouble() * 10000;
                object.add(attrName, value);
                bytes += attrName.length() + value.toString().length() + 4;
            } else if (rndType < 70) {
                Boolean value = random.nextInt(100) < 50;
                object.add(attrName, value);
                bytes += attrName.length() + value.toString().length() + 4;
            } else if (rndType < 80) {
                object.add(attrName, null);
                bytes += attrName.length() + 7;
            }
            if (bytes > targetBytes) break;
        }
    }

    private String randomAttrName() {
        StringBuilder sb = new StringBuilder();
        int count = random.nextInt(20) + 10;
        for (int i = 0; i < count; i++) {
            sb.append(randomAttrNameChars[random.nextInt(randomAttrNameChars.length)]);
        }
        return sb.toString();
    }

    private String randomString() {
        StringBuilder sb = new StringBuilder();
        int count = random.nextInt(100) + 30;
        for (int i = 0; i < count; i++) {
            sb.append(randomStringChars[random.nextInt(randomStringChars.length)]);
        }
        return sb.toString();
    }
}
