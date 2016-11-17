/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership.  The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.hadoop.ozone.protocol;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.hdfs.protocol.DatanodeID;
import org.apache.hadoop.ozone.protocol.proto.StorageContainerDatanodeProtocolProtos.SCMHeartbeatResponseProto;
import org.apache.hadoop.ozone.protocol.proto.StorageContainerDatanodeProtocolProtos.SCMVersionResponseProto;
import org.apache.hadoop.ozone.protocol.proto.StorageContainerDatanodeProtocolProtos.SCMRegisteredCmdResponseProto;

import java.io.IOException;

/**
 * The protocol spoken between datanodes and SCM. For specifics please the
 * Protoc file that defines this protocol.
 */
@InterfaceAudience.Private
public interface StorageContainerDatanodeProtocol {
  /**
   * Returns SCM version.
   * @return Version info.
   */
  SCMVersionResponseProto getVersion() throws IOException;

  /**
   * Used by data node to send a Heartbeat.
   * @param datanodeID - Datanode ID.
   * @return - SCMHeartbeatResponseProto
   * @throws IOException
   */
  SCMHeartbeatResponseProto sendHeartbeat(DatanodeID datanodeID)
      throws IOException;

  /**
   * Register Datanode.
   * @param datanodeID - DatanodID.
   * @param scmAddresses - List of SCMs this datanode is configured to
   *                     communicate.
   * @return SCM Command.
   */
  SCMRegisteredCmdResponseProto register(DatanodeID datanodeID,
      String[] scmAddresses) throws IOException;

}