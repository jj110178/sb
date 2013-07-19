create table SBDemo_Course (
	courseId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	instructorId LONG,
	courseCatalogId LONG,
	creditHours INTEGER,
	semester INTEGER,
	year INTEGER,
	name VARCHAR(75) null,
	major VARCHAR(75) null
);

create table SBDemo_CourseStudent (
	studentId LONG not null,
	courseId LONG not null,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	grade DOUBLE,
	primary key (studentId, courseId)
);

create table SBDemo_Instructor (
	instructorId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	started DATE null
);

create table SBDemo_Student (
	studentId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	enrolled BOOLEAN,
	enrollmentDate DATE null,
	yearInSchool INTEGER,
	major VARCHAR(75) null
);