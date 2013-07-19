/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.live.sb.demo.service.persistence;

import com.liferay.live.sb.demo.model.Course;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see CoursePersistenceImpl
 * @see CourseUtil
 * @generated
 */
public interface CoursePersistence extends BasePersistence<Course> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course
	*/
	public void cacheResult(com.liferay.live.sb.demo.model.Course course);

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public void cacheResult(
		java.util.List<com.liferay.live.sb.demo.model.Course> courses);

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public com.liferay.live.sb.demo.model.Course create(long courseId);

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course remove(long courseId)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.live.sb.demo.model.Course updateImpl(
		com.liferay.live.sb.demo.model.Course course, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchCourseException} if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course findByPrimaryKey(long courseId)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course fetchByPrimaryKey(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the courses where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByInstructorId(
		long instructorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the courses where instructorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param instructorId the instructor ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByInstructorId(
		long instructorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courses where instructorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param instructorId the instructor ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByInstructorId(
		long instructorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course in the ordered set where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course findByInstructorId_First(
		long instructorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course in the ordered set where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course fetchByInstructorId_First(
		long instructorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course in the ordered set where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course findByInstructorId_Last(
		long instructorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course in the ordered set where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course fetchByInstructorId_Last(
		long instructorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the courses before and after the current course in the ordered set where instructorId = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param instructorId the instructor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course[] findByInstructorId_PrevAndNext(
		long courseId, long instructorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the courses where year = &#63;.
	*
	* @param year the year
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByYear(
		int year) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the courses where year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param year the year
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByYear(
		int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courses where year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param year the year
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course findByYear_First(int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course fetchByYear_First(int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course findByYear_Last(int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course fetchByYear_Last(int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the courses before and after the current course in the ordered set where year = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course[] findByYear_PrevAndNext(
		long courseId, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the courses where year = &#63; and semester = &#63;.
	*
	* @param year the year
	* @param semester the semester
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByYearSemester(
		int year, int semester)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the courses where year = &#63; and semester = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param year the year
	* @param semester the semester
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByYearSemester(
		int year, int semester, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courses where year = &#63; and semester = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param year the year
	* @param semester the semester
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByYearSemester(
		int year, int semester, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course in the ordered set where year = &#63; and semester = &#63;.
	*
	* @param year the year
	* @param semester the semester
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course findByYearSemester_First(
		int year, int semester,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course in the ordered set where year = &#63; and semester = &#63;.
	*
	* @param year the year
	* @param semester the semester
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course fetchByYearSemester_First(
		int year, int semester,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course in the ordered set where year = &#63; and semester = &#63;.
	*
	* @param year the year
	* @param semester the semester
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course findByYearSemester_Last(
		int year, int semester,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course in the ordered set where year = &#63; and semester = &#63;.
	*
	* @param year the year
	* @param semester the semester
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course fetchByYearSemester_Last(
		int year, int semester,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the courses before and after the current course in the ordered set where year = &#63; and semester = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param year the year
	* @param semester the semester
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course[] findByYearSemester_PrevAndNext(
		long courseId, int year, int semester,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the courses where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByCourseCatalogId(
		long courseCatalogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the courses where courseCatalogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param courseCatalogId the course catalog ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByCourseCatalogId(
		long courseCatalogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courses where courseCatalogId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param courseCatalogId the course catalog ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findByCourseCatalogId(
		long courseCatalogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course in the ordered set where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course findByCourseCatalogId_First(
		long courseCatalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course in the ordered set where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course fetchByCourseCatalogId_First(
		long courseCatalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course in the ordered set where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course findByCourseCatalogId_Last(
		long courseCatalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course in the ordered set where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course fetchByCourseCatalogId_Last(
		long courseCatalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the courses before and after the current course in the ordered set where courseCatalogId = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param courseCatalogId the course catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Course[] findByCourseCatalogId_PrevAndNext(
		long courseId, long courseCatalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the courses.
	*
	* @return the courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Course> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the courses where instructorId = &#63; from the database.
	*
	* @param instructorId the instructor ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByInstructorId(long instructorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the courses where year = &#63; from the database.
	*
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByYear(int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the courses where year = &#63; and semester = &#63; from the database.
	*
	* @param year the year
	* @param semester the semester
	* @throws SystemException if a system exception occurred
	*/
	public void removeByYearSemester(int year, int semester)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the courses where courseCatalogId = &#63; from the database.
	*
	* @param courseCatalogId the course catalog ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseCatalogId(long courseCatalogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the courses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courses where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public int countByInstructorId(long instructorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courses where year = &#63;.
	*
	* @param year the year
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public int countByYear(int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courses where year = &#63; and semester = &#63;.
	*
	* @param year the year
	* @param semester the semester
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public int countByYearSemester(int year, int semester)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courses where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseCatalogId(long courseCatalogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}