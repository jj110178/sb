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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the course service. This utility wraps {@link CoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see CoursePersistence
 * @see CoursePersistenceImpl
 * @generated
 */
public class CourseUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Course course) {
		getPersistence().clearCache(course);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Course update(Course course, boolean merge)
		throws SystemException {
		return getPersistence().update(course, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Course update(Course course, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(course, merge, serviceContext);
	}

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course
	*/
	public static void cacheResult(com.liferay.live.sb.demo.model.Course course) {
		getPersistence().cacheResult(course);
	}

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public static void cacheResult(
		java.util.List<com.liferay.live.sb.demo.model.Course> courses) {
		getPersistence().cacheResult(courses);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public static com.liferay.live.sb.demo.model.Course create(long courseId) {
		return getPersistence().create(courseId);
	}

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course remove(long courseId)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(courseId);
	}

	public static com.liferay.live.sb.demo.model.Course updateImpl(
		com.liferay.live.sb.demo.model.Course course, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(course, merge);
	}

	/**
	* Returns the course with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchCourseException} if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course findByPrimaryKey(
		long courseId)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(courseId);
	}

	/**
	* Returns the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course fetchByPrimaryKey(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(courseId);
	}

	/**
	* Returns all the courses where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByInstructorId(
		long instructorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInstructorId(instructorId);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByInstructorId(
		long instructorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInstructorId(instructorId, start, end);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByInstructorId(
		long instructorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByInstructorId(instructorId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course findByInstructorId_First(
		long instructorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByInstructorId_First(instructorId, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course fetchByInstructorId_First(
		long instructorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInstructorId_First(instructorId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course findByInstructorId_Last(
		long instructorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByInstructorId_Last(instructorId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course fetchByInstructorId_Last(
		long instructorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInstructorId_Last(instructorId, orderByComparator);
	}

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
	public static com.liferay.live.sb.demo.model.Course[] findByInstructorId_PrevAndNext(
		long courseId, long instructorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByInstructorId_PrevAndNext(courseId, instructorId,
			orderByComparator);
	}

	/**
	* Returns all the courses where year = &#63;.
	*
	* @param year the year
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByYear(
		int year) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(year);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByYear(
		int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(year, start, end);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(year, start, end, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course findByYear_First(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear_First(year, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course fetchByYear_First(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByYear_First(year, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course findByYear_Last(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear_Last(year, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course fetchByYear_Last(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByYear_Last(year, orderByComparator);
	}

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
	public static com.liferay.live.sb.demo.model.Course[] findByYear_PrevAndNext(
		long courseId, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYear_PrevAndNext(courseId, year, orderByComparator);
	}

	/**
	* Returns all the courses where year = &#63; and semester = &#63;.
	*
	* @param year the year
	* @param semester the semester
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByYearSemester(
		int year, int semester)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYearSemester(year, semester);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByYearSemester(
		int year, int semester, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYearSemester(year, semester, start, end);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByYearSemester(
		int year, int semester, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYearSemester(year, semester, start, end,
			orderByComparator);
	}

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
	public static com.liferay.live.sb.demo.model.Course findByYearSemester_First(
		int year, int semester,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYearSemester_First(year, semester, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where year = &#63; and semester = &#63;.
	*
	* @param year the year
	* @param semester the semester
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course fetchByYearSemester_First(
		int year, int semester,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByYearSemester_First(year, semester, orderByComparator);
	}

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
	public static com.liferay.live.sb.demo.model.Course findByYearSemester_Last(
		int year, int semester,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYearSemester_Last(year, semester, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where year = &#63; and semester = &#63;.
	*
	* @param year the year
	* @param semester the semester
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course fetchByYearSemester_Last(
		int year, int semester,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByYearSemester_Last(year, semester, orderByComparator);
	}

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
	public static com.liferay.live.sb.demo.model.Course[] findByYearSemester_PrevAndNext(
		long courseId, int year, int semester,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYearSemester_PrevAndNext(courseId, year, semester,
			orderByComparator);
	}

	/**
	* Returns all the courses where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByCourseCatalogId(
		long courseCatalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseCatalogId(courseCatalogId);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByCourseCatalogId(
		long courseCatalogId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseCatalogId(courseCatalogId, start, end);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findByCourseCatalogId(
		long courseCatalogId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseCatalogId(courseCatalogId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course findByCourseCatalogId_First(
		long courseCatalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseCatalogId_First(courseCatalogId,
			orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course fetchByCourseCatalogId_First(
		long courseCatalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseCatalogId_First(courseCatalogId,
			orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course findByCourseCatalogId_Last(
		long courseCatalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseCatalogId_Last(courseCatalogId,
			orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Course fetchByCourseCatalogId_Last(
		long courseCatalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseCatalogId_Last(courseCatalogId,
			orderByComparator);
	}

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
	public static com.liferay.live.sb.demo.model.Course[] findByCourseCatalogId_PrevAndNext(
		long courseId, long courseCatalogId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseCatalogId_PrevAndNext(courseId,
			courseCatalogId, orderByComparator);
	}

	/**
	* Returns all the courses.
	*
	* @return the courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Course> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the courses where instructorId = &#63; from the database.
	*
	* @param instructorId the instructor ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByInstructorId(long instructorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByInstructorId(instructorId);
	}

	/**
	* Removes all the courses where year = &#63; from the database.
	*
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByYear(int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByYear(year);
	}

	/**
	* Removes all the courses where year = &#63; and semester = &#63; from the database.
	*
	* @param year the year
	* @param semester the semester
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByYearSemester(int year, int semester)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByYearSemester(year, semester);
	}

	/**
	* Removes all the courses where courseCatalogId = &#63; from the database.
	*
	* @param courseCatalogId the course catalog ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseCatalogId(long courseCatalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseCatalogId(courseCatalogId);
	}

	/**
	* Removes all the courses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of courses where instructorId = &#63;.
	*
	* @param instructorId the instructor ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByInstructorId(long instructorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByInstructorId(instructorId);
	}

	/**
	* Returns the number of courses where year = &#63;.
	*
	* @param year the year
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByYear(int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByYear(year);
	}

	/**
	* Returns the number of courses where year = &#63; and semester = &#63;.
	*
	* @param year the year
	* @param semester the semester
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByYearSemester(int year, int semester)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByYearSemester(year, semester);
	}

	/**
	* Returns the number of courses where courseCatalogId = &#63;.
	*
	* @param courseCatalogId the course catalog ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseCatalogId(long courseCatalogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseCatalogId(courseCatalogId);
	}

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CoursePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoursePersistence)PortletBeanLocatorUtil.locate(com.liferay.live.sb.demo.service.ClpSerializer.getServletContextName(),
					CoursePersistence.class.getName());

			ReferenceRegistry.registerReference(CourseUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CoursePersistence persistence) {
	}

	private static CoursePersistence _persistence;
}