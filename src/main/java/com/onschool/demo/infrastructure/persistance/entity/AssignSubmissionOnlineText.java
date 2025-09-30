package com.onschool.demo.infrastructure.persistance.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity đại diện cho bảng <b>mdl_assignsubmission_onlinetext</b>.
 *
 * Bảng này lưu thông tin phần nộp bài dạng văn bản trực tuyến (online text)
 * trong hệ thống Moodle. Mỗi bản ghi thể hiện một lần nộp bài
 * của người dùng cho một bài tập cụ thể bằng cách nhập trực tiếp văn bản.
 *
 * <p><b>Chi tiết các trường:</b></p>
 * <ul>
 *   <li>{@code id} - Khóa chính, tự sinh.</li>
 *   <li>{@code assignment} - Khóa ngoại tham chiếu đến bài tập (Assign).</li>
 *   <li>{@code submission} - Khóa ngoại tham chiếu đến bản ghi nộp bài (AssignmentSubmissions).</li>
 *   <li>{@code onlinetext} - Nội dung văn bản mà sinh viên nộp trực tuyến.</li>
 *   <li>{@code onlinetextformat} - Định dạng văn bản (plain text, HTML, Markdown,...).</li>
 * </ul>
 *
 * <p><b>Quan hệ:</b></p>
 * <ul>
 *   <li>{@link AssignmentSubmissions} - Một nộp bài có thể có nhiều phần văn bản online.</li>
 *   <li>{@link Assign} - Liên kết với thông tin bài tập gốc.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Entity
@Table(name = "assignsubmission_onlinetext")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AssignSubmissionOnlineText {

    /** Khóa chính tự động tăng. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID bài tập trong Moodle (liên kết tới {@link Assign}). */
//    private Long assignment;

//    /** ID bản ghi nộp bài (liên kết tới {@link AssignmentSubmissions}). */
//    private Long submission;

    /** Nội dung văn bản trực tuyến mà sinh viên đã nộp. */
    private String onlinetext;

    /** Định dạng văn bản (0 = plain text, 1 = HTML, 2 = Markdown, ...). */
    private Integer onlinetextformat;

    /** Quan hệ nhiều-nhiều tới bảng AssignmentSubmissions. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "submission")
    private AssignmentSubmissions assignmentSubmission;

    /** Quan hệ nhiều-nhiều tới bảng Assign. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment")
    private Assign assign;

}
