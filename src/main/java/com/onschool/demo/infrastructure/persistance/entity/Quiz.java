package com.onschool.demo.infrastructure.persistance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
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
 * Entity đại diện cho bảng <b>mdl_quiz</b>.
 * <p>
 * Bảng này lưu thông tin về các hoạt động <b>Quiz</b> trong Moodle (bài kiểm tra trắc nghiệm).
 * </p>
 *
 * <h3>Các cột chính:</h3>
 * <ul>
 *   <li><b>course</b>: ID khóa học mà Quiz thuộc về.</li>
 *   <li><b>name</b>: Tên Quiz.</li>
 *   <li><b>intro</b>: Nội dung mô tả Quiz (intro text).</li>
 *   <li><b>timeopen</b>, <b>timeclose</b>: Khoảng thời gian mở/đóng Quiz.</li>
 *   <li><b>timelimit</b>: Giới hạn thời gian làm bài (tính bằng giây).</li>
 *   <li><b>overduehandling</b>: Cách xử lý khi quá hạn (autosubmit, graceperiod,...).</li>
 *   <li><b>preferredbehaviour</b>: Kiểu hành vi khi làm quiz (deferred feedback, immediate,...).</li>
 *   <li><b>attempts</b>: Số lần được phép làm bài.</li>
 *   <li><b>grademethod</b>: Cách tính điểm (cao nhất, trung bình, lần cuối,...).</li>
 *   <li><b>decimalpoints</b>: Số chữ số thập phân hiển thị trong điểm.</li>
 *   <li><b>sumgrades</b>: Tổng điểm của các câu hỏi.</li>
 *   <li><b>grade</b>: Điểm tối đa của quiz (sau khi scale từ sumgrades).</li>
 *   <li><b>password</b>: Mật khẩu để vào làm quiz (nếu có).</li>
 *   <li><b>browsersecurity</b>: Cấu hình hạn chế trình duyệt.</li>
 *   <li><b>completionattemptsexhausted</b>: Hoàn thành khi đã dùng hết số lần attempt.</li>
 *   <li><b>completionpass</b>: Hoàn thành khi đạt điểm qua môn.</li>
 *   <li><b>allowofflineattempts</b>: Cho phép làm quiz offline (cho app di động).</li>
 * </ul>
 *
 * <h3>Quan hệ:</h3>
 * <ul>
 *   <li>Một {@link Quiz} có nhiều {@link QuizSlots} (danh sách slot chứa câu hỏi).</li>
 *   <li>Một {@link Quiz} có nhiều {@link QuizAttempts} (các lần làm quiz của học viên).</li>
 *   <li>Một {@link Quiz} liên kết 1-1 với {@link GradeItems} (điểm trong gradebook).</li>
 *   <li>Một {@link Quiz} liên kết 1-1 với {@link CourseModules} (module trong khóa học).</li>
 * </ul>
 *
 * @author Hoang
 */
@Table(name = "quiz")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    /** Khóa chính tự tăng. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID khóa học chứa Quiz. */
//    private Long course;

    /** Tên Quiz. */
    private String name;

    /** Nội dung mô tả. */
    private String intro;

    /** Định dạng nội dung intro (HTML, TEXT, Markdown...). */
    private Integer introformat;

    /** Thời điểm mở Quiz. */
    private Long timeopen;

    /** Thời điểm đóng Quiz. */
    private Long timeclose;

    /** Giới hạn thời gian làm bài. */
    private Long timelimit;

    /** Cách xử lý khi quá hạn. */
    private String overduehandling;

    /** Thời gian gia hạn sau khi hết hạn. */
    private Long graceperiod;

    /** Kiểu hành vi của quiz (immediate, deferred,...). */
    private String preferredbehaviour;

    /** Cho phép làm lại câu hỏi. */
    private Integer canredoquestions;

    /** Số lần attempt cho phép. */
    private Long attempts;

    /** Đánh dấu attempt cuối cùng để chấm điểm. */
    private Integer attemptonlast;

    /** Phương pháp tính điểm. */
    private Integer grademethod;

    /** Số chữ số thập phân hiển thị trong điểm. */
    private Integer decimalpoints;

    /** Số chữ số thập phân trong câu hỏi. */
    private Integer questiondecimalpoints;

    /** Các thiết lập review (xem lại attempt). */
    private Long reviewattempt;
    private Long reviewcorrectness;
    private Long reviewmarks;
    private Long reviewspecificfeedback;
    private Long reviewgeneralfeedback;
    private Long reviewrightanswer;
    private Long reviewoverallfeedback;

    /** Số câu hỏi mỗi trang. */
    private Long questionsperpage;

    /** Kiểu điều hướng (free/sequential). */
    private String navmethod;

    /** Shuffle câu hỏi. */
    private Integer shufflequestions;

    /** Tổng điểm của các câu hỏi. */
    private BigDecimal sumgrades;

    /** Điểm tối đa của quiz. */
    private BigDecimal grade;

    /** Ngày tạo quiz. */
    private Long timecreated;

    /** Ngày sửa đổi quiz. */
    private Long timemodified;

    /** Mật khẩu để vào quiz. */
    private String password;

    /** Giới hạn subnet. */
    private String subnet;

    /** Cấu hình bảo mật trình duyệt. */
    private String browsersecurity;

    /** Độ trễ giữa các attempt (lần 1 -> 2). */
    private Integer delay1;

    /** Độ trễ giữa các attempt (lần 2 -> 3). */
    private Integer delay2;

    /** Hiển thị ảnh người dùng trong attempt. */
    private Integer showuserpicture;

    /** Hiển thị block khi làm quiz. */
    private Integer showblocks;

    /** Hoàn thành khi hết số attempt. */
    private Long completionattemptsexhausted;

    /** Hoàn thành khi pass. */
    private Long completionpass;

    /** Cho phép làm quiz offline. */
    private Long allowofflineattempts;

    /** Danh sách slot câu hỏi thuộc quiz. */
    @OneToMany(mappedBy = "quiz")
    @JsonManagedReference
    private List<QuizSlots> quizSlotsList;

    /** Danh sách attempt của quiz. */
    @OneToMany(mappedBy = "quizEntity")
    private List<QuizAttempts> quizAttemptsList;

    /** Liên kết 1-1 với GradeItems. */
    @OneToOne(mappedBy = "quiz")
    private GradeItems gradeItems;

    /** Liên kết 1-1 với CourseModules. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    private CourseModules courseModules;
}
