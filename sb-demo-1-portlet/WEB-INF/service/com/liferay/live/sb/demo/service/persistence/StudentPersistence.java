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

import com.liferay.live.sb.demo.model.Student;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see StudentPersistenceImpl
 * @see StudentUtil
 * @generated
 */
public interface StudentPersistence extends BasePersistence<Student> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the student in the entity cache if it is enabled.
	*
	* @param student the student
	*/
	public void cacheResult(com.liferay.live.sb.demo.model.Student student);

	/**
	* Caches the students in the entity cache if it is enabled.
	*
	* @param students the students
	*/
	public void cacheResult(
		java.util.List<com.liferay.live.sb.demo.model.Student> students);

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public com.liferay.live.sb.demo.model.Student create(long studentId);

	/**
	* Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student
	* @return the student that was removed
	* @throws com.liferay.live.sb.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student remove(long studentId)
		throws com.liferay.live.sb.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.live.sb.demo.model.Student updateImpl(
		com.liferay.live.sb.demo.model.Student student, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchStudentException} if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student
	* @throws com.liferay.live.sb.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student findByPrimaryKey(
		long studentId)
		throws com.liferay.live.sb.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student, or <code>null</code> if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student fetchByPrimaryKey(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where yearInSchool = &#63;.
	*
	* @param yearInSchool the year in school
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Student> findByYearInSchool(
		int yearInSchool)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where yearInSchool = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param yearInSchool the year in school
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Student> findByYearInSchool(
		int yearInSchool, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where yearInSchool = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param yearInSchool the year in school
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Student> findByYearInSchool(
		int yearInSchool, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where yearInSchool = &#63;.
	*
	* @param yearInSchool the year in school
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.liferay.live.sb.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student findByYearInSchool_First(
		int yearInSchool,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where yearInSchool = &#63;.
	*
	* @param yearInSchool the year in school
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student fetchByYearInSchool_First(
		int yearInSchool,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where yearInSchool = &#63;.
	*
	* @param yearInSchool the year in school
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.liferay.live.sb.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student findByYearInSchool_Last(
		int yearInSchool,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where yearInSchool = &#63;.
	*
	* @param yearInSchool the year in school
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student fetchByYearInSchool_Last(
		int yearInSchool,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where yearInSchool = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param yearInSchool the year in school
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.liferay.live.sb.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student[] findByYearInSchool_PrevAndNext(
		long studentId, int yearInSchool,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where major = &#63;.
	*
	* @param major the major
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Student> findByMajor(
		java.lang.String major)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where major = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param major the major
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Student> findByMajor(
		java.lang.String major, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where major = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param major the major
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Student> findByMajor(
		java.lang.String major, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where major = &#63;.
	*
	* @param major the major
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.liferay.live.sb.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student findByMajor_First(
		java.lang.String major,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where major = &#63;.
	*
	* @param major the major
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student fetchByMajor_First(
		java.lang.String major,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where major = &#63;.
	*
	* @param major the major
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.liferay.live.sb.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student findByMajor_Last(
		java.lang.String major,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where major = &#63;.
	*
	* @param major the major
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student fetchByMajor_Last(
		java.lang.String major,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where major = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param major the major
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.liferay.live.sb.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Student[] findByMajor_PrevAndNext(
		long studentId, java.lang.String major,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.live.sb.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students.
	*
	* @return the students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Student> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Student> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Student> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students where yearInSchool = &#63; from the database.
	*
	* @param yearInSchool the year in school
	* @throws SystemException if a system exception occurred
	*/
	public void removeByYearInSchool(int yearInSchool)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students where major = &#63; from the database.
	*
	* @param major the major
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMajor(java.lang.String major)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where yearInSchool = &#63;.
	*
	* @param yearInSchool the year in school
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByYearInSchool(int yearInSchool)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where major = &#63;.
	*
	* @param major the major
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByMajor(java.lang.String major)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students.
	*
	* @return the number of students
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}