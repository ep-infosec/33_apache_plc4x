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

// ListOfCovNotificationsList is the corresponding interface of ListOfCovNotificationsList
type ListOfCovNotificationsList interface {
	utils.LengthAware
	utils.Serializable
	// GetOpeningTag returns OpeningTag (property field)
	GetOpeningTag() BACnetOpeningTag
	// GetSpecifications returns Specifications (property field)
	GetSpecifications() []ListOfCovNotifications
	// GetClosingTag returns ClosingTag (property field)
	GetClosingTag() BACnetClosingTag
}

// ListOfCovNotificationsListExactly can be used when we want exactly this type and not a type which fulfills ListOfCovNotificationsList.
// This is useful for switch cases.
type ListOfCovNotificationsListExactly interface {
	ListOfCovNotificationsList
	isListOfCovNotificationsList() bool
}

// _ListOfCovNotificationsList is the data-structure of this message
type _ListOfCovNotificationsList struct {
	OpeningTag     BACnetOpeningTag
	Specifications []ListOfCovNotifications
	ClosingTag     BACnetClosingTag

	// Arguments.
	TagNumber uint8
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_ListOfCovNotificationsList) GetOpeningTag() BACnetOpeningTag {
	return m.OpeningTag
}

func (m *_ListOfCovNotificationsList) GetSpecifications() []ListOfCovNotifications {
	return m.Specifications
}

func (m *_ListOfCovNotificationsList) GetClosingTag() BACnetClosingTag {
	return m.ClosingTag
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewListOfCovNotificationsList factory function for _ListOfCovNotificationsList
func NewListOfCovNotificationsList(openingTag BACnetOpeningTag, specifications []ListOfCovNotifications, closingTag BACnetClosingTag, tagNumber uint8) *_ListOfCovNotificationsList {
	return &_ListOfCovNotificationsList{OpeningTag: openingTag, Specifications: specifications, ClosingTag: closingTag, TagNumber: tagNumber}
}

// Deprecated: use the interface for direct cast
func CastListOfCovNotificationsList(structType interface{}) ListOfCovNotificationsList {
	if casted, ok := structType.(ListOfCovNotificationsList); ok {
		return casted
	}
	if casted, ok := structType.(*ListOfCovNotificationsList); ok {
		return *casted
	}
	return nil
}

func (m *_ListOfCovNotificationsList) GetTypeName() string {
	return "ListOfCovNotificationsList"
}

func (m *_ListOfCovNotificationsList) GetLengthInBits() uint16 {
	return m.GetLengthInBitsConditional(false)
}

func (m *_ListOfCovNotificationsList) GetLengthInBitsConditional(lastItem bool) uint16 {
	lengthInBits := uint16(0)

	// Simple field (openingTag)
	lengthInBits += m.OpeningTag.GetLengthInBits()

	// Array field
	if len(m.Specifications) > 0 {
		for _, element := range m.Specifications {
			lengthInBits += element.GetLengthInBits()
		}
	}

	// Simple field (closingTag)
	lengthInBits += m.ClosingTag.GetLengthInBits()

	return lengthInBits
}

func (m *_ListOfCovNotificationsList) GetLengthInBytes() uint16 {
	return m.GetLengthInBits() / 8
}

func ListOfCovNotificationsListParse(theBytes []byte, tagNumber uint8) (ListOfCovNotificationsList, error) {
	return ListOfCovNotificationsListParseWithBuffer(utils.NewReadBufferByteBased(theBytes), tagNumber)
}

func ListOfCovNotificationsListParseWithBuffer(readBuffer utils.ReadBuffer, tagNumber uint8) (ListOfCovNotificationsList, error) {
	positionAware := readBuffer
	_ = positionAware
	if pullErr := readBuffer.PullContext("ListOfCovNotificationsList"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for ListOfCovNotificationsList")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (openingTag)
	if pullErr := readBuffer.PullContext("openingTag"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for openingTag")
	}
	_openingTag, _openingTagErr := BACnetOpeningTagParseWithBuffer(readBuffer, uint8(tagNumber))
	if _openingTagErr != nil {
		return nil, errors.Wrap(_openingTagErr, "Error parsing 'openingTag' field of ListOfCovNotificationsList")
	}
	openingTag := _openingTag.(BACnetOpeningTag)
	if closeErr := readBuffer.CloseContext("openingTag"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for openingTag")
	}

	// Array field (specifications)
	if pullErr := readBuffer.PullContext("specifications", utils.WithRenderAsList(true)); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for specifications")
	}
	// Terminated array
	var specifications []ListOfCovNotifications
	{
		for !bool(IsBACnetConstructedDataClosingTag(readBuffer, false, tagNumber)) {
			_item, _err := ListOfCovNotificationsParseWithBuffer(readBuffer)
			if _err != nil {
				return nil, errors.Wrap(_err, "Error parsing 'specifications' field of ListOfCovNotificationsList")
			}
			specifications = append(specifications, _item.(ListOfCovNotifications))
		}
	}
	if closeErr := readBuffer.CloseContext("specifications", utils.WithRenderAsList(true)); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for specifications")
	}

	// Simple Field (closingTag)
	if pullErr := readBuffer.PullContext("closingTag"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for closingTag")
	}
	_closingTag, _closingTagErr := BACnetClosingTagParseWithBuffer(readBuffer, uint8(tagNumber))
	if _closingTagErr != nil {
		return nil, errors.Wrap(_closingTagErr, "Error parsing 'closingTag' field of ListOfCovNotificationsList")
	}
	closingTag := _closingTag.(BACnetClosingTag)
	if closeErr := readBuffer.CloseContext("closingTag"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for closingTag")
	}

	if closeErr := readBuffer.CloseContext("ListOfCovNotificationsList"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for ListOfCovNotificationsList")
	}

	// Create the instance
	return &_ListOfCovNotificationsList{
		TagNumber:      tagNumber,
		OpeningTag:     openingTag,
		Specifications: specifications,
		ClosingTag:     closingTag,
	}, nil
}

func (m *_ListOfCovNotificationsList) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes())))
	if err := m.SerializeWithWriteBuffer(wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_ListOfCovNotificationsList) SerializeWithWriteBuffer(writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	if pushErr := writeBuffer.PushContext("ListOfCovNotificationsList"); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for ListOfCovNotificationsList")
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

	// Array Field (specifications)
	if pushErr := writeBuffer.PushContext("specifications", utils.WithRenderAsList(true)); pushErr != nil {
		return errors.Wrap(pushErr, "Error pushing for specifications")
	}
	for _, _element := range m.GetSpecifications() {
		_elementErr := writeBuffer.WriteSerializable(_element)
		if _elementErr != nil {
			return errors.Wrap(_elementErr, "Error serializing 'specifications' field")
		}
	}
	if popErr := writeBuffer.PopContext("specifications", utils.WithRenderAsList(true)); popErr != nil {
		return errors.Wrap(popErr, "Error popping for specifications")
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

	if popErr := writeBuffer.PopContext("ListOfCovNotificationsList"); popErr != nil {
		return errors.Wrap(popErr, "Error popping for ListOfCovNotificationsList")
	}
	return nil
}

////
// Arguments Getter

func (m *_ListOfCovNotificationsList) GetTagNumber() uint8 {
	return m.TagNumber
}

//
////

func (m *_ListOfCovNotificationsList) isListOfCovNotificationsList() bool {
	return true
}

func (m *_ListOfCovNotificationsList) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}