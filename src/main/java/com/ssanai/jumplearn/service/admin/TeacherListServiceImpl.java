package com.ssanai.jumplearn.service.admin;

import com.ssanai.jumplearn.dto.*;
import com.ssanai.jumplearn.mapper.admin.TeacherListMapper;
import com.ssanai.jumplearn.vo.TeacherVO;
import jdk.jfr.Label;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class TeacherListServiceImpl implements TeacherListServiceIf{
    private final TeacherListMapper teacherListXmlMapper;
    private final ModelMapper modelMapper;

    @Override
    public int teacherTotalCount(PageRequestDTO requestDTO) {
        return teacherListXmlMapper.teacherTotalCount(requestDTO);
    }

    @Override
    public int teacherDelete(String id) {
        int rs = teacherListXmlMapper.teacherDelete(id);
        return rs;
    }

    @Override
    public int teacherChange(String id, int status) {
        int rs = teacherListXmlMapper.teacherChange(id, status);
        return rs;
    }

    @Override
    public int teacherCreate(TeacherDTO teacherDTO) {
        TeacherVO teacherVO = modelMapper.map(teacherDTO, TeacherVO.class);
        int rs = teacherListXmlMapper.teacherCreate(teacherVO);
        return rs;
    }

    @Override
    public PageResponseDTO<TeacherDTO> searchList(PageRequestDTO requestDTO) {
        // 조건에 따른 DB 조회
        int totalCount = teacherListXmlMapper.teacherTotalCount(requestDTO);
        List<TeacherDTO> teacherList = teacherListXmlMapper.searchList(requestDTO);
        // VO --> DTO 객체 매핑
        List<TeacherDTO> bbsDTOList =
                teacherList.stream().map(
                        vo->modelMapper.map(vo, TeacherDTO.class)
                ).collect(Collectors.toList());

        // DTO 객체 + UI 제어위한 파라미터 매핑
        PageResponseDTO<TeacherDTO> responseDTO =
                PageResponseDTO
                        .<TeacherDTO>withAll()
                        .reqDTO(requestDTO)
                        .dtoList(bbsDTOList)
                        .total_count(totalCount)
                        .build();
        return responseDTO;
    }

    @Override
    public TeacherDTO teacherDetail(String id) {
        return teacherListXmlMapper.teacherDetail(id);
    }

    @Override
    public List<TeacherClassDTO> teacherClass(String id) {
        List<TeacherClassDTO> dtoList = teacherListXmlMapper.teacherClass(id);
        return dtoList ;
    }
}
