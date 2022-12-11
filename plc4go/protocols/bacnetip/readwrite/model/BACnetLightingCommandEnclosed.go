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

package model

import (
	"github.com/apache/plc4x/plc4go/spi/utils"
	"github.com/pkg/errors"
)

// Code generated by code-generation. DO NOT EDIT.

// BACnetLightingCommandEnclosed is the corresponding interface of BACnetLightingCommandEnclosed
type BACnetLightingCommandEnclosed interface {
	utils.LengthAware
	utils.Serializable
	// GetOpeningTag returns OpeningTag (property field)
	GetOpeningTag() BACnetOpeningTag
	// GetLightingCommand returns LightingCommand (property field)
	GetLightingCommand() BACnetLightingCommand
	// GetClosingTag returns ClosingTag (property field)
	GetClosingTag() BACnetClosingTag
}

// BACnetLightingCommandEnclosedExactly can be used when we want exactly this type and not a type which fulfills BACnetLightingCommandEnclosed.
// This is useful for switch cases.
type BACnetLightingCommandEnclosedExactly interface {
	BACnetLightingCommandEnclosed
	isBACnetLightingCommandEnclosed() bool
}

// _BACnetLightingCommandEnclosed is the data-structure of this message
type _BACnetLightingCommandEnclosed struct {
	OpeningTag      BACnetOpeningTag
	LightingCommand BACnetLightingCommand
	ClosingTag      BACnetClosingTag

	// Arguments.
	TagNumber uint8
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_BACnetLightingCommandEnclosed) GetOpeningTag() BACnetOpeningTag {
	return m.OpeningTag
}

func (m *_BACnetLightingCommandEnclosed) GetLightingCommand() BACnetLightingCommand {
	return m.LightingCommand
}

func (m *_BACnetLightingCommandEnclosed) GetClosingTag() BACnetClosingTag {
	return m.ClosingTag
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewBACnetLightingCommandEnclosed factory function for _BACnetLightingCommandEnclosed
func NewBACnetLightingCommandEnclosed(openingTag BACnetOpeningTag, lightingCommand BACnetLightingCommand, closingTag BACnetClosingTag, tagNumber uint8) *_BACnetLightingCommandEnclosed {
	return &_BACnetLightingCommandEnclosed{OpeningTag: openingTag, LightingCommand: lightingCommand, ClosingTag: closingTag, TagNumber: tagNumber}
}

// Deprecated: use the interface for direct cast
func CastBACnetLightingCommandEnclosed(structType interface{}) BACnetLightingCommandEnclosed {
	if casted, ok := structType.(BACnetLightingCommandEnclosed); ok {
		return casted
	}
	if casted, ok := structType.(*BACnetLightingCommandEnclosed); ok {
		return *casted
	}
	return nil
}

func (m *_BACnetLightingCommandEnclosed) GetTypeName() string {
	return "BACnetLightingCommandEnclosed"
}

func (m *_BACnetLightingCommandEnclosed) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_BACnetLightingCommandEnclosed) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(0)

	// Simple field (openingTag)
	lengthInBits += m.OpeningTag.GetLengthInBits()

	// Simple field (lightingCommand)
	lengthInBits += m.LightingCommand.GetLengthInBits()

	// Simple field (closingTag)
	lengthInBits += m.ClosingTag.GetLengthInBits()

	return lengthInBits
}

func (m *_BACnetLightingCommandEnclosed) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func BACnetLightingCommandEnclosedParse(theBytes []byte, tagNumber uint8) (BACnetLightingCommandEnclosed, error) {
	return BACnetLightingCommandEnclosedParseWithBuffer(utils.NewReadBufferByteBased(theBytes), tagNumber)
}

