package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity đại diện cho bảng <b>mdl_course_completions</b>.
 * <p>
 * Lưu thông tin về hoàn thành khóa học của người dùng trong Moodle.
 * Mỗi {@link CourseCompletions} liên kết với một {@link Course} và một {@link User}.
 * </p>
 *
 * <ul>
 *   <li><b>userid</b>: ID người dùng.</li>
 *   <li><b>course</b>: ID khóa học mà người dùng hoàn thành.</li>
 *   <li><b>timeenrolled</b>: thời điểm người dùng đăng ký khóa học (timestamp).</li>
 *   <li><b>timecompleted</b>: thời điểm hoàn thành khóa học (timestamp).</li>
 *   <li><b>reaggregate</b>: cờ đánh dấu liệu có cần tính toán lại tiến trình hoàn thành.</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link Course}: Khóa học mà bản ghi hoàn thành này áp dụng.</li>
 *   <li>{@link User}: Người dùng đã hoàn thành khóa học.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Table(name = "course_completions")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseCompletions {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID người dùng. */
//    private Long userid;
//
//    /** ID khóa học mà người dùng hoàn thành. */
//    private Long course;

    /** Thời điểm người dùng đăng ký khóa học (timestamp). */
    private Long timeenrolled;

    /** Thời điểm hoàn thành khóa học (timestamp). */
    private Long timecompleted;

    /** Cờ đánh dấu liệu có cần tính toán lại tiến trình hoàn thành. */
    private Long reaggregate;

    /** Khóa học mà bản ghi hoàn thành này áp dụng. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    private Course courseEntity;

    /** Người dùng đã hoàn thành khóa học. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;
}
