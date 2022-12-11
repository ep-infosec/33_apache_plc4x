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
package org.apache.plc4x.java.plc4x.readwrite;

import java.util.HashMap;
import java.util.Map;

// Code generated by code-generation. DO NOT EDIT.

public enum Plc4xRequestType {
  CONNECT_REQUEST((short) 0x01),
  CONNECT_RESPONSE((short) 0x02),
  DISCONNECT_REQUEST((short) 0x03),
  DISCONNECT_RESPONSE((short) 0x04),
  READ_REQUEST((short) 0x05),
  READ_RESPONSE((short) 0x06),
  WRITE_REQUEST((short) 0x07),
  WRITE_RESPONSE((short) 0x08),
  SUBSCRIPTION_REQUEST((short) 0x09),
  SUBSCRIPTION_RESPONSE((short) 0x0A),
  UNSUBSCRIPTION_REQUEST((short) 0x0B),
  UNSUBSCRIPTION_RESPONSE((short) 0x0C);
  private static final Map<Short, Plc4xRequestType> map;

  static {
    map = new HashMap<>();
    for (Plc4xRequestType value : Plc4xRequestType.values()) {
      map.put((short) value.getValue(), value);
    }
  }

  private short value;

  Plc4xRequestType(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }

  public static Plc4xRequestType enumForValue(short value) {
    return map.get(value);
  }

  public static Boolean isDefined(short value) {
    return map.containsKey(value);
  }
}
