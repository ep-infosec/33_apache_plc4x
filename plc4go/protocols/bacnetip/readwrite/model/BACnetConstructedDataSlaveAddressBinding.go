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

// BACnetConstructedDataSlaveAddressBinding is the corresponding interface of BACnetConstructedDataSlaveAddressBinding
type BACnetConstructedDataSlaveAddressBinding interface {
	utils.LengthAware
	utils.Serializable
	BACnetConstructedData
	// GetSlaveAddressBinding returns SlaveAddressBinding (property field)
	GetSlaveAddressBinding() []BACnetAddressBinding
}

// BACnetConstructedDataSlaveAddressBindingExactly can be used when we want exactly this type and not a type which fulfills BACnetConstructedDataSlaveAddressBinding.
// This is useful for switch cases.
type BACnetConstructedDataSlaveAddressBindingExactly interface {
	BACnetConstructedDataSlaveAddressBinding
	isBACnetConstructedDataSlaveAddressBinding() bool
}

// _BACnetConstructedDataSlaveAddressBinding is the data-structure of this message
type _BACnetConstructedDataSlaveAddressBinding struct {
	*_BACnetConstructedData
	SlaveAddressBinding []BACnetAddressBinding
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

func (m *_BACnetConstructedDataSlaveAddressBinding) GetObjectTypeArgument() BACnetObjectType {
	return 0
}

func (m *_BACnetConstructedDataSlaveAddressBinding) GetPropertyIdentifierArgument() BACnetPropertyIdentifier {
	return BACnetPropertyIdentifier_SLAVE_ADDRESS_BINDING
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_BACnetConstructedDataSlaveAddressBinding) InitializeParent(parent BACnetConstructedData, openingTag BACnetOpeningTag, peekedTagHeader BACnetTagHeader, closingTag BACnetClosingTag) {
	m.OpeningTag = openingTag
	m.PeekedTagHeader = peekedTagHeader
	m.ClosingTag = closingTag
}

func (m *_BACnetConstructedDataSlaveAddressBinding) GetParent() BACnetConstructedData {
	return m._BACnetConstructedData
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_BACnetConstructedDataSlaveAddressBinding) GetSlaveAddressBinding() []BACnetAddressBinding {
	return m.SlaveAddressBinding
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewBACnetConstructedDataSlaveAddressBinding factory function for _BACnetConstructedDataSlaveAddressBinding
func NewBACnetConstructedDataSlaveAddressBinding(slaveAddressBinding []BACnetAddressBinding, openingTag BACnetOpeningTag, peekedTagHeader BACnetTagHeader, closingTag BACnetClosingTag, tagNumber uint8, arrayIndexArgument BACnetTagPayloadUnsignedInteger) *_BACnetConstructedDataSlaveAddressBinding {
	_result := &_BACnetConstructedDataSlaveAddressBinding{
		SlaveAddressBinding:    slaveAddressBinding,
		_BACnetConstructedData: NewBACnetConstructedData(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument),
	}
	_result._BACnetConstructedData._BACnetConstructedDataChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastBACnetConstructedDataSlaveAddressBinding(structType interface{}) BACnetConstructedDataSlaveAddressBinding {
	if casted, ok := structType.(BACnetConstructedDataSlaveAddressBinding); ok {
		return casted
	}
	if casted, ok := structType.(*BACnetConstructedDataSlaveAddressBinding); ok {
		return *casted
	}
	return nil
}

func (m *_BACnetConstructedDataSlaveAddressBinding) GetTypeName() string {
	return "BACnetConstructedDataSlaveAddressBinding"
}

func (m *_BACnetConstructedDataSlaveAddressBinding) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_BACnetConstructedDataSlaveAddressBinding) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	// Array field
	if len(m.SlaveAddressBinding) > 0 {
		for _, element := range m.SlaveAddressBinding {
			lengthInBits += element.GetLengthInBits()
		}
	}

	return lengthInBits
}

func (m *_BACnetConstructedDataSlaveAddressBinding) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func BACnetConstructedDataSlaveAddressBindingParse(theBytes []byte, tagNumber uint8, objectTypeArgument BACnetObjectType, propertyIdentifierArgument BACnetPropertyIdentifier, arrayIndexArgument BACnetTagPayloadUnsignedInteger) (BACnetConstructedDataSlaveAddressBinding, error) {
	return BACnetConstructedDataSlaveAddressBindingParseWithBuffer(utils.NewReadBufferByteBased(theBytes), tagNumber, objectTypeArgument, propertyIdentifierArgument, arrayIndexArgument)
}

func BACnetConstructedDataSlaveAddressBindingParseWithBuffer(readBuffer utils.ReadBuffer, tagNumber uint8, objectTypeArgument BACnetObjectType, propertyIdentifierArgument BACnetPropertyIdentifier, arrayIndexArgument BACnetTagPayloadUnsignedInteger) (BACnetConstructedDataSlaveAddressBinding, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("BACnetConstructedDataSlaveAddressBinding"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for BACnetConstructedDataSlaveAddressBinding")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Array field (slaveAddressBinding)
	if pullErr := readBuffer.PullContext("slaveAddressBinding", utils.WithRenderAsList(true)); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for slaveAddressBinding")
	}
	// Terminated array
	var slaveAddressBinding []BACnetAddressBinding
	{
		for !bool(IsBACnetConstructedDataClosingTag(readBuffer, false, tagNumber)) {
			_item, _err := BACnetAddressBindingParseWithBuffer(readBuffer)
			if _err != nil {
				return nil, errors.Wrap(_err, "Error parsing 'slaveAddressBinding' field of BACnetConstructedDataSlaveAddressBinding")
			}
			slaveAddressBinding = append(slaveAddressBinding, _item.(BACnetAddressBinding))
		}
	}
	if closeErr := readBuffer.CloseContext("slaveAddressBinding", utils.WithRenderAsList(true)); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for slaveAddressBinding")
	}

	if closeErr := readBuffer.CloseContext("BACnetConstructedDataSlaveAddressBinding"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for BACnetConstructedDataSlaveAddressBinding")
	}

	// Create a partially initialized instance
	_child := &_BACnetConstructedDataSlaveAddressBinding{
		_BACnetConstructedData: &_BACnetConstructedData{
			TagNumber:          tagNumber,
			ArrayIndexArgument: arrayIndexArgument,
		},
		SlaveAddressBinding: slaveAddressBinding,
	}
	_child._BACnetConstructedData._BACnetConstructedDataChildRequirements = _child
	return _child, nil
}

