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

import com.liferay.live.sb.demo.NoSuchCourseException;
import com.liferay.live.sb.demo.model.Course;
import com.liferay.live.sb.demo.model.impl.CourseImpl;
import com.liferay.live.sb.demo.model.impl.CourseModelImpl;

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
 * The persistence implementation for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see CoursePersistence
 * @see CourseUtil
 * @generated
 */
public class CoursePersistenceImpl extends BasePersistenceImpl<Course>
	implements CoursePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTRUCTORID =
		new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInstructorId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTRUCTORID =
		new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstructorId",
			new String[] { Long.class.getName() },
			CourseModelImpl.INSTRUCTORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTRUCTORID = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstructorId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYear",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] { Integer.class.getName() },
			CourseModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEAR = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEARSEMESTER =
		new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYearSemester",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARSEMESTER =
		new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYearSemester",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			CourseModelImpl.YEAR_COLUMN_BITMASK |
			CourseModelImpl.SEMESTER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEARSEMESTER = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYearSemester",
			new String[] { Integer.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSECATALOGID =
		new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseCatalogId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSECATALOGID =
		new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseCatalogId",
			new String[] { Long.class.getName() },
			CourseModelImpl.COURSECATALOGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSECATALOGID = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseCatalogId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the course in the entity cache if it is enabled.
	 *
	 * @param course the course
	 */
	public void cacheResult(Course course) {
		EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey(), course);

		course.resetOriginalValues();
	}

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses
	 */
	public void cacheResult(List<Course> courses) {
		for (Course course : courses) {
			if (EntityCacheUtil.getResult(
						CourseModelImpl.ENTITY_CACHE_ENABLED, CourseImpl.class,
						course.getPrimaryKey()) == null) {
				cacheResult(course);
			}
			else {
				course.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all courses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Course course) {
		EntityCacheUtil.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Course> courses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Course course : courses) {
			EntityCacheUtil.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
				CourseImpl.class, course.getPrimaryKey());
		}
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	public Course create(long courseId) {
		Course course = new CourseImpl();

		course.setNew(true);
		course.setPrimaryKey(courseId);

		return course;
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseId the primary key of the course
	 * @return the course that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course remove(long courseId)
		throws NoSuchCourseException, SystemException {
		return remove(Long.valueOf(courseId));
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course that was removed
	 * @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course remove(Serializable primaryKey)
		throws NoSuchCourseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Course course = (Course)session.get(CourseImpl.class, primaryKey);

			if (course == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(course);
		}
		catch (NoSuchCourseException nsee) {
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
	protected Course removeImpl(Course course) throws SystemException {
		course = toUnwrappedModel(course);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, course);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(course);

		return course;
	}

	@Override
	public Course updateImpl(com.liferay.live.sb.demo.model.Course course,
		boolean merge) throws SystemException {
		course = toUnwrappedModel(course);

		boolean isNew = course.isNew();

		CourseModelImpl courseModelImpl = (CourseModelImpl)course;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, course, merge);

			course.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTRUCTORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(courseModelImpl.getOriginalInstructorId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTRUCTORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTRUCTORID,
					args);

				args = new Object[] {
						Long.valueOf(courseModelImpl.getInstructorId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTRUCTORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTRUCTORID,
					args);
			}

			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(courseModelImpl.getOriginalYear())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);

				args = new Object[] { Integer.valueOf(courseModelImpl.getYear()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);
			}

			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARSEMESTER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(courseModelImpl.getOriginalYear()),
						Integer.valueOf(courseModelImpl.getOriginalSemester())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEARSEMESTER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARSEMESTER,
					args);

				args = new Object[] {
						Integer.valueOf(courseModelImpl.getYear()),
						Integer.valueOf(courseModelImpl.getSemester())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEARSEMESTER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARSEMESTER,
					args);
			}

			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSECATALOGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(courseModelImpl.getOriginalCourseCatalogId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSECATALOGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSECATALOGID,
					args);

				args = new Object[] {
						Long.valueOf(courseModelImpl.getCourseCatalogId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSECATALOGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSECATALOGID,
					args);
			}
		}

		EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey(), course);

		return course;
	}

	protected Course toUnwrappedModel(Course course) {
		if (course instanceof CourseImpl) {
			return course;
		}

		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setNew(course.isNew());
		courseImpl.setPrimaryKey(course.getPrimaryKey());

		courseImpl.setCourseId(course.getCourseId());
		courseImpl.setUserId(course.getUserId());
		courseImpl.setCreateDate(course.getCreateDate());
		courseImpl.setModifiedDate(course.getModifiedDate());
		courseImpl.setInstructorId(course.getInstructorId());
		courseImpl.setCourseCatalogId(course.getCourseCatalogId());
		courseImpl.setCreditHours(course.getCreditHours());
		courseImpl.setSemester(course.getSemester());
		courseImpl.setYear(course.getYear());
		courseImpl.setName(course.getName());
		courseImpl.setMajor(course.getMajor());

		return courseImpl;
	}

	/**
	 * Returns the course with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course
	 * @throws com.liferay.portal.NoSuchModelException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the course with the primary key or throws a {@link com.liferay.live.sb.demo.NoSuchCourseException} if it could not be found.
	 *
	 * @param courseId the primary key of the course
	 * @return the course
	 * @throws com.liferay.live.sb.demo.NoSuchCourseException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course findByPrimaryKey(long courseId)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByPrimaryKey(courseId);

		if (course == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + courseId);
			}

			throw new NoSuchCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				courseId);
		}

		return course;
	}

	/**
	 * Returns the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Course fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseId the primary key of the course
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course fetchByPrimaryKey(long courseId) throws SystemException {
		Course course = (Course)EntityCacheUtil.getResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
				CourseImpl.class, courseId);

		if (course == _nullCourse) {
			return null;
		}

		if (course == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				course = (Course)session.get(CourseImpl.class,
						Long.valueOf(courseId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (course != null) {
					cacheResult(course);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
						CourseImpl.class, courseId, _nullCourse);
				}

				closeSession(session);
			}
		}

		return course;
	}

	/**
	 * Returns all the courses where instructorId = &#63;.
	 *
	 * @param instructorId the instructor ID
	 * @return the matching courses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Course> findByInstructorId(long instructorId)
		throws SystemException {
		return findByInstructorId(instructorId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Course> findByInstructorId(long instructorId, int start, int end)
		throws SystemException {
		return findByInstructorId(instructorId, start, end, null);
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
	public List<Course> findByInstructorId(long instructorId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTRUCTORID;
			finderArgs = new Object[] { instructorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTRUCTORID;
			finderArgs = new Object[] {
					instructorId,
					
					start, end, orderByComparator
				};
		}

		List<Course> list = (List<Course>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Course course : list) {
				if ((instructorId != course.getInstructorId())) {
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
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSE_WHERE);

			query.append(_FINDER_COLUMN_INSTRUCTORID_INSTRUCTORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(instructorId);

				list = (List<Course>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first course in the ordered set where instructorId = &#63;.
	 *
	 * @param instructorId the instructor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course
	 * @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course findByInstructorId_First(long instructorId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByInstructorId_First(instructorId,
				orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("instructorId=");
		msg.append(instructorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
	}

	/**
	 * Returns the first course in the ordered set where instructorId = &#63;.
	 *
	 * @param instructorId the instructor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course fetchByInstructorId_First(long instructorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Course> list = findByInstructorId(instructorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Course findByInstructorId_Last(long instructorId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByInstructorId_Last(instructorId, orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("instructorId=");
		msg.append(instructorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
	}

	/**
	 * Returns the last course in the ordered set where instructorId = &#63;.
	 *
	 * @param instructorId the instructor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course fetchByInstructorId_Last(long instructorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByInstructorId(instructorId);

		List<Course> list = findByInstructorId(instructorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Course[] findByInstructorId_PrevAndNext(long courseId,
		long instructorId, OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = findByPrimaryKey(courseId);

		Session session = null;

		try {
			session = openSession();

			Course[] array = new CourseImpl[3];

			array[0] = getByInstructorId_PrevAndNext(session, course,
					instructorId, orderByComparator, true);

			array[1] = course;

			array[2] = getByInstructorId_PrevAndNext(session, course,
					instructorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Course getByInstructorId_PrevAndNext(Session session,
		Course course, long instructorId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSE_WHERE);

		query.append(_FINDER_COLUMN_INSTRUCTORID_INSTRUCTORID_2);

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

		else {
			query.append(CourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(instructorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(course);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Course> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the courses where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching courses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Course> findByYear(int year) throws SystemException {
		return findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Course> findByYear(int year, int start, int end)
		throws SystemException {
		return findByYear(year, start, end, null);
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
	public List<Course> findByYear(int year, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year, start, end, orderByComparator };
		}

		List<Course> list = (List<Course>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Course course : list) {
				if ((year != course.getYear())) {
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
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSE_WHERE);

			query.append(_FINDER_COLUMN_YEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				list = (List<Course>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first course in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course
	 * @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course findByYear_First(int year, OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByYear_First(year, orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
	}

	/**
	 * Returns the first course in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course fetchByYear_First(int year,
		OrderByComparator orderByComparator) throws SystemException {
		List<Course> list = findByYear(year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Course findByYear_Last(int year, OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByYear_Last(year, orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
	}

	/**
	 * Returns the last course in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course fetchByYear_Last(int year, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByYear(year);

		List<Course> list = findByYear(year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Course[] findByYear_PrevAndNext(long courseId, int year,
		OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = findByPrimaryKey(courseId);

		Session session = null;

		try {
			session = openSession();

			Course[] array = new CourseImpl[3];

			array[0] = getByYear_PrevAndNext(session, course, year,
					orderByComparator, true);

			array[1] = course;

			array[2] = getByYear_PrevAndNext(session, course, year,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Course getByYear_PrevAndNext(Session session, Course course,
		int year, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSE_WHERE);

		query.append(_FINDER_COLUMN_YEAR_YEAR_2);

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

		else {
			query.append(CourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(course);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Course> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the courses where year = &#63; and semester = &#63;.
	 *
	 * @param year the year
	 * @param semester the semester
	 * @return the matching courses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Course> findByYearSemester(int year, int semester)
		throws SystemException {
		return findByYearSemester(year, semester, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Course> findByYearSemester(int year, int semester, int start,
		int end) throws SystemException {
		return findByYearSemester(year, semester, start, end, null);
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
	public List<Course> findByYearSemester(int year, int semester, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARSEMESTER;
			finderArgs = new Object[] { year, semester };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEARSEMESTER;
			finderArgs = new Object[] {
					year, semester,
					
					start, end, orderByComparator
				};
		}

		List<Course> list = (List<Course>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Course course : list) {
				if ((year != course.getYear()) ||
						(semester != course.getSemester())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_COURSE_WHERE);

			query.append(_FINDER_COLUMN_YEARSEMESTER_YEAR_2);

			query.append(_FINDER_COLUMN_YEARSEMESTER_SEMESTER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				qPos.add(semester);

				list = (List<Course>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first course in the ordered set where year = &#63; and semester = &#63;.
	 *
	 * @param year the year
	 * @param semester the semester
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course
	 * @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course findByYearSemester_First(int year, int semester,
		OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByYearSemester_First(year, semester,
				orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(", semester=");
		msg.append(semester);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
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
	public Course fetchByYearSemester_First(int year, int semester,
		OrderByComparator orderByComparator) throws SystemException {
		List<Course> list = findByYearSemester(year, semester, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Course findByYearSemester_Last(int year, int semester,
		OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByYearSemester_Last(year, semester,
				orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(", semester=");
		msg.append(semester);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
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
	public Course fetchByYearSemester_Last(int year, int semester,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByYearSemester(year, semester);

		List<Course> list = findByYearSemester(year, semester, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Course[] findByYearSemester_PrevAndNext(long courseId, int year,
		int semester, OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = findByPrimaryKey(courseId);

		Session session = null;

		try {
			session = openSession();

			Course[] array = new CourseImpl[3];

			array[0] = getByYearSemester_PrevAndNext(session, course, year,
					semester, orderByComparator, true);

			array[1] = course;

			array[2] = getByYearSemester_PrevAndNext(session, course, year,
					semester, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Course getByYearSemester_PrevAndNext(Session session,
		Course course, int year, int semester,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSE_WHERE);

		query.append(_FINDER_COLUMN_YEARSEMESTER_YEAR_2);

		query.append(_FINDER_COLUMN_YEARSEMESTER_SEMESTER_2);

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

		else {
			query.append(CourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(year);

		qPos.add(semester);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(course);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Course> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the courses where courseCatalogId = &#63;.
	 *
	 * @param courseCatalogId the course catalog ID
	 * @return the matching courses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Course> findByCourseCatalogId(long courseCatalogId)
		throws SystemException {
		return findByCourseCatalogId(courseCatalogId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Course> findByCourseCatalogId(long courseCatalogId, int start,
		int end) throws SystemException {
		return findByCourseCatalogId(courseCatalogId, start, end, null);
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
	public List<Course> findByCourseCatalogId(long courseCatalogId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSECATALOGID;
			finderArgs = new Object[] { courseCatalogId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSECATALOGID;
			finderArgs = new Object[] {
					courseCatalogId,
					
					start, end, orderByComparator
				};
		}

		List<Course> list = (List<Course>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Course course : list) {
				if ((courseCatalogId != course.getCourseCatalogId())) {
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
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSE_WHERE);

			query.append(_FINDER_COLUMN_COURSECATALOGID_COURSECATALOGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseCatalogId);

				list = (List<Course>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first course in the ordered set where courseCatalogId = &#63;.
	 *
	 * @param courseCatalogId the course catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course
	 * @throws com.liferay.live.sb.demo.NoSuchCourseException if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course findByCourseCatalogId_First(long courseCatalogId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByCourseCatalogId_First(courseCatalogId,
				orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseCatalogId=");
		msg.append(courseCatalogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
	}

	/**
	 * Returns the first course in the ordered set where courseCatalogId = &#63;.
	 *
	 * @param courseCatalogId the course catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course fetchByCourseCatalogId_First(long courseCatalogId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Course> list = findByCourseCatalogId(courseCatalogId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Course findByCourseCatalogId_Last(long courseCatalogId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByCourseCatalogId_Last(courseCatalogId,
				orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseCatalogId=");
		msg.append(courseCatalogId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
	}

	/**
	 * Returns the last course in the ordered set where courseCatalogId = &#63;.
	 *
	 * @param courseCatalogId the course catalog ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course, or <code>null</code> if a matching course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course fetchByCourseCatalogId_Last(long courseCatalogId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseCatalogId(courseCatalogId);

		List<Course> list = findByCourseCatalogId(courseCatalogId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Course[] findByCourseCatalogId_PrevAndNext(long courseId,
		long courseCatalogId, OrderByComparator orderByComparator)
		throws NoSuchCourseException, SystemException {
		Course course = findByPrimaryKey(courseId);

		Session session = null;

		try {
			session = openSession();

			Course[] array = new CourseImpl[3];

			array[0] = getByCourseCatalogId_PrevAndNext(session, course,
					courseCatalogId, orderByComparator, true);

			array[1] = course;

			array[2] = getByCourseCatalogId_PrevAndNext(session, course,
					courseCatalogId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Course getByCourseCatalogId_PrevAndNext(Session session,
		Course course, long courseCatalogId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSE_WHERE);

		query.append(_FINDER_COLUMN_COURSECATALOGID_COURSECATALOGID_2);

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

		else {
			query.append(CourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseCatalogId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(course);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Course> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the courses.
	 *
	 * @return the courses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Course> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Course> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Course> findAll(int start, int end,
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

		List<Course> list = (List<Course>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSE.concat(CourseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the courses where instructorId = &#63; from the database.
	 *
	 * @param instructorId the instructor ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByInstructorId(long instructorId)
		throws SystemException {
		for (Course course : findByInstructorId(instructorId)) {
			remove(course);
		}
	}

	/**
	 * Removes all the courses where year = &#63; from the database.
	 *
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByYear(int year) throws SystemException {
		for (Course course : findByYear(year)) {
			remove(course);
		}
	}

	/**
	 * Removes all the courses where year = &#63; and semester = &#63; from the database.
	 *
	 * @param year the year
	 * @param semester the semester
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByYearSemester(int year, int semester)
		throws SystemException {
		for (Course course : findByYearSemester(year, semester)) {
			remove(course);
		}
	}

	/**
	 * Removes all the courses where courseCatalogId = &#63; from the database.
	 *
	 * @param courseCatalogId the course catalog ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCourseCatalogId(long courseCatalogId)
		throws SystemException {
		for (Course course : findByCourseCatalogId(courseCatalogId)) {
			remove(course);
		}
	}

	/**
	 * Removes all the courses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Course course : findAll()) {
			remove(course);
		}
	}

	/**
	 * Returns the number of courses where instructorId = &#63;.
	 *
	 * @param instructorId the instructor ID
	 * @return the number of matching courses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByInstructorId(long instructorId) throws SystemException {
		Object[] finderArgs = new Object[] { instructorId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_INSTRUCTORID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_WHERE);

			query.append(_FINDER_COLUMN_INSTRUCTORID_INSTRUCTORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(instructorId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INSTRUCTORID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of courses where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching courses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByYear(int year) throws SystemException {
		Object[] finderArgs = new Object[] { year };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_YEAR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_WHERE);

			query.append(_FINDER_COLUMN_YEAR_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_YEAR,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of courses where year = &#63; and semester = &#63;.
	 *
	 * @param year the year
	 * @param semester the semester
	 * @return the number of matching courses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByYearSemester(int year, int semester)
		throws SystemException {
		Object[] finderArgs = new Object[] { year, semester };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_YEARSEMESTER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSE_WHERE);

			query.append(_FINDER_COLUMN_YEARSEMESTER_YEAR_2);

			query.append(_FINDER_COLUMN_YEARSEMESTER_SEMESTER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				qPos.add(semester);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_YEARSEMESTER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of courses where courseCatalogId = &#63;.
	 *
	 * @param courseCatalogId the course catalog ID
	 * @return the number of matching courses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCourseCatalogId(long courseCatalogId)
		throws SystemException {
		Object[] finderArgs = new Object[] { courseCatalogId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COURSECATALOGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_WHERE);

			query.append(_FINDER_COLUMN_COURSECATALOGID_COURSECATALOGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseCatalogId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSECATALOGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COURSE);

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
	 * Initializes the course persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.live.sb.demo.model.Course")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Course>> listenersList = new ArrayList<ModelListener<Course>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Course>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseImpl.class.getName());
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
	private static final String _SQL_SELECT_COURSE = "SELECT course FROM Course course";
	private static final String _SQL_SELECT_COURSE_WHERE = "SELECT course FROM Course course WHERE ";
	private static final String _SQL_COUNT_COURSE = "SELECT COUNT(course) FROM Course course";
	private static final String _SQL_COUNT_COURSE_WHERE = "SELECT COUNT(course) FROM Course course WHERE ";
	private static final String _FINDER_COLUMN_INSTRUCTORID_INSTRUCTORID_2 = "course.instructorId = ?";
	private static final String _FINDER_COLUMN_YEAR_YEAR_2 = "course.year = ?";
	private static final String _FINDER_COLUMN_YEARSEMESTER_YEAR_2 = "course.year = ? AND ";
	private static final String _FINDER_COLUMN_YEARSEMESTER_SEMESTER_2 = "course.semester = ?";
	private static final String _FINDER_COLUMN_COURSECATALOGID_COURSECATALOGID_2 =
		"course.courseCatalogId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "course.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Course exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Course exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CoursePersistenceImpl.class);
	private static Course _nullCourse = new CourseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Course> toCacheModel() {
				return _nullCourseCacheModel;
			}
		};

	private static CacheModel<Course> _nullCourseCacheModel = new CacheModel<Course>() {
			public Course toEntityModel() {
				return _nullCourse;
			}
		};
}