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
package org.spongepowered.api.service.user;

import java.util.Collection;
import java.util.UUID;

import org.spongepowered.api.GameProfile;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.service.profile.GameProfileResolver;

import com.google.common.base.Optional;

/**
 * Stores the persistent {@link User} data of a {@link Player}.
 */
public interface UserStorage {

    /**
     * Gets the data of a {@link User} by their unique id.
     *
     * @param uniqueId The UUID of the user.
     * @return {@link User} or Optional.absent() if not found
     */
    Optional<User> get(UUID uniqueId);

    /**
     * Gets the data of a {@link User} by their last known user name
     * (case-insensitive).
     *
     * <p>To get the current name of a player, use the
     * {@link GameProfileResolver} service.</p>
     *
     * @param uniqueId The UUID of the user.
     * @return {@link User} or Optional.absent() if not found
     */
    Optional<User> get(String lastKnownName);

    /**
     * Gets the data of a {@link User} by their profile.
     *
     * @param uniqueId The UUID of the user.
     * @return {@link User} or Optional.absent() if not found
     */
    Optional<User> get(GameProfile profile);

    /**
     * Gets or creates a persistent {@link User} associated with the given
     * {@link GameProfile}.
     *
     * To obtain a {@link GameProfile}, use the {@link GameProfileResolver}.
     *
     * @param profile The profile
     * @return The user object
     */
    User getOrCreate(GameProfile profile);

    /**
     * Deletes the data associated with a {@link User}.
     *
     * @param profile The profile
     * @return The user object
     */
    void delete(GameProfile profile);

    /**
     * Gets the collection of all stored {@link User}s.
     *
     * @return A {@link Collection} of users.
     */
    Collection<User> getAll();

    /**
     * Returns a collection of matching {@code User}s whose last known user
     * names start with the given string (case-insensitive).
     *
     * @param name
     * @return The result of the request
     */
    Collection<User> match(String lastKnownName);
}
