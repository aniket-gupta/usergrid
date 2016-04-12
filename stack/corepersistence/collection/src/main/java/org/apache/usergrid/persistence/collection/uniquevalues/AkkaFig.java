/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.usergrid.persistence.collection.uniquevalues;


import org.safehaus.guicyfig.Default;
import org.safehaus.guicyfig.FigSingleton;
import org.safehaus.guicyfig.GuicyFig;
import org.safehaus.guicyfig.Key;

@FigSingleton
public interface AkkaFig extends GuicyFig {

    String AKKA_HOSTNAME = "collection.akka.hostname";

    String AKKA_PORT = "collection.akka.port";

    String AKKA_REGION = "collection.akka.region";

    String AKKA_REGIONS = "collection.akka.regions";

    String AKKA_UNIQUE_VALUE_ACTORS = "collection.akka.unique.value.actors";

    String AKKA_REGION_SEEDS = "collection.akka.region.seeds";

    String AKKA_REGION_TYPES = "collection.akka.region.types";


    /**
     * Hostname to be used in Akka configuration.
     */
    @Key(AKKA_HOSTNAME)
    @Default("localhost")
    String getHostname();

    /**
     * local port to be used in Akka configuration.
     */
    @Key(AKKA_PORT)
    @Default("2551")
    int getPort();

    /**
     * Local region to be used in Akka configuration.
     */
    @Key(AKKA_REGION)
    @Default("us-east")
    String getRegion();

    /**
     * Comma-separated list of all regions to be used in Akka configuration.
     */
    @Key(AKKA_REGIONS)
    @Default("us-east")
    String getRegions();

    /**
     * Number of UniqueValueActors to be started on each node
     */
    @Key(AKKA_UNIQUE_VALUE_ACTORS)
    @Default("300")
    int getUniqueValueActors();

    /**
     * Comma-separated lists of seeds each with format {region}:{hostname}:{port}
     */
    @Key(AKKA_REGION_SEEDS)
    @Default("us-east:localhost:2551")
    String getRegionSeeds();

    /**
     * Authoritative regions may be specified for types
     * Comma-separated lists of region types each with format {region}:{type}
     */
    // TODO: allow this to be set via REST API
    @Key(AKKA_REGION_TYPES)
    @Default("")
    String getRegionTypes();
}