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

import com.liferay.h7g5.service.base.H7G5EntryServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.model.User;
import java.util.Objects; 
import com.liferay.h7g5.model.H7G5Entry;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ohqiwtsfhl",
		"json.web.service.context.path=H7G5Entry"
	},
	service = AopService.class
)
public class H7G5EntryServiceImpl extends H7G5EntryServiceBaseImpl {
	public H7G5Entry addMyCustomH7G5EntryServiceWithPermissionCheck(
		String description, String name)
		throws PortalException {
        
			checkEmailAdress();
		
			System.out.println(
			 "Invoking H7G5EntryServiceImpl#addMyCustomH7G5Entry(" + description + ", " + name + ")");
		
			H7G5Entry h7g5Entry = h7g5EntryLocalService.createH7G5Entry(
			 System.currentTimeMillis());
		
			h7g5Entry.setDescription(description);
			h7g5Entry.setName(name);
		
			h7g5EntryLocalService.addH7G5Entry(h7g5Entry);
		
		
			return h7g5Entry;
		}


	public void checkEmailAdress() throws PortalException {

		User user = getUser();
		

		if (!Objects.equals(user.getEmailAddress(), "test@liferay.com")) {
			throw new PrincipalException("You are not test@liferay.com");
		}
	}
}