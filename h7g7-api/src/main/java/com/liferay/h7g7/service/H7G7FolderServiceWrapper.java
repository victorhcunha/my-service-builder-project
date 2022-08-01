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

package com.liferay.h7g7.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link H7G7FolderService}.
 *
 * @author Brian Wing Shun Chan
 * @see H7G7FolderService
 * @generated
 */
public class H7G7FolderServiceWrapper
	implements H7G7FolderService, ServiceWrapper<H7G7FolderService> {

	public H7G7FolderServiceWrapper() {
		this(null);
	}

	public H7G7FolderServiceWrapper(H7G7FolderService h7g7FolderService) {
		_h7g7FolderService = h7g7FolderService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _h7g7FolderService.getOSGiServiceIdentifier();
	}

	@Override
	public H7G7FolderService getWrappedService() {
		return _h7g7FolderService;
	}

	@Override
	public void setWrappedService(H7G7FolderService h7g7FolderService) {
		_h7g7FolderService = h7g7FolderService;
	}

	private H7G7FolderService _h7g7FolderService;

}