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
package org.apache.plc4x.java.opcua.readwrite;

import static org.apache.plc4x.java.spi.codegen.fields.FieldReaderFactory.*;
import static org.apache.plc4x.java.spi.codegen.fields.FieldWriterFactory.*;
import static org.apache.plc4x.java.spi.codegen.io.DataReaderFactory.*;
import static org.apache.plc4x.java.spi.codegen.io.DataWriterFactory.*;
import static org.apache.plc4x.java.spi.generation.StaticHelper.*;

import java.time.*;
import java.util.*;
import org.apache.plc4x.java.api.exceptions.*;
import org.apache.plc4x.java.api.value.*;
import org.apache.plc4x.java.spi.codegen.*;
import org.apache.plc4x.java.spi.codegen.fields.*;
import org.apache.plc4x.java.spi.codegen.io.*;
import org.apache.plc4x.java.spi.generation.*;

// Code generated by code-generation. DO NOT EDIT.

public abstract class ExtensionObjectDefinition implements Message {

  // Abstract accessors for discriminator values.
  public abstract String getIdentifier();

  public ExtensionObjectDefinition() {
    super();
  }

  protected abstract void serializeExtensionObjectDefinitionChild(WriteBuffer writeBuffer)
      throws SerializationException;

  public void serialize(WriteBuffer writeBuffer) throws SerializationException {
    PositionAware positionAware = writeBuffer;
    int startPos = positionAware.getPos();
    writeBuffer.pushContext("ExtensionObjectDefinition");

    // Switch field (Serialize the sub-type)
    serializeExtensionObjectDefinitionChild(writeBuffer);

    writeBuffer.popContext("ExtensionObjectDefinition");
  }

  @Override
  public int getLengthInBytes() {
    return (int) Math.ceil((float) getLengthInBits() / 8.0);
  }

  @Override
  public int getLengthInBits() {
    int lengthInBits = 0;
    ExtensionObjectDefinition _value = this;

    // Length of sub-type elements will be added by sub-type...

    return lengthInBits;
  }

  public static ExtensionObjectDefinition staticParse(ReadBuffer readBuffer, Object... args)
      throws ParseException {
    PositionAware positionAware = readBuffer;
    if ((args == null) || (args.length != 1)) {
      throw new PlcRuntimeException(
          "Wrong number of arguments, expected 1, but got " + args.length);
    }
    String identifier;
    if (args[0] instanceof String) {
      identifier = (String) args[0];
    } else if (args[0] instanceof String) {
      identifier = String.valueOf((String) args[0]);
    } else {
      throw new PlcRuntimeException(
          "Argument 0 expected to be of type String or a string which is parseable but was "
              + args[0].getClass().getName());
    }
    return staticParse(readBuffer, identifier);
  }

