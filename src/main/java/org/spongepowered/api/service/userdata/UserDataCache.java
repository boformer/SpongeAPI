package org.spongepowered.api.service.userdata;

import java.util.List;
import java.util.UUID;

import org.spongepowered.api.entity.player.User;

import com.google.common.base.Optional;

/**
 * A service which provides access to the local {@link User} data cache.
 *
 * The data returned by this cache may not always be up to date.
 */
public interface UserDataCache {

    /**
     * Returns the user data for a given unique ID.
     *
     * @param uniqueId The unique ID
     * @return The user data, if found in cache
     */
    Optional<User> get(UUID uniqueId);

    /**
     * Returns the user data for a given name (case-insensitive).
     *
     * @param name The user name
     * @return The user data, if found in cache
     */
    Optional<User> get(String name);

    /**
     * Returns a list of matching users whose names start with the given string
     * (case-insensitive).
     *
     * @param name
     * @return A list of cached users
     */
    List<User> match(String name);

    /**
     * Returns a list of all cached users.
     *
     * @return A list of cached users
     */
    List<User> getAll();

    /**
     * Discards the cached data for a user.
     *
     * @param uniqueId The unique ID
     */
    void invalidate(UUID uniqueId);
}
