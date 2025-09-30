package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_course_sections</b>.
 * <p>
 * Lưu thông tin về các section trong khóa học Moodle.
 * Mỗi {@link CourseSections} thuộc về duy nhất một {@link Course} và có thể chứa nhiều {@link CourseModules}.
 * </p>
 *
 * <ul>
 *   <li><b>course</b>: ID khóa học mà section này thuộc về.</li>
 *   <li><b>section</b>: số thứ tự section trong khóa học.</li>
 *   <li><b>name</b>: tên của section.</li>
 *   <li><b>summary</b>: mô tả tóm tắt của section.</li>
 *   <li><b>summaryformat</b>: định dạng mô tả (ví dụ: HTML, plain text).</li>
 *   <li><b>sequence</b>: chuỗi các module trong section, phân tách bằng dấu phẩy.</li>
 *   <li><b>visible</b>: trạng thái hiển thị của section (1 = visible, 0 = hidden).</li>
 *   <li><b>availability</b>: quy tắc khả dụng của section.</li>
 *   <li><b>timemodified</b>: timestamp lần chỉnh sửa cuối cùng.</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link CourseModules}: Danh sách các module thuộc section này.</li>
 *   <li>{@link Course}: Khóa học chứa section này.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Table(name = "course_sections")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CourseSections {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ID khóa học mà section này thuộc về. */
//    private Long course;

    /** Số thứ tự section trong khóa học. */
    private Long section;

    /** Tên của section. */
    private String name;

    /** Mô tả tóm tắt của section. */
    private String summary;

    /** Định dạng mô tả (ví dụ: HTML, plain text). */
    private Integer summaryformat;

    /** Chuỗi các module trong section, phân tách bằng dấu phẩy. */
    private String sequence;

    /** Trạng thái hiển thị của section (1 = visible, 0 = hidden). */
    private Integer visible;

    /** Quy tắc khả dụng của section. */
    private String availability;

    /** Timestamp lần chỉnh sửa cuối cùng. */
    private Long timemodified;

    /** Danh sách các module thuộc section này. */
    @OneToMany(mappedBy = "courseSections")
    private List<CourseModules> courseModules;

    /** Khóa học chứa section này. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    private Course courseEntity;
}
