/*
 * Copyright (c) 2017 Bosch Software Innovations GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/epl-2.0/index.php
 *
 * Contributors:
 *    Bosch Software Innovations GmbH - initial contribution
 */
package org.eclipse.ditto.model.amqpbridge;

import java.util.Set;

import javax.annotation.concurrent.Immutable;

import org.eclipse.ditto.json.JsonObject;
import org.eclipse.ditto.model.base.auth.AuthorizationSubject;

/**
 * Factory to create new {@link AmqpConnection} instances.
 */
@Immutable
public final class AmqpBridgeModelFactory {

    private AmqpBridgeModelFactory() {
        throw new AssertionError();
    }

    /**
     * Returns a new {@code Connection}.
     *
     * @param id the connection identifier.
     * @param uri the connection uri.
     * @param authorizationSubject the connection authorization subject.
     * @param sources the connection sources.
     * @param failoverEnabled whether failover is enabled for the connection or not.
     * @return the ImmutableConnection.
     * @throws NullPointerException if any argument is {@code null}.
     */
    public static AmqpConnection newConnection(final String id, final String uri,
            final AuthorizationSubject authorizationSubject, final Set<String> sources, final boolean failoverEnabled) {
        return ImmutableAmqpConnection.of(id, uri, authorizationSubject, sources, failoverEnabled);
    }

    /**
     * Creates a new {@code Connection} object from the specified JSON object.
     *
     * @param jsonObject a JSON object which provides the data for the Connection to be created.
     * @return a new Connection which is initialised with the extracted data from {@code jsonObject}.
     * @throws NullPointerException if {@code jsonObject} is {@code null}.
     * @throws org.eclipse.ditto.json.JsonParseException if {@code jsonObject} is not an appropriate JSON object.
     */
    public static AmqpConnection connectionFromJson(final JsonObject jsonObject) {
        return ImmutableAmqpConnection.fromJson(jsonObject);
    }

}
