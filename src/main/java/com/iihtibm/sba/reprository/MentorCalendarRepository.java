package com.iihtibm.sba.reprository;

import java.util.List;

import com.iihtibm.sba.entity.MentorCalendar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author savagelee
 */
public interface MentorCalendarRepository extends PagingAndSortingRepository<MentorCalendar, Long> {


	String findMentorCalendarByMentorId = "SELECT * FROM Mentor_Calendar mc "
			+ "WHERE mc.mentor_id=?1 AND (mc.start_date BETWEEN ?2 AND ?3 AND mc.end_date BETWEEN ?2 AND ?3) ";
	@Query(value = findMentorCalendarByMentorId + " ORDER BY mc.start_date", 
			nativeQuery = true)
	List<MentorCalendar> findMentorCalendarByMentorId(Long mentorId, String startDate, String endDate);

	@Query(value = "SELECT * FROM Mentor_Calendar mc " 
	        + "WHERE mc.mentor_id=?1 AND "
			+ "(mc.start_date BETWEEN ?2 AND ?3 AND mc.end_date BETWEEN ?2 AND ?3) AND "
			+ "(mc.start_time BETWEEN ?4 AND ?5 AND mc.end_time BETWEEN ?4 AND ?5) ", 
			nativeQuery = true)
	List<MentorCalendar> findCalendarEntry(Long mentorId, String startDate, String endDate, String startTime, String endTime);

}
