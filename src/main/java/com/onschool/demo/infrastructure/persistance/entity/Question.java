package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_question</b>.
 * <p>
 * Bảng này lưu trữ thông tin về các <b>câu hỏi</b> trong hệ thống Moodle.
 * Mỗi câu hỏi có thể thuộc một loại khác nhau (Multiple choice, True/False, Essay...).
 * </p>
 *
 * <h3>Các cột chính:</h3>
 * <ul>
 *   <li><b>category</b>: ID danh mục câu hỏi (liên kết tới {@link QuestionCategories}).</li>
 *   <li><b>parent</b>: ID câu hỏi cha (nếu đây là câu hỏi con/phụ thuộc).</li>
 *   <li><b>name</b>: Tên câu hỏi.</li>
 *   <li><b>questiontext</b>: Nội dung câu hỏi.</li>
 *   <li><b>generalfeedback</b>: Phản hồi chung hiển thị sau khi làm.</li>
 *   <li><b>defaultmark</b>: Điểm mặc định của câu hỏi.</li>
 *   <li><b>penalty</b>: Mức trừ điểm khi làm sai (dành cho adaptive mode).</li>
 *   <li><b>qtype</b>: Loại câu hỏi (MCQ, essay, short answer...).</li>
 *   <li><b>length</b>: Độ dài (số câu con).</li>
 *   <li><b>hidden</b>: Ẩn/hiện câu hỏi.</li>
 *   <li><b>timecreated</b>, <b>timemodified</b>: Thời gian tạo/cập nhật.</li>
 *   <li><b>createdby</b>, <b>modifiedby</b>: Người tạo và người sửa cuối cùng.</li>
 *   <li><b>idnumber</b>: Mã định danh duy nhất.</li>
 * </ul>
 *
 * <h3>Quan hệ:</h3>
 * <ul>
 *   <li>Một {@link Question} có thể xuất hiện trong nhiều {@link QuestionAttempts} (các lần làm của học viên).</li>
 *   <li>Một {@link Question} có thể nằm trong nhiều {@link QuizSlots} (slot của quiz).</li>
 *   <li>Một {@link Question} có nhiều {@link QuestionHints} (gợi ý cho học viên).</li>
 *   <li>Một {@link Question} có nhiều {@link QuestionAnswers} (các đáp án khả dĩ).</li>
 *   <li>Một {@link Question} có thể có thống kê {@link QuestionStatistics} (1-1).</li>
 *   <li>Nhiều câu hỏi thuộc về một {@link QuestionCategories}.</li>
 * </ul>
 *
 * @author Hoang
 */
@Table(name = "question")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {

    /** Khóa chính tự tăng. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID danh mục chứa câu hỏi. */
//    private Long category;

    /** ID câu hỏi cha (nếu có). */
    private Long parent;

    /** Tên câu hỏi. */
    private String name;

    /** Nội dung câu hỏi. */
    private String questiontext;

    /** Định dạng nội dung câu hỏi. */
    private Integer questiontextformat;

    /** Phản hồi chung. */
    private String generalfeedback;

    /** Định dạng phản hồi chung. */
    private Integer generalfeedbackformat;

    /** Điểm mặc định. */
    private BigDecimal defaultmark;

    /** Mức trừ điểm khi làm sai. */
    private BigDecimal penalty;

    /** Loại câu hỏi (MCQ, essay, short answer...). */
    private String qtype;

    /** Độ dài (số câu con). */
    private Long length;

    /** Dấu định danh (stamp). */
    private String stamp;

    /** Phiên bản câu hỏi. */
    private String version;

    /** Trạng thái ẩn/hiện. */
    private Integer hidden;

    /** Thời điểm tạo. */
    private Long timecreated;

    /** Thời điểm cập nhật. */
    private Long timemodified;

    /** Người tạo. */
    private Long createdby;

    /** Người chỉnh sửa cuối cùng. */
    private Long modifiedby;

    /** Mã định danh duy nhất. */
    private String idnumber;

    /** Danh sách các lần attempt chứa câu hỏi này. */
    @OneToMany(mappedBy = "question")
    private List<QuestionAttempts> questionAttempts;

    /** Danh sách slot quiz có chứa câu hỏi này. */
    @OneToMany(mappedBy = "question")
    private List<QuizSlots> quizSlotsList;

    /** Danh sách gợi ý (hints) của câu hỏi. */
    @OneToMany(mappedBy = "question")
    private List<QuestionHints> questionHintsList;

    /** Danh sách các đáp án của câu hỏi. */
    @OneToMany(mappedBy = "questionEntity")
    private List<QuestionAnswers> questionAnswersList;

    /** Thống kê của câu hỏi (1-1). */
    @OneToOne(mappedBy = "question")
    private QuestionStatistics qustionStatistics;

    /** Danh mục chứa câu hỏi này. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private QuestionCategories questionCategories;
}
