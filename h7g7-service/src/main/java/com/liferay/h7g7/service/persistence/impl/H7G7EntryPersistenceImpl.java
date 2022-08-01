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

package com.liferay.h7g7.service.persistence.impl;

import com.liferay.h7g7.exception.NoSuchH7G7EntryException;
import com.liferay.h7g7.model.H7G7Entry;
import com.liferay.h7g7.model.H7G7EntryTable;
import com.liferay.h7g7.model.impl.H7G7EntryImpl;
import com.liferay.h7g7.model.impl.H7G7EntryModelImpl;
import com.liferay.h7g7.service.persistence.H7G7EntryPersistence;
import com.liferay.h7g7.service.persistence.H7G7EntryUtil;
import com.liferay.h7g7.service.persistence.impl.constants.OHQIWTSFHLPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the h7g7 entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {H7G7EntryPersistence.class, BasePersistence.class})
public class H7G7EntryPersistenceImpl
	extends BasePersistenceImpl<H7G7Entry> implements H7G7EntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>H7G7EntryUtil</code> to access the h7g7 entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		H7G7EntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByH7G7FolderId;
	private FinderPath _finderPathWithoutPaginationFindByH7G7FolderId;
	private FinderPath _finderPathCountByH7G7FolderId;

	/**
	 * Returns all the h7g7 entries where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @return the matching h7g7 entries
	 */
	@Override
	public List<H7G7Entry> findByH7G7FolderId(long h7g7FolderId) {
		return findByH7G7FolderId(
			h7g7FolderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<H7G7Entry> findByH7G7FolderId(
		long h7g7FolderId, int start, int end) {

		return findByH7G7FolderId(h7g7FolderId, start, end, null);
	}

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
	@Override
	public List<H7G7Entry> findByH7G7FolderId(
		long h7g7FolderId, int start, int end,
		OrderByComparator<H7G7Entry> orderByComparator) {

		return findByH7G7FolderId(
			h7g7FolderId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<H7G7Entry> findByH7G7FolderId(
		long h7g7FolderId, int start, int end,
		OrderByComparator<H7G7Entry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByH7G7FolderId;
				finderArgs = new Object[] {h7g7FolderId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByH7G7FolderId;
			finderArgs = new Object[] {
				h7g7FolderId, start, end, orderByComparator
			};
		}

		List<H7G7Entry> list = null;

		if (useFinderCache) {
			list = (List<H7G7Entry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (H7G7Entry h7g7Entry : list) {
					if (h7g7FolderId != h7g7Entry.getH7g7FolderId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_H7G7ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_H7G7FOLDERID_H7G7FOLDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(H7G7EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(h7g7FolderId);

				list = (List<H7G7Entry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first h7g7 entry in the ordered set where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry findByH7G7FolderId_First(
			long h7g7FolderId, OrderByComparator<H7G7Entry> orderByComparator)
		throws NoSuchH7G7EntryException {

		H7G7Entry h7g7Entry = fetchByH7G7FolderId_First(
			h7g7FolderId, orderByComparator);

		if (h7g7Entry != null) {
			return h7g7Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("h7g7FolderId=");
		sb.append(h7g7FolderId);

		sb.append("}");

		throw new NoSuchH7G7EntryException(sb.toString());
	}

	/**
	 * Returns the first h7g7 entry in the ordered set where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry fetchByH7G7FolderId_First(
		long h7g7FolderId, OrderByComparator<H7G7Entry> orderByComparator) {

		List<H7G7Entry> list = findByH7G7FolderId(
			h7g7FolderId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last h7g7 entry in the ordered set where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry findByH7G7FolderId_Last(
			long h7g7FolderId, OrderByComparator<H7G7Entry> orderByComparator)
		throws NoSuchH7G7EntryException {

		H7G7Entry h7g7Entry = fetchByH7G7FolderId_Last(
			h7g7FolderId, orderByComparator);

		if (h7g7Entry != null) {
			return h7g7Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("h7g7FolderId=");
		sb.append(h7g7FolderId);

		sb.append("}");

		throw new NoSuchH7G7EntryException(sb.toString());
	}

	/**
	 * Returns the last h7g7 entry in the ordered set where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry fetchByH7G7FolderId_Last(
		long h7g7FolderId, OrderByComparator<H7G7Entry> orderByComparator) {

		int count = countByH7G7FolderId(h7g7FolderId);

		if (count == 0) {
			return null;
		}

		List<H7G7Entry> list = findByH7G7FolderId(
			h7g7FolderId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the h7g7 entries before and after the current h7g7 entry in the ordered set where h7g7FolderId = &#63;.
	 *
	 * @param h7g7EntryId the primary key of the current h7g7 entry
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next h7g7 entry
	 * @throws NoSuchH7G7EntryException if a h7g7 entry with the primary key could not be found
	 */
	@Override
	public H7G7Entry[] findByH7G7FolderId_PrevAndNext(
			long h7g7EntryId, long h7g7FolderId,
			OrderByComparator<H7G7Entry> orderByComparator)
		throws NoSuchH7G7EntryException {

		H7G7Entry h7g7Entry = findByPrimaryKey(h7g7EntryId);

		Session session = null;

		try {
			session = openSession();

			H7G7Entry[] array = new H7G7EntryImpl[3];

			array[0] = getByH7G7FolderId_PrevAndNext(
				session, h7g7Entry, h7g7FolderId, orderByComparator, true);

			array[1] = h7g7Entry;

			array[2] = getByH7G7FolderId_PrevAndNext(
				session, h7g7Entry, h7g7FolderId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected H7G7Entry getByH7G7FolderId_PrevAndNext(
		Session session, H7G7Entry h7g7Entry, long h7g7FolderId,
		OrderByComparator<H7G7Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_H7G7ENTRY_WHERE);

		sb.append(_FINDER_COLUMN_H7G7FOLDERID_H7G7FOLDERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(H7G7EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(h7g7FolderId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(h7g7Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<H7G7Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the h7g7 entries where h7g7FolderId = &#63; from the database.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 */
	@Override
	public void removeByH7G7FolderId(long h7g7FolderId) {
		for (H7G7Entry h7g7Entry :
				findByH7G7FolderId(
					h7g7FolderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(h7g7Entry);
		}
	}

	/**
	 * Returns the number of h7g7 entries where h7g7FolderId = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @return the number of matching h7g7 entries
	 */
	@Override
	public int countByH7G7FolderId(long h7g7FolderId) {
		FinderPath finderPath = _finderPathCountByH7G7FolderId;

		Object[] finderArgs = new Object[] {h7g7FolderId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_H7G7ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_H7G7FOLDERID_H7G7FOLDERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(h7g7FolderId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_H7G7FOLDERID_H7G7FOLDERID_2 =
		"h7g7Entry.h7g7FolderId = ?";

	private FinderPath _finderPathFetchByKey;
	private FinderPath _finderPathCountByKey;

	/**
	 * Returns the h7g7 entry where key = &#63; or throws a <code>NoSuchH7G7EntryException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry findByKey(String key) throws NoSuchH7G7EntryException {
		H7G7Entry h7g7Entry = fetchByKey(key);

		if (h7g7Entry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("key=");
			sb.append(key);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchH7G7EntryException(sb.toString());
		}

		return h7g7Entry;
	}

	/**
	 * Returns the h7g7 entry where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry fetchByKey(String key) {
		return fetchByKey(key, true);
	}

	/**
	 * Returns the h7g7 entry where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry fetchByKey(String key, boolean useFinderCache) {
		key = Objects.toString(key, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {key};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByKey, finderArgs);
		}

		if (result instanceof H7G7Entry) {
			H7G7Entry h7g7Entry = (H7G7Entry)result;

			if (!Objects.equals(key, h7g7Entry.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_H7G7ENTRY_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				sb.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				sb.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKey) {
					queryPos.add(key);
				}

				List<H7G7Entry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByKey, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {key};
							}

							_log.warn(
								"H7G7EntryPersistenceImpl.fetchByKey(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					H7G7Entry h7g7Entry = list.get(0);

					result = h7g7Entry;

					cacheResult(h7g7Entry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (H7G7Entry)result;
		}
	}

	/**
	 * Removes the h7g7 entry where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the h7g7 entry that was removed
	 */
	@Override
	public H7G7Entry removeByKey(String key) throws NoSuchH7G7EntryException {
		H7G7Entry h7g7Entry = findByKey(key);

		return remove(h7g7Entry);
	}

	/**
	 * Returns the number of h7g7 entries where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching h7g7 entries
	 */
	@Override
	public int countByKey(String key) {
		key = Objects.toString(key, "");

		FinderPath finderPath = _finderPathCountByKey;

		Object[] finderArgs = new Object[] {key};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_H7G7ENTRY_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				sb.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				sb.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKey) {
					queryPos.add(key);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_KEY_KEY_2 = "h7g7Entry.key = ?";

	private static final String _FINDER_COLUMN_KEY_KEY_3 =
		"(h7g7Entry.key IS NULL OR h7g7Entry.key = '')";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the h7g7 entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching h7g7 entries
	 */
	@Override
	public List<H7G7Entry> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<H7G7Entry> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

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
	@Override
	public List<H7G7Entry> findByName(
		String name, int start, int end,
		OrderByComparator<H7G7Entry> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

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
	@Override
	public List<H7G7Entry> findByName(
		String name, int start, int end,
		OrderByComparator<H7G7Entry> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<H7G7Entry> list = null;

		if (useFinderCache) {
			list = (List<H7G7Entry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (H7G7Entry h7g7Entry : list) {
					if (!name.equals(h7g7Entry.getName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_H7G7ENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(H7G7EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<H7G7Entry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first h7g7 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry findByName_First(
			String name, OrderByComparator<H7G7Entry> orderByComparator)
		throws NoSuchH7G7EntryException {

		H7G7Entry h7g7Entry = fetchByName_First(name, orderByComparator);

		if (h7g7Entry != null) {
			return h7g7Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchH7G7EntryException(sb.toString());
	}

	/**
	 * Returns the first h7g7 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry fetchByName_First(
		String name, OrderByComparator<H7G7Entry> orderByComparator) {

		List<H7G7Entry> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last h7g7 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry findByName_Last(
			String name, OrderByComparator<H7G7Entry> orderByComparator)
		throws NoSuchH7G7EntryException {

		H7G7Entry h7g7Entry = fetchByName_Last(name, orderByComparator);

		if (h7g7Entry != null) {
			return h7g7Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchH7G7EntryException(sb.toString());
	}

	/**
	 * Returns the last h7g7 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry fetchByName_Last(
		String name, OrderByComparator<H7G7Entry> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<H7G7Entry> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the h7g7 entries before and after the current h7g7 entry in the ordered set where name = &#63;.
	 *
	 * @param h7g7EntryId the primary key of the current h7g7 entry
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next h7g7 entry
	 * @throws NoSuchH7G7EntryException if a h7g7 entry with the primary key could not be found
	 */
	@Override
	public H7G7Entry[] findByName_PrevAndNext(
			long h7g7EntryId, String name,
			OrderByComparator<H7G7Entry> orderByComparator)
		throws NoSuchH7G7EntryException {

		name = Objects.toString(name, "");

		H7G7Entry h7g7Entry = findByPrimaryKey(h7g7EntryId);

		Session session = null;

		try {
			session = openSession();

			H7G7Entry[] array = new H7G7EntryImpl[3];

			array[0] = getByName_PrevAndNext(
				session, h7g7Entry, name, orderByComparator, true);

			array[1] = h7g7Entry;

			array[2] = getByName_PrevAndNext(
				session, h7g7Entry, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected H7G7Entry getByName_PrevAndNext(
		Session session, H7G7Entry h7g7Entry, String name,
		OrderByComparator<H7G7Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_H7G7ENTRY_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(H7G7EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(h7g7Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<H7G7Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the h7g7 entries where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (H7G7Entry h7g7Entry :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(h7g7Entry);
		}
	}

	/**
	 * Returns the number of h7g7 entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching h7g7 entries
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_H7G7ENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"h7g7Entry.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(h7g7Entry.name IS NULL OR h7g7Entry.name = '')";

	private FinderPath _finderPathFetchByH_D_N;
	private FinderPath _finderPathCountByH_D_N;

	/**
	 * Returns the h7g7 entry where h7g7FolderId = &#63; and description = &#63; and name = &#63; or throws a <code>NoSuchH7G7EntryException</code> if it could not be found.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the matching h7g7 entry
	 * @throws NoSuchH7G7EntryException if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry findByH_D_N(
			long h7g7FolderId, String description, String name)
		throws NoSuchH7G7EntryException {

		H7G7Entry h7g7Entry = fetchByH_D_N(h7g7FolderId, description, name);

		if (h7g7Entry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("h7g7FolderId=");
			sb.append(h7g7FolderId);

			sb.append(", description=");
			sb.append(description);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchH7G7EntryException(sb.toString());
		}

		return h7g7Entry;
	}

	/**
	 * Returns the h7g7 entry where h7g7FolderId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry fetchByH_D_N(
		long h7g7FolderId, String description, String name) {

		return fetchByH_D_N(h7g7FolderId, description, name, true);
	}

	/**
	 * Returns the h7g7 entry where h7g7FolderId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param description the description
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching h7g7 entry, or <code>null</code> if a matching h7g7 entry could not be found
	 */
	@Override
	public H7G7Entry fetchByH_D_N(
		long h7g7FolderId, String description, String name,
		boolean useFinderCache) {

		description = Objects.toString(description, "");
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {h7g7FolderId, description, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByH_D_N, finderArgs);
		}

		if (result instanceof H7G7Entry) {
			H7G7Entry h7g7Entry = (H7G7Entry)result;

			if ((h7g7FolderId != h7g7Entry.getH7g7FolderId()) ||
				!Objects.equals(description, h7g7Entry.getDescription()) ||
				!Objects.equals(name, h7g7Entry.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_H7G7ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_H_D_N_H7G7FOLDERID_2);

			boolean bindDescription = false;

			if (description.isEmpty()) {
				sb.append(_FINDER_COLUMN_H_D_N_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				sb.append(_FINDER_COLUMN_H_D_N_DESCRIPTION_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_H_D_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_H_D_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(h7g7FolderId);

				if (bindDescription) {
					queryPos.add(description);
				}

				if (bindName) {
					queryPos.add(name);
				}

				List<H7G7Entry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByH_D_N, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									h7g7FolderId, description, name
								};
							}

							_log.warn(
								"H7G7EntryPersistenceImpl.fetchByH_D_N(long, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					H7G7Entry h7g7Entry = list.get(0);

					result = h7g7Entry;

					cacheResult(h7g7Entry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (H7G7Entry)result;
		}
	}

	/**
	 * Removes the h7g7 entry where h7g7FolderId = &#63; and description = &#63; and name = &#63; from the database.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the h7g7 entry that was removed
	 */
	@Override
	public H7G7Entry removeByH_D_N(
			long h7g7FolderId, String description, String name)
		throws NoSuchH7G7EntryException {

		H7G7Entry h7g7Entry = findByH_D_N(h7g7FolderId, description, name);

		return remove(h7g7Entry);
	}

	/**
	 * Returns the number of h7g7 entries where h7g7FolderId = &#63; and description = &#63; and name = &#63;.
	 *
	 * @param h7g7FolderId the h7g7 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the number of matching h7g7 entries
	 */
	@Override
	public int countByH_D_N(
		long h7g7FolderId, String description, String name) {

		description = Objects.toString(description, "");
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByH_D_N;

		Object[] finderArgs = new Object[] {h7g7FolderId, description, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_H7G7ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_H_D_N_H7G7FOLDERID_2);

			boolean bindDescription = false;

			if (description.isEmpty()) {
				sb.append(_FINDER_COLUMN_H_D_N_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				sb.append(_FINDER_COLUMN_H_D_N_DESCRIPTION_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_H_D_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_H_D_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(h7g7FolderId);

				if (bindDescription) {
					queryPos.add(description);
				}

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_H_D_N_H7G7FOLDERID_2 =
		"h7g7Entry.h7g7FolderId = ? AND ";

	private static final String _FINDER_COLUMN_H_D_N_DESCRIPTION_2 =
		"h7g7Entry.description = ? AND ";

	private static final String _FINDER_COLUMN_H_D_N_DESCRIPTION_3 =
		"(h7g7Entry.description IS NULL OR h7g7Entry.description = '') AND ";

	private static final String _FINDER_COLUMN_H_D_N_NAME_2 =
		"h7g7Entry.name = ?";

	private static final String _FINDER_COLUMN_H_D_N_NAME_3 =
		"(h7g7Entry.name IS NULL OR h7g7Entry.name = '')";

	public H7G7EntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);

		setModelClass(H7G7Entry.class);

		setModelImplClass(H7G7EntryImpl.class);
		setModelPKClass(long.class);

		setTable(H7G7EntryTable.INSTANCE);
	}

	/**
	 * Caches the h7g7 entry in the entity cache if it is enabled.
	 *
	 * @param h7g7Entry the h7g7 entry
	 */
	@Override
	public void cacheResult(H7G7Entry h7g7Entry) {
		entityCache.putResult(
			H7G7EntryImpl.class, h7g7Entry.getPrimaryKey(), h7g7Entry);

		finderCache.putResult(
			_finderPathFetchByKey, new Object[] {h7g7Entry.getKey()},
			h7g7Entry);

		finderCache.putResult(
			_finderPathFetchByH_D_N,
			new Object[] {
				h7g7Entry.getH7g7FolderId(), h7g7Entry.getDescription(),
				h7g7Entry.getName()
			},
			h7g7Entry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the h7g7 entries in the entity cache if it is enabled.
	 *
	 * @param h7g7Entries the h7g7 entries
	 */
	@Override
	public void cacheResult(List<H7G7Entry> h7g7Entries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (h7g7Entries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (H7G7Entry h7g7Entry : h7g7Entries) {
			if (entityCache.getResult(
					H7G7EntryImpl.class, h7g7Entry.getPrimaryKey()) == null) {

				cacheResult(h7g7Entry);
			}
		}
	}

	/**
	 * Clears the cache for all h7g7 entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(H7G7EntryImpl.class);

		finderCache.clearCache(H7G7EntryImpl.class);
	}

	/**
	 * Clears the cache for the h7g7 entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(H7G7Entry h7g7Entry) {
		entityCache.removeResult(H7G7EntryImpl.class, h7g7Entry);
	}

	@Override
	public void clearCache(List<H7G7Entry> h7g7Entries) {
		for (H7G7Entry h7g7Entry : h7g7Entries) {
			entityCache.removeResult(H7G7EntryImpl.class, h7g7Entry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(H7G7EntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(H7G7EntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		H7G7EntryModelImpl h7g7EntryModelImpl) {

		Object[] args = new Object[] {h7g7EntryModelImpl.getKey()};

		finderCache.putResult(_finderPathCountByKey, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByKey, args, h7g7EntryModelImpl);

		args = new Object[] {
			h7g7EntryModelImpl.getH7g7FolderId(),
			h7g7EntryModelImpl.getDescription(), h7g7EntryModelImpl.getName()
		};

		finderCache.putResult(_finderPathCountByH_D_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByH_D_N, args, h7g7EntryModelImpl);
	}

	/**
	 * Creates a new h7g7 entry with the primary key. Does not add the h7g7 entry to the database.
	 *
	 * @param h7g7EntryId the primary key for the new h7g7 entry
	 * @return the new h7g7 entry
	 */
	@Override
	public H7G7Entry create(long h7g7EntryId) {
		H7G7Entry h7g7Entry = new H7G7EntryImpl();

		h7g7Entry.setNew(true);
		h7g7Entry.setPrimaryKey(h7g7EntryId);

		h7g7Entry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return h7g7Entry;
	}

	/**
	 * Removes the h7g7 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param h7g7EntryId the primary key of the h7g7 entry
	 * @return the h7g7 entry that was removed
	 * @throws NoSuchH7G7EntryException if a h7g7 entry with the primary key could not be found
	 */
	@Override
	public H7G7Entry remove(long h7g7EntryId) throws NoSuchH7G7EntryException {
		return remove((Serializable)h7g7EntryId);
	}

	/**
	 * Removes the h7g7 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the h7g7 entry
	 * @return the h7g7 entry that was removed
	 * @throws NoSuchH7G7EntryException if a h7g7 entry with the primary key could not be found
	 */
	@Override
	public H7G7Entry remove(Serializable primaryKey)
		throws NoSuchH7G7EntryException {

		Session session = null;

		try {
			session = openSession();

			H7G7Entry h7g7Entry = (H7G7Entry)session.get(
				H7G7EntryImpl.class, primaryKey);

			if (h7g7Entry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchH7G7EntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(h7g7Entry);
		}
		catch (NoSuchH7G7EntryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected H7G7Entry removeImpl(H7G7Entry h7g7Entry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(h7g7Entry)) {
				h7g7Entry = (H7G7Entry)session.get(
					H7G7EntryImpl.class, h7g7Entry.getPrimaryKeyObj());
			}

			if (h7g7Entry != null) {
				session.delete(h7g7Entry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (h7g7Entry != null) {
			clearCache(h7g7Entry);
		}

		return h7g7Entry;
	}

	@Override
	public H7G7Entry updateImpl(H7G7Entry h7g7Entry) {
		boolean isNew = h7g7Entry.isNew();

		if (!(h7g7Entry instanceof H7G7EntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(h7g7Entry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(h7g7Entry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in h7g7Entry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom H7G7Entry implementation " +
					h7g7Entry.getClass());
		}

		H7G7EntryModelImpl h7g7EntryModelImpl = (H7G7EntryModelImpl)h7g7Entry;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (h7g7Entry.getCreateDate() == null)) {
			if (serviceContext == null) {
				h7g7Entry.setCreateDate(date);
			}
			else {
				h7g7Entry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!h7g7EntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				h7g7Entry.setModifiedDate(date);
			}
			else {
				h7g7Entry.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(h7g7Entry);
			}
			else {
				h7g7Entry = (H7G7Entry)session.merge(h7g7Entry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			H7G7EntryImpl.class, h7g7EntryModelImpl, false, true);

		cacheUniqueFindersCache(h7g7EntryModelImpl);

		if (isNew) {
			h7g7Entry.setNew(false);
		}

		h7g7Entry.resetOriginalValues();

		return h7g7Entry;
	}

	/**
	 * Returns the h7g7 entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the h7g7 entry
	 * @return the h7g7 entry
	 * @throws NoSuchH7G7EntryException if a h7g7 entry with the primary key could not be found
	 */
	@Override
	public H7G7Entry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchH7G7EntryException {

		H7G7Entry h7g7Entry = fetchByPrimaryKey(primaryKey);

		if (h7g7Entry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchH7G7EntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return h7g7Entry;
	}

	/**
	 * Returns the h7g7 entry with the primary key or throws a <code>NoSuchH7G7EntryException</code> if it could not be found.
	 *
	 * @param h7g7EntryId the primary key of the h7g7 entry
	 * @return the h7g7 entry
	 * @throws NoSuchH7G7EntryException if a h7g7 entry with the primary key could not be found
	 */
	@Override
	public H7G7Entry findByPrimaryKey(long h7g7EntryId)
		throws NoSuchH7G7EntryException {

		return findByPrimaryKey((Serializable)h7g7EntryId);
	}

	/**
	 * Returns the h7g7 entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param h7g7EntryId the primary key of the h7g7 entry
	 * @return the h7g7 entry, or <code>null</code> if a h7g7 entry with the primary key could not be found
	 */
	@Override
	public H7G7Entry fetchByPrimaryKey(long h7g7EntryId) {
		return fetchByPrimaryKey((Serializable)h7g7EntryId);
	}

	/**
	 * Returns all the h7g7 entries.
	 *
	 * @return the h7g7 entries
	 */
	@Override
	public List<H7G7Entry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<H7G7Entry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<H7G7Entry> findAll(
		int start, int end, OrderByComparator<H7G7Entry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<H7G7Entry> findAll(
		int start, int end, OrderByComparator<H7G7Entry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<H7G7Entry> list = null;

		if (useFinderCache) {
			list = (List<H7G7Entry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_H7G7ENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_H7G7ENTRY;

				sql = sql.concat(H7G7EntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<H7G7Entry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the h7g7 entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (H7G7Entry h7g7Entry : findAll()) {
			remove(h7g7Entry);
		}
	}

	/**
	 * Returns the number of h7g7 entries.
	 *
	 * @return the number of h7g7 entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_H7G7ENTRY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "h7g7EntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_H7G7ENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return H7G7EntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the h7g7 entry persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByH7G7FolderId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByH7G7FolderId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"h7g7FolderId"}, true);

		_finderPathWithoutPaginationFindByH7G7FolderId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByH7G7FolderId",
			new String[] {Long.class.getName()}, new String[] {"h7g7FolderId"},
			true);

		_finderPathCountByH7G7FolderId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByH7G7FolderId",
			new String[] {Long.class.getName()}, new String[] {"h7g7FolderId"},
			false);

		_finderPathFetchByKey = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByKey",
			new String[] {String.class.getName()}, new String[] {"key_"}, true);

		_finderPathCountByKey = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] {String.class.getName()}, new String[] {"key_"},
			false);

		_finderPathWithPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathFetchByH_D_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByH_D_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"h7g7FolderId", "description", "name"}, true);

		_finderPathCountByH_D_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByH_D_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"h7g7FolderId", "description", "name"}, false);

		_setH7G7EntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setH7G7EntryUtilPersistence(null);

		entityCache.removeCache(H7G7EntryImpl.class.getName());
	}

	private void _setH7G7EntryUtilPersistence(
		H7G7EntryPersistence h7g7EntryPersistence) {

		try {
			Field field = H7G7EntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, h7g7EntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = OHQIWTSFHLPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = OHQIWTSFHLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OHQIWTSFHLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_H7G7ENTRY =
		"SELECT h7g7Entry FROM H7G7Entry h7g7Entry";

	private static final String _SQL_SELECT_H7G7ENTRY_WHERE =
		"SELECT h7g7Entry FROM H7G7Entry h7g7Entry WHERE ";

	private static final String _SQL_COUNT_H7G7ENTRY =
		"SELECT COUNT(h7g7Entry) FROM H7G7Entry h7g7Entry";

	private static final String _SQL_COUNT_H7G7ENTRY_WHERE =
		"SELECT COUNT(h7g7Entry) FROM H7G7Entry h7g7Entry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "h7g7Entry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No H7G7Entry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No H7G7Entry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		H7G7EntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private H7G7EntryModelArgumentsResolver _h7g7EntryModelArgumentsResolver;

}