func (m *_BACnetConstructedDataSlaveAddressBinding) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes())))
	if err := m.SerializeWithWriteBuffer(wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_BACnetConstructedDataSlaveAddressBinding) SerializeWithWriteBuffer(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("BACnetConstructedDataSlaveAddressBinding"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for BACnetConstructedDataSlaveAddressBinding")
		}

		// Array Field (slaveAddressBinding)
		if pushErr := writeBuffer.PushContext("slaveAddressBinding", utils.WithRenderAsList(true)); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for slaveAddressBinding")
		}
		for _, _element := range m.GetSlaveAddressBinding() {
			_elementErr := writeBuffer.WriteSerializable(_element)
			if _elementErr != nil {
				return errors.Wrap(_elementErr, "Error serializing 'slaveAddressBinding' field")
			}
		}
		if popErr := writeBuffer.PopContext("slaveAddressBinding", utils.WithRenderAsList(true)); popErr != nil {
			return errors.Wrap(popErr, "Error popping for slaveAddressBinding")
		}

		if popErr := writeBuffer.PopContext("BACnetConstructedDataSlaveAddressBinding"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for BACnetConstructedDataSlaveAddressBinding")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_BACnetConstructedDataSlaveAddressBinding) isBACnetConstructedDataSlaveAddressBinding() bool {
	return true
}

func (m *_BACnetConstructedDataSlaveAddressBinding) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}