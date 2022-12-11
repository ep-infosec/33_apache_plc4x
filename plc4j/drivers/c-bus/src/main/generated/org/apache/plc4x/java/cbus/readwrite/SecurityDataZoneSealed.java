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
package org.apache.plc4x.java.cbus.readwrite;

import static org.apache.plc4x.java.spi.codegen.fields.FieldReaderFactory.*;
import static org.apache.plc4x.java.spi.codegen.fields.FieldWriterFactory.*;
import static org.apache.plc4x.java.spi.codegen.io.DataReaderFactory.*;
import static org.apache.plc4x.java.spi.codegen.io.DataWriterFactory.*;
import static org.apache.plc4x.java.spi.generation.StaticHelper.*;

import java.time.*;
import java.util.*;
import org.apache.plc4x.java.api.exceptions.*;
import org.apache.plc4x.java.api.value.*;
import org.apache.plc4x.java.spi.codegen.*;
import org.apache.plc4x.java.spi.codegen.fields.*;
import org.apache.plc4x.java.spi.codegen.io.*;
import org.apache.plc4x.java.spi.generation.*;

// Code generated by code-generation. DO NOT EDIT.

public class SecurityDataZoneSealed extends SecurityData implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final short zoneNumber;

  public SecurityDataZoneSealed(
      SecurityCommandTypeContainer commandTypeContainer, byte argument, short zoneNumber) {
    super(commandTypeContainer, argument);
    this.zoneNumber = zoneNumber;
  }

  public short getZoneNumber() {
    return zoneNumber;
  }

  @Override
  protected void serializeSecurityDataChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("SecurityDataZoneSealed");

    // Simple Field (zoneNumber)
    writeSimpleField("zoneNumber", zoneNumber, writeUnsignedShort(writeBuffer, 8));

    writeBuffer.popContext("SecurityDataZoneSealed");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    SecurityDataZoneSealed _value = this;

    // Simple field (zoneNumber)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static SecurityDataZoneSealedBuilder staticParseBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("SecurityDataZoneSealed");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short zoneNumber = readSimpleField("zoneNumber", readUnsignedShort(readBuffer, 8));

    readBuffer.closeContext("SecurityDataZoneSealed");
    // Create the instance
    return new SecurityDataZoneSealedBuilder(zoneNumber);
  }

  public static class SecurityDataZoneSealedBuilder implements SecurityData.SecurityDataBuilder {
    private final short zoneNumber;

    public SecurityDataZoneSealedBuilder(short zoneNumber) {

      this.zoneNumber = zoneNumber;
    }

    public SecurityDataZoneSealed build(
        SecurityCommandTypeContainer commandTypeContainer, byte argument) {
      SecurityDataZoneSealed securityDataZoneSealed =
          new SecurityDataZoneSealed(commandTypeContainer, argument, zoneNumber);
      return securityDataZoneSealed;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SecurityDataZoneSealed)) {
      return false;
    }
    SecurityDataZoneSealed that = (SecurityDataZoneSealed) o;
    return (getZoneNumber() == that.getZoneNumber()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getZoneNumber());
  }

  @Override
  public String toString() {
    WriteBufferBoxBased writeBufferBoxBased = new WriteBufferBoxBased(true, true);
    try {
      writeBufferBoxBased.writeSerializable(this);
    } catch (SerializationException e) {
      throw new RuntimeException(e);
    }
    return "\n" + writeBufferBoxBased.getBox().toString() + "\n";
  }
}
