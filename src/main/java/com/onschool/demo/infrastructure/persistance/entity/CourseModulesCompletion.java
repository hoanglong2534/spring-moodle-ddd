package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity ánh xạ bảng <b>mdl_course_modules_completion</b> trong Moodle.
 * <p>
 * Bảng này lưu trạng thái hoàn thành (completion) của từng học viên đối với
 * một activity hoặc resource trong khóa học (được quản lý qua {@link CourseModules}).
 * Dữ liệu này phục vụ cho tính năng "Completion tracking" trong Moodle.
 * </p>
 *
 * <h3>Các cột chính:</h3>
 * <ul>
 *   <li><b>coursemoduleid</b>: ID của {@link CourseModules} (module cụ thể trong khóa học).</li>
 *   <li><b>userid</b>: ID người dùng được theo dõi.</li>
 *   <li><b>completionstate</b>: Trạng thái hoàn thành (0 = chưa hoàn thành, 1 = hoàn thành thủ công, 2 = hoàn thành tự động).</li>
 *   <li><b>viewed</b>: Đánh dấu xem (1 nếu học viên đã mở activity).</li>
 *   <li><b>overrideby</b>: ID người đã ghi đè trạng thái (thường là giáo viên hoặc quản trị viên).</li>
 *   <li><b>timemodified</b>: Thời gian cập nhật trạng thái gần nhất (timestamp).</li>
 * </ul>
 *
 * <h3>Quan hệ:</h3>
 * <ul>
 *   <li>N-N (thông qua entity này) giữa {@link User} và {@link CourseModules}.</li>
 *   <li>Nhiều bản ghi thuộc về một {@link CourseModules} (ManyToOne).</li>
 *   <li>Nhiều bản ghi thuộc về một {@link User} (ManyToOne).</li>
 * </ul>
 *
 * @author Hoang
 */
@Table(name = "course_modules_completion")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseModulesCompletion {

    /** Khóa chính tự tăng. */
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    /** ID của course module trong bảng {@link CourseModules}. */
//    private Long coursemoduleid;

    /** ID người dùng (học viên). */
//    private Long userid;

    /** Trạng thái hoàn thành (0 = chưa, 1 = hoàn thành, 2 = tự động...). */
    private Integer completionstate;

    /** Đã xem activity hay chưa (1 = đã xem, 0 = chưa). */
    private Integer viewed;

    /** Người ghi đè trạng thái (ID user). */
    private Long overrideby;

    /** Thời gian cập nhật trạng thái gần nhất (timestamp). */
    private Long timemodified;

    /** Quan hệ N-1 tới {@link CourseModules}. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coursemoduleid")
    private CourseModules courseModules;

    /** Quan hệ N-1 tới {@link User}. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;
}
