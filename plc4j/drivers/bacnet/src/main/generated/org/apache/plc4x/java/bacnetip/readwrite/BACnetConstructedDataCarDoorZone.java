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

public class BACnetConstructedDataCarDoorZone extends BACnetConstructedData implements Message {

  // Accessors for discriminator values.
  public BACnetObjectType getObjectTypeArgument() {
    return null;
  }

  public BACnetPropertyIdentifier getPropertyIdentifierArgument() {
    return BACnetPropertyIdentifier.CAR_DOOR_ZONE;
  }

  // Properties.
  protected final BACnetApplicationTagBoolean carDoorZone;

  // Arguments.
  protected final Short tagNumber;
  protected final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

  public BACnetConstructedDataCarDoorZone(
      BACnetOpeningTag openingTag,
      BACnetTagHeader peekedTagHeader,
      BACnetClosingTag closingTag,
      BACnetApplicationTagBoolean carDoorZone,
      Short tagNumber,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
    super(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument);
    this.carDoorZone = carDoorZone;
    this.tagNumber = tagNumber;
    this.arrayIndexArgument = arrayIndexArgument;
  }

  public BACnetApplicationTagBoolean getCarDoorZone() {
    return carDoorZone;
  }

  public BACnetApplicationTagBoolean getActualValue() {
    return (BACnetApplicationTagBoolean) (getCarDoorZone());
  }

  @Override
  protected void serializeBACnetConstructedDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConstructedDataCarDoorZone");

    // Simple Field (carDoorZone)
    writeSimpleField("carDoorZone", carDoorZone, new DataWriterComplexDefault<>(writeBuffer));

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    BACnetApplicationTagBoolean actualValue = getActualValue();
    writeBuffer.writeVirtual("actualValue", actualValue);

    writeBuffer.popContext("BACnetConstructedDataCarDoorZone");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConstructedDataCarDoorZone _value = this;

    // Simple field (carDoorZone)
    lengthInBits += carDoorZone.getLengthInBits();

    // A virtual field doesn't have any in- or output.

    return lengthInBits;
  }

  public static BACnetConstructedDataCarDoorZoneBuilder staticParseBuilder(
      ReadBuffer readBuffer,
      Short tagNumber,
      BACnetObjectType objectTypeArgument,
      BACnetPropertyIdentifier propertyIdentifierArgument,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument)
      throws ParseException {
    readBuffer.pullContext("BACnetConstructedDataCarDoorZone");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetApplicationTagBoolean carDoorZone =
        readSimpleField(
            "carDoorZone",
            new DataReaderComplexDefault<>(
                () -> (BACnetApplicationTagBoolean) BACnetApplicationTag.staticParse(readBuffer),
                readBuffer));
    BACnetApplicationTagBoolean actualValue =
        readVirtualField("actualValue", BACnetApplicationTagBoolean.class, carDoorZone);

    readBuffer.closeContext("BACnetConstructedDataCarDoorZone");
    // Create the instance
    return new BACnetConstructedDataCarDoorZoneBuilder(carDoorZone, tagNumber, arrayIndexArgument);
  }

  public static class BACnetConstructedDataCarDoorZoneBuilder
      implements BACnetConstructedData.BACnetConstructedDataBuilder {
    private final BACnetApplicationTagBoolean carDoorZone;
    private final Short tagNumber;
    private final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

    public BACnetConstructedDataCarDoorZoneBuilder(
        BACnetApplicationTagBoolean carDoorZone,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {

      this.carDoorZone = carDoorZone;
      this.tagNumber = tagNumber;
      this.arrayIndexArgument = arrayIndexArgument;
    }

    public BACnetConstructedDataCarDoorZone build(
        BACnetOpeningTag openingTag,
        BACnetTagHeader peekedTagHeader,
        BACnetClosingTag closingTag,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
      BACnetConstructedDataCarDoorZone bACnetConstructedDataCarDoorZone =
          new BACnetConstructedDataCarDoorZone(
              openingTag, peekedTagHeader, closingTag, carDoorZone, tagNumber, arrayIndexArgument);
      return bACnetConstructedDataCarDoorZone;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConstructedDataCarDoorZone)) {
      return false;
    }
    BACnetConstructedDataCarDoorZone that = (BACnetConstructedDataCarDoorZone) o;
    return (getCarDoorZone() == that.getCarDoorZone()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCarDoorZone());
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
