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
package org.apache.plc4x.java.abeth.readwrite;

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

public class DF1CommandRequestMessage extends DF1RequestMessage implements Message {

  // Accessors for discriminator values.
  public Short getCommandCode() {
    return (short) 0x0F;
  }

  // Properties.
  protected final DF1RequestCommand command;

  public DF1CommandRequestMessage(
      short destinationAddress,
      short sourceAddress,
      short status,
      int transactionCounter,
      DF1RequestCommand command) {
    super(destinationAddress, sourceAddress, status, transactionCounter);
    this.command = command;
  }

  public DF1RequestCommand getCommand() {
    return command;
  }

  @Override
  protected void serializeDF1RequestMessageChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("DF1CommandRequestMessage");

    // Simple Field (command)
    writeSimpleField("command", command, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("DF1CommandRequestMessage");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    DF1CommandRequestMessage _value = this;

    // Simple field (command)
    lengthInBits += command.getLengthInBits();

    return lengthInBits;
  }

  public static DF1CommandRequestMessageBuilder staticParseBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("DF1CommandRequestMessage");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    DF1RequestCommand command =
        readSimpleField(
            "command",
            new DataReaderComplexDefault<>(
                () -> DF1RequestCommand.staticParse(readBuffer), readBuffer));

    readBuffer.closeContext("DF1CommandRequestMessage");
    // Create the instance
    return new DF1CommandRequestMessageBuilder(command);
  }

  public static class DF1CommandRequestMessageBuilder
      implements DF1RequestMessage.DF1RequestMessageBuilder {
    private final DF1RequestCommand command;

    public DF1CommandRequestMessageBuilder(DF1RequestCommand command) {

      this.command = command;
    }

    public DF1CommandRequestMessage build(
        short destinationAddress, short sourceAddress, short status, int transactionCounter) {
      DF1CommandRequestMessage dF1CommandRequestMessage =
          new DF1CommandRequestMessage(
              destinationAddress, sourceAddress, status, transactionCounter, command);
      return dF1CommandRequestMessage;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DF1CommandRequestMessage)) {
      return false;
    }
    DF1CommandRequestMessage that = (DF1CommandRequestMessage) o;
    return (getCommand() == that.getCommand()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCommand());
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
