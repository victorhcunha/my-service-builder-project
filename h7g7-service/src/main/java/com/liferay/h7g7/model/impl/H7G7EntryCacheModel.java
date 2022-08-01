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

package com.liferay.h7g7.model.impl;

import com.liferay.h7g7.model.H7G7Entry;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing H7G7Entry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class H7G7EntryCacheModel
	implements CacheModel<H7G7Entry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof H7G7EntryCacheModel)) {
			return false;
		}

		H7G7EntryCacheModel h7g7EntryCacheModel = (H7G7EntryCacheModel)object;

		if (h7g7EntryId == h7g7EntryCacheModel.h7g7EntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, h7g7EntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{h7g7EntryId=");
		sb.append(h7g7EntryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", h7g7FolderId=");
		sb.append(h7g7FolderId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", key=");
		sb.append(key);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public H7G7Entry toEntityModel() {
		H7G7EntryImpl h7g7EntryImpl = new H7G7EntryImpl();

		h7g7EntryImpl.setH7g7EntryId(h7g7EntryId);
		h7g7EntryImpl.setGroupId(groupId);
		h7g7EntryImpl.setCompanyId(companyId);
		h7g7EntryImpl.setUserId(userId);

		if (userName == null) {
			h7g7EntryImpl.setUserName("");
		}
		else {
			h7g7EntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			h7g7EntryImpl.setCreateDate(null);
		}
		else {
			h7g7EntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			h7g7EntryImpl.setModifiedDate(null);
		}
		else {
			h7g7EntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		h7g7EntryImpl.setH7g7FolderId(h7g7FolderId);

		if (description == null) {
			h7g7EntryImpl.setDescription("");
		}
		else {
			h7g7EntryImpl.setDescription(description);
		}

		if (key == null) {
			h7g7EntryImpl.setKey("");
		}
		else {
			h7g7EntryImpl.setKey(key);
		}

		if (name == null) {
			h7g7EntryImpl.setName("");
		}
		else {
			h7g7EntryImpl.setName(name);
		}

		h7g7EntryImpl.resetOriginalValues();

		return h7g7EntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		h7g7EntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		h7g7FolderId = objectInput.readLong();
		description = objectInput.readUTF();
		key = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(h7g7EntryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(h7g7FolderId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long h7g7EntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long h7g7FolderId;
	public String description;
	public String key;
	public String name;

}