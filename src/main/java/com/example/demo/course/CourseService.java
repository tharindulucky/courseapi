package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses(){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
       return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(String id, Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getCoursesByTopicId(String topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }
}
