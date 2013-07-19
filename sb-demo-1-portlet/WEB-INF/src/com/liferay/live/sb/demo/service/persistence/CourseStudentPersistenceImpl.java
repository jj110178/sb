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

import com.liferay.live.sb.demo.NoSuchCourseStudentException;
import com.liferay.live.sb.demo.model.CourseStudent;
import com.liferay.live.sb.demo.model.impl.CourseStudentImpl;
import com.liferay.live.sb.demo.model.impl.CourseStudentModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see CourseStudentPersistence
 * @see CourseStudentUtil
 * @generated
 */
public class CourseStudentPersistenceImpl extends BasePersistenceImpl<CourseStudent>
	implements CourseStudentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseStudentUtil} to access the course student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseStudentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentModelImpl.FINDER_CACHE_ENABLED,
			CourseStudentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
		new FinderPath(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentModelImpl.FINDER_CACHE_ENABLED,
			CourseStudentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseId", new String[] { Long.class.getName() },
			CourseStudentModelImpl.COURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentModelImpl.FINDER_CACHE_ENABLED,
			CourseStudentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStudentId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentModelImpl.FINDER_CACHE_ENABLED,
			CourseStudentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStudentId", new String[] { Long.class.getName() },
			CourseStudentModelImpl.STUDENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDENTID = new FinderPath(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStudentId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentModelImpl.FINDER_CACHE_ENABLED,
			CourseStudentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentModelImpl.FINDER_CACHE_ENABLED,
			CourseStudentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the course student in the entity cache if it is enabled.
	 *
	 * @param courseStudent the course student
	 */
	public void cacheResult(CourseStudent courseStudent) {
		EntityCacheUtil.putResult(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentImpl.class, courseStudent.getPrimaryKey(),
			courseStudent);

		courseStudent.resetOriginalValues();
	}

	/**
	 * Caches the course students in the entity cache if it is enabled.
	 *
	 * @param courseStudents the course students
	 */
	public void cacheResult(List<CourseStudent> courseStudents) {
		for (CourseStudent courseStudent : courseStudents) {
			if (EntityCacheUtil.getResult(
						CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
						CourseStudentImpl.class, courseStudent.getPrimaryKey()) == null) {
				cacheResult(courseStudent);
			}
			else {
				courseStudent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course students.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseStudentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseStudentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course student.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseStudent courseStudent) {
		EntityCacheUtil.removeResult(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentImpl.class, courseStudent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CourseStudent> courseStudents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseStudent courseStudent : courseStudents) {
			EntityCacheUtil.removeResult(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
				CourseStudentImpl.class, courseStudent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new course student with the primary key. Does not add the course student to the database.
	 *
	 * @param courseStudentPK the primary key for the new course student
	 * @return the new course student
	 */
	public CourseStudent create(CourseStudentPK courseStudentPK) {
		CourseStudent courseStudent = new CourseStudentImpl();

		courseStudent.setNew(true);
		courseStudent.setPrimaryKey(courseStudentPK);

		return courseStudent;
	}

	/**
	 * Removes the course student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseStudentPK the primary key of the course student
	 * @return the course student that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a course student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent remove(CourseStudentPK courseStudentPK)
		throws NoSuchCourseStudentException, SystemException {
		return remove((Serializable)courseStudentPK);
	}

	/**
	 * Removes the course student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course student
	 * @return the course student that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a course student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseStudent remove(Serializable primaryKey)
		throws NoSuchCourseStudentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseStudent courseStudent = (CourseStudent)session.get(CourseStudentImpl.class,
					primaryKey);

			if (courseStudent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseStudent);
		}
		catch (NoSuchCourseStudentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CourseStudent removeImpl(CourseStudent courseStudent)
		throws SystemException {
		courseStudent = toUnwrappedModel(courseStudent);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, courseStudent);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(courseStudent);

		return courseStudent;
	}

	@Override
	public CourseStudent updateImpl(
		com.liferay.live.sb.demo.model.CourseStudent courseStudent,
		boolean merge) throws SystemException {
		courseStudent = toUnwrappedModel(courseStudent);

		boolean isNew = courseStudent.isNew();

		CourseStudentModelImpl courseStudentModelImpl = (CourseStudentModelImpl)courseStudent;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, courseStudent, merge);

			courseStudent.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseStudentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((courseStudentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(courseStudentModelImpl.getOriginalCourseId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);

				args = new Object[] {
						Long.valueOf(courseStudentModelImpl.getCourseId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);
			}

			if ((courseStudentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(courseStudentModelImpl.getOriginalStudentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STUDENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);

				args = new Object[] {
						Long.valueOf(courseStudentModelImpl.getStudentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STUDENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
			CourseStudentImpl.class, courseStudent.getPrimaryKey(),
			courseStudent);

		return courseStudent;
	}

	protected CourseStudent toUnwrappedModel(CourseStudent courseStudent) {
		if (courseStudent instanceof CourseStudentImpl) {
			return courseStudent;
		}

		CourseStudentImpl courseStudentImpl = new CourseStudentImpl();

		courseStudentImpl.setNew(courseStudent.isNew());
		courseStudentImpl.setPrimaryKey(courseStudent.getPrimaryKey());

		courseStudentImpl.setStudentId(courseStudent.getStudentId());
		courseStudentImpl.setCourseId(courseStudent.getCourseId());
		courseStudentImpl.setUserId(courseStudent.getUserId());
		courseStudentImpl.setCreateDate(courseStudent.getCreateDate());
		courseStudentImpl.setModifiedDate(courseStudent.getModifiedDate());
		courseStudentImpl.setGrade(courseStudent.getGrade());

		return courseStudentImpl;
	}

	/**
	 * Returns the course student with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course student
	 * @return the course student
	 * @throws com.liferay.portal.NoSuchModelException if a course student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseStudent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((CourseStudentPK)primaryKey);
	}

	/**
	 * Returns the course student with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchCourseStudentException} if it could not be found.
	 *
	 * @param courseStudentPK the primary key of the course student
	 * @return the course student
	 * @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a course student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent findByPrimaryKey(CourseStudentPK courseStudentPK)
		throws NoSuchCourseStudentException, SystemException {
		CourseStudent courseStudent = fetchByPrimaryKey(courseStudentPK);

		if (courseStudent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + courseStudentPK);
			}

			throw new NoSuchCourseStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				courseStudentPK);
		}

		return courseStudent;
	}

	/**
	 * Returns the course student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course student
	 * @return the course student, or <code>null</code> if a course student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseStudent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((CourseStudentPK)primaryKey);
	}

	/**
	 * Returns the course student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseStudentPK the primary key of the course student
	 * @return the course student, or <code>null</code> if a course student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent fetchByPrimaryKey(CourseStudentPK courseStudentPK)
		throws SystemException {
		CourseStudent courseStudent = (CourseStudent)EntityCacheUtil.getResult(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
				CourseStudentImpl.class, courseStudentPK);

		if (courseStudent == _nullCourseStudent) {
			return null;
		}

		if (courseStudent == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				courseStudent = (CourseStudent)session.get(CourseStudentImpl.class,
						courseStudentPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (courseStudent != null) {
					cacheResult(courseStudent);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CourseStudentModelImpl.ENTITY_CACHE_ENABLED,
						CourseStudentImpl.class, courseStudentPK,
						_nullCourseStudent);
				}

				closeSession(session);
			}
		}

		return courseStudent;
	}

	/**
	 * Returns all the course students where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the matching course students
	 * @throws SystemException if a system exception occurred
	 */
	public List<CourseStudent> findByCourseId(long courseId)
		throws SystemException {
		return findByCourseId(courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	public List<CourseStudent> findByCourseId(long courseId, int start, int end)
		throws SystemException {
		return findByCourseId(courseId, start, end, null);
	}

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
	public List<CourseStudent> findByCourseId(long courseId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID;
			finderArgs = new Object[] { courseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID;
			finderArgs = new Object[] { courseId, start, end, orderByComparator };
		}

		List<CourseStudent> list = (List<CourseStudent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseStudent courseStudent : list) {
				if ((courseId != courseStudent.getCourseId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_COURSESTUDENT_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				list = (List<CourseStudent>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first course student in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course student
	 * @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a matching course student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent findByCourseId_First(long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseStudentException, SystemException {
		CourseStudent courseStudent = fetchByCourseId_First(courseId,
				orderByComparator);

		if (courseStudent != null) {
			return courseStudent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseStudentException(msg.toString());
	}

	/**
	 * Returns the first course student in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course student, or <code>null</code> if a matching course student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent fetchByCourseId_First(long courseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseStudent> list = findByCourseId(courseId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course student in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course student
	 * @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a matching course student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent findByCourseId_Last(long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseStudentException, SystemException {
		CourseStudent courseStudent = fetchByCourseId_Last(courseId,
				orderByComparator);

		if (courseStudent != null) {
			return courseStudent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseStudentException(msg.toString());
	}

	/**
	 * Returns the last course student in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course student, or <code>null</code> if a matching course student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent fetchByCourseId_Last(long courseId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseId(courseId);

		List<CourseStudent> list = findByCourseId(courseId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public CourseStudent[] findByCourseId_PrevAndNext(
		CourseStudentPK courseStudentPK, long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseStudentException, SystemException {
		CourseStudent courseStudent = findByPrimaryKey(courseStudentPK);

		Session session = null;

		try {
			session = openSession();

			CourseStudent[] array = new CourseStudentImpl[3];

			array[0] = getByCourseId_PrevAndNext(session, courseStudent,
					courseId, orderByComparator, true);

			array[1] = courseStudent;

			array[2] = getByCourseId_PrevAndNext(session, courseStudent,
					courseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseStudent getByCourseId_PrevAndNext(Session session,
		CourseStudent courseStudent, long courseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSESTUDENT_WHERE);

		query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseStudent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseStudent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the course students where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the matching course students
	 * @throws SystemException if a system exception occurred
	 */
	public List<CourseStudent> findByStudentId(long studentId)
		throws SystemException {
		return findByStudentId(studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	public List<CourseStudent> findByStudentId(long studentId, int start,
		int end) throws SystemException {
		return findByStudentId(studentId, start, end, null);
	}

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
	public List<CourseStudent> findByStudentId(long studentId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId, start, end, orderByComparator };
		}

		List<CourseStudent> list = (List<CourseStudent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseStudent courseStudent : list) {
				if ((studentId != courseStudent.getStudentId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_COURSESTUDENT_WHERE);

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				list = (List<CourseStudent>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first course student in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course student
	 * @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a matching course student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent findByStudentId_First(long studentId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseStudentException, SystemException {
		CourseStudent courseStudent = fetchByStudentId_First(studentId,
				orderByComparator);

		if (courseStudent != null) {
			return courseStudent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseStudentException(msg.toString());
	}

	/**
	 * Returns the first course student in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course student, or <code>null</code> if a matching course student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent fetchByStudentId_First(long studentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseStudent> list = findByStudentId(studentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course student in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course student
	 * @throws com.liferay.live.sb.demo.NoSuchCourseStudentException if a matching course student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent findByStudentId_Last(long studentId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseStudentException, SystemException {
		CourseStudent courseStudent = fetchByStudentId_Last(studentId,
				orderByComparator);

		if (courseStudent != null) {
			return courseStudent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseStudentException(msg.toString());
	}

	/**
	 * Returns the last course student in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course student, or <code>null</code> if a matching course student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CourseStudent fetchByStudentId_Last(long studentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStudentId(studentId);

		List<CourseStudent> list = findByStudentId(studentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public CourseStudent[] findByStudentId_PrevAndNext(
		CourseStudentPK courseStudentPK, long studentId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseStudentException, SystemException {
		CourseStudent courseStudent = findByPrimaryKey(courseStudentPK);

		Session session = null;

		try {
			session = openSession();

			CourseStudent[] array = new CourseStudentImpl[3];

			array[0] = getByStudentId_PrevAndNext(session, courseStudent,
					studentId, orderByComparator, true);

			array[1] = courseStudent;

			array[2] = getByStudentId_PrevAndNext(session, courseStudent,
					studentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseStudent getByStudentId_PrevAndNext(Session session,
		CourseStudent courseStudent, long studentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSESTUDENT_WHERE);

		query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseStudent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseStudent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the course students.
	 *
	 * @return the course students
	 * @throws SystemException if a system exception occurred
	 */
	public List<CourseStudent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<CourseStudent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<CourseStudent> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CourseStudent> list = (List<CourseStudent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSESTUDENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSESTUDENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CourseStudent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CourseStudent>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the course students where courseId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCourseId(long courseId) throws SystemException {
		for (CourseStudent courseStudent : findByCourseId(courseId)) {
			remove(courseStudent);
		}
	}

	/**
	 * Removes all the course students where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStudentId(long studentId) throws SystemException {
		for (CourseStudent courseStudent : findByStudentId(studentId)) {
			remove(courseStudent);
		}
	}

	/**
	 * Removes all the course students from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CourseStudent courseStudent : findAll()) {
			remove(courseStudent);
		}
	}

	/**
	 * Returns the number of course students where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching course students
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCourseId(long courseId) throws SystemException {
		Object[] finderArgs = new Object[] { courseId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COURSEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSESTUDENT_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of course students where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching course students
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStudentId(long studentId) throws SystemException {
		Object[] finderArgs = new Object[] { studentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STUDENTID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSESTUDENT_WHERE);

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STUDENTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of course students.
	 *
	 * @return the number of course students
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COURSESTUDENT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the course student persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.live.sb.demo.model.CourseStudent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseStudent>> listenersList = new ArrayList<ModelListener<CourseStudent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseStudent>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CourseStudentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = CourseCatalogPersistence.class)
	protected CourseCatalogPersistence courseCatalogPersistence;
	@BeanReference(type = CourseStudentPersistence.class)
	protected CourseStudentPersistence courseStudentPersistence;
	@BeanReference(type = InstructorPersistence.class)
	protected InstructorPersistence instructorPersistence;
	@BeanReference(type = StudentPersistence.class)
	protected StudentPersistence studentPersistence;
	@BeanReference(type = StudentGPAPersistence.class)
	protected StudentGPAPersistence studentGPAPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_COURSESTUDENT = "SELECT courseStudent FROM CourseStudent courseStudent";
	private static final String _SQL_SELECT_COURSESTUDENT_WHERE = "SELECT courseStudent FROM CourseStudent courseStudent WHERE ";
	private static final String _SQL_COUNT_COURSESTUDENT = "SELECT COUNT(courseStudent) FROM CourseStudent courseStudent";
	private static final String _SQL_COUNT_COURSESTUDENT_WHERE = "SELECT COUNT(courseStudent) FROM CourseStudent courseStudent WHERE ";
	private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "courseStudent.id.courseId = ?";
	private static final String _FINDER_COLUMN_STUDENTID_STUDENTID_2 = "courseStudent.id.studentId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseStudent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseStudent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseStudent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseStudentPersistenceImpl.class);
	private static CourseStudent _nullCourseStudent = new CourseStudentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseStudent> toCacheModel() {
				return _nullCourseStudentCacheModel;
			}
		};

	private static CacheModel<CourseStudent> _nullCourseStudentCacheModel = new CacheModel<CourseStudent>() {
			public CourseStudent toEntityModel() {
				return _nullCourseStudent;
			}
		};
}