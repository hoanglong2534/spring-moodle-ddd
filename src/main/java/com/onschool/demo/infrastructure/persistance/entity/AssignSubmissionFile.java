package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity đại diện cho bảng <b>mdl_assignsubmission_file</b>.
 * <p>
 * Bảng này lưu thông tin về số lượng và dữ liệu file mà người dùng
 * nộp trong một bài tập (assignment). Mỗi bản ghi tương ứng với một
 * submission file cho một lần nộp cụ thể.
 * </p>
 *
 * <ul>
 *   <li><b>assignment</b>: ID bài tập (tham chiếu đến {@link Assign}).</li>
 *   <li><b>submission</b>: ID lần nộp bài (tham chiếu đến {@link AssignmentSubmissions}).</li>
 *   <li><b>numfiles</b>: Số lượng file được nộp trong lần submission này.</li>
 * </ul>
 *
 * <p>
 * Quan hệ:
 * <ul>
 *   <li>Một {@link AssignSubmissionFile} thuộc về một {@link AssignmentSubmissions}.</li>
 *   <li>Một {@link AssignSubmissionFile} cũng thuộc về một {@link Assign} (bài tập cụ thể).</li>
 * </ul>
 * </p>
 *
 * @author Hoang Long
 */
@Table(name = "assignsubmission_file")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignSubmissionFile {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    /** ID bài tập (tham chiếu đến {@link Assign}). */
//    private Long assignment;
//
//    /** ID lần nộp bài (tham chiếu đến {@link AssignmentSubmissions}). */
//    private Long submission;

    /** Số lượng file trong lần submission này. */
    private Long numfiles;

    /** Lần nộp bài mà file này thuộc về. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "submission")
    private AssignmentSubmissions assignmentSubmissions;

    /** Bài tập (assignment) mà file này được nộp cho. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment")
    private Assign assign;
}
