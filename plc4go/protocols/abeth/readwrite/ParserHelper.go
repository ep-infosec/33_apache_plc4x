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

package readwrite

import (
	"github.com/apache/plc4x/plc4go/protocols/abeth/readwrite/model"
	"github.com/apache/plc4x/plc4go/spi/utils"
	"github.com/pkg/errors"
)

// Code generated by code-generation. DO NOT EDIT.

type AbethParserHelper struct {
}

func (m AbethParserHelper) Parse(typeName string, arguments []string, io utils.ReadBuffer) (interface{}, error) {
	switch typeName {
	case "DF1RequestCommand":
		return model.DF1RequestCommandParseWithBuffer(io)
	case "DF1RequestMessage":
		return model.DF1RequestMessageParseWithBuffer(io)
	case "DF1ResponseMessage":
		payloadLength, err := utils.StrToUint16(arguments[0])
		if err != nil {
			return nil, errors.Wrap(err, "Error parsing")
		}
		return model.DF1ResponseMessageParseWithBuffer(io, payloadLength)
	case "CIPEncapsulationPacket":
		return model.CIPEncapsulationPacketParseWithBuffer(io)
	}
	return nil, errors.Errorf("Unsupported type %s", typeName)
}
