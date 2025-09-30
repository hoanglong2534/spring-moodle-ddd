package com.onschool.demo.infrastructure.persistance.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_role</b>.
 * <p>
 * Lưu thông tin về các vai trò (role) trong Moodle.
 * Mỗi {@link Role} có thể được gán cho nhiều người dùng thông qua {@link RoleAssignments}.
 * </p>
 *
 * <ul>
 *   <li><b>name</b>: tên vai trò đầy đủ.</li>
 *   <li><b>shortName</b>: tên rút gọn của vai trò.</li>
 *   <li><b>description</b>: mô tả chi tiết về vai trò.</li>
 *   <li><b>sortOrder</b>: thứ tự sắp xếp vai trò.</li>
 *   <li><b>archetype</b>: loại archetype của vai trò (ví dụ: student, teacher, manager).</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link RoleAssignments}: Danh sách các bản ghi gán vai trò cho người dùng.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Tên vai trò đầy đủ. */
    private String name;

    /** Tên rút gọn của vai trò. */
    @Column(name="shortname")
    private String shortName;

    /** Mô tả chi tiết về vai trò. */
    private String description;

    /** Thứ tự sắp xếp vai trò. */
    @Column(name = "sortorder")
    private Long sortOrder;

    /** Loại archetype của vai trò (ví dụ: student, teacher, manager). */
    private String archetype;

    /** Danh sách các bản ghi gán vai trò cho người dùng. */
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<RoleAssignments> roleAssignmentsList;
}
