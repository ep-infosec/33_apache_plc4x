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

public abstract class ConnectionResponseDataBlock implements Message {

  // Abstract accessors for discriminator values.
  public abstract Short getConnectionType();

  public ConnectionResponseDataBlock() {
    super();
  }

  protected abstract void serializeConnectionResponseDataBlockChild(WriteBuffer writeBuffer)
      throws SerializationException;

  public void serialize(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ConnectionResponseDataBlock");

    // Implicit Field (structureLength) (Used for parsing, but its value is not stored as it's
    // implicitly given by the objects content)
    short structureLength = (short) (getLengthInBytes());
    writeImplicitField("structureLength", structureLength, writeUnsignedShort(writeBuffer, 8));

    // Discriminator Field (connectionType) (Used as input to a switch field)
    writeDiscriminatorField(
        "connectionType", getConnectionType(), writeUnsignedShort(writeBuffer, 8));

    // Switch field (Serialize the sub-type)
    serializeConnectionResponseDataBlockChild(writeBuffer);

    writeBuffer.popContext("ConnectionResponseDataBlock");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = 0;
    ConnectionResponseDataBlock _value = this;

    // Implicit Field (structureLength)
    lengthInBits += 8;

    // Discriminator Field (connectionType)
    lengthInBits += 8;

    // Length of sub-type elements will be added by sub-type...

    return lengthInBits;
  }

  public static ConnectionResponseDataBlock staticParse(ReadBuffer readBuffer, Object... args)
      throws ParseException {
    PositionAware positionAware = readBuffer;
    return staticParse(readBuffer);
  }

  public static ConnectionResponseDataBlock staticParse(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("ConnectionResponseDataBlock");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    short structureLength = readImplicitField("structureLength", readUnsignedShort(readBuffer, 8));

    short connectionType =
        readDiscriminatorField("connectionType", readUnsignedShort(readBuffer, 8));

    // Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
    ConnectionResponseDataBlockBuilder builder = null;
    if (EvaluationHelper.equals(connectionType, (short) 0x03)) {
      builder = ConnectionResponseDataBlockDeviceManagement.staticParseBuilder(readBuffer);
    } else if (EvaluationHelper.equals(connectionType, (short) 0x04)) {
      builder = ConnectionResponseDataBlockTunnelConnection.staticParseBuilder(readBuffer);
    }
    if (builder == null) {
      throw new ParseException(
          "Unsupported case for discriminated type"
              + " parameters ["
              + "connectionType="
              + connectionType
              + "]");
    }

    readBuffer.closeContext("ConnectionResponseDataBlock");
    // Create the instance
    ConnectionResponseDataBlock _connectionResponseDataBlock = builder.build();
    return _connectionResponseDataBlock;
  }

  public static interface ConnectionResponseDataBlockBuilder {
    ConnectionResponseDataBlock build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ConnectionResponseDataBlock)) {
      return false;
    }
    ConnectionResponseDataBlock that = (ConnectionResponseDataBlock) o;
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
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
