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

/**
 * Entity đại diện cho bảng <b>mdl_question_hints</b>.
 *
 * <p>Bảng này lưu các gợi ý (hint) được gán cho câu hỏi trong quiz hoặc ngân hàng câu hỏi.
 * Gợi ý thường hiển thị khi người học trả lời sai hoặc cần thêm trợ giúp.</p>
 *
 * <p><b>Các trường chính:</b></p>
 * <ul>
 *   <li>{@code id} – Khóa chính tự sinh.</li>
 *   <li>{@code questionid} – Khóa ngoại tham chiếu đến câu hỏi được gán hint.</li>
 *   <li>{@code hint} – Nội dung gợi ý.</li>
 *   <li>{@code hintformat} – Định dạng gợi ý (plain text, HTML, Markdown...).</li>
 *   <li>{@code shownumcorrect} – Có hiển thị số lượng câu trả lời đúng hay không.</li>
 *   <li>{@code clearwrong} – Có xóa các đáp án sai sau khi gợi ý được hiển thị không.</li>
 *   <li>{@code options} – Các tùy chọn khác cho gợi ý (dữ liệu bổ sung).</li>
 * </ul>
 *
 * <p><b>Quan hệ:</b></p>
 * <ul>
 *   <li>{@link Question} – Mỗi hint thuộc về một câu hỏi (Many-to-One).</li>
 * </ul>
 *
 * @author
 */
@Table(name = "question_hints")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuestionHints {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** Khóa ngoại: ID của câu hỏi được gán hint. */
//    private Long questionid;

    /** Nội dung gợi ý. */
    private String hint;

    /** Định dạng của gợi ý (ví dụ: text, HTML...). */
    private Integer hintformat;

    /** Có hiển thị số lượng câu trả lời đúng hay không. */
    private Integer shownumcorrect;

    /** Có xóa đáp án sai sau khi gợi ý hiển thị không. */
    private Integer clearwrong;

    /** Các tùy chọn bổ sung cho gợi ý. */
    private String options;

    /** Quan hệ nhiều-1 với câu hỏi cha. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionid")
    private Question question;
}
