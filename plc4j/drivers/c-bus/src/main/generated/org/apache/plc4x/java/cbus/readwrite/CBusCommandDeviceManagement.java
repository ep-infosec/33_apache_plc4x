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

public class CBusCommandDeviceManagement extends CBusCommand implements Message {

  // Accessors for discriminator values.

  // Constant values.
  public static final Byte DELIMITER = 0x0;

  // Properties.
  protected final Parameter paramNo;
  protected final byte parameterValue;

  // Arguments.
  protected final CBusOptions cBusOptions;

  public CBusCommandDeviceManagement(
      CBusHeader header, Parameter paramNo, byte parameterValue, CBusOptions cBusOptions) {
    super(header, cBusOptions);
    this.paramNo = paramNo;
    this.parameterValue = parameterValue;
    this.cBusOptions = cBusOptions;
  }

  public Parameter getParamNo() {
    return paramNo;
  }

  public byte getParameterValue() {
    return parameterValue;
  }

  public byte getDelimiter() {
    return DELIMITER;
  }

  @Override
  protected void serializeCBusCommandChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("CBusCommandDeviceManagement");

    // Simple Field (paramNo)
    writeSimpleEnumField(
        "paramNo",
        "Parameter",
        paramNo,
        new DataWriterEnumDefault<>(
            Parameter::getValue, Parameter::name, writeUnsignedShort(writeBuffer, 8)));

    // Const Field (delimiter)
    writeConstField("delimiter", DELIMITER, writeByte(writeBuffer, 8));

    // Simple Field (parameterValue)
    writeSimpleField("parameterValue", parameterValue, writeByte(writeBuffer, 8));

    writeBuffer.popContext("CBusCommandDeviceManagement");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    CBusCommandDeviceManagement _value = this;

    // Simple field (paramNo)
    lengthInBits += 8;

    // Const Field (delimiter)
    lengthInBits += 8;

    // Simple field (parameterValue)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static CBusCommandDeviceManagementBuilder staticParseBuilder(
      ReadBuffer readBuffer, CBusOptions cBusOptions) throws ParseException {
    readBuffer.pullContext("CBusCommandDeviceManagement");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    Parameter paramNo =
        readEnumField(
            "paramNo",
            "Parameter",
            new DataReaderEnumDefault<>(Parameter::enumForValue, readUnsignedShort(readBuffer, 8)));

    byte delimiter =
        readConstField("delimiter", readByte(readBuffer, 8), CBusCommandDeviceManagement.DELIMITER);

    byte parameterValue = readSimpleField("parameterValue", readByte(readBuffer, 8));

    readBuffer.closeContext("CBusCommandDeviceManagement");
    // Create the instance
    return new CBusCommandDeviceManagementBuilder(paramNo, parameterValue, cBusOptions);
  }

  public static class CBusCommandDeviceManagementBuilder implements CBusCommand.CBusCommandBuilder {
    private final Parameter paramNo;
    private final byte parameterValue;
    private final CBusOptions cBusOptions;

    public CBusCommandDeviceManagementBuilder(
        Parameter paramNo, byte parameterValue, CBusOptions cBusOptions) {

      this.paramNo = paramNo;
      this.parameterValue = parameterValue;
      this.cBusOptions = cBusOptions;
    }

    public CBusCommandDeviceManagement build(CBusHeader header, CBusOptions cBusOptions) {
      CBusCommandDeviceManagement cBusCommandDeviceManagement =
          new CBusCommandDeviceManagement(header, paramNo, parameterValue, cBusOptions);
      return cBusCommandDeviceManagement;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CBusCommandDeviceManagement)) {
      return false;
    }
    CBusCommandDeviceManagement that = (CBusCommandDeviceManagement) o;
    return (getParamNo() == that.getParamNo())
        && (getParameterValue() == that.getParameterValue())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getParamNo(), getParameterValue());
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
