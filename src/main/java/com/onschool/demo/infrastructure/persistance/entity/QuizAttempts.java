package com.onschool.demo.infrastructure.persistance.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_quiz_attempts</b>.
 *
 * <p>Bảng này lưu thông tin về các lần làm bài kiểm tra (quiz) của người dùng trong Moodle.
 * Mỗi bản ghi biểu thị một lần attempt của một người dùng đối với một quiz cụ thể.</p>
 *
 * <p><b>Các trường chính:</b></p>
 * <ul>
 *   <li>{@code id} – Khóa chính tự sinh.</li>
 *   <li>{@code quiz} – Khóa ngoại tham chiếu đến quiz được làm.</li>
 *   <li>{@code userid} – ID người dùng thực hiện attempt.</li>
 *   <li>{@code attempt} – Số thứ tự của attempt (lần làm thứ mấy).</li>
 *   <li>{@code uniqueid} – Liên kết với attempt usage (trong hệ thống câu hỏi).</li>
 *   <li>{@code layout} – Thứ tự các câu hỏi trong attempt.</li>
 *   <li>{@code currentpage} – Trang hiện tại khi làm quiz (nếu phân trang).</li>
 *   <li>{@code preview} – Đánh dấu attempt có phải chế độ xem trước hay không (0/1).</li>
 *   <li>{@code state} – Trạng thái attempt (ví dụ: inprogress, finished, abandoned...).</li>
 *   <li>{@code timestart} – Thời điểm bắt đầu attempt.</li>
 *   <li>{@code timefinish} – Thời điểm kết thúc attempt.</li>
 *   <li>{@code timemodified} – Thời điểm sửa đổi lần cuối.</li>
 *   <li>{@code timemodifiedoffline} – Thời điểm sửa đổi offline lần cuối.</li>
 *   <li>{@code timecheckstate} – Thời điểm hệ thống kiểm tra lại trạng thái.</li>
 *   <li>{@code sumgrades} – Tổng điểm đạt được trong attempt.</li>
 * </ul>
 *
 * <p><b>Quan hệ:</b></p>
 * <ul>
 *   <li>{@link Quiz} – Mỗi attempt thuộc về một quiz (Many-to-One).</li>
 *   <li>{@link User} – Mỗi attempt do một người dùng thực hiện (Many-to-One).</li>
 *   <li>{@link QuestionAttempts} – Một attempt chứa nhiều câu hỏi attempt (One-to-Many).</li>
 * </ul>
 *
 * @author
 */
@Table(name = "quiz_attempts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class QuizAttempts {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID của quiz mà attempt này thuộc về. */
//    private Long quiz;

//    /** ID của người dùng thực hiện attempt. */
//    private Long userid;

    /** Số thứ tự của lần làm quiz (1, 2, 3...). */
    private Long attempt;

    /** ID duy nhất liên kết với question usage. */
    private Long uniqueid;

    /** Thứ tự các câu hỏi trong attempt. */
    private String layout;

    /** Trang hiện tại khi người dùng đang làm quiz. */
    private Long currentpage;

    /** Đánh dấu xem attempt này có phải chế độ xem trước không. */
    private Integer preview;

    /** Trạng thái của attempt (inprogress, finished, abandoned...). */
    private String state;

    /** Thời gian bắt đầu attempt. */
    private Long timestart;

    /** Thời gian kết thúc attempt. */
    private Long timefinish;

    /** Thời gian sửa đổi lần cuối. */
    private Long timemodified;

    /** Thời gian sửa đổi offline lần cuối. */
    private Long timemodifiedoffline;

    /** Thời gian kiểm tra lại trạng thái của attempt. */
    private Long timecheckstate;

    /** Tổng điểm đạt được trong attempt. */
    private BigDecimal sumgrades;

    /** Danh sách các attempt ở cấp câu hỏi thuộc attempt này. */
    @OneToMany(mappedBy = "quizAttempts")
    private List<QuestionAttempts> questionAttemptsList;

    /** Quan hệ nhiều-1 với quiz cha. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz")
    private Quiz quizEntity;

    /** Quan hệ nhiều-1 với người dùng thực hiện attempt. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @JsonBackReference
    private User user;
}
