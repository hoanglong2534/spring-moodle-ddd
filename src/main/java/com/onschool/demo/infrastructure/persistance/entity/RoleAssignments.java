package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity đại diện cho bảng <b>mdl_role_assignments</b>.
 * <p>
 * Lưu thông tin về việc gán vai trò (role) cho người dùng trong Moodle.
 * Mỗi {@link RoleAssignments} liên kết với một {@link Role}, một {@link Context} và một {@link User}.
 * </p>
 *
 * <ul>
 *   <li><b>roleId</b>: ID vai trò được gán.</li>
 *   <li><b>contextid</b>: ID ngữ cảnh mà vai trò được áp dụng.</li>
 *   <li><b>userid</b>: ID người dùng nhận vai trò.</li>
 *   <li><b>timemodified</b>: thời điểm chỉnh sửa bản ghi (timestamp).</li>
 *   <li><b>modifierid</b>: ID người thực hiện thay đổi.</li>
 *   <li><b>component</b>: thành phần liên quan đến role assignment (ví dụ: 'mod_assign').</li>
 *   <li><b>itemid</b>: ID item liên quan (nếu có).</li>
 *   <li><b>sortorder</b>: thứ tự sắp xếp role assignment.</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link Role}: Vai trò được gán.</li>
 *   <li>{@link Context}: Ngữ cảnh áp dụng vai trò.</li>
 *   <li>{@link User}: Người dùng nhận vai trò.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Entity
@Table(name = "role_assignments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleAssignments {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID vai trò được gán. */
//    private Long roleId;

//    /** ID ngữ cảnh mà vai trò được áp dụng. */
//    private Long contextid;

//    /** ID người dùng nhận vai trò. */
//    private Long userid;

    /** Thời điểm chỉnh sửa bản ghi (timestamp). */
    private Long timemodified;

    /** ID người thực hiện thay đổi. */
    private Long modifierid;

    /** Thành phần liên quan đến role assignment (ví dụ: 'mod_assign'). */
    private String component;

    /** ID item liên quan (nếu có). */
    private Long itemid;

    /** Thứ tự sắp xếp role assignment. */
    private Long sortorder;

    /** Vai trò được gán. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId")
    private Role role;

    /** Ngữ cảnh áp dụng vai trò. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contextid")
    private Context context;

    /** Người dùng nhận vai trò. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;
}
