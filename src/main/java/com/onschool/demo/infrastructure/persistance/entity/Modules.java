package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * Entity đại diện cho bảng <b>mdl_modules</b>.
 * <p>
 * Lưu thông tin về các loại module trong Moodle (ví dụ: assignment, quiz, url, label...).
 * Mỗi {@link Modules} có thể liên kết với nhiều {@link CourseModules}.
 * </p>
 *
 * <ul>
 *   <li><b>name</b>: tên loại module.</li>
 *   <li><b>cron</b>: khoảng thời gian cron chạy cho module (timestamp hoặc số giây).</li>
 *   <li><b>lastcron</b>: thời điểm cron chạy lần cuối.</li>
 *   <li><b>search</b>: thông tin hỗ trợ tìm kiếm module.</li>
 *   <li><b>visible</b>: trạng thái hiển thị của loại module.</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link CourseModules}: Danh sách các module thuộc loại này.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Table(name = "modules")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Modules {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Tên loại module (ví dụ: "assignment", "quiz"). */
    private String name;

    /** Khoảng thời gian cron chạy cho module (có thể là timestamp hoặc số giây). */
    private Long cron;

    /** Thời điểm cron chạy lần cuối. */
    private Long lastcron;

    /** Thông tin hỗ trợ tìm kiếm module. */
    private String search;

    /** Trạng thái hiển thị của module (1 = visible, 0 = hidden). */
    private Integer visible;

    /** Danh sách các course module thuộc loại này. */
    @OneToMany(mappedBy = "modules")
    private Set<CourseModules> courseModulesList;
}
