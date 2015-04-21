/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.service.profile;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.spongepowered.api.GameProfile;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * A service which contacts the authentification servers to get a
 * {@link GameProfile} by a given UUID or name.
 *
 * <p>The service may cache the data of a request for faster lookups. Note that
 * the cached data may not always be up to date.</p>
 *
 * <p>The returned {@code ListenableFuture} throws an {@link ExecutionException}
 * caused by a {@link ProfileNotFoundException} if the profile does not exist or
 * an {@link IOException} if a network error occured.</p>
 */
public interface GameProfileResolver
{

    /**
     * Looks up a {@link GameProfile} by its unique ID.
     *
     * @param uniqueId The unique ID
     * @param useCache true to perform a cache lookup first
     * @return The result of the request
     */
    ListenableFuture<GameProfile> get(UUID uniqueId, boolean useCache);

    /**
     * Gets a collection of {@link GameProfile}s by their unique IDs.
     *
     * @param uniqueIds The UUIDs
     * @param useCache true to perform a cache lookup first
     * @return The result of the request
     */
    ListenableFuture<Collection<GameProfile>> getAllById(Iterable<UUID> uniqueIds, boolean useCache);

    /**
     * Looks up a {@link GameProfile} by its user name.
     *
     * @param name The username
     * @return The result of the request
     */
    ListenableFuture<GameProfile> get(String name, boolean useCache);

    /**
     * Gets a collection of {@link GameProfile}s by their user names.
     *
     * @param names The user names
     * @return The result of the request
     */
    ListenableFuture<Collection<GameProfile>> getAllByName(Iterable<String> names, boolean useCache);
}
