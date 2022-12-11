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
package org.apache.plc4x.java.opcua.readwrite;

import java.util.HashMap;
import java.util.Map;

// Code generated by code-generation. DO NOT EDIT.

public enum PermissionType {
  permissionTypeNone((long) 0L),
  permissionTypeBrowse((long) 1L),
  permissionTypeReadRolePermissions((long) 2L),
  permissionTypeWriteAttribute((long) 4L),
  permissionTypeWriteRolePermissions((long) 8L),
  permissionTypeWriteHistorizing((long) 16L),
  permissionTypeRead((long) 32L),
  permissionTypeWrite((long) 64L),
  permissionTypeReadHistory((long) 128L),
  permissionTypeInsertHistory((long) 256L),
  permissionTypeModifyHistory((long) 512L),
  permissionTypeDeleteHistory((long) 1024L),
  permissionTypeReceiveEvents((long) 2048L),
  permissionTypeCall((long) 4096L),
  permissionTypeAddReference((long) 8192L),
  permissionTypeRemoveReference((long) 16384L),
  permissionTypeDeleteNode((long) 32768L),
  permissionTypeAddNode((long) 65536L);
  private static final Map<Long, PermissionType> map;

  static {
    map = new HashMap<>();
    for (PermissionType value : PermissionType.values()) {
      map.put((long) value.getValue(), value);
    }
  }

  private long value;

  PermissionType(long value) {
    this.value = value;
  }

  public long getValue() {
    return value;
  }

  public static PermissionType enumForValue(long value) {
    return map.get(value);
  }

  public static Boolean isDefined(long value) {
    return map.containsKey(value);
  }
}
