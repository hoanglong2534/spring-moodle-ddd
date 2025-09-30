package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_question_categories</b>.
 * <p>
 * Bảng này lưu thông tin về các <b>danh mục câu hỏi</b> (Question Categories) trong Moodle.
 * Danh mục giúp tổ chức và phân loại câu hỏi để tái sử dụng trong nhiều quiz hoặc khóa học.
 * </p>
 *
 * <h3>Các cột chính:</h3>
 * <ul>
 *   <li><b>name</b>: Tên danh mục.</li>
 *   <li><b>contextid</b>: ID của context (ví dụ: khóa học hoặc module) mà danh mục này thuộc về.</li>
 *   <li><b>info</b>: Thông tin mô tả cho danh mục.</li>
 *   <li><b>infoformat</b>: Định dạng của phần mô tả (plain text, HTML...).</li>
 *   <li><b>stamp</b>: Chuỗi dấu định danh duy nhất.</li>
 *   <li><b>parent</b>: ID danh mục cha (nếu đây là danh mục con).</li>
 *   <li><b>sortorder</b>: Thứ tự sắp xếp trong cùng một cấp.</li>
 *   <li><b>idnumber</b>: Mã định danh duy nhất do quản trị viên gán.</li>
 * </ul>
 *
 * <h3>Quan hệ:</h3>
 * <ul>
 *   <li>Một {@link QuestionCategories} có thể chứa nhiều {@link Question} (1-n).</li>
 *   <li>Có thể tồn tại quan hệ phân cấp giữa các danh mục (qua trường <b>parent</b>).</li>
 * </ul>
 *
 * @author Hoang
 */
@Table(name = "question_categories")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCategories {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Tên danh mục. */
    private String name;

    /** ID context mà danh mục này thuộc về. */
    private Long contextid;

    /** Thông tin mô tả của danh mục. */
    private String info;

    /** Định dạng của phần mô tả. */
    private Integer infoformat;

    /** Chuỗi dấu định danh duy nhất. */
    private String stamp;

    /** ID danh mục cha (nếu có). */
    private Long parent;

    /** Thứ tự sắp xếp trong cùng cấp. */
    private Long sortorder;

    /** Mã định danh do quản trị viên gán. */
    private String idnumber;

    /** Danh sách câu hỏi thuộc danh mục này. */
    @OneToMany(mappedBy = "questionCategories")
    private List<Question> questions;
}
