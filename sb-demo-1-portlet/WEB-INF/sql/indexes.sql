create index IX_39518BDB on SBDemo_Course (courseCatalogId);
create index IX_80D9481A on SBDemo_Course (instructorId);
create index IX_2557E47F on SBDemo_Course (year);
create index IX_B4B84FEB on SBDemo_Course (year, semester);

create index IX_EF84D8A3 on SBDemo_CourseStudent (courseId);
create index IX_9397116D on SBDemo_CourseStudent (studentId);

create index IX_1D18CBB5 on SBDemo_Student (major);
create index IX_32E91BE on SBDemo_Student (yearInSchool);