func BACnetLightingCommandEnclosedParseWithBuffer(readBuffer utils.ReadBuffer, tagNumber uint8) (BACnetLightingCommandEnclosed, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("BACnetLightingCommandEnclosed"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for BACnetLightingCommandEnclosed")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (openingTag)
	if pullErr := readBuffer.PullContext("openingTag"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for openingTag")
	}
	_openingTag, _openingTagErr := BACnetOpeningTagParseWithBuffer(readBuffer, uint8(tagNumber))
	if _openingTagErr != nil {
		return nil, errors.Wrap(_openingTagErr, "Error parsing 'openingTag' field of BACnetLightingCommandEnclosed")
	}
	openingTag := _openingTag.(BACnetOpeningTag)
	if closeErr := readBuffer.CloseContext("openingTag"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for openingTag")
	}

	// Simple Field (lightingCommand)
	if pullErr := readBuffer.PullContext("lightingCommand"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for lightingCommand")
	}
	_lightingCommand, _lightingCommandErr := BACnetLightingCommandParseWithBuffer(readBuffer)
	if _lightingCommandErr != nil {
		return nil, errors.Wrap(_lightingCommandErr, "Error parsing 'lightingCommand' field of BACnetLightingCommandEnclosed")
	}
	lightingCommand := _lightingCommand.(BACnetLightingCommand)
	if closeErr := readBuffer.CloseContext("lightingCommand"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for lightingCommand")
	}

	// Simple Field (closingTag)
	if pullErr := readBuffer.PullContext("closingTag"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for closingTag")
	}
	_closingTag, _closingTagErr := BACnetClosingTagParseWithBuffer(readBuffer, uint8(tagNumber))
	if _closingTagErr != nil {
		return nil, errors.Wrap(_closingTagErr, "Error parsing 'closingTag' field of BACnetLightingCommandEnclosed")
	}
	closingTag := _closingTag.(BACnetClosingTag)
	if closeErr := readBuffer.CloseContext("closingTag"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for closingTag")
	}

	if closeErr := readBuffer.CloseContext("BACnetLightingCommandEnclosed"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for BACnetLightingCommandEnclosed")
	}

	// Create the instance
	return &_BACnetLightingCommandEnclosed{
		TagNumber:       tagNumber,
		OpeningTag:      openingTag,
		LightingCommand: lightingCommand,
		ClosingTag:      closingTag,
	}, nil
}

func (m *_BACnetLightingCommandEnclosed) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes())))
	if err := m.SerializeWithWriteBuffer(wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_BACnetLightingCommandEnclosed) SerializeWithWriteBuffer(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	if pushErr := writeBuffer.PushContext("BACnetLightingCommandEnclosed"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for BACnetLightingCommandEnclosed")
	}

	// Simple Field (openingTag)
	if pushErr := writeBuffer.PushContext("openingTag"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for openingTag")
	}
	_openingTagErr := writeBuffer.WriteSerializable(m.GetOpeningTag())
	if popErr := writeBuffer.PopContext("openingTag"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for openingTag")
	}
	if _openingTagErr != nil {
		return errors.Wrap(_openingTagErr, "Error serializing 'openingTag' field")
	}

	// Simple Field (lightingCommand)
	if pushErr := writeBuffer.PushContext("lightingCommand"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for lightingCommand")
	}
	_lightingCommandErr := writeBuffer.WriteSerializable(m.GetLightingCommand())
	if popErr := writeBuffer.PopContext("lightingCommand"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for lightingCommand")
	}
	if _lightingCommandErr != nil {
		return errors.Wrap(_lightingCommandErr, "Error serializing 'lightingCommand' field")
	}

	// Simple Field (closingTag)
	if pushErr := writeBuffer.PushContext("closingTag"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for closingTag")
	}
	_closingTagErr := writeBuffer.WriteSerializable(m.GetClosingTag())
	if popErr := writeBuffer.PopContext("closingTag"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for closingTag")
	}
	if _closingTagErr != nil {
		return errors.Wrap(_closingTagErr, "Error serializing 'closingTag' field")
	}

	if popErr := writeBuffer.PopContext("BACnetLightingCommandEnclosed"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for BACnetLightingCommandEnclosed")
	}
	return nil
}

////
// Arguments Getter

func (m *_BACnetLightingCommandEnclosed) GetTagNumber() uint8 {
	return m.TagNumber
}

//
////

func (m *_BACnetLightingCommandEnclosed) isBACnetLightingCommandEnclosed() bool {
	return true
}

func (m *_BACnetLightingCommandEnclosed) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
