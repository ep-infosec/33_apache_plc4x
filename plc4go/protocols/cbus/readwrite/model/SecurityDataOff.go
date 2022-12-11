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

// SecurityDataOff is the corresponding interface of SecurityDataOff
type SecurityDataOff interface {
	utils.LengthAware
	utils.Serializable
	SecurityData
	// GetData returns Data (property field)
	GetData() []byte
}

// SecurityDataOffExactly can be used when we want exactly this type and not a type which fulfills SecurityDataOff.
// This is useful for switch cases.
type SecurityDataOffExactly interface {
	SecurityDataOff
	isSecurityDataOff() bool
}

// _SecurityDataOff is the data-structure of this message
type _SecurityDataOff struct {
	*_SecurityData
	Data []byte
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_SecurityDataOff) InitializeParent(parent SecurityData, commandTypeContainer SecurityCommandTypeContainer, argument byte) {
	m.CommandTypeContainer = commandTypeContainer
	m.Argument = argument
}

func (m *_SecurityDataOff) GetParent() SecurityData {
	return m._SecurityData
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_SecurityDataOff) GetData() []byte {
	return m.Data
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewSecurityDataOff factory function for _SecurityDataOff
func NewSecurityDataOff(data []byte, commandTypeContainer SecurityCommandTypeContainer, argument byte) *_SecurityDataOff {
	_result := &_SecurityDataOff{
		Data:          data,
		_SecurityData: NewSecurityData(commandTypeContainer, argument),
	}
	_result._SecurityData._SecurityDataChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastSecurityDataOff(structType interface{}) SecurityDataOff {
	if casted, ok := structType.(SecurityDataOff); ok {
		return casted
	}
	if casted, ok := structType.(*SecurityDataOff); ok {
		return *casted
	}
	return nil
}

func (m *_SecurityDataOff) GetTypeName() string {
	return "SecurityDataOff"
}

func (m *_SecurityDataOff) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_SecurityDataOff) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	// Array field
	if len(m.Data) > 0 {
		lengthInBits += 8 * uint16(len(m.Data))
	}

	return lengthInBits
}

func (m *_SecurityDataOff) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func SecurityDataOffParse(theBytes []byte, commandTypeContainer SecurityCommandTypeContainer) (SecurityDataOff, error) {
	return SecurityDataOffParseWithBuffer(utils.NewReadBufferByteBased(theBytes), commandTypeContainer)
}

func SecurityDataOffParseWithBuffer(readBuffer utils.ReadBuffer, commandTypeContainer SecurityCommandTypeContainer) (SecurityDataOff, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("SecurityDataOff"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for SecurityDataOff")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos
	// Byte Array field (data)
	numberOfBytesdata := int(uint16(commandTypeContainer.NumBytes()) - uint16(uint16(1)))
	data, _readArrayErr := readBuffer.ReadByteArray("data", numberOfBytesdata)
	if _readArrayErr != nil {
		return nil, errors.Wrap(_readArrayErr, "Error parsing 'data' field of SecurityDataOff")
	}

	if closeErr := readBuffer.CloseContext("SecurityDataOff"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for SecurityDataOff")
	}

	// Create a partially initialized instance
	_child := &_SecurityDataOff{
		_SecurityData: &_SecurityData{},
		Data:          data,
	}
	_child._SecurityData._SecurityDataChildRequirements = _child
	return _child, nil
}

func (m *_SecurityDataOff) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes())))
	if err := m.SerializeWithWriteBuffer(wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_SecurityDataOff) SerializeWithWriteBuffer(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("SecurityDataOff"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for SecurityDataOff")
		}

		// Array Field (data)
		// Byte Array field (data)
		if err := writeBuffer.WriteByteArray("data", m.GetData()); err != nil {
			return errors.Wrap(err, "Error serializing 'data' field")
		}

		if popErr := writeBuffer.PopContext("SecurityDataOff"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for SecurityDataOff")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_SecurityDataOff) isSecurityDataOff() bool {
	return true
}

func (m *_SecurityDataOff) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}