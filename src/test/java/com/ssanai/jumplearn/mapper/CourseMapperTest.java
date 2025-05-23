package com.ssanai.jumplearn.mapper;

import com.ssanai.jumplearn.dto.ClassDetailDTO;
import com.ssanai.jumplearn.dto.ClassVideoDTO;
import com.ssanai.jumplearn.dto.ReviewDTO;
import com.ssanai.jumplearn.dto.course.SearchDTO;
import com.ssanai.jumplearn.dto.mainpage.ClassDTO;
import com.ssanai.jumplearn.mapper.course.CourseMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class CourseMapperTest {
	@Autowired(required = false)
	CourseMapper courseMapper;

	@Test
	public void getClassListTest() {
		List<ClassDTO> classList = courseMapper.getClassList(new SearchDTO());
		for (ClassDTO classDTO : classList) {
			log.info(classDTO);
		}
	}

	@Test
	public void getSearchListTest1() {
		List<ClassDTO> classList = courseMapper.getClassList(
				SearchDTO.builder()
						.search_word("강사")
						.search_condition1("강사")
						.search_condition2("고2")
						.build()
		);
		for (ClassDTO classDTO : classList) {
			log.info(classDTO);
		}
	}

	@Test
	public void getSearchListTest2() {
		List<ClassDTO> classList = courseMapper.getClassList(
				SearchDTO.builder()
						.search_word("강사")
						.search_condition1("강사")
						.search_condition2("고2")
						.sort_condition("recently")
						.build()
		);
		for (ClassDTO classDTO : classList) {
			log.info(classDTO);
		}
	}

	@Test
	public void getSearchListTest3() {
		List<ClassDTO> classList = courseMapper.getClassList(
				SearchDTO.builder()
						.search_condition1("제목")
						.sort_condition("higher_price")
						.build()
		);
		for (ClassDTO classDTO : classList) {
			log.info(classDTO);
		}
	}

	@Test
	public void getSearchListTest4() {
		List<ClassDTO> classList = courseMapper.getClassList(
				SearchDTO.builder()
						.search_condition1("제목")
						.sort_condition("lower_price")
						.build()
		);
		for (ClassDTO classDTO : classList) {
			log.info(classDTO);
		}
	}

	@Test
	public void getSearchListTest5() {
		List<ClassDTO> classList = courseMapper.getClassList(
				new SearchDTO(1, 10, 0, 10, null, null, null, null, null)
		);

		for (ClassDTO classDTO : classList) {
			log.info(classDTO);
		}
	}

	@Test
	public void getListTotalCountTest() {
		int total_count = courseMapper.getListTotalCount(
				SearchDTO.builder()
						.search_condition1("제목")
						.sort_condition("lower_price")
						.build()
		);
		log.info(total_count);
	}

	@Test
	public void getClassDetailByIdTest() {
		ClassDetailDTO classDetail = courseMapper.getClassDetailById(27);
		log.info(classDetail);
	}

	@Test
	public void getReviewListByIdTest(){
		List<ReviewDTO> reviewList = courseMapper.getReviewListById(6);
		for (ReviewDTO reviewDTO : reviewList) {
			log.info(reviewDTO);
		}
	}

	@Test
	public void getClassVideoListTest(){
		List<ClassVideoDTO> classVideoList = courseMapper.getClassVideoList(6);
		for (ClassVideoDTO classVideoDTO : classVideoList) {
			log.info(classVideoDTO);
		}
	}

	@Test
	public void getReviewRateTest(){
		double rate = courseMapper.getReviewRate(6);
		log.info(rate);
	}

	@Test
	public void getReviewRateTest2(){
		int review_count = courseMapper.checkReviewExist(105);
		if(review_count > 0){
			double rate = courseMapper.getReviewRate(105);
			log.info(rate);
		} else {
			log.info("No Review");
		}
	}
}
