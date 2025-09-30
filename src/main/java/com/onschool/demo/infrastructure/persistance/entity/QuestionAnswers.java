package com.onschool.demo.infrastructure.persistance.entity;

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
 * Entity đại diện cho bảng <b>mdl_question_answers</b>.
 *
 * <p>Bảng này lưu các đáp án của một câu hỏi trong Moodle.
 * Mỗi đáp án có thể là đúng, sai, hoặc một phần đúng (thông qua trường {@code fraction}).</p>
 *
 * <p><b>Các trường chính:</b></p>
 * <ul>
 *   <li>{@code id} – Khóa chính tự sinh.</li>
 *   <li>{@code question} – Khóa ngoại tham chiếu đến câu hỏi mà đáp án này thuộc về.</li>
 *   <li>{@code answer} – Nội dung đáp án.</li>
 *   <li>{@code answerformat} – Định dạng của nội dung đáp án (text, HTML...).</li>
 *   <li>{@code fraction} – Hệ số điểm (1 = đúng hoàn toàn, 0 = sai, giá trị giữa = đúng một phần).</li>
 *   <li>{@code feedback} – Phản hồi được hiển thị cho người học nếu chọn đáp án này.</li>
 *   <li>{@code feedbackformat} – Định dạng của phản hồi.</li>
 * </ul>
 *
 * <p><b>Quan hệ:</b></p>
 * <ul>
 *   <li>{@link Question} – Mỗi đáp án thuộc về một câu hỏi (Many-to-One).</li>
 * </ul>
 *
 * @author
 */
@Table(name = "question_answers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionAnswers {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** Khóa ngoại: ID của câu hỏi chứa đáp án này. */
//    private Long question;

    /** Nội dung đáp án. */
    private String answer;

    /** Định dạng nội dung đáp án (plain text, HTML...). */
    private Integer answerformat;

    /** Hệ số điểm của đáp án (1 = đúng, 0 = sai, giữa = một phần đúng). */
    private BigDecimal fraction;

    /** Phản hồi khi người học chọn đáp án này. */
    private String feedback;

    /** Định dạng của phản hồi. */
    private Integer feedbackformat;

    /** Quan hệ nhiều-1 với câu hỏi cha. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question")
    private Question questionEntity;
}
