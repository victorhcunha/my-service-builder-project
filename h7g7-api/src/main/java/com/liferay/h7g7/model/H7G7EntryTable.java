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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;OHQIWTSFHL_H7G7Entry&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see H7G7Entry
 * @generated
 */
public class H7G7EntryTable extends BaseTable<H7G7EntryTable> {

	public static final H7G7EntryTable INSTANCE = new H7G7EntryTable();

	public final Column<H7G7EntryTable, Long> h7g7EntryId = createColumn(
		"h7g7EntryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<H7G7EntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<H7G7EntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<H7G7EntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<H7G7EntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<H7G7EntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<H7G7EntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<H7G7EntryTable, Long> h7g7FolderId = createColumn(
		"h7g7FolderId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<H7G7EntryTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<H7G7EntryTable, String> key = createColumn(
		"key_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<H7G7EntryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private H7G7EntryTable() {
		super("OHQIWTSFHL_H7G7Entry", H7G7EntryTable::new);
	}

}