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
package org.apache.plc4x.java.bacnetip.readwrite;

import java.util.HashMap;
import java.util.Map;

// Code generated by code-generation. DO NOT EDIT.

public enum BACnetFaultType {
  NONE((short) 0),
  FAULT_CHARACTERSTRING((short) 1),
  FAULT_EXTENDED((short) 2),
  FAULT_LIFE_SAFETY((short) 3),
  FAULT_STATE((short) 4),
  FAULT_STATUS_FLAGS((short) 5),
  FAULT_OUT_OF_RANGE((short) 6),
  FAULT_LISTED((short) 7);
  private static final Map<Short, BACnetFaultType> map;

  static {
    map = new HashMap<>();
    for (BACnetFaultType value : BACnetFaultType.values()) {
      map.put((short) value.getValue(), value);
    }
  }

  private short value;

  BACnetFaultType(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }

  public static BACnetFaultType enumForValue(short value) {
    return map.get(value);
  }

  public static Boolean isDefined(short value) {
    return map.containsKey(value);
  }
}
