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
	"encoding/binary"
	"github.com/apache/plc4x/plc4go/spi/utils"
	"github.com/pkg/errors"
)

// Code generated by code-generation. DO NOT EDIT.

// BVLCReadForeignDeviceTable is the corresponding interface of BVLCReadForeignDeviceTable
type BVLCReadForeignDeviceTable interface {
	utils.LengthAware
	utils.Serializable
	BVLC
}

// BVLCReadForeignDeviceTableExactly can be used when we want exactly this type and not a type which fulfills BVLCReadForeignDeviceTable.
// This is useful for switch cases.
type BVLCReadForeignDeviceTableExactly interface {
	BVLCReadForeignDeviceTable
	isBVLCReadForeignDeviceTable() bool
}

// _BVLCReadForeignDeviceTable is the data-structure of this message
type _BVLCReadForeignDeviceTable struct {
	*_BVLC
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

func (m *_BVLCReadForeignDeviceTable) GetBvlcFunction() uint8 {
	return 0x06
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_BVLCReadForeignDeviceTable) InitializeParent(parent BVLC) {}

func (m *_BVLCReadForeignDeviceTable) GetParent() BVLC {
	return m._BVLC
}

// NewBVLCReadForeignDeviceTable factory function for _BVLCReadForeignDeviceTable
func NewBVLCReadForeignDeviceTable() *_BVLCReadForeignDeviceTable {
	_result := &_BVLCReadForeignDeviceTable{
		_BVLC: NewBVLC(),
	}
	_result._BVLC._BVLCChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastBVLCReadForeignDeviceTable(structType interface{}) BVLCReadForeignDeviceTable {
	if casted, ok := structType.(BVLCReadForeignDeviceTable); ok {
		return casted
	}
	if casted, ok := structType.(*BVLCReadForeignDeviceTable); ok {
		return *casted
	}
	return nil
}

func (m *_BVLCReadForeignDeviceTable) GetTypeName() string {
	return "BVLCReadForeignDeviceTable"
}

func (m *_BVLCReadForeignDeviceTable) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_BVLCReadForeignDeviceTable) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	return lengthInBits
}

func (m *_BVLCReadForeignDeviceTable) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func BVLCReadForeignDeviceTableParse(theBytes []byte) (BVLCReadForeignDeviceTable, error) {
	return BVLCReadForeignDeviceTableParseWithBuffer(utils.NewReadBufferByteBased(theBytes, utils.WithByteOrderForReadBufferByteBased(binary.BigEndian)))
}

func BVLCReadForeignDeviceTableParseWithBuffer(readBuffer utils.ReadBuffer) (BVLCReadForeignDeviceTable, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("BVLCReadForeignDeviceTable"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for BVLCReadForeignDeviceTable")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	if closeErr := readBuffer.CloseContext("BVLCReadForeignDeviceTable"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for BVLCReadForeignDeviceTable")
	}

	// Create a partially initialized instance
	_child := &_BVLCReadForeignDeviceTable{
		_BVLC: &_BVLC{},
	}
	_child._BVLC._BVLCChildRequirements = _child
	return _child, nil
}

func (m *_BVLCReadForeignDeviceTable) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes())), utils.WithByteOrderForByteBasedBuffer(binary.BigEndian))
	if err := m.SerializeWithWriteBuffer(wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_BVLCReadForeignDeviceTable) SerializeWithWriteBuffer(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("BVLCReadForeignDeviceTable"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for BVLCReadForeignDeviceTable")
		}

		if popErr := writeBuffer.PopContext("BVLCReadForeignDeviceTable"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for BVLCReadForeignDeviceTable")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_BVLCReadForeignDeviceTable) isBVLCReadForeignDeviceTable() bool {
	return true
}

func (m *_BVLCReadForeignDeviceTable) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}