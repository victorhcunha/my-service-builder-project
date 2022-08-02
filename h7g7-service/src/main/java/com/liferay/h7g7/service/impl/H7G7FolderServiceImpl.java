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

package com.liferay.h7g7.service.impl;

import com.liferay.h7g7.model.H7G7Folder;

import com.liferay.h7g7.service.base.H7G7FolderServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = {
		"json.web.service.context.name=ohqiwtsfhl",
		"json.web.service.context.path=H7G7Folder"
}, service = AopService.class)
public class H7G7FolderServiceImpl extends H7G7FolderServiceBaseImpl {

	public H7G7Folder addMyCustomH77Folder(String description, String name) {
		System.out.println(
				"Invoking H7G7FolderServiceImpl#addMyCustomH7G7Folder(" +
						description + ", " + name + ")");

		H7G7Folder h7g7Folder = h7g7FolderLocalService.createH7G7Folder(
				System.currentTimeMillis());

		h7g7Folder.setDescription(description);
		h7g7Folder.setName(name);

		h7g7FolderLocalService.addH7G7Folder(h7g7Folder);

		return h7g7Folder;
	}

	public H7G5Folder addMyCustomH7G5FolderWithPermissionCheck(
			String description, String name)
			throws PortalException {

		User user = getUser();

		if (!Objects.equals(user.getEmailAddress(), "test@liferay.com")) {
			throw new PrincipalException("You are not test@liferay.com");
		}

		return addMyCustomH7G5Folder(description, name);
	}
}