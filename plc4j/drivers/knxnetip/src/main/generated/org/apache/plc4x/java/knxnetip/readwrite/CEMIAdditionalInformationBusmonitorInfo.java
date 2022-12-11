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

public class CEMIAdditionalInformationBusmonitorInfo extends CEMIAdditionalInformation
    implements Message {

  // Accessors for discriminator values.
  public Short getAdditionalInformationType() {
    return (short) 0x03;
  }

  // Constant values.
  public static final Short LEN = 1;

  // Properties.
  protected final boolean frameErrorFlag;
  protected final boolean bitErrorFlag;
  protected final boolean parityErrorFlag;
  protected final boolean unknownFlag;
  protected final boolean lostFlag;
  protected final byte sequenceNumber;

  public CEMIAdditionalInformationBusmonitorInfo(
      boolean frameErrorFlag,
      boolean bitErrorFlag,
      boolean parityErrorFlag,
      boolean unknownFlag,
      boolean lostFlag,
      byte sequenceNumber) {
    super();
    this.frameErrorFlag = frameErrorFlag;
    this.bitErrorFlag = bitErrorFlag;
    this.parityErrorFlag = parityErrorFlag;
    this.unknownFlag = unknownFlag;
    this.lostFlag = lostFlag;
    this.sequenceNumber = sequenceNumber;
  }

  public boolean getFrameErrorFlag() {
    return frameErrorFlag;
  }

  public boolean getBitErrorFlag() {
    return bitErrorFlag;
  }

  public boolean getParityErrorFlag() {
    return parityErrorFlag;
  }

  public boolean getUnknownFlag() {
    return unknownFlag;
  }

  public boolean getLostFlag() {
    return lostFlag;
  }

  public byte getSequenceNumber() {
    return sequenceNumber;
  }

  public short getLen() {
    return LEN;
  }

  @Override
  protected void serializeCEMIAdditionalInformationChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("CEMIAdditionalInformationBusmonitorInfo");

    // Const Field (len)
    writeConstField("len", LEN, writeUnsignedShort(writeBuffer, 8));

    // Simple Field (frameErrorFlag)
    writeSimpleField("frameErrorFlag", frameErrorFlag, writeBoolean(writeBuffer));

    // Simple Field (bitErrorFlag)
    writeSimpleField("bitErrorFlag", bitErrorFlag, writeBoolean(writeBuffer));

    // Simple Field (parityErrorFlag)
    writeSimpleField("parityErrorFlag", parityErrorFlag, writeBoolean(writeBuffer));

    // Simple Field (unknownFlag)
    writeSimpleField("unknownFlag", unknownFlag, writeBoolean(writeBuffer));

    // Simple Field (lostFlag)
    writeSimpleField("lostFlag", lostFlag, writeBoolean(writeBuffer));

    // Simple Field (sequenceNumber)
    writeSimpleField("sequenceNumber", sequenceNumber, writeUnsignedByte(writeBuffer, 3));

    writeBuffer.popContext("CEMIAdditionalInformationBusmonitorInfo");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    CEMIAdditionalInformationBusmonitorInfo _value = this;

    // Const Field (len)
    lengthInBits += 8;

    // Simple field (frameErrorFlag)
    lengthInBits += 1;

    // Simple field (bitErrorFlag)
    lengthInBits += 1;

    // Simple field (parityErrorFlag)
    lengthInBits += 1;

    // Simple field (unknownFlag)
    lengthInBits += 1;

    // Simple field (lostFlag)
    lengthInBits += 1;

    // Simple field (sequenceNumber)
    lengthInBits += 3;

    return lengthInBits;
  }

  public static CEMIAdditionalInformationBusmonitorInfoBuilder staticParseBuilder(
      ReadBuffer readBuffer) throws ParseException {
    readBuffer.pullContext("CEMIAdditionalInformationBusmonitorInfo");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short len =
        readConstField(
            "len", readUnsignedShort(readBuffer, 8), CEMIAdditionalInformationBusmonitorInfo.LEN);

    boolean frameErrorFlag = readSimpleField("frameErrorFlag", readBoolean(readBuffer));

    boolean bitErrorFlag = readSimpleField("bitErrorFlag", readBoolean(readBuffer));

    boolean parityErrorFlag = readSimpleField("parityErrorFlag", readBoolean(readBuffer));

    boolean unknownFlag = readSimpleField("unknownFlag", readBoolean(readBuffer));

    boolean lostFlag = readSimpleField("lostFlag", readBoolean(readBuffer));

    byte sequenceNumber = readSimpleField("sequenceNumber", readUnsignedByte(readBuffer, 3));

    readBuffer.closeContext("CEMIAdditionalInformationBusmonitorInfo");
    // Create the instance
    return new CEMIAdditionalInformationBusmonitorInfoBuilder(
        frameErrorFlag, bitErrorFlag, parityErrorFlag, unknownFlag, lostFlag, sequenceNumber);
  }

  public static class CEMIAdditionalInformationBusmonitorInfoBuilder
      implements CEMIAdditionalInformation.CEMIAdditionalInformationBuilder {
    private final boolean frameErrorFlag;
    private final boolean bitErrorFlag;
    private final boolean parityErrorFlag;
    private final boolean unknownFlag;
    private final boolean lostFlag;
    private final byte sequenceNumber;

    public CEMIAdditionalInformationBusmonitorInfoBuilder(
        boolean frameErrorFlag,
        boolean bitErrorFlag,
        boolean parityErrorFlag,
        boolean unknownFlag,
        boolean lostFlag,
        byte sequenceNumber) {

      this.frameErrorFlag = frameErrorFlag;
      this.bitErrorFlag = bitErrorFlag;
      this.parityErrorFlag = parityErrorFlag;
      this.unknownFlag = unknownFlag;
      this.lostFlag = lostFlag;
      this.sequenceNumber = sequenceNumber;
    }

    public CEMIAdditionalInformationBusmonitorInfo build() {
      CEMIAdditionalInformationBusmonitorInfo cEMIAdditionalInformationBusmonitorInfo =
          new CEMIAdditionalInformationBusmonitorInfo(
              frameErrorFlag, bitErrorFlag, parityErrorFlag, unknownFlag, lostFlag, sequenceNumber);
      return cEMIAdditionalInformationBusmonitorInfo;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CEMIAdditionalInformationBusmonitorInfo)) {
      return false;
    }
    CEMIAdditionalInformationBusmonitorInfo that = (CEMIAdditionalInformationBusmonitorInfo) o;
    return (getFrameErrorFlag() == that.getFrameErrorFlag())
        && (getBitErrorFlag() == that.getBitErrorFlag())
        && (getParityErrorFlag() == that.getParityErrorFlag())
        && (getUnknownFlag() == that.getUnknownFlag())
        && (getLostFlag() == that.getLostFlag())
        && (getSequenceNumber() == that.getSequenceNumber())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getFrameErrorFlag(),
        getBitErrorFlag(),
        getParityErrorFlag(),
        getUnknownFlag(),
        getLostFlag(),
        getSequenceNumber());
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
