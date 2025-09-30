package com.onschool.demo.infrastructure.persistance.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity đại diện cho bảng <b>mdl_assignfeedback_file</b>.
 * <p>
 * Bảng này lưu trữ thông tin về các file được dùng để phản hồi (feedback)
 * trong quá trình chấm điểm một bài tập (assignment).
 * </p>
 *
 * <ul>
 *   <li><b>assignment</b>: ID của bài tập liên kết với feedback này.</li>
 *   <li><b>numfiles</b>: Số lượng file feedback được lưu cho một bản ghi.</li>
 *   <li><b>gradeGrades</b>: Tham chiếu đến bản ghi trong {@link GradeGrades},
 *   cho biết feedback này gắn với lần chấm điểm nào.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Table(name = "assignfeedback_file")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignFeedbackFile {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    /** ID của bài tập liên kết với feedback. */
    private Long assignment;

    /** Số lượng file feedback được lưu. */
    private Long numfiles;

    /**
     * Thông tin về lần chấm điểm (grade) liên kết với feedback này.
     * Tham chiếu tới entity {@link GradeGrades}.
     */
    @ManyToOne
    @JoinColumn(name = "grade")
    private GradeGrades gradeGrades;
}
