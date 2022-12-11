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

public class LPollData extends LDataFrame implements Message {

  // Accessors for discriminator values.
  public Boolean getNotAckFrame() {
    return (boolean) true;
  }

  public Boolean getPolling() {
    return (boolean) true;
  }

  // Properties.
  protected final KnxAddress sourceAddress;
  protected final byte[] targetAddress;
  protected final short numberExpectedPollData;
  // Reserved Fields
  private Byte reservedField0;

  public LPollData(
      boolean frameType,
      boolean notRepeated,
      CEMIPriority priority,
      boolean acknowledgeRequested,
      boolean errorFlag,
      KnxAddress sourceAddress,
      byte[] targetAddress,
      short numberExpectedPollData) {
    super(frameType, notRepeated, priority, acknowledgeRequested, errorFlag);
    this.sourceAddress = sourceAddress;
    this.targetAddress = targetAddress;
    this.numberExpectedPollData = numberExpectedPollData;
  }

  public KnxAddress getSourceAddress() {
    return sourceAddress;
  }

  public byte[] getTargetAddress() {
    return targetAddress;
  }

  public short getNumberExpectedPollData() {
    return numberExpectedPollData;
  }

  @Override
  protected void serializeLDataFrameChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("LPollData");

    // Simple Field (sourceAddress)
    writeSimpleField("sourceAddress", sourceAddress, new DataWriterComplexDefault<>(writeBuffer));

    // Array Field (targetAddress)
    writeByteArrayField("targetAddress", targetAddress, writeByteArray(writeBuffer, 8));

    // Reserved Field (reserved)
    writeReservedField(
        "reserved",
        reservedField0 != null ? reservedField0 : (byte) 0x00,
        writeUnsignedByte(writeBuffer, 4));

    // Simple Field (numberExpectedPollData)
    writeSimpleField(
        "numberExpectedPollData", numberExpectedPollData, writeUnsignedShort(writeBuffer, 6));

    writeBuffer.popContext("LPollData");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    LPollData _value = this;

    // Simple field (sourceAddress)
    lengthInBits += sourceAddress.getLengthInBits();

    // Array field
    if (targetAddress != null) {
      lengthInBits += 8 * targetAddress.length;
    }

    // Reserved Field (reserved)
    lengthInBits += 4;

    // Simple field (numberExpectedPollData)
    lengthInBits += 6;

    return lengthInBits;
  }

  public static LPollDataBuilder staticParseBuilder(ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("LPollData");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    KnxAddress sourceAddress =
        readSimpleField(
            "sourceAddress",
            new DataReaderComplexDefault<>(() -> KnxAddress.staticParse(readBuffer), readBuffer));

    byte[] targetAddress = readBuffer.readByteArray("targetAddress", Math.toIntExact(2));

    Byte reservedField0 =
        readReservedField("reserved", readUnsignedByte(readBuffer, 4), (byte) 0x00);

    short numberExpectedPollData =
        readSimpleField("numberExpectedPollData", readUnsignedShort(readBuffer, 6));

    readBuffer.closeContext("LPollData");
    // Create the instance
    return new LPollDataBuilder(
        sourceAddress, targetAddress, numberExpectedPollData, reservedField0);
  }

  public static class LPollDataBuilder implements LDataFrame.LDataFrameBuilder {
    private final KnxAddress sourceAddress;
    private final byte[] targetAddress;
    private final short numberExpectedPollData;
    private final Byte reservedField0;

    public LPollDataBuilder(
        KnxAddress sourceAddress,
        byte[] targetAddress,
        short numberExpectedPollData,
        Byte reservedField0) {
      this.sourceAddress = sourceAddress;
      this.targetAddress = targetAddress;
      this.numberExpectedPollData = numberExpectedPollData;
      this.reservedField0 = reservedField0;
    }

    public LPollData build(
        boolean frameType,
        boolean notRepeated,
        CEMIPriority priority,
        boolean acknowledgeRequested,
        boolean errorFlag) {
      LPollData lPollData =
          new LPollData(
              frameType,
              notRepeated,
              priority,
              acknowledgeRequested,
              errorFlag,
              sourceAddress,
              targetAddress,
              numberExpectedPollData);
      lPollData.reservedField0 = reservedField0;
      return lPollData;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LPollData)) {
      return false;
    }
    LPollData that = (LPollData) o;
    return (getSourceAddress() == that.getSourceAddress())
        && (getTargetAddress() == that.getTargetAddress())
        && (getNumberExpectedPollData() == that.getNumberExpectedPollData())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(), getSourceAddress(), getTargetAddress(), getNumberExpectedPollData());
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
