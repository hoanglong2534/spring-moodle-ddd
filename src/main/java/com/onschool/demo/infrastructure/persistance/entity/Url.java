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
 * Entity ánh xạ bảng <b>mdl_url</b> trong Moodle.
 * <p>
 * Resource URL là một loại tài nguyên trong Moodle,
 * cho phép giảng viên thêm liên kết (URL) bên ngoài vào khóa học.
 * Ví dụ: link đến website, tài liệu trực tuyến, video YouTube, Google Drive, v.v.
 * </p>
 *
 * <h3>Các cột chính:</h3>
 * <ul>
 *   <li><b>course</b>: ID khóa học chứa URL này.</li>
 *   <li><b>name</b>: Tên hiển thị của URL (ví dụ: "Xem tài liệu trên Google Drive").</li>
 *   <li><b>intro</b>: Mô tả hoặc nội dung giới thiệu về URL (có thể chứa HTML).</li>
 *   <li><b>introformat</b>: Định dạng của intro (plain text, HTML...).</li>
 *   <li><b>externalurl</b>: Liên kết ngoài thực tế.</li>
 *   <li><b>display</b>: Cách hiển thị URL (ví dụ: trong cửa sổ mới, nhúng iframe...).</li>
 *   <li><b>displayoptions</b>: Các tùy chọn hiển thị (JSON/serialized options).</li>
 *   <li><b>parameters</b>: Tham số bổ sung gắn kèm khi mở URL.</li>
 *   <li><b>timemodified</b>: Thời gian cập nhật gần nhất (timestamp).</li>
 * </ul>
 *
 * <h3>Quan hệ:</h3>
 * <ul>
 *   <li>Quan hệ 1-1 với {@link CourseModules},
 *       ánh xạ qua trường <b>course</b>.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Table(name = "url")
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    /** Khóa chính tự tăng. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID khóa học chứa URL này. */
//    private Long course;

    /** Tên hiển thị của URL. */
    private String name;

    /** Nội dung mô tả/giới thiệu về URL. */
    private String intro;

    /** Định dạng của intro (plain text, HTML...). */
    private Integer introformat;

    /** Đường dẫn URL bên ngoài. */
    private String externalurl;

    /** Kiểu hiển thị (mở tab mới, nhúng, popup...). */
    private Integer display;

    /** Các tùy chọn hiển thị (lưu dưới dạng serialized hoặc JSON). */
    private String displayoptions;

    /** Tham số gắn thêm khi gọi URL. */
    private String parameters;

    /** Thời gian chỉnh sửa gần nhất (timestamp). */
    private Long timemodified;

    /**
     * Quan hệ 1-1 với {@link CourseModules},
     * liên kết qua khóa ngoại <b>course</b>.
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course")
    private CourseModules courseModules;
}
