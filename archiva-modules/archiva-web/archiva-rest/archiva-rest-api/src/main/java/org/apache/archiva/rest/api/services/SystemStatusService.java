package org.apache.archiva.rest.api.services;
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.archiva.security.common.ArchivaRoleConstants;
import org.codehaus.plexus.redback.authorization.RedbackAuthorization;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Olivier Lamy
 * @since 1.4-M3
 */
@Path( "/systemStatusService/" )
public interface SystemStatusService
{
    @Path( "memoryStatus" )
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    @RedbackAuthorization( permissions = ArchivaRoleConstants.OPERATION_MANAGE_CONFIGURATION )
    String getMemoryStatus()
        throws ArchivaRestServiceException;

    @Path( "currentServerTime/{locale}" )
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    @RedbackAuthorization( permissions = ArchivaRoleConstants.OPERATION_MANAGE_CONFIGURATION )
    String getCurrentServerTime( @PathParam( "locale" ) String locale )
        throws ArchivaRestServiceException;

}
