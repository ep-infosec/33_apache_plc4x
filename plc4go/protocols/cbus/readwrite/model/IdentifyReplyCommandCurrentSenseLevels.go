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

// IdentifyReplyCommandCurrentSenseLevels is the corresponding interface of IdentifyReplyCommandCurrentSenseLevels
type IdentifyReplyCommandCurrentSenseLevels interface {
	utils.LengthAware
	utils.Serializable
	IdentifyReplyCommand
	// GetCurrentSenseLevels returns CurrentSenseLevels (property field)
	GetCurrentSenseLevels() []byte
}

// IdentifyReplyCommandCurrentSenseLevelsExactly can be used when we want exactly this type and not a type which fulfills IdentifyReplyCommandCurrentSenseLevels.
// This is useful for switch cases.
type IdentifyReplyCommandCurrentSenseLevelsExactly interface {
	IdentifyReplyCommandCurrentSenseLevels
	isIdentifyReplyCommandCurrentSenseLevels() bool
}

// _IdentifyReplyCommandCurrentSenseLevels is the data-structure of this message
type _IdentifyReplyCommandCurrentSenseLevels struct {
	*_IdentifyReplyCommand
	CurrentSenseLevels []byte
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

func (m *_IdentifyReplyCommandCurrentSenseLevels) GetAttribute() Attribute {
	return Attribute_CurrentSenseLevels
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_IdentifyReplyCommandCurrentSenseLevels) InitializeParent(parent IdentifyReplyCommand) {}

func (m *_IdentifyReplyCommandCurrentSenseLevels) GetParent() IdentifyReplyCommand {
	return m._IdentifyReplyCommand
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_IdentifyReplyCommandCurrentSenseLevels) GetCurrentSenseLevels() []byte {
	return m.CurrentSenseLevels
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewIdentifyReplyCommandCurrentSenseLevels factory function for _IdentifyReplyCommandCurrentSenseLevels
func NewIdentifyReplyCommandCurrentSenseLevels(currentSenseLevels []byte, numBytes uint8) *_IdentifyReplyCommandCurrentSenseLevels {
	_result := &_IdentifyReplyCommandCurrentSenseLevels{
		CurrentSenseLevels:    currentSenseLevels,
		_IdentifyReplyCommand: NewIdentifyReplyCommand(numBytes),
	}
	_result._IdentifyReplyCommand._IdentifyReplyCommandChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastIdentifyReplyCommandCurrentSenseLevels(structType interface{}) IdentifyReplyCommandCurrentSenseLevels {
	if casted, ok := structType.(IdentifyReplyCommandCurrentSenseLevels); ok {
		return casted
	}
	if casted, ok := structType.(*IdentifyReplyCommandCurrentSenseLevels); ok {
		return *casted
	}
	return nil
}

func (m *_IdentifyReplyCommandCurrentSenseLevels) GetTypeName() string {
	return "IdentifyReplyCommandCurrentSenseLevels"
}

func (m *_IdentifyReplyCommandCurrentSenseLevels) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_IdentifyReplyCommandCurrentSenseLevels) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	// Array field
	if len(m.CurrentSenseLevels) > 0 {
		lengthInBits += 8 * uint16(len(m.CurrentSenseLevels))
	}

	return lengthInBits
}

func (m *_IdentifyReplyCommandCurrentSenseLevels) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func IdentifyReplyCommandCurrentSenseLevelsParse(theBytes []byte, attribute Attribute, numBytes uint8) (IdentifyReplyCommandCurrentSenseLevels, error) {
	return IdentifyReplyCommandCurrentSenseLevelsParseWithBuffer(utils.NewReadBufferByteBased(theBytes), attribute, numBytes)
}

func IdentifyReplyCommandCurrentSenseLevelsParseWithBuffer(readBuffer utils.ReadBuffer, attribute Attribute, numBytes uint8) (IdentifyReplyCommandCurrentSenseLevels, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("IdentifyReplyCommandCurrentSenseLevels"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for IdentifyReplyCommandCurrentSenseLevels")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos
	// Byte Array field (currentSenseLevels)
	numberOfBytescurrentSenseLevels := int(numBytes)
	currentSenseLevels, _readArrayErr := readBuffer.ReadByteArray("currentSenseLevels", numberOfBytescurrentSenseLevels)
	if _readArrayErr != nil {
		return nil, errors.Wrap(_readArrayErr, "Error parsing 'currentSenseLevels' field of IdentifyReplyCommandCurrentSenseLevels")
	}

	if closeErr := readBuffer.CloseContext("IdentifyReplyCommandCurrentSenseLevels"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for IdentifyReplyCommandCurrentSenseLevels")
	}

	// Create a partially initialized instance
	_child := &_IdentifyReplyCommandCurrentSenseLevels{
		_IdentifyReplyCommand: &_IdentifyReplyCommand{
			NumBytes: numBytes,
		},
		CurrentSenseLevels: currentSenseLevels,
	}
	_child._IdentifyReplyCommand._IdentifyReplyCommandChildRequirements = _child
	return _child, nil
}

func (m *_IdentifyReplyCommandCurrentSenseLevels) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes())))
	if err := m.SerializeWithWriteBuffer(wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_IdentifyReplyCommandCurrentSenseLevels) SerializeWithWriteBuffer(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("IdentifyReplyCommandCurrentSenseLevels"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for IdentifyReplyCommandCurrentSenseLevels")
		}

		// Array Field (currentSenseLevels)
		// Byte Array field (currentSenseLevels)
		if err := writeBuffer.WriteByteArray("currentSenseLevels", m.GetCurrentSenseLevels()); err != nil {
			return errors.Wrap(err, "Error serializing 'currentSenseLevels' field")
		}

		if popErr := writeBuffer.PopContext("IdentifyReplyCommandCurrentSenseLevels"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for IdentifyReplyCommandCurrentSenseLevels")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_IdentifyReplyCommandCurrentSenseLevels) isIdentifyReplyCommandCurrentSenseLevels() bool {
	return true
}

func (m *_IdentifyReplyCommandCurrentSenseLevels) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}