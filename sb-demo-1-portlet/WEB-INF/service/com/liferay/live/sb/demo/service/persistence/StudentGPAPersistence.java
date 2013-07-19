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

import com.liferay.live.sb.demo.model.StudentGPA;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the student g p a service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see StudentGPAPersistenceImpl
 * @see StudentGPAUtil
 * @generated
 */
public interface StudentGPAPersistence extends BasePersistence<StudentGPA> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentGPAUtil} to access the student g p a persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the student g p a in the entity cache if it is enabled.
	*
	* @param studentGPA the student g p a
	*/
	public void cacheResult(
		com.liferay.live.sb.demo.model.StudentGPA studentGPA);

	/**
	* Caches the student g p as in the entity cache if it is enabled.
	*
	* @param studentGPAs the student g p as
	*/
	public void cacheResult(
		java.util.List<com.liferay.live.sb.demo.model.StudentGPA> studentGPAs);

	/**
	* Creates a new student g p a with the primary key. Does not add the student g p a to the database.
	*
	* @param studentId the primary key for the new student g p a
	* @return the new student g p a
	*/
	public com.liferay.live.sb.demo.model.StudentGPA create(long studentId);

	/**
	* Removes the student g p a with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student g p a
	* @return the student g p a that was removed
	* @throws com.liferay.live.sb.demo.NoSuchStudentGPAException if a student g p a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.StudentGPA remove(long studentId)
		throws com.liferay.live.sb.demo.NoSuchStudentGPAException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.live.sb.demo.model.StudentGPA updateImpl(
		com.liferay.live.sb.demo.model.StudentGPA studentGPA, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student g p a with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchStudentGPAException} if it could not be found.
	*
	* @param studentId the primary key of the student g p a
	* @return the student g p a
	* @throws com.liferay.live.sb.demo.NoSuchStudentGPAException if a student g p a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.StudentGPA findByPrimaryKey(
		long studentId)
		throws com.liferay.live.sb.demo.NoSuchStudentGPAException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student g p a with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student g p a
	* @return the student g p a, or <code>null</code> if a student g p a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.live.sb.demo.model.StudentGPA fetchByPrimaryKey(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the student g p as.
	*
	* @return the student g p as
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.StudentGPA> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the student g p as.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of student g p as
	* @param end the upper bound of the range of student g p as (not inclusive)
	* @return the range of student g p as
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.StudentGPA> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the student g p as.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of student g p as
	* @param end the upper bound of the range of student g p as (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of student g p as
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.live.sb.demo.model.StudentGPA> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the student g p as from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of student g p as.
	*
	* @return the number of student g p as
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}