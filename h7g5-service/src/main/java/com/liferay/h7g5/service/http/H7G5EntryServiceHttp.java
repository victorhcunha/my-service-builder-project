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

package com.liferay.h7g5.service.http;

import com.liferay.h7g5.service.H7G5EntryServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>H7G5EntryServiceUtil</code> service
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
public class H7G5EntryServiceHttp {

	public static com.liferay.h7g5.model.H7G5Entry addMyCustomH7G5Entry(
		HttpPrincipal httpPrincipal, String description, String name) {

		try {
			MethodKey methodKey = new MethodKey(
				H7G5EntryServiceUtil.class, "addMyCustomH7G5Entry",
				_addMyCustomH7G5EntryParameterTypes0);

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

			return (com.liferay.h7g5.model.H7G5Entry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.h7g5.model.H7G5Entry
			addMyCustomH7G5EntryWithPermissionCheck(
				HttpPrincipal httpPrincipal, String description, String name)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				H7G5EntryServiceUtil.class,
				"addMyCustomH7G5EntryWithPermissionCheck",
				_addMyCustomH7G5EntryWithPermissionCheckParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, description, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.h7g5.model.H7G5Entry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(H7G5EntryServiceHttp.class);

	private static final Class<?>[] _addMyCustomH7G5EntryParameterTypes0 =
		new Class[] {String.class, String.class};
	private static final Class<?>[]
		_addMyCustomH7G5EntryWithPermissionCheckParameterTypes1 = new Class[] {
			String.class, String.class
		};

}