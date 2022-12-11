/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.plc4x.java.knxnetip.readwrite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Code generated by code-generation. DO NOT EDIT.

public enum KnxDatapointMainType {
  DPT_UNKNOWN((int) 0, (int) 0, (String) "Unknown Datapoint Type", (short) 0),
  DPT_64_BIT_SET((int) 1, (int) 0, (String) "Unknown Datapoint Type", (short) 64),
  DPT_8_BYTE_UNSIGNED_VALUE((int) 2, (int) 0, (String) "Unknown Datapoint Type", (short) 64),
  DPT_8_BYTE_SIGNED_VALUE((int) 3, (int) 0, (String) "Unknown Datapoint Type", (short) 64),
  DPT_12_BYTE_SIGNED_VALUE((int) 4, (int) 0, (String) "Unknown Datapoint Type", (short) 96),
  DPT_8_BYTE_FLOAT_VALUE((int) 5, (int) 0, (String) "Unknown Datapoint Type", (short) 64),
  DPT_1_BIT((int) 6, (int) 1, (String) "1-bit", (short) 1),
  DPT_1_BIT_CONTROLLED((int) 7, (int) 2, (String) "1-bit controlled", (short) 2),
  DPT_3_BIT_CONTROLLED((int) 8, (int) 3, (String) "3-bit controlled", (short) 4),
  DPT_CHARACTER((int) 9, (int) 4, (String) "character", (short) 8),
  DPT_8_BIT_UNSIGNED_VALUE((int) 10, (int) 5, (String) "8-bit unsigned value", (short) 8),
  DPT_8_BIT_SIGNED_VALUE((int) 11, (int) 6, (String) "8-bit signed value", (short) 8),
  DPT_2_BYTE_UNSIGNED_VALUE((int) 12, (int) 7, (String) "2-byte unsigned value", (short) 16),
  DPT_2_BYTE_SIGNED_VALUE((int) 13, (int) 8, (String) "2-byte signed value", (short) 16),
  DPT_2_BYTE_FLOAT_VALUE((int) 14, (int) 9, (String) "2-byte float value", (short) 16),
  DPT_TIME((int) 15, (int) 10, (String) "time", (short) 24),
  DPT_DATE((int) 16, (int) 11, (String) "date", (short) 24),
  DPT_4_BYTE_UNSIGNED_VALUE((int) 17, (int) 12, (String) "4-byte unsigned value", (short) 32),
  DPT_4_BYTE_SIGNED_VALUE((int) 18, (int) 13, (String) "4-byte signed value", (short) 32),
  DPT_4_BYTE_FLOAT_VALUE((int) 19, (int) 14, (String) "4-byte float value", (short) 32),
  DPT_ENTRANCE_ACCESS((int) 20, (int) 15, (String) "entrance access", (short) 32),
  DPT_CHARACTER_STRING((int) 21, (int) 16, (String) "character string", (short) 112),
  DPT_SCENE_NUMBER((int) 22, (int) 17, (String) "scene number", (short) 8),
  DPT_SCENE_CONTROL((int) 23, (int) 18, (String) "scene control", (short) 8),
  DPT_DATE_TIME((int) 24, (int) 19, (String) "Date Time", (short) 64),
  DPT_1_BYTE((int) 25, (int) 20, (String) "1-byte", (short) 8),
  DPT_8_BIT_SET((int) 26, (int) 21, (String) "8-bit set", (short) 8),
  DPT_16_BIT_SET((int) 27, (int) 22, (String) "16-bit set", (short) 16),
  DPT_2_BIT_SET((int) 28, (int) 23, (String) "2-bit set", (short) 2),
  DPT_2_NIBBLE_SET((int) 29, (int) 25, (String) "2-nibble set", (short) 8),
  DPT_8_BIT_SET_2((int) 30, (int) 26, (String) "8-bit set", (short) 8),
  DPT_32_BIT_SET((int) 31, (int) 27, (String) "32-bit set", (short) 32),
  DPT_ELECTRICAL_ENERGY((int) 32, (int) 29, (String) "electrical energy", (short) 64),
  DPT_24_TIMES_CHANNEL_ACTIVATION(
      (int) 33, (int) 30, (String) "24 times channel activation", (short) 24),
  DPT_16_BIT_UNSIGNED_VALUE_AND_8_BIT_ENUM(
      (int) 34, (int) 206, (String) "16-bit unsigned value & 8-bit enum", (short) 24),
  DPT_8_BIT_UNSIGNED_VALUE_AND_8_BIT_ENUM(
      (int) 35, (int) 207, (String) "8-bit unsigned value & 8-bit enum", (short) 16),
  DPT_DATAPOINT_TYPE_VERSION((int) 36, (int) 217, (String) "datapoint type version", (short) 16),
  DPT_ALARM_INFO((int) 37, (int) 219, (String) "alarm info", (short) 48),
  DPT_3X_2_BYTE_FLOAT_VALUE((int) 38, (int) 222, (String) "3x 2-byte float value", (short) 48),
  DPT_SCALING_SPEED((int) 39, (int) 225, (String) "scaling speed", (short) 24),
  DPT_4_1_1_BYTE_COMBINED_INFORMATION(
      (int) 40, (int) 229, (String) "4-1-1 byte combined information", (short) 48),
  DPT_MBUS_ADDRESS((int) 41, (int) 230, (String) "MBus address", (short) 64),
  DPT_3_BYTE_COLOUR_RGB((int) 42, (int) 232, (String) "3-byte colour RGB", (short) 24),
  DPT_LANGUAGE_CODE_ISO_639_1((int) 43, (int) 234, (String) "language code ISO 639-1", (short) 16),
  DPT_SIGNED_VALUE_WITH_CLASSIFICATION_AND_VALIDITY(
      (int) 44, (int) 235, (String) "Signed value with classification and validity", (short) 48),
  DPT_PRIORITISED_MODE_CONTROL((int) 45, (int) 236, (String) "Prioritised Mode Control", (short) 8),
  DPT_CONFIGURATION_DIAGNOSTICS_16_BIT(
      (int) 46, (int) 237, (String) "configuration/ diagnostics", (short) 16),
  DPT_CONFIGURATION_DIAGNOSTICS_8_BIT(
      (int) 47, (int) 238, (String) "configuration/ diagnostics", (short) 8),
  DPT_POSITIONS((int) 48, (int) 240, (String) "positions", (short) 24),
  DPT_STATUS_32_BIT((int) 49, (int) 241, (String) "status", (short) 32),
  DPT_STATUS_48_BIT((int) 50, (int) 242, (String) "status", (short) 48),
  DPT_CONVERTER_STATUS((int) 51, (int) 244, (String) "Converter Status", (short) 16),
  DPT_CONVERTER_TEST_RESULT((int) 52, (int) 245, (String) "Converter test result", (short) 48),
  DPT_BATTERY_INFORMATION((int) 53, (int) 246, (String) "Battery Information", (short) 16),
  DPT_BRIGHTNESS_COLOUR_TEMPERATURE_TRANSITION(
      (int) 54, (int) 249, (String) "brightness colour temperature transition", (short) 48),
  DPT_STATUS_24_BIT((int) 55, (int) 250, (String) "status", (short) 24),
  DPT_COLOUR_RGBW((int) 56, (int) 251, (String) "Colour RGBW", (short) 48),
  DPT_RELATIVE_CONTROL_RGBW((int) 57, (int) 252, (String) "Relative Control RGBW", (short) 40),
  DPT_RELATIVE_CONTROL_RGB((int) 58, (int) 254, (String) "Relative Control RGB", (short) 24),
  DPT_F32F32((int) 59, (int) 255, (String) "F32F32", (short) 64),
  DPT_F16F16F16F16((int) 60, (int) 275, (String) "F16F16F16F16", (short) 64);
  private static final Map<Integer, KnxDatapointMainType> map;

