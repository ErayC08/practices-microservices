package com.example.model;

import java.time.LocalDate;

public class AssignmentDetails {
    private Student assignee;
    private LocalDate dueDate;

    public AssignmentDetails(Student assignee, LocalDate dueDate) {
        setAssignee(assignee);
        setDueDate(dueDate);
    }

    public Student getAssignee() {
        return assignee;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    private void setAssignee(Student assignee) {
        this.assignee = assignee;
    }

    private void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
