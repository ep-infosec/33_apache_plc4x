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
package org.apache.plc4x.java.cbus.readwrite;

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

public class MediaTransportControlDataSetTrack extends MediaTransportControlData
    implements Message {

  // Accessors for discriminator values.

  // Properties.
  protected final byte trackMSB;
  protected final byte trackMMSB;
  protected final byte trackMLSB;
  protected final byte trackLSB;

  public MediaTransportControlDataSetTrack(
      MediaTransportControlCommandTypeContainer commandTypeContainer,
      byte mediaLinkGroup,
      byte trackMSB,
      byte trackMMSB,
      byte trackMLSB,
      byte trackLSB) {
    super(commandTypeContainer, mediaLinkGroup);
    this.trackMSB = trackMSB;
    this.trackMMSB = trackMMSB;
    this.trackMLSB = trackMLSB;
    this.trackLSB = trackLSB;
  }

  public byte getTrackMSB() {
    return trackMSB;
  }

  public byte getTrackMMSB() {
    return trackMMSB;
  }

  public byte getTrackMLSB() {
    return trackMLSB;
  }

  public byte getTrackLSB() {
    return trackLSB;
  }

  @Override
  protected void serializeMediaTransportControlDataChild(WriteBuffer writeBuffer)
      throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("MediaTransportControlDataSetTrack");

    // Simple Field (trackMSB)
    writeSimpleField("trackMSB", trackMSB, writeByte(writeBuffer, 8));

    // Simple Field (trackMMSB)
    writeSimpleField("trackMMSB", trackMMSB, writeByte(writeBuffer, 8));

    // Simple Field (trackMLSB)
    writeSimpleField("trackMLSB", trackMLSB, writeByte(writeBuffer, 8));

    // Simple Field (trackLSB)
    writeSimpleField("trackLSB", trackLSB, writeByte(writeBuffer, 8));

    writeBuffer.popContext("MediaTransportControlDataSetTrack");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = super.getLengthInBits();
    MediaTransportControlDataSetTrack _value = this;

    // Simple field (trackMSB)
    lengthInBits += 8;

    // Simple field (trackMMSB)
    lengthInBits += 8;

    // Simple field (trackMLSB)
    lengthInBits += 8;

    // Simple field (trackLSB)
    lengthInBits += 8;

    return lengthInBits;
  }

  public static MediaTransportControlDataSetTrackBuilder staticParseBuilder(ReadBuffer readBuffer)
      throws ParseException {
    readBuffer.pullContext("MediaTransportControlDataSetTrack");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    byte trackMSB = readSimpleField("trackMSB", readByte(readBuffer, 8));

    byte trackMMSB = readSimpleField("trackMMSB", readByte(readBuffer, 8));

    byte trackMLSB = readSimpleField("trackMLSB", readByte(readBuffer, 8));

    byte trackLSB = readSimpleField("trackLSB", readByte(readBuffer, 8));

    readBuffer.closeContext("MediaTransportControlDataSetTrack");
    // Create the instance
    return new MediaTransportControlDataSetTrackBuilder(trackMSB, trackMMSB, trackMLSB, trackLSB);
  }

  public static class MediaTransportControlDataSetTrackBuilder
      implements MediaTransportControlData.MediaTransportControlDataBuilder {
    private final byte trackMSB;
    private final byte trackMMSB;
    private final byte trackMLSB;
    private final byte trackLSB;

    public MediaTransportControlDataSetTrackBuilder(
        byte trackMSB, byte trackMMSB, byte trackMLSB, byte trackLSB) {

      this.trackMSB = trackMSB;
      this.trackMMSB = trackMMSB;
      this.trackMLSB = trackMLSB;
      this.trackLSB = trackLSB;
    }

    public MediaTransportControlDataSetTrack build(
        MediaTransportControlCommandTypeContainer commandTypeContainer, byte mediaLinkGroup) {
      MediaTransportControlDataSetTrack mediaTransportControlDataSetTrack =
          new MediaTransportControlDataSetTrack(
              commandTypeContainer, mediaLinkGroup, trackMSB, trackMMSB, trackMLSB, trackLSB);
      return mediaTransportControlDataSetTrack;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MediaTransportControlDataSetTrack)) {
      return false;
    }
    MediaTransportControlDataSetTrack that = (MediaTransportControlDataSetTrack) o;
    return (getTrackMSB() == that.getTrackMSB())
        && (getTrackMMSB() == that.getTrackMMSB())
        && (getTrackMLSB() == that.getTrackMLSB())
        && (getTrackLSB() == that.getTrackLSB())
        && super.equals(that)
        && true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(), getTrackMSB(), getTrackMMSB(), getTrackMLSB(), getTrackLSB());
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
