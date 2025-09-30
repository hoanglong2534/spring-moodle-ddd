package com.onschool.demo.infrastructure.persistance.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_context</b>.
 * <p>
 * Lưu thông tin về ngữ cảnh (context) trong Moodle.
 * Context được sử dụng để xác định phạm vi quyền hạn, liên kết với các module, khóa học, danh mục hoặc người dùng.
 * </p>
 *
 * <ul>
 *   <li><b>contextlevel</b>: cấp độ ngữ cảnh (ví dụ: system, course, module...).</li>
 *   <li><b>instanceid</b>: ID thực thể tương ứng với contextlevel (ví dụ: course_id, module_id).</li>
 *   <li><b>path</b>: đường dẫn phân cấp context.</li>
 *   <li><b>depth</b>: độ sâu của context trong cây phân cấp.</li>
 *   <li><b>locked</b>: cờ khóa context (0 = không khóa, 1 = khóa).</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link CourseModules}: Module liên kết với context (<b>OneToOne</b>).</li>
 *   <li>{@link Course}: Khóa học liên kết với context (<b>OneToOne</b>).</li>
 *   <li>{@link CourseCategories}: Danh mục liên kết với context (<b>OneToOne</b>).</li>
 *   <li>{@link User}: Người dùng liên kết với context (<b>OneToOne</b>).</li>
 *   <li>{@link RoleAssignments}: Danh sách role assignments thuộc context (<b>OneToMany</b>).</li>
 * </ul>
 *
 * <p>
 * Lưu ý về OneToOne:
 * <br>
 * Context là **chủ sở hữu mối quan hệ** cho tất cả các liên kết OneToOne, do đó bảng <b>mdl_context</b> sẽ có các cột FK: module_id, course_id, categories_id, user_id.
 * </p>
 *
 * @author Hoang Long
 */
@Entity
@Table(name = "context")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Context {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Cấp độ ngữ cảnh (ví dụ: system, course, module...). */
    private Long contextlevel;

    /** ID thực thể tương ứng với contextlevel (ví dụ: course_id, module_id). */
    private Long instanceid;

    /** Đường dẫn phân cấp context. */
    private String path;

    /** Độ sâu của context trong cây phân cấp. */
    private Integer depth;

    /** Cờ khóa context (0 = không khóa, 1 = khóa). */
    private Integer locked;

    /** Module liên kết với context (OneToOne, Context là chủ sở hữu). */
    @OneToOne(fetch = FetchType.EAGER)
    private CourseModules module;

    /** Khóa học liên kết với context (OneToOne, Context là chủ sở hữu). */
    @OneToOne(fetch = FetchType.EAGER)
    private Course course;

    /** Danh mục liên kết với context (OneToOne, Context là chủ sở hữu). */
    @OneToOne(fetch = FetchType.EAGER)
    private CourseCategories categories;

    /** Danh sách role assignments thuộc context (OneToMany). */
    @OneToMany(mappedBy = "context")
    private List<RoleAssignments> assignmentsList;

    /** Người dùng liên kết với context (OneToOne, Context là chủ sở hữu). */
    @OneToOne(fetch = FetchType.EAGER)
    private User user;
}
