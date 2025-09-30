package com.onschool.demo.infrastructure.persistance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Entity đại diện cho bảng <b>mdl_quiz_slots</b>.
 *
 * <p>Mỗi slot là một "chỗ" (vị trí) trong quiz, chứa thông tin về
 * câu hỏi được gán vào quiz, thứ tự hiển thị, trang nằm trên,
 * và số điểm tối đa cho câu hỏi đó.</p>
 *
 * <p><b>Các trường chính:</b></p>
 * <ul>
 *   <li>{@code id} – Khóa chính tự sinh.</li>
 *   <li>{@code slot} – Thứ tự slot trong quiz.</li>
 *   <li>{@code quizid} – ID của quiz chứa slot này.</li>
 *   <li>{@code page} – Trang mà slot xuất hiện trong quiz.</li>
 *   <li>{@code requireprevious} – Yêu cầu phải làm xong slot trước (nếu có).</li>
 *   <li>{@code questionid} – ID câu hỏi được gán vào slot.</li>
 *   <li>{@code questioncategoryid} – ID của category chứa câu hỏi.</li>
 *   <li>{@code includingsubcategories} – Có lấy thêm sub-category khi chọn câu hỏi không.</li>
 *   <li>{@code maxmark} – Điểm tối đa của câu hỏi trong slot này.</li>
 * </ul>
 *
 * <p><b>Quan hệ:</b></p>
 * <ul>
 *   <li>{@link Quiz} – Một quiz có nhiều slot (1-N).</li>
 *   <li>{@link Question} – Mỗi slot tham chiếu đến một câu hỏi cụ thể.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Table(name = "quiz_slots")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class QuizSlots {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Thứ tự slot trong quiz. */
    private Long slot;

//    /** ID quiz chứa slot này (khóa ngoại). */
//    private Long quizid;

    /** Trang mà slot xuất hiện trong quiz. */
    private Long page;

    /** Yêu cầu hoàn thành slot trước (nếu có). */
    private String requireprevious;

//    /** ID câu hỏi được gán cho slot. */
//    private Long questionid;

    /** ID category của câu hỏi. */
    private Long questioncategoryid;

    /** Có bao gồm subcategory khi chọn câu hỏi không. */
    private Integer includingsubcategories;

    /** Điểm tối đa của câu hỏi trong slot này. */
    private BigDecimal maxmark;

    /** Quan hệ nhiều-1 tới quiz cha. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quizid")
    @JsonBackReference
    private Quiz quiz;

    /** Quan hệ nhiều-1 tới câu hỏi. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionid")
    private Question question;
}
