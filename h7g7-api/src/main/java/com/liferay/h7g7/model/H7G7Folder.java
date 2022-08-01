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

package com.liferay.h7g7.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the H7G7Folder service. Represents a row in the &quot;OHQIWTSFHL_H7G7Folder&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see H7G7FolderModel
 * @generated
 */
@ImplementationClassName("com.liferay.h7g7.model.impl.H7G7FolderImpl")
@ProviderType
public interface H7G7Folder extends H7G7FolderModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.h7g7.model.impl.H7G7FolderImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<H7G7Folder, Long> H7G7_FOLDER_ID_ACCESSOR =
		new Accessor<H7G7Folder, Long>() {

			@Override
			public Long get(H7G7Folder h7g7Folder) {
				return h7g7Folder.getH7g7FolderId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<H7G7Folder> getTypeClass() {
				return H7G7Folder.class;
			}

		};

}