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

// ApduDataExtMemoryBitWrite is the corresponding interface of ApduDataExtMemoryBitWrite
type ApduDataExtMemoryBitWrite interface {
	utils.LengthAware
	utils.Serializable
	ApduDataExt
}

// ApduDataExtMemoryBitWriteExactly can be used when we want exactly this type and not a type which fulfills ApduDataExtMemoryBitWrite.
// This is useful for switch cases.
type ApduDataExtMemoryBitWriteExactly interface {
	ApduDataExtMemoryBitWrite
	isApduDataExtMemoryBitWrite() bool
}

// _ApduDataExtMemoryBitWrite is the data-structure of this message
type _ApduDataExtMemoryBitWrite struct {
	*_ApduDataExt
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

func (m *_ApduDataExtMemoryBitWrite) GetExtApciType() uint8 {
	return 0x10
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_ApduDataExtMemoryBitWrite) InitializeParent(parent ApduDataExt) {}

func (m *_ApduDataExtMemoryBitWrite) GetParent() ApduDataExt {
	return m._ApduDataExt
}

// NewApduDataExtMemoryBitWrite factory function for _ApduDataExtMemoryBitWrite
func NewApduDataExtMemoryBitWrite(length uint8) *_ApduDataExtMemoryBitWrite {
	_result := &_ApduDataExtMemoryBitWrite{
		_ApduDataExt: NewApduDataExt(length),
	}
	_result._ApduDataExt._ApduDataExtChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastApduDataExtMemoryBitWrite(structType interface{}) ApduDataExtMemoryBitWrite {
	if casted, ok := structType.(ApduDataExtMemoryBitWrite); ok {
		return casted
	}
	if casted, ok := structType.(*ApduDataExtMemoryBitWrite); ok {
		return *casted
	}
	return nil
}

func (m *_ApduDataExtMemoryBitWrite) GetTypeName() string {
	return "ApduDataExtMemoryBitWrite"
}

func (m *_ApduDataExtMemoryBitWrite) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_ApduDataExtMemoryBitWrite) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	return lengthInBits
}

func (m *_ApduDataExtMemoryBitWrite) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func ApduDataExtMemoryBitWriteParse(theBytes []byte, length uint8) (ApduDataExtMemoryBitWrite, error) {
	return ApduDataExtMemoryBitWriteParseWithBuffer(utils.NewReadBufferByteBased(theBytes), length)
}

func ApduDataExtMemoryBitWriteParseWithBuffer(readBuffer utils.ReadBuffer, length uint8) (ApduDataExtMemoryBitWrite, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("ApduDataExtMemoryBitWrite"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for ApduDataExtMemoryBitWrite")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	if closeErr := readBuffer.CloseContext("ApduDataExtMemoryBitWrite"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for ApduDataExtMemoryBitWrite")
	}

	// Create a partially initialized instance
	_child := &_ApduDataExtMemoryBitWrite{
		_ApduDataExt: &_ApduDataExt{
			Length: length,
		},
	}
	_child._ApduDataExt._ApduDataExtChildRequirements = _child
	return _child, nil
}

func (m *_ApduDataExtMemoryBitWrite) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes())))
	if err := m.SerializeWithWriteBuffer(wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_ApduDataExtMemoryBitWrite) SerializeWithWriteBuffer(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("ApduDataExtMemoryBitWrite"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for ApduDataExtMemoryBitWrite")
		}

		if popErr := writeBuffer.PopContext("ApduDataExtMemoryBitWrite"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for ApduDataExtMemoryBitWrite")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_ApduDataExtMemoryBitWrite) isApduDataExtMemoryBitWrite() bool {
	return true
}

func (m *_ApduDataExtMemoryBitWrite) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
