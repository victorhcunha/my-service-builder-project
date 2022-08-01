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
 * Provides a wrapper for {@link H7G7EntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see H7G7EntryService
 * @generated
 */
public class H7G7EntryServiceWrapper
	implements H7G7EntryService, ServiceWrapper<H7G7EntryService> {

	public H7G7EntryServiceWrapper() {
		this(null);
	}

	public H7G7EntryServiceWrapper(H7G7EntryService h7g7EntryService) {
		_h7g7EntryService = h7g7EntryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _h7g7EntryService.getOSGiServiceIdentifier();
	}

	@Override
	public H7G7EntryService getWrappedService() {
		return _h7g7EntryService;
	}

	@Override
	public void setWrappedService(H7G7EntryService h7g7EntryService) {
		_h7g7EntryService = h7g7EntryService;
	}

	private H7G7EntryService _h7g7EntryService;

}