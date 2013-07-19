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

package com.liferay.live.sb.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.live.sb.demo.model.Course;
import com.liferay.live.sb.demo.model.CourseStudent;
import com.liferay.live.sb.demo.model.Student;
import com.liferay.live.sb.demo.model.StudentGPA;
import com.liferay.live.sb.demo.model.impl.StudentGPAImpl;
import com.liferay.live.sb.demo.service.base.StudentGPALocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the student g p a local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.live.sb.demo.service.StudentGPALocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author dnebinger
 * @see com.liferay.live.sb.demo.service.base.StudentGPALocalServiceBaseImpl
 * @see com.liferay.live.sb.demo.service.StudentGPALocalServiceUtil
 */
public class StudentGPALocalServiceImpl extends StudentGPALocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link com.liferay.live.sb.demo.service.StudentGPALocalServiceUtil} to access the student g p a local service.
	 */
	private static final Log logger = LogFactoryUtil.getLog(StudentGPALocalServiceImpl.class);

	private static final Double A = 95.0;

	private static final Double A_Minus = 92.0;

	private static final Double B_Plus = 88.0;

	private static final Double B = 85.0;

	private static final Double B_Minus = 82.0;

	private static final Double C_Plus = 78.0;

	private static final Double C = 75.0;

	private static final Double C_Minus = 72.0;

	private static final Double D_Plus = 68.0;

	private static final Double D = 65.0;

	private static final Double D_Minus = 62.0;

	private static final Double A_Pts = 4.0;

	private static final Double A_Minus_Pts = 3.7;

	private static final Double B_Plus_Pts = 3.33;

	private static final Double B_Pts = 3.0;

	private static final Double B_Minus_Pts = 2.7;

	private static final Double C_Plus_Pts = 2.3;

	private static final Double C_Pts = 2.0;

	private static final Double C_Minus_Pts = 1.7;

	private static final Double D_Plus_Pts = 1.3;

	private static final Double D_Pts = 1.0;

	private static final Double D_Minus_Pts = 0.7;

	/**
	 * getStudentGPA: Returns the gpa for the given student in the given class.
	 * 
	 * @param courseId
	 * @param studentId
	 * @return StudentGPA The gpa or <code>null</code> if it could not be calculated.
	 */
	public StudentGPA getStudentGPA(final long courseId, final long studentId) {
		final StudentGPA gpa = new StudentGPAImpl();

		// okay, we need the course student record...
		final CourseStudent cs = courseStudentLocalService.getCourseStudent(courseId, studentId);

		if (cs == null) {
			return null;
		}

		Course course = null;
		Student student = null;

		try {
			course = courseLocalService.getCourse(courseId);
		} catch (final PortalException e) {
			logger.error("Error retrieving course: " + e.getMessage(), e);
		} catch (final SystemException e) {
			logger.error("Error retrieving course: " + e.getMessage(), e);
		}

		try {
			student = studentLocalService.getStudent(studentId);
		} catch (final PortalException e) {
			logger.error("Error retrieving student: " + e.getMessage(), e);
		} catch (final SystemException e) {
			logger.error("Error retrieving student: " + e.getMessage(), e);
		}

		if (course == null) {
			return null;
		}
		if (student == null) {
			return null;
		}

		// have the course and the grade, calculate the gpa...
		final double points = getPoints(cs.getGrade());
		final double creditHours = course.getCreditHours();

		// gpa = (points * creditHours) / creditHours
		// Since we only have one course, gpa will be either points or zero if no credit hours.
		if (creditHours > 0) {
			gpa.setGpa(points);
		} else {
			gpa.setGpa(0.0);
		}

		gpa.setName(student.getName());
		gpa.setSemester(course.getSemester());
		gpa.setStudentId(studentId);
		gpa.setYear(course.getYear());
		gpa.setGradePoints(points * creditHours);
		gpa.setCreditHours(course.getCreditHours());
		gpa.setLetterGrade(getLetterGrade(gpa.getGpa()));

		return gpa;
	}

	/**
	 * getStudentGPA: Returns the student gpa for the given student.
	 * 
	 * @param studentId Student to get the gpa for.
	 * @return StudentGPA The gpa or <code>null</code> if one could not be calculated.
	 */
	public StudentGPA getStudentGPA(final long studentId) {
		List<CourseStudent> courseStudents = null;

		try {
			courseStudents = courseStudentLocalService.findByStudentId(studentId);
		} catch (final SystemException e) {
			logger.error("Error retrieving course students: " + e.getMessage(), e);
		}

		if ((courseStudents == null) || (courseStudents.isEmpty())) {
			return null;
		}

		final StudentGPA gpa = new StudentGPAImpl();

		final List<StudentGPA> courseGPAs = new ArrayList(courseStudents.size());
		StudentGPA x;

		for (final CourseStudent cs : courseStudents) {
			x = getStudentGPA(cs.getCourseId(), studentId);

			if (x != null) {
				courseGPAs.add(x);
			}
		}

		if (courseGPAs.isEmpty()) {
			return null;
		}

		gpa.setStudentId(studentId);

		boolean first = true;
		int totalCreditHours = 0;
		double totalGradePoints = 0.0;

		for (final StudentGPA y : courseGPAs) {
			if (first) {
				// capture the student name while we have the record...
				gpa.setName(y.getName());
				first = false;
			}

			totalCreditHours += y.getCreditHours();
			totalGradePoints += y.getGradePoints();
		}

		gpa.setCreditHours(totalCreditHours);
		gpa.setGradePoints(totalGradePoints);

		if (totalCreditHours > 0) {
			// calculate the gpa, multiply by 100 so we can truncate...
			Double val = (totalGradePoints / totalCreditHours) * 100.0;
			final int ival = val.intValue();

			val = Double.valueOf(ival);
			val = val / 100.0;

			gpa.setGpa(val);
		} else {
			gpa.setGpa(0.0);
		}
		gpa.setLetterGrade(getLetterGrade(gpa.getGpa()));

		return gpa;
	}

	/**
	 * getAllStudentGPAs: Returns the list of gpas for all students.
	 * 
	 * @return List The list of gpas.
	 */
	public List<StudentGPA> getAllStudentGPAs() {
		List<Student> studs = null;

		try {
			studs = studentLocalService.getStudents(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (final SystemException e) {
			logger.error("Error retrieving students: " + e.getMessage(), e);
		}

		if ((studs == null) || (studs.isEmpty())) {
			return null;
		}

		final List<StudentGPA> gpas = new ArrayList(studs.size());
		StudentGPA gpa;

		for (final Student stud : studs) {
			gpa = getStudentGPA(stud.getStudentId());

			if (gpa == null) {
				// no gpa for this student, perhaps no courses taken.
				gpa = new StudentGPAImpl();

				gpa.setStudentId(stud.getStudentId());
				gpa.setName(stud.getName());

				gpa.setCreditHours(0);
				gpa.setGradePoints(0.0);
				gpa.setGpa(0.0);
			}

			gpa.setLetterGrade(getLetterGrade(gpa.getGpa()));

			if (gpa.getCreditHours() == 0) {
				gpa.setLetterGrade("n/a");
			}

			gpas.add(gpa);
		}

		return gpas;
	}

	/**
	 * getPoints: Returns the points for the given grade.
	 * 
	 * @param grade
	 * @return double The points.
	 */
	public double getPoints(final double grade) {

		if (A.compareTo(grade) <= 0) {
			return A_Pts;
		}
		if (A_Minus.compareTo(grade) <= 0) {
			return A_Minus_Pts;
		}
		if (B_Plus.compareTo(grade) <= 0) {
			return B_Plus_Pts;
		}
		if (B.compareTo(grade) <= 0) {
			return B_Pts;
		}
		if (B_Minus.compareTo(grade) <= 0) {
			return B_Minus_Pts;
		}
		if (C_Plus.compareTo(grade) <= 0) {
			return C_Plus_Pts;
		}
		if (C.compareTo(grade) <= 0) {
			return C_Pts;
		}
		if (C_Minus.compareTo(grade) <= 0) {
			return C_Minus_Pts;
		}
		if (D_Plus.compareTo(grade) <= 0) {
			return D_Plus_Pts;
		}
		if (D.compareTo(grade) <= 0) {
			return D_Pts;
		}
		if (D_Minus.compareTo(grade) <= 0) {
			return D_Minus_Pts;
		}

		return 0.0;
	}

	/**
	 * getLetterGrade: Returns the letter grade for the given gpa value.
	 * 
	 * @param gpa
	 * @return String The letter grade.
	 */
	public String getLetterGrade(final double gpa) {

		if (A_Pts.compareTo(gpa) <= 0) {
			return "A";
		}
		if (A_Minus_Pts.compareTo(gpa) <= 0) {
			return "A-";
		}
		if (B_Plus_Pts.compareTo(gpa) <= 0) {
			return "B+";
		}
		if (B_Pts.compareTo(gpa) <= 0) {
			return "B";
		}
		if (B_Minus_Pts.compareTo(gpa) <= 0) {
			return "B-";
		}
		if (C_Plus_Pts.compareTo(gpa) <= 0) {
			return "C+";
		}
		if (C_Pts.compareTo(gpa) <= 0) {
			return "C";
		}
		if (C_Minus_Pts.compareTo(gpa) <= 0) {
			return "C-";
		}
		if (D_Plus_Pts.compareTo(gpa) <= 0) {
			return "D+";
		}
		if (D_Pts.compareTo(gpa) <= 0) {
			return "D";
		}
		if (D_Minus_Pts.compareTo(gpa) <= 0) {
			return "D-";
		}

		return "F";
	}
}
