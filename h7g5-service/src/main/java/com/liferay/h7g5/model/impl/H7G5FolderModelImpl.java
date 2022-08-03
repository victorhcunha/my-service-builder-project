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

package com.liferay.h7g5.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.h7g5.model.H7G5Folder;
import com.liferay.h7g5.model.H7G5FolderModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the H7G5Folder service. Represents a row in the &quot;OHQIWTSFHL_H7G5Folder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>H7G5FolderModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link H7G5FolderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see H7G5FolderImpl
 * @generated
 */
@JSON(strict = true)
public class H7G5FolderModelImpl
	extends BaseModelImpl<H7G5Folder> implements H7G5FolderModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a h7g5 folder model instance should use the <code>H7G5Folder</code> interface instead.
	 */
	public static final String TABLE_NAME = "OHQIWTSFHL_H7G5Folder";

	public static final Object[][] TABLE_COLUMNS = {
		{"h7g5FolderId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"description", Types.VARCHAR},
		{"name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("h7g5FolderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table OHQIWTSFHL_H7G5Folder (h7g5FolderId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,description VARCHAR(75) null,name VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table OHQIWTSFHL_H7G5Folder";

	public static final String ORDER_BY_JPQL =
		" ORDER BY h7g5Folder.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY OHQIWTSFHL_H7G5Folder.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public H7G5FolderModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _h7g5FolderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setH7g5FolderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _h7g5FolderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return H7G5Folder.class;
	}

	@Override
	public String getModelClassName() {
		return H7G5Folder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<H7G5Folder, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<H7G5Folder, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<H7G5Folder, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((H7G5Folder)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<H7G5Folder, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<H7G5Folder, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(H7G5Folder)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<H7G5Folder, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<H7G5Folder, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<H7G5Folder, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<H7G5Folder, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<H7G5Folder, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<H7G5Folder, Object>>();
		Map<String, BiConsumer<H7G5Folder, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<H7G5Folder, ?>>();

		attributeGetterFunctions.put(
			"h7g5FolderId", H7G5Folder::getH7g5FolderId);
		attributeSetterBiConsumers.put(
			"h7g5FolderId",
			(BiConsumer<H7G5Folder, Long>)H7G5Folder::setH7g5FolderId);
		attributeGetterFunctions.put("groupId", H7G5Folder::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<H7G5Folder, Long>)H7G5Folder::setGroupId);
		attributeGetterFunctions.put("companyId", H7G5Folder::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<H7G5Folder, Long>)H7G5Folder::setCompanyId);
		attributeGetterFunctions.put("userId", H7G5Folder::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<H7G5Folder, Long>)H7G5Folder::setUserId);
		attributeGetterFunctions.put("userName", H7G5Folder::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<H7G5Folder, String>)H7G5Folder::setUserName);
		attributeGetterFunctions.put("createDate", H7G5Folder::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<H7G5Folder, Date>)H7G5Folder::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", H7G5Folder::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<H7G5Folder, Date>)H7G5Folder::setModifiedDate);
		attributeGetterFunctions.put("description", H7G5Folder::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<H7G5Folder, String>)H7G5Folder::setDescription);
		attributeGetterFunctions.put("name", H7G5Folder::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<H7G5Folder, String>)H7G5Folder::setName);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getH7g5FolderId() {
		return _h7g5FolderId;
	}

	@Override
	public void setH7g5FolderId(long h7g5FolderId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_h7g5FolderId = h7g5FolderId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), H7G5Folder.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public H7G5Folder toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, H7G5Folder>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		H7G5FolderImpl h7g5FolderImpl = new H7G5FolderImpl();

		h7g5FolderImpl.setH7g5FolderId(getH7g5FolderId());
		h7g5FolderImpl.setGroupId(getGroupId());
		h7g5FolderImpl.setCompanyId(getCompanyId());
		h7g5FolderImpl.setUserId(getUserId());
		h7g5FolderImpl.setUserName(getUserName());
		h7g5FolderImpl.setCreateDate(getCreateDate());
		h7g5FolderImpl.setModifiedDate(getModifiedDate());
		h7g5FolderImpl.setDescription(getDescription());
		h7g5FolderImpl.setName(getName());

		h7g5FolderImpl.resetOriginalValues();

		return h7g5FolderImpl;
	}

	@Override
	public H7G5Folder cloneWithOriginalValues() {
		H7G5FolderImpl h7g5FolderImpl = new H7G5FolderImpl();

		h7g5FolderImpl.setH7g5FolderId(
			this.<Long>getColumnOriginalValue("h7g5FolderId"));
		h7g5FolderImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		h7g5FolderImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		h7g5FolderImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		h7g5FolderImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		h7g5FolderImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		h7g5FolderImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		h7g5FolderImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		h7g5FolderImpl.setName(this.<String>getColumnOriginalValue("name"));

		return h7g5FolderImpl;
	}

	@Override
	public int compareTo(H7G5Folder h7g5Folder) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), h7g5Folder.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof H7G5Folder)) {
			return false;
		}

		H7G5Folder h7g5Folder = (H7G5Folder)object;

		long primaryKey = h7g5Folder.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<H7G5Folder> toCacheModel() {
		H7G5FolderCacheModel h7g5FolderCacheModel = new H7G5FolderCacheModel();

		h7g5FolderCacheModel.h7g5FolderId = getH7g5FolderId();

		h7g5FolderCacheModel.groupId = getGroupId();

		h7g5FolderCacheModel.companyId = getCompanyId();

		h7g5FolderCacheModel.userId = getUserId();

		h7g5FolderCacheModel.userName = getUserName();

		String userName = h7g5FolderCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			h7g5FolderCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			h7g5FolderCacheModel.createDate = createDate.getTime();
		}
		else {
			h7g5FolderCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			h7g5FolderCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			h7g5FolderCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		h7g5FolderCacheModel.description = getDescription();

		String description = h7g5FolderCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			h7g5FolderCacheModel.description = null;
		}

		h7g5FolderCacheModel.name = getName();

		String name = h7g5FolderCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			h7g5FolderCacheModel.name = null;
		}

		return h7g5FolderCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<H7G5Folder, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<H7G5Folder, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<H7G5Folder, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((H7G5Folder)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<H7G5Folder, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<H7G5Folder, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<H7G5Folder, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((H7G5Folder)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, H7G5Folder>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					H7G5Folder.class, ModelWrapper.class);

	}

	private long _h7g5FolderId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _description;
	private String _name;

	public <T> T getColumnValue(String columnName) {
		Function<H7G5Folder, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((H7G5Folder)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("h7g5FolderId", _h7g5FolderId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("name", _name);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("h7g5FolderId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("description", 128L);

		columnBitmasks.put("name", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private H7G5Folder _escapedModel;

}