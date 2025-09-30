package com.onschool.demo.infrastructure.persistance.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_assign</b>.
 * <p>
 * Bảng này lưu thông tin về các hoạt động <b>Assignment</b> trong Moodle
 * (bài tập được giao cho học viên nộp).
 * </p>
 *
 * <ul>
 *   <li><b>course</b>: ID của khóa học chứa Assignment.</li>
 *   <li><b>name</b>: Tên hiển thị của Assignment.</li>
 *   <li><b>intro</b>: Nội dung mô tả (giới thiệu) của Assignment.</li>
 *   <li><b>duedate</b>: Thời hạn nộp bài.</li>
 *   <li><b>allowsubmissionsfromdate</b>: Ngày cho phép bắt đầu nộp bài.</li>
 *   <li><b>cutoffdate</b>: Hạn cuối cho việc nộp bài muộn.</li>
 *   <li><b>gradingduedate</b>: Hạn chót cho việc chấm điểm.</li>
 *   <li><b>grade</b>: Thang điểm tối đa hoặc ID grade scale.</li>
 *   <li><b>teamsubmission</b>: Cho phép nộp theo nhóm (1 = có, 0 = không).</li>
 *   <li><b>blindmarking</b>: Ẩn thông tin sinh viên khi chấm điểm.</li>
 *   <li><b>markingworkflow</b>: Sử dụng quy trình chấm điểm (workflow).</li>
 *   <li><b>attemptreopenmethod</b>: Cách xử lý khi sinh viên nộp lại (manual, automatic, unlimited,...).</li>
 * </ul>
 *
 * <p>
 * Quan hệ:
 * <ul>
 *   <li>Một {@link Assign} có nhiều {@link AssignSubmissionFile} (file nộp bài).</li>
 *   <li>Một {@link Assign} có nhiều {@link AssignSubmissionOnlineText} (nộp bài dạng văn bản online).</li>
 *   <li>Một {@link Assign} có nhiều {@link AssignGrades} (điểm được chấm cho từng submission).</li>
 *   <li>Một {@link Assign} có nhiều {@link AssignmentSubmissions} (danh sách submission).</li>
 *   <li>Một {@link Assign} liên kết 1-1 với {@link GradeItems} (thông tin chấm điểm trong gradebook).</li>
 *   <li>Một {@link Assign} liên kết N-1 với {@link Course} (thuộc về 1 khóa học).</li>
 * </ul>
 * </p>
 *
 * @author Hoang Long
 */
@Table(name = "assign")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assign {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

//    /** ID khóa học chứa Assignment. */
//    private Long course;

    /** Tên Assignment. */
    private String name;

    /** Nội dung mô tả (intro). */
    private String intro;

    /** Định dạng nội dung intro (HTML, TEXT, Markdown...). */
    private Integer introformat;

    /** Luôn hiển thị mô tả. */
    private Integer alwaysshowdescription;

    /** Không cho phép nộp bài (1 = true). */
    private Integer nosubmissions;

    /** Cho phép nộp bản nháp. */
    private Integer submissiondrafts;

    /** Gửi thông báo khi nộp bài. */
    private Integer sendnotifications;

    /** Gửi thông báo khi nộp muộn. */
    private Integer sendlatenotifications;

    /** Thời hạn nộp bài. */
    private Long duedate;

    /** Ngày bắt đầu cho phép nộp bài. */
    private Long allowsubmissionsfromdate;

    /** Điểm tối đa hoặc ID grade scale. */
    private Long grade;

    /** Thời điểm cập nhật cuối cùng. */
    private Integer timemodified;

    /** Yêu cầu xác nhận cam kết khi nộp bài. */
    private Integer requiresubmissionstatement;

    /** Hoàn thành khi nộp bài. */
    private Integer completionsubmit;

    /** Hạn cuối cùng cho việc nộp muộn. */
    private Long cutoffdate;

    /** Hạn cuối cho việc chấm điểm. */
    private Long gradingduedate;

    /** Cho phép nộp bài theo nhóm. */
    private Integer teamsubmission;

    /** Yêu cầu tất cả thành viên nhóm phải nộp. */
    private Integer requireallteammemberssubmit;

    /** Grouping ID dùng cho nộp nhóm. */
    private Long teamsubmissiongroupingid;

    /** Chấm điểm ẩn (blind marking). */
    private Integer blindmarking;

    /** Ẩn tên giảng viên chấm bài. */
    private Integer hidegrader;

    /** Công khai danh tính sau khi chấm. */
    private Integer revealidentities;

    /** Phương thức mở lại attempt (manual, automatic, unlimited,...). */
    private String attemptreopenmethod;

    /** Số lần nộp tối đa. */
    private Long maxattempts;

    /** Có sử dụng marking workflow. */
    private Integer markingworkflow;

    /** Có sử dụng marking allocation. */
    private Integer markingallocation;

    /** Gửi thông báo đến sinh viên khi có cập nhật. */
    private Integer sendstudentnotifications;

    /** Ngăn không cho nộp nếu không ở trong group. */
    private Integer preventsubmissionnotingroup;

    /** Danh sách file nộp bài. */
    @OneToMany(mappedBy = "assign")
    private List<AssignSubmissionFile> assignSubmissionFileList;

    /** Danh sách nộp bài online (văn bản). */
    @OneToMany(mappedBy = "assign")
    private List<AssignSubmissionOnlineText> assignsubmissionOnlineTextList;

    /** Danh sách điểm cho từng submission. */
    @OneToMany(mappedBy = "assign")
    private List<AssignGrades> assignGrades;

    /** Danh sách submission của Assignment. */
    @OneToMany(mappedBy = "assign", fetch = FetchType.LAZY)
    private List<AssignmentSubmissions> assignmentSubmissionsList;

    /** Liên kết 1-1 với GradeItems trong gradebook. */
    @OneToOne(mappedBy = "assign")
    private GradeItems gradeItems;

    /** Liên kết 1-1 với CourseModules. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    private CourseModules courseModules;
}
