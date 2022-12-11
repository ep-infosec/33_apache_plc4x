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
package org.apache.plc4x.java.ads.readwrite;

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

public class AdsWriteControlRequest extends AmsPacket implements Message {

  // Accessors for discriminator values.
  public CommandId getCommandId() {
    return CommandId.ADS_WRITE_CONTROL;
  }

  public Boolean getResponse() {
    return (boolean) false;
  }

  // Properties.
  protected final int adsState;
  protected final int deviceState;
  protected final byte[] data;

  public AdsWriteControlRequest(
      AmsNetId targetAmsNetId,
      int targetAmsPort,
      AmsNetId sourceAmsNetId,
      int sourceAmsPort,
      long errorCode,
      long invokeId,
      int adsState,
      int deviceState,
      byte[] data) {
    super(targetAmsNetId, targetAmsPort, sourceAmsNetId, sourceAmsPort, errorCode, invokeId);
    this.adsState = adsState;
    this.deviceState = deviceState;
    this.data = data;
  }

  public int getAdsState() {
    return adsState;
  }

  public int getDeviceState() {
    return deviceState;
  }

  public byte[] getData() {
    return data;
  }

  @Override
  protected void serializeAmsPacketChild(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("AdsWriteControlRequest");

    // Simple Field (adsState)
    writeSimpleField("adsState", adsState, writeUnsignedInt(writeBuffer, 16));

    // Simple Field (deviceState)
    writeSimpleField("deviceState", deviceState, writeUnsignedInt(writeBuffer, 16));

    // Implicit Field (length) (Used for parsing, but its value is not stored as it's implicitly
    // given by the objects content)
    long length = (long) (COUNT(getData()));
    writeImplicitField("length", length, writeUnsignedLong(writeBuffer, 32));

    // Array Field (data)
    writeByteArrayField("data", data, writeByteArray(writeBuffer, 8));

    writeBuffer.popContext("AdsWriteControlRequest");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    AdsWriteControlRequest _value = this;

    // Simple field (adsState)
    lengthInBits += 16;

    // Simple field (deviceState)
    lengthInBits += 16;

    // Implicit Field (length)
    lengthInBits += 32;

    // Array field
    if (data != null) {
      lengthInBits += 8 * data.length;
    }

    return lengthInBits;
  }

  public static AdsWriteControlRequestBuilder staticParseBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("AdsWriteControlRequest");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    int adsState = readSimpleField("adsState", readUnsignedInt(readBuffer, 16));

    int deviceState = readSimpleField("deviceState", readUnsignedInt(readBuffer, 16));

    long length = readImplicitField("length", readUnsignedLong(readBuffer, 32));

    byte[] data = readBuffer.readByteArray("data", Math.toIntExact(length));

    readBuffer.closeContext("AdsWriteControlRequest");
    // Create the instance
    return new AdsWriteControlRequestBuilder(adsState, deviceState, data);
  }

  public static class AdsWriteControlRequestBuilder implements AmsPacket.AmsPacketBuilder {
    private final int adsState;
    private final int deviceState;
    private final byte[] data;

    public AdsWriteControlRequestBuilder(int adsState, int deviceState, byte[] data) {

      this.adsState = adsState;
      this.deviceState = deviceState;
      this.data = data;
    }

    public AdsWriteControlRequest build(
        AmsNetId targetAmsNetId,
        int targetAmsPort,
        AmsNetId sourceAmsNetId,
        int sourceAmsPort,
        long errorCode,
        long invokeId) {
      AdsWriteControlRequest adsWriteControlRequest =
          new AdsWriteControlRequest(
              targetAmsNetId,
              targetAmsPort,
              sourceAmsNetId,
              sourceAmsPort,
              errorCode,
              invokeId,
              adsState,
              deviceState,
              data);
      return adsWriteControlRequest;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AdsWriteControlRequest)) {
      return false;
    }
    AdsWriteControlRequest that = (AdsWriteControlRequest) o;
    return (getAdsState() == that.getAdsState())
        && (getDeviceState() == that.getDeviceState())
        && (getData() == that.getData())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getAdsState(), getDeviceState(), getData());
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
