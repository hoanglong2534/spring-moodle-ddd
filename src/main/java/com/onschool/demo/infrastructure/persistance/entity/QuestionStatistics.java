package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Entity đại diện cho bảng <b>mdl_question_statistics</b>.
 * <p>
 * Lưu trữ các thông tin thống kê liên quan đến một câu hỏi trong Moodle,
 * chẳng hạn như tần suất nộp, mức độ phân biệt, điểm đoán ngẫu nhiên, v.v.
 * Mỗi thống kê gắn liền với một {@link Question}.
 * </p>
 *
 * <ul>
 *   <li><b>hashcode</b>: Mã hash duy nhất để nhận diện bản ghi thống kê.</li>
 *   <li><b>timemodified</b>: Thời điểm cập nhật lần cuối (timestamp).</li>
 *   <li><b>questionid</b>: ID của câu hỏi được thống kê.</li>
 *   <li><b>slot</b>: Vị trí (slot) của câu hỏi trong quiz.</li>
 *   <li><b>submissions</b>: Số lượng lượt nộp liên quan đến câu hỏi này.</li>
 *   <li><b>variant</b>: Biến thể của câu hỏi (nếu có nhiều phiên bản).</li>
 *   <li><b>s</b>: Tham số thống kê đặc thù (tùy Moodle).</li>
 *   <li><b>effectiveheight</b>: Độ cao hiệu quả trong phân tích thống kê.</li>
 *   <li><b>negcovar</b>: Giá trị cho biết có covariance âm hay không.</li>
 *   <li><b>discriminationindex</b>: Chỉ số phân biệt câu hỏi.</li>
 *   <li><b>discriminativeefficiency</b>: Hiệu quả phân biệt câu hỏi.</li>
 *   <li><b>facility</b>: Độ dễ của câu hỏi (facility value).</li>
 *   <li><b>sunquestions</b>: Chuỗi chứa thông tin các sub-questions (nếu có).</li>
 *   <li><b>maxmark</b>: Điểm tối đa có thể đạt được ở câu hỏi.</li>
 *   <li><b>positions</b>: Vị trí xuất hiện của câu hỏi trong bài quiz.</li>
 *   <li><b>randomguessscore</b>: Điểm dự kiến nếu đoán ngẫu nhiên.</li>
 * </ul>
 *
 * <p>
 * Quan hệ:
 * <ul>
 *   <li>Mỗi <b>QuestionStatistics</b> gắn liền với một {@link Question} (One-to-One).</li>
 * </ul>
 * </p>
 *
 * @author Hoang Long
 */
@Table(name = "question_statistics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuestionStatistics {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Mã hash nhận diện bản ghi thống kê. */
    private String hashcode;

    /** Thời điểm bản ghi được cập nhật lần cuối. */
    private Long timemodified;

//    /** ID của câu hỏi liên quan. */
//    private Long questionid;

    /** Vị trí slot của câu hỏi trong quiz. */
    private Long slot;

    /** Số lượt nộp liên quan đến câu hỏi. */
    private Integer submissions;

    /** Biến thể của câu hỏi (nếu có). */
    private Long variant;

    /** Tham số thống kê S. */
    private Long s;

    /** Độ cao hiệu quả (effective height). */
    private BigDecimal effectiveheight;

    /** Giá trị covariance âm (nếu có). */
    private Integer negcovar;

    /** Chỉ số phân biệt (discrimination index). */
    private BigDecimal discriminationindex;

    /** Hiệu quả phân biệt (discriminative efficiency). */
    private BigDecimal discriminativeefficiency;

    /** Độ dễ của câu hỏi (facility). */
    private BigDecimal facility;

    /** Chuỗi chứa thông tin các sub-question. */
    private String sunquestions;

    /** Điểm tối đa. */
    private BigDecimal maxmark;

    /** Vị trí xuất hiện của câu hỏi trong quiz. */
    private String positions;

    /** Điểm dự kiến nếu đoán ngẫu nhiên. */
    private BigDecimal randomguessscore;

    /**
     * Quan hệ One-to-One đến {@link Question}.
     * <br>
     * Một câu hỏi có duy nhất một bản thống kê.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionid")
    private Question question;

}
