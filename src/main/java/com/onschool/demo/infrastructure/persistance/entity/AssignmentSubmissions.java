package com.onschool.demo.infrastructure.persistance.entity;

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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_assignment_submissions</b>.
 *
 * <p>
 * Bảng này lưu thông tin về các lần nộp bài tập (submissions) của sinh viên trong Moodle.
 * Mỗi bản ghi tương ứng với một lần nộp của một sinh viên cho một bài tập cụ thể.
 * </p>
 *
 * <p><b>Các trường dữ liệu chính:</b></p>
 * <ul>
 *   <li>{@code id} - Khóa chính tự sinh.</li>
 *   <li>{@code assignment} - Khóa ngoại liên kết đến bài tập {@link Assign}.</li>
 *   <li>{@code userid} - ID của sinh viên thực hiện nộp bài.</li>
 *   <li>{@code timecreated} - Thời điểm nộp bài (timestamp).</li>
 *   <li>{@code timemodified} - Thời điểm chỉnh sửa lần nộp (timestamp).</li>
 *   <li>{@code numfiles} - Số lượng file được đính kèm.</li>
 *   <li>{@code data1}, {@code data2} - Dữ liệu bổ sung (tùy theo plugin submission).</li>
 *   <li>{@code grade} - Điểm tạm thời hoặc điểm liên kết đến {@link AssignGrades}.</li>
 *   <li>{@code submissioncomment} - Nhận xét khi nộp bài.</li>
 *   <li>{@code format} - Định dạng của comment.</li>
 *   <li>{@code teacher} - ID giáo viên phụ trách chấm bài.</li>
 *   <li>{@code timemarked} - Thời điểm được chấm điểm.</li>
 *   <li>{@code mailed} - Trạng thái gửi thông báo (0/1).</li>
 * </ul>
 *
 * <p><b>Quan hệ:</b></p>
 * <ul>
 *   <li>{@link AssignSubmissionFile} - Một lần nộp có thể chứa nhiều file đính kèm.</li>
 *   <li>{@link AssignSubmissionOnlineText} - Một lần nộp có thể chứa nhiều đoạn văn bản online.</li>
 *   <li>{@link Assign} - Mỗi lần nộp thuộc về một bài tập cụ thể.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignment_submissions")
public class AssignmentSubmissions {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID bài tập liên kết. */
//    private Long assignment;

    /** ID sinh viên nộp bài. */
    private Long userid;

    /** Thời điểm tạo lần nộp (timestamp). */
    private Long timecreated;

    /** Thời điểm cập nhật lần nộp (timestamp). */
    private Long timemodified;

    /** Số lượng file được nộp. */
    private Long numfiles;

    /** Trường dữ liệu mở rộng 1 (dùng cho plugin submission). */
    private String data1;

    /** Trường dữ liệu mở rộng 2 (dùng cho plugin submission). */
    private String data2;

    /** Điểm số liên kết hoặc tham chiếu. */
    private Long grade;

    /** Nhận xét đi kèm khi nộp bài. */
    private String submissioncomment;

    /** Định dạng của nhận xét. */
    private Integer format;

    /** ID giáo viên chấm bài. */
    private Long teacher;

    /** Thời điểm được chấm điểm. */
    private Long timemarked;

    /** Trạng thái gửi mail thông báo (0/1). */
    private Integer mailed;

    /** Danh sách file được nộp trong lần submission này. */
    @OneToMany(mappedBy = "assignmentSubmissions", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<AssignSubmissionFile> assignSubmissionFileList;

    /** Danh sách văn bản online được nộp trong lần submission này. */
    @OneToMany(mappedBy = "assignmentSubmission")
    private List<AssignSubmissionOnlineText> assignsubmissionOnlineTextList;

    /** Quan hệ với bảng bài tập (một bài tập có nhiều lần nộp). */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment")
    private Assign assign;
}
