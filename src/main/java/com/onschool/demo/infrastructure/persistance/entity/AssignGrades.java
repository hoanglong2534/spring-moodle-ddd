package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Entity đại diện cho bảng <b>mdl_assign_grades</b>.
 *
 * Bảng này lưu thông tin về điểm số (grades) của người học
 * cho một bài tập cụ thể trong Moodle.
 * Mỗi bản ghi phản ánh kết quả chấm điểm cho một lần nộp bài (attempt).
 *
 * <p><b>Chi tiết các trường:</b></p>
 * <ul>
 *   <li>{@code id} - Khóa chính, tự sinh.</li>
 *   <li>{@code assignment} - Khóa ngoại tham chiếu đến bài tập (Assign).</li>
 *   <li>{@code userid} - ID của người nộp bài (người học).</li>
 *   <li>{@code timecreated} - Thời điểm tạo điểm (timestamp).</li>
 *   <li>{@code timemodified} - Thời điểm chỉnh sửa điểm gần nhất.</li>
 *   <li>{@code grader} - ID của người chấm (giáo viên).</li>
 *   <li>{@code grade} - Điểm số được chấm cho lần nộp.</li>
 *   <li>{@code attemptnumber} - Số thứ tự lần nộp bài mà điểm này gắn liền.</li>
 * </ul>
 *
 * <p><b>Quan hệ:</b></p>
 * <ul>
 *   <li>{@link Assign} - Một bài tập có thể có nhiều bản ghi điểm của các sinh viên khác nhau.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Table(name = "assign_grades")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignGrades {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID bài tập liên kết (tham chiếu tới {@link Assign}). */
//    private Long assignment;

    /** ID của người học (người nộp bài). */
    private Long userid;

    /** Thời điểm điểm số được tạo (timestamp). */
    private Long timecreated;

    /** Thời điểm điểm số được cập nhật gần nhất. */
    private Long timemodified;

    /** ID của giáo viên/giám khảo chấm điểm. */
    private Long grader;

    /** Điểm số được gán cho lần nộp bài. */
    private BigDecimal grade;

    /** Số thứ tự lần nộp mà điểm số này thuộc về. */
    private Long attemptnumber;

    /** Quan hệ nhiều-nhiều với bảng bài tập (Assign). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment")
    private Assign assign;
}
