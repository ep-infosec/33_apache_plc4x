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

public class ApduDataExtFileStreamInfoReport extends ApduDataExt implements Message {

  // Accessors for discriminator values.
  public Short getExtApciType() {
    return (short) 0x30;
  }

  // Arguments.
  protected final Short length;

  public ApduDataExtFileStreamInfoReport(Short length) {
    super(length);
    this.length = length;
  }

  @Override
  protected void serializeApduDataExtChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ApduDataExtFileStreamInfoReport");

    writeBuffer.popContext("ApduDataExtFileStreamInfoReport");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    ApduDataExtFileStreamInfoReport _value = this;

    return lengthInBits;
  }

  public static ApduDataExtFileStreamInfoReportBuilder staticParseBuilder(
      ReadBuffer readBuffer, Short length) throws ParseException {
    readBuffer.pullContext("ApduDataExtFileStreamInfoReport");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    readBuffer.closeContext("ApduDataExtFileStreamInfoReport");
    // Create the instance
    return new ApduDataExtFileStreamInfoReportBuilder(length);
  }

  public static class ApduDataExtFileStreamInfoReportBuilder
      implements ApduDataExt.ApduDataExtBuilder {
    private final Short length;

    public ApduDataExtFileStreamInfoReportBuilder(Short length) {

      this.length = length;
    }

    public ApduDataExtFileStreamInfoReport build(Short length) {

      ApduDataExtFileStreamInfoReport apduDataExtFileStreamInfoReport =
          new ApduDataExtFileStreamInfoReport(length);
      return apduDataExtFileStreamInfoReport;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApduDataExtFileStreamInfoReport)) {
      return false;
    }
    ApduDataExtFileStreamInfoReport that = (ApduDataExtFileStreamInfoReport) o;
    return super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
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
