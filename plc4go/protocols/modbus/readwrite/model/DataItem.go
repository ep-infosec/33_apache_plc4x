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
	api "github.com/apache/plc4x/plc4go/pkg/api/values"
	"github.com/apache/plc4x/plc4go/spi/utils"
	"github.com/apache/plc4x/plc4go/spi/values"
	"github.com/pkg/errors"
)

// Code generated by code-generation. DO NOT EDIT.

func DataItemParse(theBytes []byte, dataType ModbusDataType, numberOfValues uint16) (api.PlcValue, error) {
	return DataItemParseWithBuffer(utils.NewReadBufferByteBased(theBytes), dataType, numberOfValues)
}

func DataItemParseWithBuffer(readBuffer utils.ReadBuffer, dataType ModbusDataType, numberOfValues uint16) (api.PlcValue, error) {
	readBuffer.PullContext("DataItem")
	switch {
	case dataType == ModbusDataType_BOOL && numberOfValues == uint16(1): // BOOL
		// Reserved Field (Just skip the bytes)
		if _, _err := readBuffer.ReadUint16("reserved", 15); _err != nil {
			return nil, errors.Wrap(_err, "Error parsing reserved field")
		}

		// Simple Field (value)
		value, _valueErr := readBuffer.ReadBit("value")
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcBOOL(value), nil
	case dataType == ModbusDataType_BOOL: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadBit("value")
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcBOOL(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_BYTE && numberOfValues == uint16(1): // BYTE
		// Reserved Field (Just skip the bytes)
		if _, _err := readBuffer.ReadUint8("reserved", 8); _err != nil {
			return nil, errors.Wrap(_err, "Error parsing reserved field")
		}

		// Simple Field (value)
		value, _valueErr := readBuffer.ReadUint8("value", 8)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcBYTE(value), nil
	case dataType == ModbusDataType_BYTE: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int((numberOfValues)*(8)); i++ {
			_item, _itemErr := readBuffer.ReadBit("value")
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcBOOL(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_WORD: // WORD
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadUint16("value", 16)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcWORD(value), nil
	case dataType == ModbusDataType_DWORD: // DWORD
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadUint32("value", 32)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcDWORD(value), nil
	case dataType == ModbusDataType_LWORD: // LWORD
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadUint64("value", 64)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcLWORD(value), nil
	case dataType == ModbusDataType_SINT && numberOfValues == uint16(1): // SINT
		// Reserved Field (Just skip the bytes)
		if _, _err := readBuffer.ReadUint8("reserved", 8); _err != nil {
			return nil, errors.Wrap(_err, "Error parsing reserved field")
		}

		// Simple Field (value)
		value, _valueErr := readBuffer.ReadInt8("value", 8)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcSINT(value), nil
	case dataType == ModbusDataType_SINT: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadInt8("value", 8)
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcSINT(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_INT && numberOfValues == uint16(1): // INT
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadInt16("value", 16)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcINT(value), nil
	case dataType == ModbusDataType_INT: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadInt16("value", 16)
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcINT(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_DINT && numberOfValues == uint16(1): // DINT
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadInt32("value", 32)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcDINT(value), nil
	case dataType == ModbusDataType_DINT: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadInt32("value", 32)
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcDINT(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_LINT && numberOfValues == uint16(1): // LINT
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadInt64("value", 64)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcLINT(value), nil
	case dataType == ModbusDataType_LINT: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadInt64("value", 64)
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcLINT(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_USINT && numberOfValues == uint16(1): // USINT
		// Reserved Field (Just skip the bytes)
		if _, _err := readBuffer.ReadUint8("reserved", 8); _err != nil {
			return nil, errors.Wrap(_err, "Error parsing reserved field")
		}

		// Simple Field (value)
		value, _valueErr := readBuffer.ReadUint8("value", 8)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcUSINT(value), nil
	case dataType == ModbusDataType_USINT: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadUint8("value", 8)
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcUSINT(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_UINT && numberOfValues == uint16(1): // UINT
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadUint16("value", 16)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcUINT(value), nil
	case dataType == ModbusDataType_UINT: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadUint16("value", 16)
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcUINT(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_UDINT && numberOfValues == uint16(1): // UDINT
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadUint32("value", 32)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcUDINT(value), nil
	case dataType == ModbusDataType_UDINT: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadUint32("value", 32)
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcUDINT(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_ULINT && numberOfValues == uint16(1): // ULINT
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadUint64("value", 64)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcULINT(value), nil
	case dataType == ModbusDataType_ULINT: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadUint64("value", 64)
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcULINT(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_REAL && numberOfValues == uint16(1): // REAL
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadFloat32("value", 32)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcREAL(value), nil
	case dataType == ModbusDataType_REAL: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadFloat32("value", 32)
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcREAL(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_LREAL && numberOfValues == uint16(1): // LREAL
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadFloat64("value", 64)
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcLREAL(value), nil
	case dataType == ModbusDataType_LREAL: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadFloat64("value", 64)
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcLREAL(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_CHAR && numberOfValues == uint16(1): // CHAR
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadString("value", uint32(8), "UTF-8")
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcCHAR(value), nil
	case dataType == ModbusDataType_CHAR: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadString("value", uint32(8), "UTF-8")
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcSTRING(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	case dataType == ModbusDataType_WCHAR && numberOfValues == uint16(1): // WCHAR
		// Simple Field (value)
		value, _valueErr := readBuffer.ReadString("value", uint32(16), "UTF-16")
		if _valueErr != nil {
			return nil, errors.Wrap(_valueErr, "Error parsing 'value' field")
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcWCHAR(value), nil
	case dataType == ModbusDataType_WCHAR: // List
		// Array Field (value)
		var value []api.PlcValue
		for i := 0; i < int(numberOfValues); i++ {
			_item, _itemErr := readBuffer.ReadString("value", uint32(16), "UTF-16")
			if _itemErr != nil {
				return nil, errors.Wrap(_itemErr, "Error parsing 'value' field")
			}
			value = append(value, values.NewPlcSTRING(_item))
		}
		readBuffer.CloseContext("DataItem")
		return values.NewPlcList(value), nil
	}
	// TODO: add more info which type it is actually
	return nil, errors.New("unsupported type")
}

func DataItemSerialize(value api.PlcValue, dataType ModbusDataType, numberOfValues uint16) ([]byte, error) {
	wb := utils.NewWriteBufferByteBased()
	if err := DataItemSerializeWithWriteBuffer(wb, value, dataType, numberOfValues); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func DataItemSerializeWithWriteBuffer(writeBuffer utils.WriteBuffer, value api.PlcValue, dataType ModbusDataType, numberOfValues uint16) error {
	m := struct {
		DataType       ModbusDataType
		NumberOfValues uint16
	}{
		DataType:       dataType,
		NumberOfValues: numberOfValues,
	}
	_ = m
	writeBuffer.PushContext("DataItem")
	switch {
	case dataType == ModbusDataType_BOOL && numberOfValues == uint16(1): // BOOL
		// Reserved Field (Just skip the bytes)
		if _err := writeBuffer.WriteUint16("reserved", 15, uint16(0x0000)); _err != nil {
			return errors.Wrap(_err, "Error serializing reserved field")
		}

		// Simple Field (value)
		if _err := writeBuffer.WriteBit("value", value.GetBool()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_BOOL: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteBit("", value.GetIndex(i).GetBool())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_BYTE && numberOfValues == uint16(1): // BYTE
		// Reserved Field (Just skip the bytes)
		if _err := writeBuffer.WriteUint8("reserved", 8, uint8(0x00)); _err != nil {
			return errors.Wrap(_err, "Error serializing reserved field")
		}

		// Simple Field (value)
		if _err := writeBuffer.WriteUint8("value", 8, value.GetUint8()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_BYTE: // List
		// Array Field (value)
		for i := uint32(0); i < uint32((m.NumberOfValues)*(8)); i++ {
			_itemErr := writeBuffer.WriteBit("", value.GetIndex(i).GetBool())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_WORD: // WORD
		// Simple Field (value)
		if _err := writeBuffer.WriteUint16("value", 16, value.GetUint16()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_DWORD: // DWORD
		// Simple Field (value)
		if _err := writeBuffer.WriteUint32("value", 32, value.GetUint32()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_LWORD: // LWORD
		// Simple Field (value)
		if _err := writeBuffer.WriteUint64("value", 64, value.GetUint64()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_SINT && numberOfValues == uint16(1): // SINT
		// Reserved Field (Just skip the bytes)
		if _err := writeBuffer.WriteUint8("reserved", 8, uint8(0x00)); _err != nil {
			return errors.Wrap(_err, "Error serializing reserved field")
		}

		// Simple Field (value)
		if _err := writeBuffer.WriteInt8("value", 8, value.GetInt8()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_SINT: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteInt8("", 8, value.GetIndex(i).GetInt8())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_INT && numberOfValues == uint16(1): // INT
		// Simple Field (value)
		if _err := writeBuffer.WriteInt16("value", 16, value.GetInt16()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_INT: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteInt16("", 16, value.GetIndex(i).GetInt16())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_DINT && numberOfValues == uint16(1): // DINT
		// Simple Field (value)
		if _err := writeBuffer.WriteInt32("value", 32, value.GetInt32()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_DINT: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteInt32("", 32, value.GetIndex(i).GetInt32())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_LINT && numberOfValues == uint16(1): // LINT
		// Simple Field (value)
		if _err := writeBuffer.WriteInt64("value", 64, value.GetInt64()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_LINT: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteInt64("", 64, value.GetIndex(i).GetInt64())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_USINT && numberOfValues == uint16(1): // USINT
		// Reserved Field (Just skip the bytes)
		if _err := writeBuffer.WriteUint8("reserved", 8, uint8(0x00)); _err != nil {
			return errors.Wrap(_err, "Error serializing reserved field")
		}

		// Simple Field (value)
		if _err := writeBuffer.WriteUint8("value", 8, value.GetUint8()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_USINT: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteUint8("", 8, value.GetIndex(i).GetUint8())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_UINT && numberOfValues == uint16(1): // UINT
		// Simple Field (value)
		if _err := writeBuffer.WriteUint16("value", 16, value.GetUint16()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_UINT: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteUint16("", 16, value.GetIndex(i).GetUint16())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_UDINT && numberOfValues == uint16(1): // UDINT
		// Simple Field (value)
		if _err := writeBuffer.WriteUint32("value", 32, value.GetUint32()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_UDINT: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteUint32("", 32, value.GetIndex(i).GetUint32())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_ULINT && numberOfValues == uint16(1): // ULINT
		// Simple Field (value)
		if _err := writeBuffer.WriteUint64("value", 64, value.GetUint64()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_ULINT: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteUint64("", 64, value.GetIndex(i).GetUint64())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_REAL && numberOfValues == uint16(1): // REAL
		// Simple Field (value)
		if _err := writeBuffer.WriteFloat32("value", 32, value.GetFloat32()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_REAL: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteFloat32("", 32, value.GetIndex(i).GetFloat32())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_LREAL && numberOfValues == uint16(1): // LREAL
		// Simple Field (value)
		if _err := writeBuffer.WriteFloat64("value", 64, value.GetFloat64()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_LREAL: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteFloat64("", 64, value.GetIndex(i).GetFloat64())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_CHAR && numberOfValues == uint16(1): // CHAR
		// Simple Field (value)
		if _err := writeBuffer.WriteString("value", uint32(8), "UTF-8", value.GetString()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_CHAR: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteString("", uint32(8), "UTF-8", value.GetIndex(i).GetString())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	case dataType == ModbusDataType_WCHAR && numberOfValues == uint16(1): // WCHAR
		// Simple Field (value)
		if _err := writeBuffer.WriteString("value", uint32(16), "UTF-16", value.GetString()); _err != nil {
			return errors.Wrap(_err, "Error serializing 'value' field")
		}
	case dataType == ModbusDataType_WCHAR: // List
		// Array Field (value)
		for i := uint32(0); i < uint32(m.NumberOfValues); i++ {
			_itemErr := writeBuffer.WriteString("", uint32(16), "UTF-16", value.GetIndex(i).GetString())
			if _itemErr != nil {
				return errors.Wrap(_itemErr, "Error serializing 'value' field")
			}
		}
	default:
		// TODO: add more info which type it is actually
		return errors.New("unsupported type")
	}
	writeBuffer.PopContext("DataItem")
	return nil
}