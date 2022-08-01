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
 * Provides a wrapper for {@link H7G7FolderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see H7G7FolderLocalService
 * @generated
 */
public class H7G7FolderLocalServiceWrapper
	implements H7G7FolderLocalService, ServiceWrapper<H7G7FolderLocalService> {

	public H7G7FolderLocalServiceWrapper() {
		this(null);
	}

	public H7G7FolderLocalServiceWrapper(
		H7G7FolderLocalService h7g7FolderLocalService) {

		_h7g7FolderLocalService = h7g7FolderLocalService;
	}

	/**
	 * Adds the h7g7 folder to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G7FolderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g7Folder the h7g7 folder
	 * @return the h7g7 folder that was added
	 */
	@Override
	public com.liferay.h7g7.model.H7G7Folder addH7G7Folder(
		com.liferay.h7g7.model.H7G7Folder h7g7Folder) {

		return _h7g7FolderLocalService.addH7G7Folder(h7g7Folder);
	}

	/**
	 * Creates a new h7g7 folder with the primary key. Does not add the h7g7 folder to the database.
	 *
	 * @param h7g7FolderId the primary key for the new h7g7 folder
	 * @return the new h7g7 folder
	 */
	@Override
	public com.liferay.h7g7.model.H7G7Folder createH7G7Folder(
		long h7g7FolderId) {

		return _h7g7FolderLocalService.createH7G7Folder(h7g7FolderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g7FolderLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the h7g7 folder from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G7FolderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g7Folder the h7g7 folder
	 * @return the h7g7 folder that was removed
	 */
	@Override
	public com.liferay.h7g7.model.H7G7Folder deleteH7G7Folder(
		com.liferay.h7g7.model.H7G7Folder h7g7Folder) {

		return _h7g7FolderLocalService.deleteH7G7Folder(h7g7Folder);
	}

	/**
	 * Deletes the h7g7 folder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G7FolderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g7FolderId the primary key of the h7g7 folder
	 * @return the h7g7 folder that was removed
	 * @throws PortalException if a h7g7 folder with the primary key could not be found
	 */
	@Override
	public com.liferay.h7g7.model.H7G7Folder deleteH7G7Folder(long h7g7FolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g7FolderLocalService.deleteH7G7Folder(h7g7FolderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g7FolderLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _h7g7FolderLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _h7g7FolderLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _h7g7FolderLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _h7g7FolderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.h7g7.model.impl.H7G7FolderModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _h7g7FolderLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.h7g7.model.impl.H7G7FolderModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _h7g7FolderLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _h7g7FolderLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _h7g7FolderLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.h7g7.model.H7G7Folder fetchH7G7Folder(
		long h7g7FolderId) {

		return _h7g7FolderLocalService.fetchH7G7Folder(h7g7FolderId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _h7g7FolderLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the h7g7 folder with the primary key.
	 *
	 * @param h7g7FolderId the primary key of the h7g7 folder
	 * @return the h7g7 folder
	 * @throws PortalException if a h7g7 folder with the primary key could not be found
	 */
	@Override
	public com.liferay.h7g7.model.H7G7Folder getH7G7Folder(long h7g7FolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g7FolderLocalService.getH7G7Folder(h7g7FolderId);
	}

	/**
	 * Returns a range of all the h7g7 folders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.h7g7.model.impl.H7G7FolderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g7 folders
	 * @param end the upper bound of the range of h7g7 folders (not inclusive)
	 * @return the range of h7g7 folders
	 */
	@Override
	public java.util.List<com.liferay.h7g7.model.H7G7Folder> getH7G7Folders(
		int start, int end) {

		return _h7g7FolderLocalService.getH7G7Folders(start, end);
	}

	/**
	 * Returns the number of h7g7 folders.
	 *
	 * @return the number of h7g7 folders
	 */
	@Override
	public int getH7G7FoldersCount() {
		return _h7g7FolderLocalService.getH7G7FoldersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _h7g7FolderLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _h7g7FolderLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g7FolderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the h7g7 folder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G7FolderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g7Folder the h7g7 folder
	 * @return the h7g7 folder that was updated
	 */
	@Override
	public com.liferay.h7g7.model.H7G7Folder updateH7G7Folder(
		com.liferay.h7g7.model.H7G7Folder h7g7Folder) {

		return _h7g7FolderLocalService.updateH7G7Folder(h7g7Folder);
	}

	@Override
	public H7G7FolderLocalService getWrappedService() {
		return _h7g7FolderLocalService;
	}

	@Override
	public void setWrappedService(
		H7G7FolderLocalService h7g7FolderLocalService) {

		_h7g7FolderLocalService = h7g7FolderLocalService;
	}

	private H7G7FolderLocalService _h7g7FolderLocalService;

}