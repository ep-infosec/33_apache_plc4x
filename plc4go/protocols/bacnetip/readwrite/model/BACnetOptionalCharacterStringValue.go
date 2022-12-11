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

// BACnetOptionalCharacterStringValue is the corresponding interface of BACnetOptionalCharacterStringValue
type BACnetOptionalCharacterStringValue interface {
	utils.LengthAware
	utils.Serializable
	BACnetOptionalCharacterString
	// GetCharacterstring returns Characterstring (property field)
	GetCharacterstring() BACnetApplicationTagCharacterString
}

// BACnetOptionalCharacterStringValueExactly can be used when we want exactly this type and not a type which fulfills BACnetOptionalCharacterStringValue.
// This is useful for switch cases.
type BACnetOptionalCharacterStringValueExactly interface {
	BACnetOptionalCharacterStringValue
	isBACnetOptionalCharacterStringValue() bool
}

// _BACnetOptionalCharacterStringValue is the data-structure of this message
type _BACnetOptionalCharacterStringValue struct {
	*_BACnetOptionalCharacterString
	Characterstring BACnetApplicationTagCharacterString
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_BACnetOptionalCharacterStringValue) InitializeParent(parent BACnetOptionalCharacterString, peekedTagHeader BACnetTagHeader) {
	m.PeekedTagHeader = peekedTagHeader
}

func (m *_BACnetOptionalCharacterStringValue) GetParent() BACnetOptionalCharacterString {
	return m._BACnetOptionalCharacterString
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_BACnetOptionalCharacterStringValue) GetCharacterstring() BACnetApplicationTagCharacterString {
	return m.Characterstring
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewBACnetOptionalCharacterStringValue factory function for _BACnetOptionalCharacterStringValue
func NewBACnetOptionalCharacterStringValue(characterstring BACnetApplicationTagCharacterString, peekedTagHeader BACnetTagHeader) *_BACnetOptionalCharacterStringValue {
	_result := &_BACnetOptionalCharacterStringValue{
		Characterstring:                characterstring,
		_BACnetOptionalCharacterString: NewBACnetOptionalCharacterString(peekedTagHeader),
	}
	_result._BACnetOptionalCharacterString._BACnetOptionalCharacterStringChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastBACnetOptionalCharacterStringValue(structType interface{}) BACnetOptionalCharacterStringValue {
	if casted, ok := structType.(BACnetOptionalCharacterStringValue); ok {
		return casted
	}
	if casted, ok := structType.(*BACnetOptionalCharacterStringValue); ok {
		return *casted
	}
	return nil
}

func (m *_BACnetOptionalCharacterStringValue) GetTypeName() string {
	return "BACnetOptionalCharacterStringValue"
}

func (m *_BACnetOptionalCharacterStringValue) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_BACnetOptionalCharacterStringValue) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	// Simple field (characterstring)
	lengthInBits += m.Characterstring.GetLengthInBits()

	return lengthInBits
}

func (m *_BACnetOptionalCharacterStringValue) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func BACnetOptionalCharacterStringValueParse(theBytes []byte) (BACnetOptionalCharacterStringValue, error) {
	return BACnetOptionalCharacterStringValueParseWithBuffer(utils.NewReadBufferByteBased(theBytes))
}

func BACnetOptionalCharacterStringValueParseWithBuffer(readBuffer utils.ReadBuffer) (BACnetOptionalCharacterStringValue, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("BACnetOptionalCharacterStringValue"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for BACnetOptionalCharacterStringValue")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (characterstring)
	if pullErr := readBuffer.PullContext("characterstring"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for characterstring")
	}
	_characterstring, _characterstringErr := BACnetApplicationTagParseWithBuffer(readBuffer)
	if _characterstringErr != nil {
		return nil, errors.Wrap(_characterstringErr, "Error parsing 'characterstring' field of BACnetOptionalCharacterStringValue")
	}
	characterstring := _characterstring.(BACnetApplicationTagCharacterString)
	if closeErr := readBuffer.CloseContext("characterstring"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for characterstring")
	}

	if closeErr := readBuffer.CloseContext("BACnetOptionalCharacterStringValue"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for BACnetOptionalCharacterStringValue")
	}

	// Create a partially initialized instance
	_child := &_BACnetOptionalCharacterStringValue{
		_BACnetOptionalCharacterString: &_BACnetOptionalCharacterString{},
		Characterstring:                characterstring,
	}
	_child._BACnetOptionalCharacterString._BACnetOptionalCharacterStringChildRequirements = _child
	return _child, nil
}

func (m *_BACnetOptionalCharacterStringValue) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes())))
	if err := m.SerializeWithWriteBuffer(wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_BACnetOptionalCharacterStringValue) SerializeWithWriteBuffer(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("BACnetOptionalCharacterStringValue"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for BACnetOptionalCharacterStringValue")
		}

		// Simple Field (characterstring)
		if pushErr := writeBuffer.PushContext("characterstring"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for characterstring")
		}
		_characterstringErr := writeBuffer.WriteSerializable(m.GetCharacterstring())
		if popErr := writeBuffer.PopContext("characterstring"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for characterstring")
		}
		if _characterstringErr != nil {
			return errors.Wrap(_characterstringErr, "Error serializing 'characterstring' field")
		}

		if popErr := writeBuffer.PopContext("BACnetOptionalCharacterStringValue"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for BACnetOptionalCharacterStringValue")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_BACnetOptionalCharacterStringValue) isBACnetOptionalCharacterStringValue() bool {
	return true
}

func (m *_BACnetOptionalCharacterStringValue) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}