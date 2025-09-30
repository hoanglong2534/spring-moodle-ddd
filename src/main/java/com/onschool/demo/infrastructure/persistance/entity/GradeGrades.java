package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_grade_grades</b>.
 * <p>
 * Bảng này lưu thông tin chi tiết về điểm số (grades) của từng người dùng
 * cho một {@link GradeItems} cụ thể trong hệ thống.
 * Một bản ghi trong bảng này thể hiện kết quả chấm điểm của một sinh viên
 * trong một item (ví dụ: bài tập, quiz, ...).
 * </p>
 *
 * <ul>
 *   <li><b>userid</b>: Người dùng được chấm điểm.</li>
 *   <li><b>rawgrade</b>: Điểm gốc (chưa tính toán/chuẩn hóa).</li>
 *   <li><b>rawgrademax</b>: Điểm tối đa có thể đạt.</li>
 *   <li><b>rawgrademin</b>: Điểm tối thiểu (thường là 0).</li>
 *   <li><b>rawscaleid</b>: Tham chiếu tới thang điểm (scale) nếu có.</li>
 *   <li><b>usermodified</b>: Người dùng cuối cùng chỉnh sửa điểm này.</li>
 *   <li><b>finalgrade</b>: Điểm cuối cùng sau khi tính toán/xử lý.</li>
 *   <li><b>hidden</b>: Trạng thái ẩn/hiện điểm.</li>
 *   <li><b>locked</b>: Điểm có bị khóa chỉnh sửa không.</li>
 *   <li><b>locktime</b>: Thời điểm điểm bị khóa.</li>
 *   <li><b>exported</b>: Điểm đã được export chưa.</li>
 *   <li><b>overridden</b>: Điểm đã bị override (chỉnh tay) chưa.</li>
 *   <li><b>excluded</b>: Điểm có bị loại khỏi tính toán tổng hợp không.</li>
 *   <li><b>feedback</b>: Phản hồi kèm theo (feedback text).</li>
 *   <li><b>feedbackformat</b>: Định dạng phản hồi.</li>
 *   <li><b>timecreated</b>: Thời điểm tạo bản ghi.</li>
 *   <li><b>timemodified</b>: Thời điểm sửa đổi cuối cùng.</li>
 *   <li><b>aggregationstatus</b>: Trạng thái tính toán điểm tổng hợp.</li>
 *   <li><b>aggregationweight</b>: Trọng số trong quá trình tính điểm tổng hợp.</li>
 * </ul>
 *
 * <p>
 * Quan hệ:
 * <ul>
 *   <li>Một {@link GradeGrades} có thể có nhiều {@link AssignFeedbackFile} (file feedback đính kèm).</li>
 *   <li>Một {@link GradeGrades} có thể có nhiều {@link AssignFeedbackComments} (feedback dạng text).</li>
 *   <li>Một {@link GradeGrades} thuộc về một {@link GradeItems} (mục chấm điểm cụ thể).</li>
 * </ul>
 * </p>
 *
 * @author Hoang Long
 */
@Table(name = "grade_grades")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeGrades {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ID của người dùng được chấm điểm. */
    private Long userid;

    /** Điểm gốc (raw grade). */
    private BigDecimal rawgrade;

    /** Điểm tối đa. */
    private BigDecimal rawgrademax;

    /** Điểm tối thiểu. */
    private BigDecimal rawgrademin;

    /** Thang điểm (scale) liên kết (nếu có). */
    private Long rawscaleid;

    /** Người dùng đã chỉnh sửa điểm này. */
    private Long usermodified;

    /** Điểm cuối cùng. */
    private BigDecimal finalgrade;

    /** Cờ ẩn điểm. */
    private Long hidden;

    /** Cờ khóa điểm. */
    private Long locked;

    /** Thời điểm điểm bị khóa. */
    private Long locktime;

    /** Cờ export điểm. */
    private Long exported;

    /** Điểm có bị override không. */
    private Long overridden;

    /** Điểm có bị loại trừ không. */
    private Long excluded;

    /** Phản hồi (feedback text). */
    private String feedback;

    /** Định dạng feedback. */
    private Long feedbackformat;

    /** Thời điểm tạo. */
    private Long timecreated;

    /** Thời điểm sửa đổi cuối cùng. */
    private Long timemodified;

    /** Trạng thái tổng hợp điểm. */
    private String aggregationstatus;

    /** Trọng số trong tính toán điểm. */
    private BigDecimal aggregationweight;

    /** Danh sách feedback file gắn với grade này. */
    @OneToMany(mappedBy = "gradeGrades")
    private List<AssignFeedbackFile> assignFeedbackFiles;

    /** Danh sách feedback comment gắn với grade này. */
    @OneToMany(mappedBy = "gradeGrades")
    private List<AssignFeedbackComments> assignFeedbackComments;

    /** Item (mục chấm điểm) mà grade này thuộc về. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemid")
    private GradeItems gradeItems;
}
