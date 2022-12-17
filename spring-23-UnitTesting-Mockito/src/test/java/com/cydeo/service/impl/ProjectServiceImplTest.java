package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test(){

        //GIVEN - PREPARATION
        //stubbing - defining behavior (when), and returning result (then):
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project());
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        //WHEN - REAL ACTION
        //calling the method, which we want to test
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());


        //THEN - VERIFICATION (RESULT)
        //checking the order of these two mocks
        InOrder inOrder = inOrder(projectRepository, projectMapper);
        //providing the order, in which two mocks should be executed
        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO);

    }

    @Test
    void getByProjectCode_ExceptionTest(){

        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));

        Throwable throwable = assertThrows(NoSuchElementException.class, ()-> projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode("");
        verify(projectMapper, never()).convertToDto(any(Project.class));    //would NEVER run, because the exception should have been thrown before it

        assertEquals("Project not found", throwable.getMessage());

    }


}