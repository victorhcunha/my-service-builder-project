create table OHQIWTSFHL_H7G7Entry (
	h7g7EntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	h7g7FolderId LONG,
	description VARCHAR(75) null,
	key_ VARCHAR(75) null,
	name VARCHAR(75) null
);

create table OHQIWTSFHL_H7G7Folder (
	h7g7FolderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	name VARCHAR(75) null
);