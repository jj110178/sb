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

import com.liferay.live.sb.demo.model.CourseStudent;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the course student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see CourseStudentPersistenceImpl
 * @see CourseStudentUtil
 * @generated
 */
public interface CourseStudentPersistence extends BasePersistence<CourseStudent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseStudentUtil} to access the course student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the course student in the entity cache if it is enabled.
	*
	* @param courseStudent the course student
	*/
	public void cacheResult(
		com.liferay.live.sb.demo.model.CourseStudent courseStudent);

	/**
	* Caches the course students in the entity cache if it is enabled.
	*
	* @param courseStudents the course students
	*/
	public void cacheResult(
		java.util.List<com.liferay.live.sb.demo.model.CourseStudent> courseStudents);

	/**
	* Creates a new course student with the primary key. Does not add the course student to the database.
	*
	* @param courseStudentPK the primary key for the new course student
	* @return the new course student
	*/
	public com.liferay.live.sb.demo.model.CourseStudent create(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK courseStudentPK);

	/**
	* Removes the course student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseStudentPK the primary key of the course student
	* @return the course student that was removed
	* @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a course student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent remove(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK courseStudentPK)
		throws com.liferay.live.sb.demo.NoSuchCourseStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.live.sb.demo.model.CourseStudent updateImpl(
		com.liferay.live.sb.demo.model.CourseStudent courseStudent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course student with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchCourseStudentException} if it could not be found.
	*
	* @param courseStudentPK the primary key of the course student
	* @return the course student
	* @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a course student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent findByPrimaryKey(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK courseStudentPK)
		throws com.liferay.live.sb.demo.NoSuchCourseStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseStudentPK the primary key of the course student
	* @return the course student, or <code>null</code> if a course student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent fetchByPrimaryKey(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK courseStudentPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course students where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the matching course students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course students where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of course students
	* @param end the upper bound of the range of course students (not inclusive)
	* @return the range of matching course students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course students where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of course students
	* @param end the upper bound of the range of course students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findByCourseId(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course student in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course student
	* @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a matching course student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent findByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course student in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course student, or <code>null</code> if a matching course student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent fetchByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course student in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course student
	* @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a matching course student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent findByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course student in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course student, or <code>null</code> if a matching course student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent fetchByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course students before and after the current course student in the ordered set where courseId = &#63;.
	*
	* @param courseStudentPK the primary key of the current course student
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course student
	* @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a course student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent[] findByCourseId_PrevAndNext(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK courseStudentPK,
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course students where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the matching course students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findByStudentId(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course students where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of course students
	* @param end the upper bound of the range of course students (not inclusive)
	* @return the range of matching course students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findByStudentId(
		long studentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course students where studentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studentId the student ID
	* @param start the lower bound of the range of course students
	* @param end the upper bound of the range of course students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findByStudentId(
		long studentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course student in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course student
	* @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a matching course student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent findByStudentId_First(
		long studentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course student in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course student, or <code>null</code> if a matching course student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent fetchByStudentId_First(
		long studentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course student in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course student
	* @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a matching course student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent findByStudentId_Last(
		long studentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course student in the ordered set where studentId = &#63;.
	*
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course student, or <code>null</code> if a matching course student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent fetchByStudentId_Last(
		long studentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course students before and after the current course student in the ordered set where studentId = &#63;.
	*
	* @param courseStudentPK the primary key of the current course student
	* @param studentId the student ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course student
	* @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a course student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.CourseStudent[] findByStudentId_PrevAndNext(
		com.liferay.live.sb.demo.service.persistence.CourseStudentPK courseStudentPK,
		long studentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchCourseStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course students.
	*
	* @return the course students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of course students
	* @param end the upper bound of the range of course students (not inclusive)
	* @return the range of course students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of course students
	* @param end the upper bound of the range of course students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.CourseStudent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course students where courseId = &#63; from the database.
	*
	* @param courseId the course ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course students where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStudentId(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course students where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching course students
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course students where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching course students
	* @throws SystemException if a system exception occurred
	*/
	public int countByStudentId(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course students.
	*
	* @return the number of course students
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}