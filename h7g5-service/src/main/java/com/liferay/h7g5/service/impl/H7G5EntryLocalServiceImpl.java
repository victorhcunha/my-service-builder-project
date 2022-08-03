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

package com.liferay.h7g5.service.impl;

import com.liferay.h7g5.service.base.H7G5EntryLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.h7g5.model.H7G5Entry;
import com.liferay.h7g5.exception.NoSuchH7G5EntryException;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.h7g5.model.H7G5Entry", service = AopService.class)
public class H7G5EntryLocalServiceImpl extends H7G5EntryLocalServiceBaseImpl {
	public List<H7G5Entry> findByH7G5FolderId(long h7g5FolderId) {
		return h7g5EntryPersistence.findByH7G5FolderId(h7g5FolderId);
	}

	public H7G5Entry findByKey(String key) throws NoSuchH7G5EntryException {
		return h7g5EntryPersistence.findByKey(key);

	}

	public List<H7G5Entry> findByName(String name) {
		return h7g5EntryPersistence.findByName(name);

	}

	public H7G5Entry findByH_D_N(long h7g5FolderId, String description, String h_d_n) throws NoSuchH7G5EntryException {
		return h7g5EntryPersistence.findByH_D_N(h7g5FolderId, description, h_d_n);

	}

}

/*
 * 
 * <!--
 * Finder methods-->
 * 
 * <
 * finder name = "H7G5FolderId"return-type="Collection"><finder-column
 * name="h7g					5FolderId" />
 * </finder><
 * finder name = "Key"return-type="H7G5Entry"><finder-column name="key" />
 * </><
 * finder name = "Name"return-type="Collection"><finder-column name="name" />
 * </finder><
 * finder name = "H_D_N"return-type="H7G5Entry"><finder-column
 * name="h7g5FolderId" />
 * <finder-column name="description" />
 * <finder-column name="name" />
 * </finder>
 */