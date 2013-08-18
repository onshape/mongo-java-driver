/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mongodb.connection.impl;

import org.mongodb.connection.Cluster;
import org.mongodb.connection.ClusterFactory;
import org.mongodb.connection.ClusterableServerFactory;
import org.mongodb.connection.ServerAddress;

import java.util.List;

/**
 * The default factory for cluster implementations.
 *
 * @since 3.0
 */
public final class DefaultClusterFactory implements ClusterFactory {

    public DefaultClusterFactory() {
    }

    @Override
    public Cluster create(final ServerAddress serverAddress, final ClusterableServerFactory serverFactory) {
        return new DirectCluster(serverAddress, serverFactory);
    }

    @Override
    public Cluster create(final List<ServerAddress> seedList, final ClusterableServerFactory serverFactory) {
        return new DiscoveringCluster(seedList, serverFactory);
    }
}