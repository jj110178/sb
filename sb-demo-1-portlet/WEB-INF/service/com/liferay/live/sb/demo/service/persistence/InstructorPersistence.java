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

import com.liferay.live.sb.demo.model.Instructor;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the instructor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see InstructorPersistenceImpl
 * @see InstructorUtil
 * @generated
 */
public interface InstructorPersistence extends BasePersistence<Instructor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InstructorUtil} to access the instructor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the instructor in the entity cache if it is enabled.
	*
	* @param instructor the instructor
	*/
	public void cacheResult(
		com.liferay.live.sb.demo.model.Instructor instructor);

	/**
	* Caches the instructors in the entity cache if it is enabled.
	*
	* @param instructors the instructors
	*/
	public void cacheResult(
		java.util.List<com.liferay.live.sb.demo.model.Instructor> instructors);

	/**
	* Creates a new instructor with the primary key. Does not add the instructor to the database.
	*
	* @param instructorId the primary key for the new instructor
	* @return the new instructor
	*/
	public com.liferay.live.sb.demo.model.Instructor create(long instructorId);

	/**
	* Removes the instructor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param instructorId the primary key of the instructor
	* @return the instructor that was removed
	* @throws com.liferay.live.sb.demo.NoSuchInstructorException if a instructor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Instructor remove(long instructorId)
		throws com.liferay.live.sb.demo.NoSuchInstructorException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.live.sb.demo.model.Instructor updateImpl(
		com.liferay.live.sb.demo.model.Instructor instructor, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the instructor with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchInstructorException} if it could not be found.
	*
	* @param instructorId the primary key of the instructor
	* @return the instructor
	* @throws com.liferay.live.sb.demo.NoSuchInstructorException if a instructor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Instructor findByPrimaryKey(
		long instructorId)
		throws com.liferay.live.sb.demo.NoSuchInstructorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the instructor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param instructorId the primary key of the instructor
	* @return the instructor, or <code>null</code> if a instructor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.Instructor fetchByPrimaryKey(
		long instructorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the instructors.
	*
	* @return the instructors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Instructor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the instructors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of instructors
	* @param end the upper bound of the range of instructors (not inclusive)
	* @return the range of instructors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Instructor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the instructors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of instructors
	* @param end the upper bound of the range of instructors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of instructors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.Instructor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the instructors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of instructors.
	*
	* @return the number of instructors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}