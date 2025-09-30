package com.onschool.demo.infrastructure.persistance.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_grade_items</b>.
 * <p>
 * Bảng này lưu thông tin về các hạng mục chấm điểm (grade items) trong Moodle,
 * bao gồm các loại item như quiz, assignment, hoặc các hạng mục tính toán đặc biệt.
 * </p>
 *
 * <ul>
 *   <li><b>courseid</b>: ID của khóa học chứa grade item.</li>
 *   <li><b>categoryid</b>: ID của category mà grade item thuộc về.</li>
 *   <li><b>itemname</b>: Tên hiển thị của grade item.</li>
 *   <li><b>itemtype</b>: Loại của grade item (ví dụ: mod, manual,...).</li>
 *   <li><b>itemmodule</b>: Tên module tương ứng (quiz, assign,... nếu itemtype = mod).</li>
 *   <li><b>iteminstance</b>: ID instance của module (quizid, assignid,...).</li>
 *   <li><b>itemnumber</b>: Thứ tự của grade item trong module.</li>
 *   <li><b>iteminfo</b>: Thông tin bổ sung cho grade item.</li>
 *   <li><b>idnumber</b>: Mã định danh duy nhất của grade item.</li>
 *   <li><b>calculation</b>: Biểu thức tính toán (nếu grade item là loại calculated).</li>
 *   <li><b>gradetype</b>: Kiểu điểm (0 = none, 1 = value, 2 = scale, 3 = text).</li>
 * </ul>
 *
 * <p>
 * Quan hệ:
 * <ul>
 *   <li>Một {@link GradeItems} có thể có nhiều {@link GradeGrades} (One-to-Many).</li>
 *   <li>Một {@link GradeItems} có thể liên kết 1-1 với {@link Quiz} thông qua trường <b>quizid</b>.</li>
 *   <li>Một {@link GradeItems} có thể liên kết 1-1 với {@link Assign} thông qua trường <b>assignid</b>.</li>
 * </ul>
 * </p>
 *
 * @author Hoang Long
 */
@Table(name = "grade_items")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradeItems {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ID khóa học chứa grade item. */
    private Long courseid;

    /** ID category chứa grade item. */
    private Long categoryid;

    /** Tên hiển thị của grade item. */
    private String itemname;

    /** Loại grade item (mod, manual,...). */
    private String itemtype;

    /** Module tương ứng (quiz, assign, ...). */
    private String itemmodule;

    /** ID instance của module (quizid, assignid,...). */
    private Long iteminstance;

    /** Thứ tự của grade item trong module. */
    private Long itemnumber;

    /** Thông tin bổ sung. */
    private String iteminfo;

    /** Mã định danh duy nhất. */
    private String idnumber;

    /** Biểu thức tính toán (nếu có). */
    private String calculation;

    /** Kiểu điểm (0 = none, 1 = value, 2 = scale, 3 = text). */
    private Integer gradetype;

    /** Danh sách điểm của grade item (One-to-Many). */
    @OneToMany(mappedBy = "gradeItems")
    private List<GradeGrades> gradeGrades;

    /**
     * Liên kết 1-1 tới Quiz (nếu grade item thuộc về quiz).
     * Trường `quizid` được ánh xạ (read-only vì insertable=false, updatable=false).
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quizid", insertable = false, updatable = false)
    private Quiz quiz;

    /**
     * Liên kết 1-1 tới Assignment (nếu grade item thuộc về assignment).
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignid")
    private Assign assign;
}
