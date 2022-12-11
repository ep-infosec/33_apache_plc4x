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

public class BACnetConstructedDataLightingOutputAll extends BACnetConstructedData
    implements Message {

  // Accessors for discriminator values.
  public BACnetObjectType getObjectTypeArgument() {
    return BACnetObjectType.LIGHTING_OUTPUT;
  }

  public BACnetPropertyIdentifier getPropertyIdentifierArgument() {
    return BACnetPropertyIdentifier.ALL;
  }

  // Arguments.
  protected final Short tagNumber;
  protected final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

  public BACnetConstructedDataLightingOutputAll(
      BACnetOpeningTag openingTag,
      BACnetTagHeader peekedTagHeader,
      BACnetClosingTag closingTag,
      Short tagNumber,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
    super(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument);
    this.tagNumber = tagNumber;
    this.arrayIndexArgument = arrayIndexArgument;
  }

  @Override
  protected void serializeBACnetConstructedDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConstructedDataLightingOutputAll");

    writeBuffer.popContext("BACnetConstructedDataLightingOutputAll");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConstructedDataLightingOutputAll _value = this;

    return lengthInBits;
  }

  public static BACnetConstructedDataLightingOutputAllBuilder staticParseBuilder(
      ReadBuffer readBuffer,
      Short tagNumber,
      BACnetObjectType objectTypeArgument,
      BACnetPropertyIdentifier propertyIdentifierArgument,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument)
      throws ParseException {
    readBuffer.pullContext("BACnetConstructedDataLightingOutputAll");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;
    // Validation
    if (!((1) == (2))) {
      throw new ParseValidationException(
          "All should never occur in context of constructed data. If it does please report");
    }

    readBuffer.closeContext("BACnetConstructedDataLightingOutputAll");
    // Create the instance
    return new BACnetConstructedDataLightingOutputAllBuilder(tagNumber, arrayIndexArgument);
  }

  public static class BACnetConstructedDataLightingOutputAllBuilder
      implements BACnetConstructedData.BACnetConstructedDataBuilder {
    private final Short tagNumber;
    private final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

    public BACnetConstructedDataLightingOutputAllBuilder(
        Short tagNumber, BACnetTagPayloadUnsignedInteger arrayIndexArgument) {

      this.tagNumber = tagNumber;
      this.arrayIndexArgument = arrayIndexArgument;
    }

    public BACnetConstructedDataLightingOutputAll build(
        BACnetOpeningTag openingTag,
        BACnetTagHeader peekedTagHeader,
        BACnetClosingTag closingTag,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
      BACnetConstructedDataLightingOutputAll bACnetConstructedDataLightingOutputAll =
          new BACnetConstructedDataLightingOutputAll(
              openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument);
      return bACnetConstructedDataLightingOutputAll;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConstructedDataLightingOutputAll)) {
      return false;
    }
    BACnetConstructedDataLightingOutputAll that = (BACnetConstructedDataLightingOutputAll) o;
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
