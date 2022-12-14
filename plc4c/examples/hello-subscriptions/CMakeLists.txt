#[[
  Licensed to the Apache Software Foundation (ASF) under one
  or more contributor license agreements.  See the NOTICE file
  distributed with this work for additional information
  regarding copyright ownership.  The ASF licenses this file
  to you under the Apache License, Version 2.0 (the
  "License"); you may not use this file except in compliance
  with the License.  You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing,
  software distributed under the License is distributed on an
  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
  KIND, either express or implied.  See the License for the
  specific language governing permissions and limitations
  under the License.
]]

file(GLOB sources "src/*.c")

add_executable(plc4c-examples-hello-subscriptions ${sources} src/hello_subscriptions.c)

target_include_directories(plc4c-examples-hello-subscriptions
        PUBLIC
        "../../api/include"
        "../../drivers/simulated/include"
        "../../transports/dummy/include")

IF (NOT WIN32)
    target_link_libraries(plc4c-examples-hello-subscriptions
            plc4c-spi plc4c-driver-simulated
            plc4c-transport-dummy
            m
    )
ELSE()
    target_link_libraries(plc4c-examples-hello-subscriptions
            plc4c-spi plc4c-driver-simulated
            plc4c-transport-dummy
    )
ENDIF()
