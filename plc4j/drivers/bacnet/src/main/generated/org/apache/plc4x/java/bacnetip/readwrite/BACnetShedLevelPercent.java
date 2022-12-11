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

public class BACnetShedLevelPercent extends BACnetShedLevel implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final BACnetContextTagUnsignedInteger percent;

  public BACnetShedLevelPercent(
      BACnetTagHeader peekedTagHeader, BACnetContextTagUnsignedInteger percent) {
    super(peekedTagHeader);
    this.percent = percent;
  }

  public BACnetContextTagUnsignedInteger getPercent() {
    return percent;
  }

  @Override
  protected void serializeBACnetShedLevelChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetShedLevelPercent");

    // Simple Field (percent)
    writeSimpleField("percent", percent, new DataWriterComplexDefault<>(writeBuffer));

    writeBuffer.popContext("BACnetShedLevelPercent");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetShedLevelPercent _value = this;

    // Simple field (percent)
    lengthInBits += percent.getLengthInBits();

    return lengthInBits;
  }

  public static BACnetShedLevelPercentBuilder staticParseBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("BACnetShedLevelPercent");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetContextTagUnsignedInteger percent =
        readSimpleField(
            "percent",
            new DataReaderComplexDefault<>(
                () ->
                    (BACnetContextTagUnsignedInteger)
                        BACnetContextTag.staticParse(
                            readBuffer,
                            (short) (0),
                            (BACnetDataType) (BACnetDataType.UNSIGNED_INTEGER)),
                readBuffer));

    readBuffer.closeContext("BACnetShedLevelPercent");
    // Create the instance
    return new BACnetShedLevelPercentBuilder(percent);
  }

  public static class BACnetShedLevelPercentBuilder
      implements BACnetShedLevel.BACnetShedLevelBuilder {
    private final BACnetContextTagUnsignedInteger percent;

    public BACnetShedLevelPercentBuilder(BACnetContextTagUnsignedInteger percent) {

      this.percent = percent;
    }

    public BACnetShedLevelPercent build(BACnetTagHeader peekedTagHeader) {
      BACnetShedLevelPercent bACnetShedLevelPercent =
          new BACnetShedLevelPercent(peekedTagHeader, percent);
      return bACnetShedLevelPercent;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetShedLevelPercent)) {
      return false;
    }
    BACnetShedLevelPercent that = (BACnetShedLevelPercent) o;
    return (getPercent() == that.getPercent()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getPercent());
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
