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

// BACnetConstructedDataThreatAuthority is the corresponding interface of BACnetConstructedDataThreatAuthority
type BACnetConstructedDataThreatAuthority interface {
	utils.LengthAware
	utils.Serializable
	BACnetConstructedData
	// GetThreatAuthority returns ThreatAuthority (property field)
	GetThreatAuthority() BACnetAccessThreatLevel
	// GetActualValue returns ActualValue (virtual field)
	GetActualValue() BACnetAccessThreatLevel
}

// BACnetConstructedDataThreatAuthorityExactly can be used when we want exactly this type and not a type which fulfills BACnetConstructedDataThreatAuthority.
// This is useful for switch cases.
type BACnetConstructedDataThreatAuthorityExactly interface {
	BACnetConstructedDataThreatAuthority
	isBACnetConstructedDataThreatAuthority() bool
}

// _BACnetConstructedDataThreatAuthority is the data-structure of this message
type _BACnetConstructedDataThreatAuthority struct {
	*_BACnetConstructedData
	ThreatAuthority BACnetAccessThreatLevel
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

func (m *_BACnetConstructedDataThreatAuthority) GetObjectTypeArgument() BACnetObjectType {
	return 0
}

func (m *_BACnetConstructedDataThreatAuthority) GetPropertyIdentifierArgument() BACnetPropertyIdentifier {
	return BACnetPropertyIdentifier_THREAT_AUTHORITY
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_BACnetConstructedDataThreatAuthority) InitializeParent(parent BACnetConstructedData, openingTag BACnetOpeningTag, peekedTagHeader BACnetTagHeader, closingTag BACnetClosingTag) {
	m.OpeningTag = openingTag
	m.PeekedTagHeader = peekedTagHeader
	m.ClosingTag = closingTag
}

func (m *_BACnetConstructedDataThreatAuthority) GetParent() BACnetConstructedData {
	return m._BACnetConstructedData
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_BACnetConstructedDataThreatAuthority) GetThreatAuthority() BACnetAccessThreatLevel {
	return m.ThreatAuthority
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for virtual fields.
///////////////////////

func (m *_BACnetConstructedDataThreatAuthority) GetActualValue() BACnetAccessThreatLevel {
	return CastBACnetAccessThreatLevel(m.GetThreatAuthority())
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewBACnetConstructedDataThreatAuthority factory function for _BACnetConstructedDataThreatAuthority
func NewBACnetConstructedDataThreatAuthority(threatAuthority BACnetAccessThreatLevel, openingTag BACnetOpeningTag, peekedTagHeader BACnetTagHeader, closingTag BACnetClosingTag, tagNumber uint8, arrayIndexArgument BACnetTagPayloadUnsignedInteger) *_BACnetConstructedDataThreatAuthority {
	_result := &_BACnetConstructedDataThreatAuthority{
		ThreatAuthority:        threatAuthority,
		_BACnetConstructedData: NewBACnetConstructedData(openingTag, peekedTagHeader, closingTag, tagNumber, arrayIndexArgument),
	}
	_result._BACnetConstructedData._BACnetConstructedDataChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastBACnetConstructedDataThreatAuthority(structType interface{}) BACnetConstructedDataThreatAuthority {
	if casted, ok := structType.(BACnetConstructedDataThreatAuthority); ok {
		return casted
	}
	if casted, ok := structType.(*BACnetConstructedDataThreatAuthority); ok {
		return *casted
	}
	return nil
}

func (m *_BACnetConstructedDataThreatAuthority) GetTypeName() string {
	return "BACnetConstructedDataThreatAuthority"
}

func (m *_BACnetConstructedDataThreatAuthority) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_BACnetConstructedDataThreatAuthority) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits())

	// Simple field (threatAuthority)
	lengthInBits += m.ThreatAuthority.GetLengthInBits()

	// A virtual field doesn't have any in- or output.

	return lengthInBits
}

func (m *_BACnetConstructedDataThreatAuthority) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func BACnetConstructedDataThreatAuthorityParse(theBytes []byte, tagNumber uint8, objectTypeArgument BACnetObjectType, propertyIdentifierArgument BACnetPropertyIdentifier, arrayIndexArgument BACnetTagPayloadUnsignedInteger) (BACnetConstructedDataThreatAuthority, error) {
	return BACnetConstructedDataThreatAuthorityParseWithBuffer(utils.NewReadBufferByteBased(theBytes), tagNumber, objectTypeArgument, propertyIdentifierArgument, arrayIndexArgument)
}

func BACnetConstructedDataThreatAuthorityParseWithBuffer(readBuffer utils.ReadBuffer, tagNumber uint8, objectTypeArgument BACnetObjectType, propertyIdentifierArgument BACnetPropertyIdentifier, arrayIndexArgument BACnetTagPayloadUnsignedInteger) (BACnetConstructedDataThreatAuthority, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("BACnetConstructedDataThreatAuthority"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for BACnetConstructedDataThreatAuthority")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (threatAuthority)
	if pullErr := readBuffer.PullContext("threatAuthority"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for threatAuthority")
	}
	_threatAuthority, _threatAuthorityErr := BACnetAccessThreatLevelParseWithBuffer(readBuffer)
	if _threatAuthorityErr != nil {
		return nil, errors.Wrap(_threatAuthorityErr, "Error parsing 'threatAuthority' field of BACnetConstructedDataThreatAuthority")
	}
	threatAuthority := _threatAuthority.(BACnetAccessThreatLevel)
	if closeErr := readBuffer.CloseContext("threatAuthority"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for threatAuthority")
	}

	// Virtual field
	_actualValue := threatAuthority
	actualValue := _actualValue
	_ = actualValue

	if closeErr := readBuffer.CloseContext("BACnetConstructedDataThreatAuthority"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for BACnetConstructedDataThreatAuthority")
	}

	// Create a partially initialized instance
	_child := &_BACnetConstructedDataThreatAuthority{
		_BACnetConstructedData: &_BACnetConstructedData{
			TagNumber:          tagNumber,
			ArrayIndexArgument: arrayIndexArgument,
		},
		ThreatAuthority: threatAuthority,
	}
	_child._BACnetConstructedData._BACnetConstructedDataChildRequirements = _child
	return _child, nil
}

func (m *_BACnetConstructedDataThreatAuthority) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes())))
	if err := m.SerializeWithWriteBuffer(wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_BACnetConstructedDataThreatAuthority) SerializeWithWriteBuffer(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	ser := func() error {
		if pushErr := writeBuffer.PushContext("BACnetConstructedDataThreatAuthority"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for BACnetConstructedDataThreatAuthority")
		}

		// Simple Field (threatAuthority)
		if pushErr := writeBuffer.PushContext("threatAuthority"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for threatAuthority")
		}
		_threatAuthorityErr := writeBuffer.WriteSerializable(m.GetThreatAuthority())
		if popErr := writeBuffer.PopContext("threatAuthority"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for threatAuthority")
		}
		if _threatAuthorityErr != nil {
			return errors.Wrap(_threatAuthorityErr, "Error serializing 'threatAuthority' field")
		}
		// Virtual field
		if _actualValueErr := writeBuffer.WriteVirtual("actualValue", m.GetActualValue()); _actualValueErr != nil {
			return errors.Wrap(_actualValueErr, "Error serializing 'actualValue' field")
		}

		if popErr := writeBuffer.PopContext("BACnetConstructedDataThreatAuthority"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for BACnetConstructedDataThreatAuthority")
		}
		return nil
	}
	return m.SerializeParent(writeBuffer, m, ser)
}

func (m *_BACnetConstructedDataThreatAuthority) isBACnetConstructedDataThreatAuthority() bool {
	return true
}

func (m *_BACnetConstructedDataThreatAuthority) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}