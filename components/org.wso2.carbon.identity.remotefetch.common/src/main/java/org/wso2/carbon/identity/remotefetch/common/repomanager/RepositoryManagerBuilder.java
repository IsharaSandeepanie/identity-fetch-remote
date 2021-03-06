/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.remotefetch.common.repomanager;

import org.wso2.carbon.identity.remotefetch.common.RemoteFetchConfiguration;
import org.wso2.carbon.identity.remotefetch.common.RemoteFetchCoreConfiguration;

/**
 * Builds a RepositoryManager from a RemoteFetchConfiguration file.
 */
public abstract class RepositoryManagerBuilder {

    protected RemoteFetchConfiguration fetchConfig;
    protected RemoteFetchCoreConfiguration fetchCoreConfiguration;

    public RepositoryManagerBuilder() {

    }

    /**
     * Set RemoteFetchConfiguration attribute.
     *
     * @param fetchConfig
     * @return
     */
    public RepositoryManagerBuilder addRemoteFetchConfig(RemoteFetchConfiguration fetchConfig) {

        this.fetchConfig = fetchConfig;
        return this;
    }

    /**
     * Set RemoteFetchCoreConfiguration attribute.
     *
     * @param fetchCoreConfiguration
     * @return
     */
    public RepositoryManagerBuilder addRemoteFetchCoreConfig(RemoteFetchCoreConfiguration fetchCoreConfiguration) {

        this.fetchCoreConfiguration = fetchCoreConfiguration;
        return this;
    }

    /**
     * Build and return a new RepositoryManager with the set configuration.
     *
     * @return
     * @throws RepositoryManagerBuilderException
     */
    public abstract RepositoryManager build() throws RepositoryManagerBuilderException;
}
