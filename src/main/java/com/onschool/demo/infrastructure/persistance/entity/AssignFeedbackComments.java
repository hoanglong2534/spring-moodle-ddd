package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity đại diện cho bảng <b>mdl_assignfeedback_comments</b>.
 * <p>
 * Bảng này lưu trữ các phản hồi (feedback) dưới dạng văn bản (comments)
 * của giảng viên cho một bài tập (assignment).
 * </p>
 *
 * <ul>
 *   <li><b>assignment</b>: ID của bài tập liên kết với comment này.</li>
 *   <li><b>commenttext</b>: Nội dung phản hồi (text).</li>
 *   <li><b>commentformat</b>: Định dạng của nội dung phản hồi
 *       (ví dụ: plain text, HTML, Markdown).</li>
 *   <li><b>gradeGrades</b>: Tham chiếu đến bản ghi trong {@link GradeGrades},
 *       cho biết comment này gắn với lần chấm điểm nào.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Table(name = "assignfeedback_comments")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignFeedbackComments {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    /** ID của bài tập liên kết với comment. */
    private Long assignment;

    /** Nội dung phản hồi (comment) của giảng viên. */
    private String commenttext;

    /** Định dạng của phản hồi (plain text, HTML, Markdown, ...). */
    private Integer commentformat;

    /**
     * Thông tin về lần chấm điểm (grade) liên kết với comment này.
     * Tham chiếu tới entity {@link GradeGrades}.
     */
    @ManyToOne
    @JoinColumn(name = "grade")
    private GradeGrades gradeGrades;
}
