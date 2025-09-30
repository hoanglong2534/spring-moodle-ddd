package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity đại diện cho bảng <b>mdl_label</b>.
 * <p>
 * Label là một <b>tài nguyên đơn giản</b> trong Moodle,
 * thường được dùng để chèn văn bản, hình ảnh hoặc HTML trực tiếp vào trang khóa học.
 * Nó không phải là hoạt động (activity) nhưng giúp giảng viên tổ chức và trình bày nội dung.
 * </p>
 *
 * <h3>Các cột chính:</h3>
 * <ul>
 *   <li><b>course</b>: ID khóa học mà label này thuộc về.</li>
 *   <li><b>name</b>: Tên của label (thường dùng để quản lý).</li>
 *   <li><b>intro</b>: Nội dung chính hiển thị (có thể chứa HTML, văn bản, hình ảnh...).</li>
 *   <li><b>introformat</b>: Định dạng của nội dung intro (plain text, HTML...).</li>
 *   <li><b>timemodified</b>: Thời điểm chỉnh sửa lần cuối (timestamp).</li>
 * </ul>
 *
 * <h3>Quan hệ:</h3>
 * <ul>
 *   <li>Mỗi {@link Label} được gắn với một {@link CourseModules} (1-1),
 *       thông qua khóa ngoại <b>course</b>.</li>
 * </ul>
 *
 * @author Hoang
 */
@Table(name = "label")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Label {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID khóa học mà label này thuộc về. */
//    private Long course;

    /** Tên của label. */
    private String name;

    /** Nội dung chính của label (có thể chứa HTML hoặc văn bản). */
    private String intro;

    /** Định dạng của intro (plain text, HTML...). */
    private Integer introformat;

    /** Thời gian chỉnh sửa lần cuối (timestamp). */
    private Long timemodified;

    /**
     * Quan hệ 1-1 với {@link CourseModules}.
     * Liên kết qua trường <b>course</b>.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    private CourseModules courseModules;
}
