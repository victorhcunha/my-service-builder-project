/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.h7g7.service.persistence;

import com.liferay.h7g7.exception.NoSuchH7G7EntryException;
import com.liferay.h7g7.model.H7G7Entry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the h7g7 entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see H7G7EntryUtil
 * @generated
 */
@ProviderType
public interface H7G7EntryPersistence extends BasePersistence<H7G7Entry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link H7G7EntryUtil} to access the h7g7 entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the h7g7 entries where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @return the matching h7g7 entries
	 */
	public java.util.List<H7G7Entry> findByH7G7FolderId(long h7g7FolderId);

	/**
	 * Returns a range of all the h7g7 entries where h7g7FolderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G7EntryModelImpl</code>.
	 * </p>
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param start the lower bound of the range of h7g7 entries
	 * @param end the upper bound of the range of h7g7 entries (not inclusive)
	 * @return the range of matching h7g7 entries
	 */
	public java.util.List<H7G7Entry> findByH7G7FolderId(
		long h7g7FolderId, int start, int end);

	/**
	 * Returns an ordered range of all the h7g7 entries where h7g7FolderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G7EntryModelImpl</code>.
	 * </p>
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param start the lower bound of the range of h7g7 entries
	 * @param end the upper bound of the range of h7g7 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching h7g7 entries
	 */
	public java.util.List<H7G7Entry> findByH7G7FolderId(
		long h7g7FolderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the h7g7 entries where h7g7FolderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G7EntryModelImpl</code>.
	 * </p>
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param start the lower bound of the range of h7g7 entries
	 * @param end the upper bound of the range of h7g7 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching h7g7 entries
	 */
	public java.util.List<H7G7Entry> findByH7G7FolderId(
		long h7g7FolderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first h7g7 entry in the ordered set where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	public H7G7Entry findByH7G7FolderId_First(
			long h7g7FolderId,
			com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
				orderByComparator)
		throws NoSuchH7G7EntryException;

	/**
	 * Returns the first h7g7 entry in the ordered set where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	public H7G7Entry fetchByH7G7FolderId_First(
		long h7g7FolderId,
		com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
			orderByComparator);

	/**
	 * Returns the last h7g7 entry in the ordered set where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	public H7G7Entry findByH7G7FolderId_Last(
			long h7g7FolderId,
			com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
				orderByComparator)
		throws NoSuchH7G7EntryException;

	/**
	 * Returns the last h7g7 entry in the ordered set where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	public H7G7Entry fetchByH7G7FolderId_Last(
		long h7g7FolderId,
		com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
			orderByComparator);

	/**
	 * Returns the h7g7 entries before and after the current h7g7 entry in the ordered set where h7g7FolderId = &#63;.
	 *
	 * @param h7g7EntryId the primary key of the current h7g7 entry
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next h7g7 entry
	 * @throws NoSuchH7G7EntryException if a h7g7 entry with the primary key could not be found
	 */
	public H7G7Entry[] findByH7G7FolderId_PrevAndNext(
			long h7g7EntryId, long h7g7FolderId,
			com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
				orderByComparator)
		throws NoSuchH7G7EntryException;

	/**
	 * Removes all the h7g7 entries where h7g7FolderId = &#63; from the database.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 */
	public void removeByH7G7FolderId(long h7g7FolderId);

	/**
	 * Returns the number of h7g7 entries where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @return the number of matching h7g7 entries
	 */
	public int countByH7G7FolderId(long h7g7FolderId);

	/**
	 * Returns the h7g7 entry where key = &#63; or throws a <code>NoSuchH7G7EntryException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	public H7G7Entry findByKey(String key) throws NoSuchH7G7EntryException;

	/**
	 * Returns the h7g7 entry where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	public H7G7Entry fetchByKey(String key);

	/**
	 * Returns the h7g7 entry where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	public H7G7Entry fetchByKey(String key, boolean useFinderCache);

	/**
	 * Removes the h7g7 entry where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the h7g7 entry that was removed
	 */
	public H7G7Entry removeByKey(String key) throws NoSuchH7G7EntryException;

	/**
	 * Returns the number of h7g7 entries where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching h7g7 entries
	 */
	public int countByKey(String key);

	/**
	 * Returns all the h7g7 entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching h7g7 entries
	 */
	public java.util.List<H7G7Entry> findByName(String name);

	/**
	 * Returns a range of all the h7g7 entries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G7EntryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of h7g7 entries
	 * @param end the upper bound of the range of h7g7 entries (not inclusive)
	 * @return the range of matching h7g7 entries
	 */
	public java.util.List<H7G7Entry> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the h7g7 entries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G7EntryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of h7g7 entries
	 * @param end the upper bound of the range of h7g7 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching h7g7 entries
	 */
	public java.util.List<H7G7Entry> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the h7g7 entries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G7EntryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of h7g7 entries
	 * @param end the upper bound of the range of h7g7 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching h7g7 entries
	 */
	public java.util.List<H7G7Entry> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first h7g7 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	public H7G7Entry findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
				orderByComparator)
		throws NoSuchH7G7EntryException;

	/**
	 * Returns the first h7g7 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	public H7G7Entry fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
			orderByComparator);

	/**
	 * Returns the last h7g7 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	public H7G7Entry findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
				orderByComparator)
		throws NoSuchH7G7EntryException;

	/**
	 * Returns the last h7g7 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	public H7G7Entry fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
			orderByComparator);

	/**
	 * Returns the h7g7 entries before and after the current h7g7 entry in the ordered set where name = &#63;.
	 *
	 * @param h7g7EntryId the primary key of the current h7g7 entry
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next h7g7 entry
	 * @throws NoSuchH7G7EntryException if a h7g7 entry with the primary key could not be found
	 */
	public H7G7Entry[] findByName_PrevAndNext(
			long h7g7EntryId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
				orderByComparator)
		throws NoSuchH7G7EntryException;

	/**
	 * Removes all the h7g7 entries where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of h7g7 entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching h7g7 entries
	 */
	public int countByName(String name);

	/**
	 * Returns the h7g7 entry where h7g7FolderId = &#63; and description = &#63; and name = &#63; or throws a <code>NoSuchH7G7EntryException</code> if it could not be found.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	public H7G7Entry findByH_D_N(
			long h7g7FolderId, String description, String name)
		throws NoSuchH7G7EntryException;

	/**
	 * Returns the h7g7 entry where h7g7FolderId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	public H7G7Entry fetchByH_D_N(
		long h7g7FolderId, String description, String name);

	/**
	 * Returns the h7g7 entry where h7g7FolderId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param description the description
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	public H7G7Entry fetchByH_D_N(
		long h7g7FolderId, String description, String name,
		boolean useFinderCache);

	/**
	 * Removes the h7g7 entry where h7g7FolderId = &#63; and description = &#63; and name = &#63; from the database.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the h7g7 entry that was removed
	 */
	public H7G7Entry removeByH_D_N(
			long h7g7FolderId, String description, String name)
		throws NoSuchH7G7EntryException;

	/**
	 * Returns the number of h7g7 entries where h7g7FolderId = &#63; and description = &#63; and name = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the number of matching h7g7 entries
	 */
	public int countByH_D_N(long h7g7FolderId, String description, String name);

	/**
	 * Caches the h7g7 entry in the entity cache if it is enabled.
	 *
	 * @param h7g7Entry the h7g7 entry
	 */
	public void cacheResult(H7G7Entry h7g7Entry);

	/**
	 * Caches the h7g7 entries in the entity cache if it is enabled.
	 *
	 * @param h7g7Entries the h7g7 entries
	 */
	public void cacheResult(java.util.List<H7G7Entry> h7g7Entries);

	/**
	 * Creates a new h7g7 entry with the primary key. Does not add the h7g7 entry to the database.
	 *
	 * @param h7g7EntryId the primary key for the new h7g7 entry
	 * @return the new h7g7 entry
	 */
	public H7G7Entry create(long h7g7EntryId);

	/**
	 * Removes the h7g7 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param h7g7EntryId the primary key of the h7g7 entry
	 * @return the h7g7 entry that was removed
	 * @throws NoSuchH7G7EntryException if a h7g7 entry with the primary key could not be found
	 */
	public H7G7Entry remove(long h7g7EntryId) throws NoSuchH7G7EntryException;

	public H7G7Entry updateImpl(H7G7Entry h7g7Entry);

	/**
	 * Returns the h7g7 entry with the primary key or throws a <code>NoSuchH7G7EntryException</code> if it could not be found.
	 *
	 * @param h7g7EntryId the primary key of the h7g7 entry
	 * @return the h7g7 entry
	 * @throws NoSuchH7G7EntryException if a h7g7 entry with the primary key could not be found
	 */
	public H7G7Entry findByPrimaryKey(long h7g7EntryId)
		throws NoSuchH7G7EntryException;

	/**
	 * Returns the h7g7 entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param h7g7EntryId the primary key of the h7g7 entry
	 * @return the h7g7 entry, or <code>null</code> if a h7g7 entry with the primary key could not be found
	 */
	public H7G7Entry fetchByPrimaryKey(long h7g7EntryId);

	/**
	 * Returns all the h7g7 entries.
	 *
	 * @return the h7g7 entries
	 */
	public java.util.List<H7G7Entry> findAll();

	/**
	 * Returns a range of all the h7g7 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G7EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g7 entries
	 * @param end the upper bound of the range of h7g7 entries (not inclusive)
	 * @return the range of h7g7 entries
	 */
	public java.util.List<H7G7Entry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the h7g7 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G7EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g7 entries
	 * @param end the upper bound of the range of h7g7 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of h7g7 entries
	 */
	public java.util.List<H7G7Entry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the h7g7 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G7EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g7 entries
	 * @param end the upper bound of the range of h7g7 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of h7g7 entries
	 */
	public java.util.List<H7G7Entry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<H7G7Entry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the h7g7 entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of h7g7 entries.
	 *
	 * @return the number of h7g7 entries
	 */
	public int countAll();

}