  public static ExtensionObjectDefinition staticParse(ReadBuffer readBuffer, String identifier)
      throws ParseException {
    readBuffer.pullContext("ExtensionObjectDefinition");
    PositionAware positionAware = readBuffer;
    int startPos = positionAware.getPos();
    int curPos;

    // Switch Field (Depending on the discriminator values, passes the instantiation to a sub-type)
    ExtensionObjectDefinitionBuilder builder = null;
    if (EvaluationHelper.equals(identifier, (String) "0")) {
      builder = NullExtension.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12758")) {
      builder = Union.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "14535")) {
      builder = KeyValuePair.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "16315")) {
      builder = AdditionalParametersType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "17550")) {
      builder = EphemeralKeyType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15530")) {
      builder = EndpointType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "18808")) {
      builder = RationalNumber.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "18809")) {
      builder = OpcuaVector.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "18811")) {
      builder = CartesianCoordinates.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "18813")) {
      builder = Orientation.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "18815")) {
      builder = Frame.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15636")) {
      builder = IdentityMappingRuleType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "23500")) {
      builder = CurrencyUnitType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12556")) {
      builder = TrustListDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "17863")) {
      builder = DecimalDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15536")) {
      builder = DataTypeSchemaHeader.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "14527")) {
      builder = DataTypeDescription.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "14526")) {
      builder = FieldMetaData.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "14595")) {
      builder = ConfigurationVersionDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15582")) {
      builder = PublishedDataSetSourceDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "14275")) {
      builder = PublishedVariableDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15599")) {
      builder = DataSetWriterDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15600")) {
      builder = DataSetWriterTransportDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15607")) {
      builder = DataSetWriterMessageDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15611")) {
      builder = PubSubGroupDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15613")) {
      builder = WriterGroupTransportDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15618")) {
      builder = WriterGroupMessageDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15619")) {
      builder = PubSubConnectionDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15620")) {
      builder = ConnectionTransportDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15504")) {
      builder = NetworkAddressDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15623")) {
      builder = ReaderGroupTransportDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15624")) {
      builder = ReaderGroupMessageDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15630")) {
      builder = DataSetReaderTransportDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15631")) {
      builder = DataSetReaderMessageDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15632")) {
      builder = SubscribedDataSetDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "14746")) {
      builder = FieldTargetDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15532")) {
      builder = PubSubConfigurationDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "23470")) {
      builder = AliasNameDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "24109")) {
      builder = UnsignedRationalNumber.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "98")) {
      builder = RolePermissionType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "99")) {
      builder = DataTypeDefinition.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "103")) {
      builder = StructureField.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "260")) {
      builder = Node.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "287")) {
      builder = ReferenceNode.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "298")) {
      builder = Argument.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "7596")) {
      builder = EnumValueType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12757")) {
      builder = OptionSet.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "8914")) {
      builder = TimeZoneDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "310")) {
      builder = ApplicationDescription.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "391")) {
      builder = RequestHeader.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "394")) {
      builder = ResponseHeader.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "397")) {
      builder = ServiceFault.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "15903")) {
      builder = SessionlessInvokeRequestType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "21001")) {
      builder = SessionlessInvokeResponseType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "422")) {
      builder = FindServersRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "425")) {
      builder = FindServersResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12191")) {
      builder = ServerOnNetwork.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12192")) {
      builder = FindServersOnNetworkRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12193")) {
      builder = FindServersOnNetworkResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "306")) {
      builder = UserTokenPolicy.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "314")) {
      builder = EndpointDescription.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "428")) {
      builder = GetEndpointsRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "431")) {
      builder = GetEndpointsResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "434")) {
      builder = RegisteredServer.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "437")) {
      builder = RegisterServerRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "440")) {
      builder = RegisterServerResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12892")) {
      builder = DiscoveryConfiguration.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12195")) {
      builder = RegisterServer2Request.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12196")) {
      builder = RegisterServer2Response.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "443")) {
      builder = ChannelSecurityToken.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "446")) {
      builder = OpenSecureChannelRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "449")) {
      builder = OpenSecureChannelResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "452")) {
      builder = CloseSecureChannelRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "455")) {
      builder = CloseSecureChannelResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "346")) {
      builder = SignedSoftwareCertificate.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "458")) {
      builder = SignatureData.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "461")) {
      builder = CreateSessionRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "464")) {
      builder = CreateSessionResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "467")) {
      builder = ActivateSessionRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "470")) {
      builder = ActivateSessionResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "473")) {
      builder = CloseSessionRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "476")) {
      builder = CloseSessionResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "479")) {
      builder = CancelRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "482")) {
      builder = CancelResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "351")) {
      builder = NodeAttributes.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "17608")) {
      builder = GenericAttributeValue.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "378")) {
      builder = AddNodesItem.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "485")) {
      builder = AddNodesResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "488")) {
      builder = AddNodesRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "491")) {
      builder = AddNodesResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "381")) {
      builder = AddReferencesItem.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "494")) {
      builder = AddReferencesRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "497")) {
      builder = AddReferencesResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "384")) {
      builder = DeleteNodesItem.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "500")) {
      builder = DeleteNodesRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "503")) {
      builder = DeleteNodesResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "387")) {
      builder = DeleteReferencesItem.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "506")) {
      builder = DeleteReferencesRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "509")) {
      builder = DeleteReferencesResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "513")) {
      builder = ViewDescription.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "516")) {
      builder = BrowseDescription.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "520")) {
      builder = ReferenceDescription.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "524")) {
      builder = BrowseResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "527")) {
      builder = BrowseRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "530")) {
      builder = BrowseResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "533")) {
      builder = BrowseNextRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "536")) {
      builder = BrowseNextResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "539")) {
      builder = RelativePathElement.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "542")) {
      builder = RelativePath.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "545")) {
      builder = BrowsePath.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "548")) {
      builder = BrowsePathTarget.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "551")) {
      builder = BrowsePathResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "554")) {
      builder = TranslateBrowsePathsToNodeIdsRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "557")) {
      builder = TranslateBrowsePathsToNodeIdsResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "560")) {
      builder = RegisterNodesRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "563")) {
      builder = RegisterNodesResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "566")) {
      builder = UnregisterNodesRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "569")) {
      builder = UnregisterNodesResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "333")) {
      builder = EndpointConfiguration.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "572")) {
      builder = QueryDataDescription.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "575")) {
      builder = NodeTypeDescription.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "579")) {
      builder = QueryDataSet.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "582")) {
      builder = NodeReference.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "585")) {
      builder = ContentFilterElement.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "588")) {
      builder = ContentFilter.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "591")) {
      builder = FilterOperand.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "606")) {
      builder = ContentFilterElementResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "609")) {
      builder = ContentFilterResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "612")) {
      builder = ParsingResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "615")) {
      builder = QueryFirstRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "618")) {
      builder = QueryFirstResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "621")) {
      builder = QueryNextRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "624")) {
      builder = QueryNextResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "628")) {
      builder = ReadValueId.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "631")) {
      builder = ReadRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "634")) {
      builder = ReadResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "637")) {
      builder = HistoryReadValueId.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "640")) {
      builder = HistoryReadResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "643")) {
      builder = HistoryReadDetails.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "658")) {
      builder = HistoryData.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "11218")) {
      builder = ModificationInfo.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "661")) {
      builder = HistoryEvent.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "664")) {
      builder = HistoryReadRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "667")) {
      builder = HistoryReadResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "670")) {
      builder = WriteValue.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "673")) {
      builder = WriteRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "676")) {
      builder = WriteResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "679")) {
      builder = HistoryUpdateDetails.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "697")) {
      builder = HistoryUpdateResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "700")) {
      builder = HistoryUpdateRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "703")) {
      builder = HistoryUpdateResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "706")) {
      builder = CallMethodRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "709")) {
      builder = CallMethodResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "712")) {
      builder = CallRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "715")) {
      builder = CallResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "721")) {
      builder = MonitoringFilter.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "950")) {
      builder = AggregateConfiguration.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "733")) {
      builder = MonitoringFilterResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "742")) {
      builder = MonitoringParameters.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "745")) {
      builder = MonitoredItemCreateRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "748")) {
      builder = MonitoredItemCreateResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "751")) {
      builder = CreateMonitoredItemsRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "754")) {
      builder = CreateMonitoredItemsResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "757")) {
      builder = MonitoredItemModifyRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "760")) {
      builder = MonitoredItemModifyResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "763")) {
      builder = ModifyMonitoredItemsRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "766")) {
      builder = ModifyMonitoredItemsResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "769")) {
      builder = SetMonitoringModeRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "772")) {
      builder = SetMonitoringModeResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "775")) {
      builder = SetTriggeringRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "778")) {
      builder = SetTriggeringResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "781")) {
      builder = DeleteMonitoredItemsRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "784")) {
      builder = DeleteMonitoredItemsResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "787")) {
      builder = CreateSubscriptionRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "790")) {
      builder = CreateSubscriptionResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "793")) {
      builder = ModifySubscriptionRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "796")) {
      builder = ModifySubscriptionResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "799")) {
      builder = SetPublishingModeRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "802")) {
      builder = SetPublishingModeResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "805")) {
      builder = NotificationMessage.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "947")) {
      builder = NotificationData.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "808")) {
      builder = MonitoredItemNotification.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "919")) {
      builder = EventFieldList.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "922")) {
      builder = HistoryEventFieldList.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "823")) {
      builder = SubscriptionAcknowledgement.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "826")) {
      builder = PublishRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "829")) {
      builder = PublishResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "832")) {
      builder = RepublishRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "835")) {
      builder = RepublishResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "838")) {
      builder = TransferResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "841")) {
      builder = TransferSubscriptionsRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "844")) {
      builder = TransferSubscriptionsResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "847")) {
      builder = DeleteSubscriptionsRequest.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "850")) {
      builder = DeleteSubscriptionsResponse.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "340")) {
      builder = BuildInfo.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "855")) {
      builder = RedundantServerDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "11945")) {
      builder = EndpointUrlListDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "11946")) {
      builder = NetworkGroupDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "858")) {
      builder = SamplingIntervalDiagnosticsDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "861")) {
      builder = ServerDiagnosticsSummaryDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "864")) {
      builder = ServerStatusDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "867")) {
      builder = SessionDiagnosticsDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "870")) {
      builder = SessionSecurityDiagnosticsDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "873")) {
      builder = ServiceCounterDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "301")) {
      builder = StatusResult.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "876")) {
      builder = SubscriptionDiagnosticsDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "879")) {
      builder = ModelChangeStructureDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "899")) {
      builder = SemanticChangeStructureDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "886")) {
      builder = Range.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "889")) {
      builder = EUInformation.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12173")) {
      builder = ComplexNumberType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12174")) {
      builder = DoubleComplexNumberType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12081")) {
      builder = AxisInformation.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "12082")) {
      builder = XVType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "896")) {
      builder = ProgramDiagnosticDataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "24035")) {
      builder = ProgramDiagnostic2DataType.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "893")) {
      builder = Annotation.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "811")) {
      builder = DataChangeNotification.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "916")) {
      builder = EventNotificationList.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "820")) {
      builder = StatusChangeNotification.staticParseBuilder(readBuffer, identifier);
    } else if (EvaluationHelper.equals(identifier, (String) "316")) {
      builder = UserIdentityToken.staticParseBuilder(readBuffer, identifier);
    }
    if (builder == null) {
      throw new ParseException(
          "Unsupported case for discriminated type"
              + " parameters ["
              + "identifier="
              + identifier
              + "]");
    }

    readBuffer.closeContext("ExtensionObjectDefinition");
    // Create the instance
    ExtensionObjectDefinition _extensionObjectDefinition = builder.build();
    return _extensionObjectDefinition;
  }

  public static interface ExtensionObjectDefinitionBuilder {
    ExtensionObjectDefinition build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ExtensionObjectDefinition)) {
      return false;
    }
    ExtensionObjectDefinition that = (ExtensionObjectDefinition) o;
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    WriteBufferBoxBased writeBufferBoxBased = new WriteBufferBoxBased(true, true);
    try {
      writeBufferBoxBased.writeSerializable(this);
    } catch (SerializationException e) {
      throw new RuntimeException(e);
    }
    return "\n" + writeBufferBoxBased.getBox().toString() + "\n";
  }
}
