package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity đại diện cho bảng <b>mdl_question_attempt_step_data</b>.
 * <p>
 * Lưu dữ liệu chi tiết (name, value) cho từng bước trong quá trình attempt câu hỏi.
 * Mỗi {@link QuestionAttemptStepData} thuộc về duy nhất một {@link QuestionAttemptSteps}.
 * </p>
 *
 * <ul>
 *   <li><b>name</b>: tên của dữ liệu (ví dụ: "answer", "correctness").</li>
 *   <li><b>value</b>: giá trị dữ liệu tương ứng (ví dụ: "True", "0.5").</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Table(name = "question_attempt_step_data")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAttemptStepData {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /** Tên của dữ liệu (ví dụ: "answer"). */
    private String name;

    /** Giá trị của dữ liệu (ví dụ: "True", "0.5"). */
    private String value;

    /**
     * Step cha mà dữ liệu này thuộc về.
     * <br>
     * Mỗi step có thể có nhiều dữ liệu chi tiết đi kèm.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attemptstepid")
    private QuestionAttemptSteps questionAttemptSteps;
}
