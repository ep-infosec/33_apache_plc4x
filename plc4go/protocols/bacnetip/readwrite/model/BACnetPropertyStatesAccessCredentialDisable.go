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

// BACnetPropertyStatesAccessCredentialDisable is the corresponding interface of BACnetPropertyStatesAccessCredentialDisable
type BACnetPropertyStatesAccessCredentialDisable interface {
	utils.LengthAware
	utils.Serializable
	BACnetPropertyStates
	// GetAccessCredentialDisable returns AccessCredentialDisable (property field)
	GetAccessCredentialDisable() BACnetAccessCredentialDisableTagged
}

// BACnetPropertyStatesAccessCredentialDisableExactly can be used when we want exactly this type and not a type which fulfills BACnetPropertyStatesAccessCredentialDisable.
// This is useful for switch cases.
type BACnetPropertyStatesAccessCredentialDisableExactly interface {
	BACnetPropertyStatesAccessCredentialDisable
	isBACnetPropertyStatesAccessCredentialDisable() bool
}

// _BACnetPropertyStatesAccessCredentialDisable is the data-structure of this message
type _BACnetPropertyStatesAccessCredentialDisable struct {
	*_BACnetPropertyStates
	AccessCredentialDisable BACnetAccessCredentialDisableTagged
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_BACnetPropertyStatesAccessCredentialDisable) InitializeParent(parent BACnetPropertyStates, peekedTagHeader BACnetTagHeader) {
	m.PeekedTagHeader = peekedTagHeader
}

func (m *_BACnetPropertyStatesAccessCredentialDisable) GetParent() BACnetPropertyStates {
	return m._BACnetPropertyStates
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_BACnetPropertyStatesAccessCredentialDisable) GetAccessCredentialDisable() BACnetAccessCredentialDisableTagged {
	return m.AccessCredentialDisable
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewBACnetPropertyStatesAccessCredentialDisable factory function for _BACnetPropertyStatesAccessCredentialDisable
func NewBACnetPropertyStatesAccessCredentialDisable(accessCredentialDisable BACnetAccessCredentialDisableTagged, peekedTagHeader BACnetTagHeader) *_BACnetPropertyStatesAccessCredentialDisable {
	_result := &_BACnetPropertyStatesAccessCredentialDisable{
		AccessCredentialDisable: accessCredentialDisable,
		_BACnetPropertyStates:   NewBACnetPropertyStates(peekedTagHeader),
	}
	_result._BACnetPropertyStates._BACnetPropertyStatesChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastBACnetPropertyStatesAccessCredentialDisable(structType interface{}) BACnetPropertyStatesAccessCredentialDisable {
	if casted, ok := structType.(BACnetPropertyStatesAccessCredentialDisable); ok {
		return casted
	}
	if casted, ok := structType.(*BACnetPropertyStatesAccessCredentialDisable); ok {
		return *casted
	}
	return nil
}

func (m *_BACnetPropertyStatesAccessCredentialDisable) GetTypeName() string {
	return "BACnetPropertyStatesAccessCredentialDisable"
}

func (m *_BACnetPropertyStatesAccessCredentialDisable) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_BACnetPropertyStatesAccessCredentialDisable) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	// Simple field (accessCredentialDisable)
	lengthInBits += m.AccessCredentialDisable.GetLengthInBits()

	return lengthInBits
}

func (m *_BACnetPropertyStatesAccessCredentialDisable) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func BACnetPropertyStatesAccessCredentialDisableParse(theBytes []byte, peekedTagNumber uint8) (BACnetPropertyStatesAccessCredentialDisable, error) {
	return BACnetPropertyStatesAccessCredentialDisableParseWithBuffer(utils.NewReadBufferByteBased(theBytes), peekedTagNumber)
}

func BACnetPropertyStatesAccessCredentialDisableParseWithBuffer(readBuffer utils.ReadBuffer, peekedTagNumber uint8) (BACnetPropertyStatesAccessCredentialDisable, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("BACnetPropertyStatesAccessCredentialDisable"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for BACnetPropertyStatesAccessCredentialDisable")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (accessCredentialDisable)
	if pullErr := readBuffer.PullContext("accessCredentialDisable"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for accessCredentialDisable")
	}
	_accessCredentialDisable, _accessCredentialDisableErr := BACnetAccessCredentialDisableTaggedParseWithBuffer(readBuffer, uint8(peekedTagNumber), TagClass(TagClass_CONTEXT_SPECIFIC_TAGS))
	if _accessCredentialDisableErr != nil {
		return nil, errors.Wrap(_accessCredentialDisableErr, "Error parsing 'accessCredentialDisable' field of BACnetPropertyStatesAccessCredentialDisable")
	}
	accessCredentialDisable := _accessCredentialDisable.(BACnetAccessCredentialDisableTagged)
	if closeErr := readBuffer.CloseContext("accessCredentialDisable"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for accessCredentialDisable")
	}

	if closeErr := readBuffer.CloseContext("BACnetPropertyStatesAccessCredentialDisable"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for BACnetPropertyStatesAccessCredentialDisable")
	}

	// Create a partially initialized instance
	_child := &_BACnetPropertyStatesAccessCredentialDisable{
		_BACnetPropertyStates:   &_BACnetPropertyStates{},
		AccessCredentialDisable: accessCredentialDisable,
	}
	_child._BACnetPropertyStates._BACnetPropertyStatesChildRequirements = _child
	return _child, nil
}

func (m *_BACnetPropertyStatesAccessCredentialDisable) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes())))
	if err := m.SerializeWithWriteBuffer(wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_BACnetPropertyStatesAccessCredentialDisable) SerializeWithWriteBuffer(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("BACnetPropertyStatesAccessCredentialDisable"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for BACnetPropertyStatesAccessCredentialDisable")
		}

		// Simple Field (accessCredentialDisable)
		if pushErr := writeBuffer.PushContext("accessCredentialDisable"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for accessCredentialDisable")
		}
		_accessCredentialDisableErr := writeBuffer.WriteSerializable(m.GetAccessCredentialDisable())
		if popErr := writeBuffer.PopContext("accessCredentialDisable"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for accessCredentialDisable")
		}
		if _accessCredentialDisableErr != nil {
			return errors.Wrap(_accessCredentialDisableErr, "Error serializing 'accessCredentialDisable' field")
		}

		if popErr := writeBuffer.PopContext("BACnetPropertyStatesAccessCredentialDisable"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for BACnetPropertyStatesAccessCredentialDisable")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_BACnetPropertyStatesAccessCredentialDisable) isBACnetPropertyStatesAccessCredentialDisable() bool {
	return true
}

func (m *_BACnetPropertyStatesAccessCredentialDisable) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
