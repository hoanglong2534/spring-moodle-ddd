package com.onschool.demo.domain.enrollment;

public class ProgressDomain {

    private final Long id;
    private final Long enrollmentId;
    private final Long courseModuleId;
    private Boolean completed;

    public ProgressDomain(Long id, Long enrollmentId, Long courseModuleId, Boolean completed) {
        this.id = id;
        this.enrollmentId = enrollmentId;
        this.courseModuleId = courseModuleId;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public Long getCourseModuleId() {
        return courseModuleId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public void markIncomplete() {
        this.completed = false;
    }
}
