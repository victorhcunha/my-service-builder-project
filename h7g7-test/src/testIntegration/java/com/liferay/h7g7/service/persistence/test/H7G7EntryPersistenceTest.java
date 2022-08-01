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

package com.liferay.h7g7.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.h7g7.exception.NoSuchH7G7EntryException;
import com.liferay.h7g7.model.H7G7Entry;
import com.liferay.h7g7.service.H7G7EntryLocalServiceUtil;
import com.liferay.h7g7.service.persistence.H7G7EntryPersistence;
import com.liferay.h7g7.service.persistence.H7G7EntryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class H7G7EntryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.h7g7.service"));

	@Before
	public void setUp() {
		_persistence = H7G7EntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<H7G7Entry> iterator = _h7g7Entries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G7Entry h7g7Entry = _persistence.create(pk);

		Assert.assertNotNull(h7g7Entry);

		Assert.assertEquals(h7g7Entry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		H7G7Entry newH7G7Entry = addH7G7Entry();

		_persistence.remove(newH7G7Entry);

		H7G7Entry existingH7G7Entry = _persistence.fetchByPrimaryKey(
			newH7G7Entry.getPrimaryKey());

		Assert.assertNull(existingH7G7Entry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addH7G7Entry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G7Entry newH7G7Entry = _persistence.create(pk);

		newH7G7Entry.setGroupId(RandomTestUtil.nextLong());

		newH7G7Entry.setCompanyId(RandomTestUtil.nextLong());

		newH7G7Entry.setUserId(RandomTestUtil.nextLong());

		newH7G7Entry.setUserName(RandomTestUtil.randomString());

		newH7G7Entry.setCreateDate(RandomTestUtil.nextDate());

		newH7G7Entry.setModifiedDate(RandomTestUtil.nextDate());

		newH7G7Entry.setH7g7FolderId(RandomTestUtil.nextLong());

		newH7G7Entry.setDescription(RandomTestUtil.randomString());

		newH7G7Entry.setKey(RandomTestUtil.randomString());

		newH7G7Entry.setName(RandomTestUtil.randomString());

		_h7g7Entries.add(_persistence.update(newH7G7Entry));

		H7G7Entry existingH7G7Entry = _persistence.findByPrimaryKey(
			newH7G7Entry.getPrimaryKey());

		Assert.assertEquals(
			existingH7G7Entry.getH7g7EntryId(), newH7G7Entry.getH7g7EntryId());
		Assert.assertEquals(
			existingH7G7Entry.getGroupId(), newH7G7Entry.getGroupId());
		Assert.assertEquals(
			existingH7G7Entry.getCompanyId(), newH7G7Entry.getCompanyId());
		Assert.assertEquals(
			existingH7G7Entry.getUserId(), newH7G7Entry.getUserId());
		Assert.assertEquals(
			existingH7G7Entry.getUserName(), newH7G7Entry.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingH7G7Entry.getCreateDate()),
			Time.getShortTimestamp(newH7G7Entry.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingH7G7Entry.getModifiedDate()),
			Time.getShortTimestamp(newH7G7Entry.getModifiedDate()));
		Assert.assertEquals(
			existingH7G7Entry.getH7g7FolderId(),
			newH7G7Entry.getH7g7FolderId());
		Assert.assertEquals(
			existingH7G7Entry.getDescription(), newH7G7Entry.getDescription());
		Assert.assertEquals(existingH7G7Entry.getKey(), newH7G7Entry.getKey());
		Assert.assertEquals(
			existingH7G7Entry.getName(), newH7G7Entry.getName());
	}

	@Test
	public void testCountByH7G7FolderId() throws Exception {
		_persistence.countByH7G7FolderId(RandomTestUtil.nextLong());

		_persistence.countByH7G7FolderId(0L);
	}

	@Test
	public void testCountByKey() throws Exception {
		_persistence.countByKey("");

		_persistence.countByKey("null");

		_persistence.countByKey((String)null);
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testCountByH_D_N() throws Exception {
		_persistence.countByH_D_N(RandomTestUtil.nextLong(), "", "");

		_persistence.countByH_D_N(0L, "null", "null");

		_persistence.countByH_D_N(0L, (String)null, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		H7G7Entry newH7G7Entry = addH7G7Entry();

		H7G7Entry existingH7G7Entry = _persistence.findByPrimaryKey(
			newH7G7Entry.getPrimaryKey());

		Assert.assertEquals(existingH7G7Entry, newH7G7Entry);
	}

	@Test(expected = NoSuchH7G7EntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<H7G7Entry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"OHQIWTSFHL_H7G7Entry", "h7g7EntryId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "h7g7FolderId", true, "description",
			true, "key", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		H7G7Entry newH7G7Entry = addH7G7Entry();

		H7G7Entry existingH7G7Entry = _persistence.fetchByPrimaryKey(
			newH7G7Entry.getPrimaryKey());

		Assert.assertEquals(existingH7G7Entry, newH7G7Entry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G7Entry missingH7G7Entry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingH7G7Entry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		H7G7Entry newH7G7Entry1 = addH7G7Entry();
		H7G7Entry newH7G7Entry2 = addH7G7Entry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newH7G7Entry1.getPrimaryKey());
		primaryKeys.add(newH7G7Entry2.getPrimaryKey());

		Map<Serializable, H7G7Entry> h7g7Entries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, h7g7Entries.size());
		Assert.assertEquals(
			newH7G7Entry1, h7g7Entries.get(newH7G7Entry1.getPrimaryKey()));
		Assert.assertEquals(
			newH7G7Entry2, h7g7Entries.get(newH7G7Entry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, H7G7Entry> h7g7Entries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(h7g7Entries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		H7G7Entry newH7G7Entry = addH7G7Entry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newH7G7Entry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, H7G7Entry> h7g7Entries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, h7g7Entries.size());
		Assert.assertEquals(
			newH7G7Entry, h7g7Entries.get(newH7G7Entry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, H7G7Entry> h7g7Entries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(h7g7Entries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		H7G7Entry newH7G7Entry = addH7G7Entry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newH7G7Entry.getPrimaryKey());

		Map<Serializable, H7G7Entry> h7g7Entries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, h7g7Entries.size());
		Assert.assertEquals(
			newH7G7Entry, h7g7Entries.get(newH7G7Entry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			H7G7EntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<H7G7Entry>() {

				@Override
				public void performAction(H7G7Entry h7g7Entry) {
					Assert.assertNotNull(h7g7Entry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		H7G7Entry newH7G7Entry = addH7G7Entry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G7Entry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"h7g7EntryId", newH7G7Entry.getH7g7EntryId()));

		List<H7G7Entry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		H7G7Entry existingH7G7Entry = result.get(0);

		Assert.assertEquals(existingH7G7Entry, newH7G7Entry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G7Entry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"h7g7EntryId", RandomTestUtil.nextLong()));

		List<H7G7Entry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		H7G7Entry newH7G7Entry = addH7G7Entry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G7Entry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("h7g7EntryId"));

		Object newH7g7EntryId = newH7G7Entry.getH7g7EntryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"h7g7EntryId", new Object[] {newH7g7EntryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingH7g7EntryId = result.get(0);

		Assert.assertEquals(existingH7g7EntryId, newH7g7EntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G7Entry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("h7g7EntryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"h7g7EntryId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		H7G7Entry newH7G7Entry = addH7G7Entry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newH7G7Entry.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		H7G7Entry newH7G7Entry = addH7G7Entry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G7Entry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"h7g7EntryId", newH7G7Entry.getH7g7EntryId()));

		List<H7G7Entry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(H7G7Entry h7g7Entry) {
		Assert.assertEquals(
			h7g7Entry.getKey(),
			ReflectionTestUtil.invoke(
				h7g7Entry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "key_"));

		Assert.assertEquals(
			Long.valueOf(h7g7Entry.getH7g7FolderId()),
			ReflectionTestUtil.<Long>invoke(
				h7g7Entry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "h7g7FolderId"));
		Assert.assertEquals(
			h7g7Entry.getDescription(),
			ReflectionTestUtil.invoke(
				h7g7Entry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "description"));
		Assert.assertEquals(
			h7g7Entry.getName(),
			ReflectionTestUtil.invoke(
				h7g7Entry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
	}

	protected H7G7Entry addH7G7Entry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G7Entry h7g7Entry = _persistence.create(pk);

		h7g7Entry.setGroupId(RandomTestUtil.nextLong());

		h7g7Entry.setCompanyId(RandomTestUtil.nextLong());

		h7g7Entry.setUserId(RandomTestUtil.nextLong());

		h7g7Entry.setUserName(RandomTestUtil.randomString());

		h7g7Entry.setCreateDate(RandomTestUtil.nextDate());

		h7g7Entry.setModifiedDate(RandomTestUtil.nextDate());

		h7g7Entry.setH7g7FolderId(RandomTestUtil.nextLong());

		h7g7Entry.setDescription(RandomTestUtil.randomString());

		h7g7Entry.setKey(RandomTestUtil.randomString());

		h7g7Entry.setName(RandomTestUtil.randomString());

		_h7g7Entries.add(_persistence.update(h7g7Entry));

		return h7g7Entry;
	}

	private List<H7G7Entry> _h7g7Entries = new ArrayList<H7G7Entry>();
	private H7G7EntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}