  static {
    map = new HashMap<>();
    for (KnxDatapointMainType value : KnxDatapointMainType.values()) {
      map.put((int) value.getValue(), value);
    }
  }

  private int value;
  private int number;
  private String name;
  private short sizeInBits;

  KnxDatapointMainType(int value, int number, String name, short sizeInBits) {
    this.value = value;
    this.number = number;
    this.name = name;
    this.sizeInBits = sizeInBits;
  }

  public int getValue() {
    return value;
  }

  public int getNumber() {
    return number;
  }

  public static KnxDatapointMainType firstEnumForFieldNumber(int fieldValue) {
    for (KnxDatapointMainType _val : KnxDatapointMainType.values()) {
      if (_val.getNumber() == fieldValue) {
        return _val;
      }
    }
    return null;
  }

  public static List<KnxDatapointMainType> enumsForFieldNumber(int fieldValue) {
    List<KnxDatapointMainType> _values = new ArrayList();
    for (KnxDatapointMainType _val : KnxDatapointMainType.values()) {
      if (_val.getNumber() == fieldValue) {
        _values.add(_val);
      }
    }
    return _values;
  }

  public String getName() {
    return name;
  }

  public static KnxDatapointMainType firstEnumForFieldName(String fieldValue) {
    for (KnxDatapointMainType _val : KnxDatapointMainType.values()) {
      if (_val.getName() == fieldValue) {
        return _val;
      }
    }
    return null;
  }

  public static List<KnxDatapointMainType> enumsForFieldName(String fieldValue) {
    List<KnxDatapointMainType> _values = new ArrayList();
    for (KnxDatapointMainType _val : KnxDatapointMainType.values()) {
      if (_val.getName() == fieldValue) {
        _values.add(_val);
      }
    }
    return _values;
  }

  public short getSizeInBits() {
    return sizeInBits;
  }

  public static KnxDatapointMainType firstEnumForFieldSizeInBits(short fieldValue) {
    for (KnxDatapointMainType _val : KnxDatapointMainType.values()) {
      if (_val.getSizeInBits() == fieldValue) {
        return _val;
      }
    }
    return null;
  }

  public static List<KnxDatapointMainType> enumsForFieldSizeInBits(short fieldValue) {
    List<KnxDatapointMainType> _values = new ArrayList();
    for (KnxDatapointMainType _val : KnxDatapointMainType.values()) {
      if (_val.getSizeInBits() == fieldValue) {
        _values.add(_val);
      }
    }
    return _values;
  }

  public static KnxDatapointMainType enumForValue(int value) {
    return map.get(value);
  }

  public static Boolean isDefined(int value) {
    return map.containsKey(value);
  }
}
