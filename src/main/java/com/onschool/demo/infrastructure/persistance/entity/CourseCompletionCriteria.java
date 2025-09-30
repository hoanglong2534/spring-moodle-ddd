package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

/**
 * Entity đại diện cho bảng <b>mdl_course_completion_criteria</b>.
 * <p>
 * Lưu thông tin về các tiêu chí hoàn thành khóa học trong Moodle.
 * Mỗi {@link CourseCompletionCriteria} thuộc về duy nhất một {@link Course}.
 * </p>
 *
 * <ul>
 *   <li><b>course</b>: ID khóa học mà tiêu chí áp dụng.</li>
 *   <li><b>criteriatype</b>: loại tiêu chí (ví dụ: hoàn thành module, đạt điểm tối thiểu, có vai trò...).</li>
 *   <li><b>module</b>: loại module liên quan (nếu tiêu chí là dựa trên module).</li>
 *   <li><b>moduleinstance</b>: ID instance của module.</li>
 *   <li><b>courseinstance</b>: ID instance của khóa học (nếu cần).</li>
 *   <li><b>enrolperiod</b>: thời hạn enrolment để hoàn thành tiêu chí (tính bằng giây).</li>
 *   <li><b>timeend</b>: thời điểm kết thúc tiêu chí (timestamp).</li>
 *   <li><b>gradepass</b>: điểm tối thiểu cần đạt để hoàn thành tiêu chí.</li>
 *   <li><b>role</b>: ID vai trò yêu cầu để hoàn thành tiêu chí.</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link Course}: Khóa học mà tiêu chí này áp dụng.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "course_completion_criteria")
public class CourseCompletionCriteria {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID khóa học mà tiêu chí áp dụng. */
//    private Long course;

    /** Loại tiêu chí (ví dụ: module completion, grade, role, etc.). */
    private Long criteriatype;

    /** Loại module liên quan nếu tiêu chí là module-based. */
    private String module;

    /** ID instance của module. */
    private Long moduleinstance;

    /** ID instance của khóa học (nếu cần). */
    private Long courseinstance;

    /** Thời hạn enrolment để hoàn thành tiêu chí (tính bằng giây). */
    private Long enrolperiod;

    /** Thời điểm kết thúc tiêu chí (timestamp). */
    private Long timeend;

    /** Điểm tối thiểu cần đạt để hoàn thành tiêu chí. */
    private BigDecimal gradepass;

    /** ID vai trò yêu cầu để hoàn thành tiêu chí. */
    private Long role;

    /** Khóa học mà tiêu chí này áp dụng. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    private Course courseEntity;
}
