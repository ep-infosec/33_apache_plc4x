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

public class BACnetConstructedDataBinaryOutputFeedbackValue extends BACnetConstructedData
    implements Message {

  // Accessors for discriminator values.
  public BACnetObjectType getObjectTypeArgument() {
    return BACnetObjectType.BINARY_OUTPUT;
  }

  public BACnetPropertyIdentifier getPropertyIdentifierArgument() {
    return BACnetPropertyIdentifier.FEEDBACK_VALUE;
  }

  // Properties.
  protected final BACnetBinaryPVTagged feedbackValue;

  // Arguments.
  protected final Short tagNumber;
  protected final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

  public BACnetConstructedDataBinaryOutputFeedbackValue(
      BACnetOpeningTag openingTag,
      BACnetTagHeader peekedTagHeader,
      BACnetClosingTag closingTag,
      BACnetBinaryPVTagged feedbackValue,
      Short tagNumber,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
    super(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument);
    this.feedbackValue = feedbackValue;
    this.tagNumber = tagNumber;
    this.arrayIndexArgument = arrayIndexArgument;
  }

  public BACnetBinaryPVTagged getFeedbackValue() {
    return feedbackValue;
  }

  public BACnetBinaryPVTagged getActualValue() {
    return (BACnetBinaryPVTagged) (getFeedbackValue());
  }

  @Override
  protected void serializeBACnetConstructedDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("BACnetConstructedDataBinaryOutputFeedbackValue");

    // Simple Field (feedbackValue)
    writeSimpleField("feedbackValue", feedbackValue, new DataWriterComplexDefault<>(writeBuffer));

    // Virtual field (doesn't actually serialize anything, just makes the value available)
    BACnetBinaryPVTagged actualValue = getActualValue();
    writeBuffer.writeVirtual("actualValue", actualValue);

    writeBuffer.popContext("BACnetConstructedDataBinaryOutputFeedbackValue");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    BACnetConstructedDataBinaryOutputFeedbackValue _value = this;

    // Simple field (feedbackValue)
    lengthInBits += feedbackValue.getLengthInBits();

    // A virtual field doesn't have any in- or output.

    return lengthInBits;
  }

  public static BACnetConstructedDataBinaryOutputFeedbackValueBuilder staticParseBuilder(
      ReadBuffer readBuffer,
      Short tagNumber,
      BACnetObjectType objectTypeArgument,
      BACnetPropertyIdentifier propertyIdentifierArgument,
      BACnetTagPayloadUnsignedInteger arrayIndexArgument)
      throws ParseException {
    readBuffer.pullContext("BACnetConstructedDataBinaryOutputFeedbackValue");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    BACnetBinaryPVTagged feedbackValue =
        readSimpleField(
            "feedbackValue",
            new DataReaderComplexDefault<>(
                () ->
                    BACnetBinaryPVTagged.staticParse(
                        readBuffer, (short) (0), (TagClass) (TagClass.APPLICATION_TAGS)),
                readBuffer));
    BACnetBinaryPVTagged actualValue =
        readVirtualField("actualValue", BACnetBinaryPVTagged.class, feedbackValue);

    readBuffer.closeContext("BACnetConstructedDataBinaryOutputFeedbackValue");
    // Create the instance
    return new BACnetConstructedDataBinaryOutputFeedbackValueBuilder(
        feedbackValue, tagNumber, arrayIndexArgument);
  }

  public static class BACnetConstructedDataBinaryOutputFeedbackValueBuilder
      implements BACnetConstructedData.BACnetConstructedDataBuilder {
    private final BACnetBinaryPVTagged feedbackValue;
    private final Short tagNumber;
    private final BACnetTagPayloadUnsignedInteger arrayIndexArgument;

    public BACnetConstructedDataBinaryOutputFeedbackValueBuilder(
        BACnetBinaryPVTagged feedbackValue,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {

      this.feedbackValue = feedbackValue;
      this.tagNumber = tagNumber;
      this.arrayIndexArgument = arrayIndexArgument;
    }

    public BACnetConstructedDataBinaryOutputFeedbackValue build(
        BACnetOpeningTag openingTag,
        BACnetTagHeader peekedTagHeader,
        BACnetClosingTag closingTag,
        Short tagNumber,
        BACnetTagPayloadUnsignedInteger arrayIndexArgument) {
      BACnetConstructedDataBinaryOutputFeedbackValue
          bACnetConstructedDataBinaryOutputFeedbackValue =
              new BACnetConstructedDataBinaryOutputFeedbackValue(
                  openingTag,
                  peekedTagHeader,
                  closingTag,
                  feedbackValue,
                  tagNumber,
                  arrayIndexArgument);
      return bACnetConstructedDataBinaryOutputFeedbackValue;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BACnetConstructedDataBinaryOutputFeedbackValue)) {
      return false;
    }
    BACnetConstructedDataBinaryOutputFeedbackValue that =
        (BACnetConstructedDataBinaryOutputFeedbackValue) o;
    return (getFeedbackValue() == that.getFeedbackValue()) && super.equals(that) && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getFeedbackValue());
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
