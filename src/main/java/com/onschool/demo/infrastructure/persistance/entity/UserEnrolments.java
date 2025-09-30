package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity ánh xạ bảng <b>mdl_user_enrolments</b> trong Moodle.
 * <p>
 * Bảng này lưu thông tin việc ghi danh (enrolment) của người dùng vào các khóa học,
 * thông qua phương thức enrolment (được định nghĩa trong {@link Enrol}).
 * </p>
 *
 * <h2>Các cột chính:</h2>
 * <ul>
 *   <li><b>status</b>: Trạng thái ghi danh (0 = active, 1 = suspended).</li>
 *   <li><b>enrolid</b>: ID từ bảng {@link Enrol}, chỉ ra phương thức ghi danh nào được dùng (manual, self, guest...).</li>
 *   <li><b>userid</b>: ID của {@link User} được ghi danh.</li>
 *   <li><b>timestart</b>: Thời gian bắt đầu có hiệu lực ghi danh (timestamp).</li>
 *   <li><b>timeend</b>: Thời gian hết hạn ghi danh (timestamp).</li>
 *   <li><b>modifierid</b>: Người thực hiện chỉnh sửa ghi danh (thường là admin hoặc teacher).</li>
 *   <li><b>timecreated</b>: Thời điểm tạo bản ghi ghi danh.</li>
 *   <li><b>timemodified</b>: Thời điểm chỉnh sửa gần nhất.</li>
 * </ul>
 *
 * <h2>Quan hệ:</h2>
 * <ul>
 *   <li>Nhiều {@link UserEnrolments} thuộc về một {@link User} (ManyToOne).</li>
 *   <li>Nhiều {@link UserEnrolments} thuộc về một {@link Enrol} (ManyToOne).</li>
 * </ul>
 *
 * @author Hoang
 */
@Table(name = "user_enrolments")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEnrolments {

    /** Khóa chính tự tăng. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Trạng thái ghi danh (0 = active, 1 = suspended). */
    private Long status;

//    /** ID enrol method (liên kết {@link Enrol}). */
//    private Long enrolid;

//    /** ID người dùng (liên kết {@link User}). */
//    private Long userid;

    /** Thời gian bắt đầu ghi danh (timestamp). */
    private Long timestart;

    /** Thời gian kết thúc ghi danh (timestamp). */
    private Long timeend;

    /** Người chỉnh sửa ghi danh (ID user). */
    private Long modifierid;

    /** Thời điểm tạo bản ghi (timestamp). */
    private Long timecreated;

    /** Thời điểm cập nhật gần nhất (timestamp). */
    private Long timemodified;

    /** Người dùng được ghi danh. */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private User user;

    /** Phương thức ghi danh (manual, self, guest...). */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enrolid")
    private Enrol enrol;
}
