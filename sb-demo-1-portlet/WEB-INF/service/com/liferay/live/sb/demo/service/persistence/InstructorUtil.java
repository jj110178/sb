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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the instructor service. This utility wraps {@link InstructorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see InstructorPersistence
 * @see InstructorPersistenceImpl
 * @generated
 */
public class InstructorUtil {
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
	public static void clearCache(Instructor instructor) {
		getPersistence().clearCache(instructor);
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
	public static List<Instructor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Instructor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Instructor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Instructor update(Instructor instructor, boolean merge)
		throws SystemException {
		return getPersistence().update(instructor, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Instructor update(Instructor instructor, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(instructor, merge, serviceContext);
	}

	/**
	* Caches the instructor in the entity cache if it is enabled.
	*
	* @param instructor the instructor
	*/
	public static void cacheResult(
		com.liferay.live.sb.demo.model.Instructor instructor) {
		getPersistence().cacheResult(instructor);
	}

	/**
	* Caches the instructors in the entity cache if it is enabled.
	*
	* @param instructors the instructors
	*/
	public static void cacheResult(
		java.util.List<com.liferay.live.sb.demo.model.Instructor> instructors) {
		getPersistence().cacheResult(instructors);
	}

	/**
	* Creates a new instructor with the primary key. Does not add the instructor to the database.
	*
	* @param instructorId the primary key for the new instructor
	* @return the new instructor
	*/
	public static com.liferay.live.sb.demo.model.Instructor create(
		long instructorId) {
		return getPersistence().create(instructorId);
	}

	/**
	* Removes the instructor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param instructorId the primary key of the instructor
	* @return the instructor that was removed
	* @throws com.liferay.live.sb.demo.NoSuchInstructorException if a instructor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Instructor remove(
		long instructorId)
		throws com.liferay.live.sb.demo.NoSuchInstructorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(instructorId);
	}

	public static com.liferay.live.sb.demo.model.Instructor updateImpl(
		com.liferay.live.sb.demo.model.Instructor instructor, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(instructor, merge);
	}

	/**
	* Returns the instructor with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchInstructorException} if it could not be found.
	*
	* @param instructorId the primary key of the instructor
	* @return the instructor
	* @throws com.liferay.live.sb.demo.NoSuchInstructorException if a instructor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Instructor findByPrimaryKey(
		long instructorId)
		throws com.liferay.live.sb.demo.NoSuchInstructorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(instructorId);
	}

	/**
	* Returns the instructor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param instructorId the primary key of the instructor
	* @return the instructor, or <code>null</code> if a instructor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.Instructor fetchByPrimaryKey(
		long instructorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(instructorId);
	}

	/**
	* Returns all the instructors.
	*
	* @return the instructors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.live.sb.demo.model.Instructor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Instructor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.Instructor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the instructors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of instructors.
	*
	* @return the number of instructors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InstructorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InstructorPersistence)PortletBeanLocatorUtil.locate(com.liferay.live.sb.demo.service.ClpSerializer.getServletContextName(),
					InstructorPersistence.class.getName());

			ReferenceRegistry.registerReference(InstructorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(InstructorPersistence persistence) {
	}

	private static InstructorPersistence _persistence;
}