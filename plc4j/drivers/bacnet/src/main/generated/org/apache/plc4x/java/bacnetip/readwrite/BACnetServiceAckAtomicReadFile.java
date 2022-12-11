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

public class BACnetServiceAckAtomicReadFile extends BACnetServiceAck implements Message {

  // Accessors for discriminator values.
  public BACnetConfirmedServiceChoice getServiceChoice() {
    return BACnetConfirmedServiceChoice.ATOMIC_READ_FILE;
  }

  // Properties.
  protected final BACnetApplicationTagBoolean endOfFile;
  protected final BACnetServiceAckAtomicReadFileStreamOrRecord accessMethod;

  // Arguments.
  protected final Long serviceAckLength;

  public BACnetServiceAckAtomicReadFile(
      BACnetApplicationTagBoolean endOfFile,
      BACnetServiceAckAtomicReadFileStreamOrRecord accessMethod,
      Long serviceAckLength) {
    super(serviceAckLength);
    this.endOfFile = endOfFile;
    this.accessMethod = accessMethod;
    this.serviceAckLength = serviceAckLength;
  }

  public BACnetApplicationTagBoolean getEndOfFile() {
    return endOfFile;
  }

  public BACnetServiceAckAtomicReadFileStreamOrRecord getAccessMethod() {
    return accessMethod;
  }

  @Override
  protected void serializeBACnetServiceAckChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetServiceAckAtomicReadFile");

    // Simple Field (endOfFile)
    writeSimpleField("endOfFile", endOfFile, new DataWriterComplexDefault<>(writeBuffer));

    // Simple Field (accessMethod)
    writeSimpleField("accessMethod", accessMethod, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetServiceAckAtomicReadFile");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetServiceAckAtomicReadFile _value = this;

    // Simple field (endOfFile)
    lengthInBits += endOfFile.getLengthInBits();

    // Simple field (accessMethod)
    lengthInBits += accessMethod.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetServiceAckAtomicReadFileBuilder staticParseBuilder(
      ReadBuffer readBuffer, Long serviceAckLength) throws ParseException {
    readBuffer.pullContext("BACnetServiceAckAtomicReadFile");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetApplicationTagBoolean endOfFile =
        readSimpleField(
            "endOfFile",
            new DataReaderComplexDefault<>(
                () -> (BACnetApplicationTagBoolean) BACnetApplicationTag.staticParse(readBuffer),
                readBuffer));

    BACnetServiceAckAtomicReadFileStreamOrRecord accessMethod =
        readSimpleField(
            "accessMethod",
            new DataReaderComplexDefault<>(
                () -> BACnetServiceAckAtomicReadFileStreamOrRecord.staticParse(readBuffer),
                readBuffer));

    readBuffer.closeContext("BACnetServiceAckAtomicReadFile");
    // Create the instance
    return new BACnetServiceAckAtomicReadFileBuilder(endOfFile, accessMethod, serviceAckLength);
  }

  public static class BACnetServiceAckAtomicReadFileBuilder
      implements BACnetServiceAck.BACnetServiceAckBuilder {
    private final BACnetApplicationTagBoolean endOfFile;
    private final BACnetServiceAckAtomicReadFileStreamOrRecord accessMethod;
    private final Long serviceAckLength;

    public BACnetServiceAckAtomicReadFileBuilder(
        BACnetApplicationTagBoolean endOfFile,
        BACnetServiceAckAtomicReadFileStreamOrRecord accessMethod,
        Long serviceAckLength) {

      this.endOfFile = endOfFile;
      this.accessMethod = accessMethod;
      this.serviceAckLength = serviceAckLength;
    }

    public BACnetServiceAckAtomicReadFile build(Long serviceAckLength) {

      BACnetServiceAckAtomicReadFile bACnetServiceAckAtomicReadFile =
          new BACnetServiceAckAtomicReadFile(endOfFile, accessMethod, serviceAckLength);
      return bACnetServiceAckAtomicReadFile;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetServiceAckAtomicReadFile)) {
      return false;
    }
    BACnetServiceAckAtomicReadFile that = (BACnetServiceAckAtomicReadFile) o;
    return (getEndOfFile() == that.getEndOfFile())
        && (getAccessMethod() == that.getAccessMethod())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getEndOfFile(), getAccessMethod());
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
