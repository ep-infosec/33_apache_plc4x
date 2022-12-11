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

public abstract class Apdu implements Message {

  // Abstract accessors for discriminator values.
  public abstract Byte getControl();

  // Properties.
  protected final boolean numbered;
  protected final byte counter;

  // Arguments.
  protected final Short dataLength;

  public Apdu(boolean numbered, byte counter, Short dataLength) {
    super();
    this.numbered = numbered;
    this.counter = counter;
    this.dataLength = dataLength;
  }

  public boolean getNumbered() {
    return numbered;
  }

  public byte getCounter() {
    return counter;
  }

  protected abstract void serializeApduChild(WriteBuffer writeBuffer) throws SerializationException;

  public void serialize(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("Apdu");

    // Discriminator Field (control) (Used as input to a switch field)
    writeDiscriminatorField("control", getControl(), writeUnsignedByte(writeBuffer, 1));

    // Simple Field (numbered)
    writeSimpleField("numbered", numbered, writeBoolean(writeBuffer));

    // Simple Field (counter)
    writeSimpleField("counter", counter, writeUnsignedByte(writeBuffer, 4));

    // Switch field (Serialize the sub-type)
    serializeApduChild(writeBuffer);

    writeBuffer.popContext("Apdu");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = 0;
    Apdu _value = this;

    // Discriminator Field (control)
    lengthInBits += 1;

    // Simple field (numbered)
    lengthInBits += 1;

    // Simple field (counter)
    lengthInBits += 4;

    // Length of sub-type elements will be added by sub-type...

    return lengthInBits;
  }

  public static Apdu staticParse(ReadBuffer readBuffer, Object... args) throws ParseException {
    PositionAware positionAware = readBuffer;
    if ((args == null) || (args.length != 1)) {
      throw new PlcRuntimeException(
          "Wrong number of arguments, expected 1, but got " + args.length);
    }
    Short dataLength;
    if (args[0] instanceof Short) {
      dataLength = (Short) args[0];
    } else if (args[0] instanceof String) {
      dataLength = Short.valueOf((String) args[0]);
    } else {
      throw new PlcRuntimeException(
          "Argument 0 expected to be of type Short or a string which is parseable but was "
              + args[0].getClass().getName());
    }
    return staticParse(readBuffer, dataLength);
  }

  public static Apdu staticParse(ReadBuffer readBuffer, Short dataLength) throws ParseException {
    readBuffer.pullContext("Apdu");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte control = readDiscriminatorField("control", readUnsignedByte(readBuffer, 1));

    boolean numbered = readSimpleField("numbered", readBoolean(readBuffer));

    byte counter = readSimpleField("counter", readUnsignedByte(readBuffer, 4));

    // Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
    ApduBuilder builder = null;
    if (EvaluationHelper.equals(control, (byte) 1)) {
      builder = ApduControlContainer.staticParseBuilder(readBuffer, dataLength);
    } else if (EvaluationHelper.equals(control, (byte) 0)) {
      builder = ApduDataContainer.staticParseBuilder(readBuffer, dataLength);
    }
    if (builder == null) {
      throw new ParseException(
          "Unsupported case for discriminated type" + " parameters [" + "control=" + control + "]");
    }

    readBuffer.closeContext("Apdu");
    // Create the instance
    Apdu _apdu = builder.build(numbered, counter, dataLength);
    return _apdu;
  }

  public static interface ApduBuilder {
    Apdu build(boolean numbered, byte counter, Short dataLength);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Apdu)) {
      return false;
    }
    Apdu that = (Apdu) o;
    return (getNumbered() == that.getNumbered()) && (getCounter() == that.getCounter()) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNumbered(), getCounter());
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
