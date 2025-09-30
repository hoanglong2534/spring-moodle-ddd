package com.onschool.demo.infrastructure.persistance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_question_attempts</b>.
 * <p>
 * Bảng này lưu thông tin về một lần attempt (làm thử/trả lời) của người dùng
 * đối với một câu hỏi cụ thể trong một lần attempt quiz.
 * </p>
 *
 * <ul>
 *   <li><b>questionusageid</b>: Liên kết tới usage của tập hợp các attempt câu hỏi.</li>
 *   <li><b>slot</b>: Vị trí (slot) của câu hỏi trong quiz.</li>
 *   <li><b>behaviour</b>: Cách thức hoạt động (ví dụ: deferredfeedback, interactive...).</li>
 *   <li><b>questionid</b>: ID của câu hỏi được attempt.</li>
 *   <li><b>variant</b>: Phiên bản/biến thể của câu hỏi (nếu có randomization).</li>
 *   <li><b>maxmark</b>: Điểm tối đa có thể đạt cho attempt này.</li>
 *   <li><b>minfraction</b>: Fraction tối thiểu (thường dùng trong tính điểm).</li>
 *   <li><b>maxfraction</b>: Fraction tối đa.</li>
 *   <li><b>flagged</b>: Đánh dấu (flag) của người dùng cho câu hỏi này.</li>
 *   <li><b>questionsummary</b>: Tóm tắt nội dung câu hỏi.</li>
 *   <li><b>rightanswer</b>: Đáp án đúng.</li>
 *   <li><b>responsesummary</b>: Tóm tắt câu trả lời của người dùng.</li>
 *   <li><b>timemodified</b>: Thời điểm lần attempt này được cập nhật.</li>
 * </ul>
 *
 * <p>
 * Quan hệ:
 * <ul>
 *   <li>Một {@link QuestionAttempts} có nhiều {@link QuestionAttemptSteps} (các bước thực hiện trong attempt).</li>
 *   <li>Một {@link QuestionAttempts} thuộc về một {@link Question} (câu hỏi cụ thể).</li>
 *   <li>Một {@link QuestionAttempts} thuộc về một {@link QuizAttempts} (lần attempt quiz tổng thể).</li>
 * </ul>
 * </p>
 *
 * @author Hoang Long
 */
@Table(name = "question_attempts")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAttempts {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Liên kết tới usage của tập hợp các attempt. */
    private Long questionusageid;

    /** Slot của câu hỏi trong quiz. */
    private Long slot;

    /** Cách thức hoạt động (behaviour). */
    private String behaviour;

//    /** ID của câu hỏi được attempt. */
//    private Long questionid;

    /** Biến thể của câu hỏi (nếu có). */
    private Long variant;

    /** Điểm tối đa cho attempt. */
    private BigDecimal maxmark;

    /** Fraction tối thiểu. */
    private BigDecimal minfraction;

    /** Fraction tối đa. */
    private BigDecimal maxfraction;

    /** Cờ đánh dấu câu hỏi. */
    private Integer flagged;

    /** Tóm tắt câu hỏi. */
    private String questionsummary;

    /** Đáp án đúng. */
    private String rightanswer;

    /** Tóm tắt câu trả lời của người dùng. */
    private String responsesummary;

    /** Thời điểm sửa đổi. */
    private Long timemodified;

    /** Danh sách các bước attempt chi tiết. */
    @OneToMany(mappedBy = "questionAttempts")
    @JsonManagedReference
    private List<QuestionAttemptSteps> questionAttemptSteps;

    /** Câu hỏi gốc mà attempt này tham chiếu tới. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionid")
    private Question question;

    /** Lần attempt quiz mà attempt câu hỏi này thuộc về. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "questionusageid",
            referencedColumnName = "uniqueid",
            insertable = false,
            updatable = false
    )
    private QuizAttempts quizAttempts;
}
