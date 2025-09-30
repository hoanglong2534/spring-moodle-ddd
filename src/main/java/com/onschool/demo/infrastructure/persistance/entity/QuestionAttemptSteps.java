package com.onschool.demo.infrastructure.persistance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


import java.math.BigDecimal;
import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_question_attempt_steps</b>.
 * <p>
 * Lưu thông tin về từng bước (step) trong quá trình attempt một câu hỏi.
 * Mỗi step có thể chứa nhiều {@link QuestionAttemptStepData} (các dữ liệu chi tiết).
 * </p>
 *
 * <ul>
 *   <li><b>questionattemptid</b>: ID của lần attempt câu hỏi mà step này thuộc về.</li>
 *   <li><b>sequencenumber</b>: Thứ tự của step trong attempt.</li>
 *   <li><b>state</b>: Trạng thái của step (ví dụ: complete, inprogress, invalid).</li>
 *   <li><b>fraction</b>: Điểm số (phần trăm/giá trị) đạt được ở step này.</li>
 *   <li><b>timecreated</b>: Thời điểm step được tạo (timestamp).</li>
 *   <li><b>userid</b>: Người dùng đã thực hiện step này.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Table(name= "question_attempt_steps")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionAttemptSteps {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

//    private Long questionattemptid;

    /** Thứ tự step trong attempt. */
    private Long sequencenumber;

    /** Trạng thái step (ví dụ: complete, inprogress, invalid). */
    private String state;

    /** Điểm số (fraction) đạt được tại step này. */
    private BigDecimal fraction;

    /** Thời điểm step được tạo (timestamp). */
    private Long timecreated;

    /** Người dùng thực hiện step này. */
    private Long userid;

    /**
     * Danh sách dữ liệu chi tiết của step.
     * <br>
     * Một step có thể có nhiều cặp name-value được lưu trong {@link QuestionAttemptStepData}.
     */
    @OneToMany(mappedBy = "questionAttemptSteps")
    private List<QuestionAttemptStepData> questionAttemptStepData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionattemptid")
    @JsonBackReference
    private QuestionAttempts questionAttempts;
}
