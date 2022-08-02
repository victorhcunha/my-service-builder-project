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

package com.liferay.h7g7.service.http;

import com.liferay.h7g7.service.H7G7FolderServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>H7G7FolderServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class H7G7FolderServiceHttp {

	public static com.liferay.h7g7.model.H7G7Folder addMyCustomH77Folder(
		HttpPrincipal httpPrincipal, String description, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				H7G7FolderServiceUtil.class, "addMyCustomH77Folder",
				_addMyCustomH77FolderParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, description, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.h7g7.model.H7G7Folder)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static H7G5Folder addMyCustomH7G5FolderWithPermissionCheck(
			HttpPrincipal httpPrincipal, String description, String name)
		throws PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				H7G7FolderServiceUtil.class,
				"addMyCustomH7G5FolderWithPermissionCheck",
				_addMyCustomH7G5FolderWithPermissionCheckParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, description, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof PortalException) {
					throw (PortalException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (H7G5Folder)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		H7G7FolderServiceHttp.class);

	private static final Class<?>[] _addMyCustomH77FolderParameterTypes0 =
		new Class[] {String.class, String.class};
	private static final Class<?>[]
		_addMyCustomH7G5FolderWithPermissionCheckParameterTypes1 = new Class[] {
			String.class, String.class
		};

}