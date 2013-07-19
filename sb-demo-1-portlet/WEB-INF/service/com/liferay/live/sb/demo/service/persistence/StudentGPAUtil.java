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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the student g p a service. This utility wraps {@link StudentGPAPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see StudentGPAPersistence
 * @see StudentGPAPersistenceImpl
 * @generated
 */
public class StudentGPAUtil {
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
	public static void clearCache(StudentGPA studentGPA) {
		getPersistence().clearCache(studentGPA);
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
	public static List<StudentGPA> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StudentGPA> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StudentGPA> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static StudentGPA update(StudentGPA studentGPA, boolean merge)
		throws SystemException {
		return getPersistence().update(studentGPA, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static StudentGPA update(StudentGPA studentGPA, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(studentGPA, merge, serviceContext);
	}

	/**
	* Caches the student g p a in the entity cache if it is enabled.
	*
	* @param studentGPA the student g p a
	*/
	public static void cacheResult(
		com.liferay.live.sb.demo.model.StudentGPA studentGPA) {
		getPersistence().cacheResult(studentGPA);
	}

	/**
	* Caches the student g p as in the entity cache if it is enabled.
	*
	* @param studentGPAs the student g p as
	*/
	public static void cacheResult(
		java.util.List<com.liferay.live.sb.demo.model.StudentGPA> studentGPAs) {
		getPersistence().cacheResult(studentGPAs);
	}

	/**
	* Creates a new student g p a with the primary key. Does not add the student g p a to the database.
	*
	* @param studentId the primary key for the new student g p a
	* @return the new student g p a
	*/
	public static com.liferay.live.sb.demo.model.StudentGPA create(
		long studentId) {
		return getPersistence().create(studentId);
	}

	/**
	* Removes the student g p a with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student g p a
	* @return the student g p a that was removed
	* @throws com.liferay.live.sb.demo.NoSuchStudentGPAException if a student g p a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.StudentGPA remove(
		long studentId)
		throws com.liferay.live.sb.demo.NoSuchStudentGPAException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(studentId);
	}

	public static com.liferay.live.sb.demo.model.StudentGPA updateImpl(
		com.liferay.live.sb.demo.model.StudentGPA studentGPA, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(studentGPA, merge);
	}

	/**
	* Returns the student g p a with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchStudentGPAException} if it could not be found.
	*
	* @param studentId the primary key of the student g p a
	* @return the student g p a
	* @throws com.liferay.live.sb.demo.NoSuchStudentGPAException if a student g p a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.StudentGPA findByPrimaryKey(
		long studentId)
		throws com.liferay.live.sb.demo.NoSuchStudentGPAException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(studentId);
	}

	/**
	* Returns the student g p a with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student g p a
	* @return the student g p a, or <code>null</code> if a student g p a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.live.sb.demo.model.StudentGPA fetchByPrimaryKey(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(studentId);
	}

	/**
	* Returns all the student g p as.
	*
	* @return the student g p as
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.live.sb.demo.model.StudentGPA> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.StudentGPA> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.live.sb.demo.model.StudentGPA> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the student g p as from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of student g p as.
	*
	* @return the number of student g p as
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StudentGPAPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StudentGPAPersistence)PortletBeanLocatorUtil.locate(com.liferay.live.sb.demo.service.ClpSerializer.getServletContextName(),
					StudentGPAPersistence.class.getName());

			ReferenceRegistry.registerReference(StudentGPAUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(StudentGPAPersistence persistence) {
	}

	private static StudentGPAPersistence _persistence;
}