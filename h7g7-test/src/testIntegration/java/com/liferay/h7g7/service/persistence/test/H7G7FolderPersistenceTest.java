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
import com.liferay.h7g7.exception.NoSuchH7G7FolderException;
import com.liferay.h7g7.model.H7G7Folder;
import com.liferay.h7g7.service.H7G7FolderLocalServiceUtil;
import com.liferay.h7g7.service.persistence.H7G7FolderPersistence;
import com.liferay.h7g7.service.persistence.H7G7FolderUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
public class H7G7FolderPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.h7g7.service"));

	@Before
	public void setUp() {
		_persistence = H7G7FolderUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<H7G7Folder> iterator = _h7g7Folders.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G7Folder h7g7Folder = _persistence.create(pk);

		Assert.assertNotNull(h7g7Folder);

		Assert.assertEquals(h7g7Folder.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		H7G7Folder newH7G7Folder = addH7G7Folder();

		_persistence.remove(newH7G7Folder);

		H7G7Folder existingH7G7Folder = _persistence.fetchByPrimaryKey(
			newH7G7Folder.getPrimaryKey());

		Assert.assertNull(existingH7G7Folder);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addH7G7Folder();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G7Folder newH7G7Folder = _persistence.create(pk);

		newH7G7Folder.setGroupId(RandomTestUtil.nextLong());

		newH7G7Folder.setCompanyId(RandomTestUtil.nextLong());

		newH7G7Folder.setUserId(RandomTestUtil.nextLong());

		newH7G7Folder.setUserName(RandomTestUtil.randomString());

		newH7G7Folder.setCreateDate(RandomTestUtil.nextDate());

		newH7G7Folder.setModifiedDate(RandomTestUtil.nextDate());

		newH7G7Folder.setDescription(RandomTestUtil.randomString());

		newH7G7Folder.setName(RandomTestUtil.randomString());

		_h7g7Folders.add(_persistence.update(newH7G7Folder));

		H7G7Folder existingH7G7Folder = _persistence.findByPrimaryKey(
			newH7G7Folder.getPrimaryKey());

		Assert.assertEquals(
			existingH7G7Folder.getH7g7FolderId(),
			newH7G7Folder.getH7g7FolderId());
		Assert.assertEquals(
			existingH7G7Folder.getGroupId(), newH7G7Folder.getGroupId());
		Assert.assertEquals(
			existingH7G7Folder.getCompanyId(), newH7G7Folder.getCompanyId());
		Assert.assertEquals(
			existingH7G7Folder.getUserId(), newH7G7Folder.getUserId());
		Assert.assertEquals(
			existingH7G7Folder.getUserName(), newH7G7Folder.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingH7G7Folder.getCreateDate()),
			Time.getShortTimestamp(newH7G7Folder.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingH7G7Folder.getModifiedDate()),
			Time.getShortTimestamp(newH7G7Folder.getModifiedDate()));
		Assert.assertEquals(
			existingH7G7Folder.getDescription(),
			newH7G7Folder.getDescription());
		Assert.assertEquals(
			existingH7G7Folder.getName(), newH7G7Folder.getName());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		H7G7Folder newH7G7Folder = addH7G7Folder();

		H7G7Folder existingH7G7Folder = _persistence.findByPrimaryKey(
			newH7G7Folder.getPrimaryKey());

		Assert.assertEquals(existingH7G7Folder, newH7G7Folder);
	}

	@Test(expected = NoSuchH7G7FolderException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<H7G7Folder> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"OHQIWTSFHL_H7G7Folder", "h7g7FolderId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "description", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		H7G7Folder newH7G7Folder = addH7G7Folder();

		H7G7Folder existingH7G7Folder = _persistence.fetchByPrimaryKey(
			newH7G7Folder.getPrimaryKey());

		Assert.assertEquals(existingH7G7Folder, newH7G7Folder);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G7Folder missingH7G7Folder = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingH7G7Folder);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		H7G7Folder newH7G7Folder1 = addH7G7Folder();
		H7G7Folder newH7G7Folder2 = addH7G7Folder();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newH7G7Folder1.getPrimaryKey());
		primaryKeys.add(newH7G7Folder2.getPrimaryKey());

		Map<Serializable, H7G7Folder> h7g7Folders =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, h7g7Folders.size());
		Assert.assertEquals(
			newH7G7Folder1, h7g7Folders.get(newH7G7Folder1.getPrimaryKey()));
		Assert.assertEquals(
			newH7G7Folder2, h7g7Folders.get(newH7G7Folder2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, H7G7Folder> h7g7Folders =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(h7g7Folders.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		H7G7Folder newH7G7Folder = addH7G7Folder();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newH7G7Folder.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, H7G7Folder> h7g7Folders =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, h7g7Folders.size());
		Assert.assertEquals(
			newH7G7Folder, h7g7Folders.get(newH7G7Folder.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, H7G7Folder> h7g7Folders =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(h7g7Folders.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		H7G7Folder newH7G7Folder = addH7G7Folder();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newH7G7Folder.getPrimaryKey());

		Map<Serializable, H7G7Folder> h7g7Folders =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, h7g7Folders.size());
		Assert.assertEquals(
			newH7G7Folder, h7g7Folders.get(newH7G7Folder.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			H7G7FolderLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<H7G7Folder>() {

				@Override
				public void performAction(H7G7Folder h7g7Folder) {
					Assert.assertNotNull(h7g7Folder);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		H7G7Folder newH7G7Folder = addH7G7Folder();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G7Folder.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"h7g7FolderId", newH7G7Folder.getH7g7FolderId()));

		List<H7G7Folder> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		H7G7Folder existingH7G7Folder = result.get(0);

		Assert.assertEquals(existingH7G7Folder, newH7G7Folder);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G7Folder.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"h7g7FolderId", RandomTestUtil.nextLong()));

		List<H7G7Folder> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		H7G7Folder newH7G7Folder = addH7G7Folder();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G7Folder.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("h7g7FolderId"));

		Object newH7g7FolderId = newH7G7Folder.getH7g7FolderId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"h7g7FolderId", new Object[] {newH7g7FolderId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingH7g7FolderId = result.get(0);

		Assert.assertEquals(existingH7g7FolderId, newH7g7FolderId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			H7G7Folder.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("h7g7FolderId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"h7g7FolderId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected H7G7Folder addH7G7Folder() throws Exception {
		long pk = RandomTestUtil.nextLong();

		H7G7Folder h7g7Folder = _persistence.create(pk);

		h7g7Folder.setGroupId(RandomTestUtil.nextLong());

		h7g7Folder.setCompanyId(RandomTestUtil.nextLong());

		h7g7Folder.setUserId(RandomTestUtil.nextLong());

		h7g7Folder.setUserName(RandomTestUtil.randomString());

		h7g7Folder.setCreateDate(RandomTestUtil.nextDate());

		h7g7Folder.setModifiedDate(RandomTestUtil.nextDate());

		h7g7Folder.setDescription(RandomTestUtil.randomString());

		h7g7Folder.setName(RandomTestUtil.randomString());

		_h7g7Folders.add(_persistence.update(h7g7Folder));

		return h7g7Folder;
	}

	private List<H7G7Folder> _h7g7Folders = new ArrayList<H7G7Folder>();
	private H7G7FolderPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}