package com.onschool.demo.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entity đại diện cho bảng <b>mdl_enrol</b>.
 * <p>
 * Lưu thông tin về phương thức ghi danh (enrolment) của người dùng vào các khóa học trong Moodle.
 * Mỗi {@link Enrol} có thể liên kết với nhiều {@link UserEnrolments} và thuộc một {@link Course}.
 * </p>
 *
 * <ul>
 *   <li><b>enrol</b>: loại hình enrolment (ví dụ: "manual", "self", "cohort").</li>
 *   <li><b>status</b>: trạng thái enrolment (1 = active, 0 = disabled).</li>
 *   <li><b>courseid</b>: ID khóa học mà enrolment áp dụng.</li>
 *   <li><b>sortorder</b>: thứ tự hiển thị enrolment.</li>
 *   <li><b>name</b>: tên của enrolment.</li>
 *   <li><b>enrolperiod</b>: thời hạn enrolment (tính bằng giây).</li>
 *   <li><b>enrolstartdate</b>: thời điểm bắt đầu enrolment (timestamp).</li>
 *   <li><b>enrolenddate</b>: thời điểm kết thúc enrolment (timestamp).</li>
 *   <li><b>expirynotify</b>: cờ thông báo khi enrolment sắp hết hạn.</li>
 *   <li><b>expirythreshold</b>: ngưỡng thời gian để gửi thông báo hết hạn (tính bằng giây).</li>
 *   <li><b>notifyall</b>: cờ gửi thông báo cho tất cả người dùng.</li>
 *   <li><b>password</b>: mật khẩu enrolment (nếu có).</li>
 *   <li><b>cost</b>: chi phí enrolment (nếu có).</li>
 *   <li><b>currency</b>: đơn vị tiền tệ (nếu có chi phí).</li>
 *   <li><b>roleid</b>: ID vai trò được gán khi enrolment.</li>
 *   <li><b>customint1-8</b>: các trường tuỳ chỉnh kiểu số nguyên.</li>
 *   <li><b>customchar1-3</b>: các trường tuỳ chỉnh kiểu ký tự.</li>
 *   <li><b>customdec1-2</b>: các trường tuỳ chỉnh kiểu số thập phân.</li>
 *   <li><b>customtext1-4</b>: các trường tuỳ chỉnh kiểu văn bản.</li>
 *   <li><b>created</b>: timestamp khi enrolment được tạo.</li>
 *   <li><b>timemodified</b>: timestamp khi enrolment được chỉnh sửa lần cuối.</li>
 * </ul>
 *
 * <p>
 * Quan hệ với các entity khác:
 * </p>
 * <ul>
 *   <li>{@link UserEnrolments}: Danh sách các enrolment của người dùng theo phương thức này.</li>
 *   <li>{@link Course}: Khóa học mà phương thức enrolment này áp dụng.</li>
 * </ul>
 *
 * @author Hoang Long
 */
@Entity
@Table(name = "enrol")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enrol {

    /** Khóa chính tự sinh. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Loại hình enrolment (ví dụ: "manual", "self", "cohort"). */
    private String enrol;

    /** Trạng thái enrolment (1 = active, 0 = disabled). */
    private Long status;

//    /** ID khóa học mà enrolment áp dụng. */
//    private Long courseid;

    /** Thứ tự hiển thị enrolment. */
    private Long sortorder;

    /** Tên của enrolment. */
    private String name;

    /** Thời hạn enrolment (tính bằng giây). */
    private Long enrolperiod;

    /** Thời điểm bắt đầu enrolment (timestamp). */
    private Long enrolstartdate;

    /** Thời điểm kết thúc enrolment (timestamp). */
    private Long enrolenddate;

    /** Cờ thông báo khi enrolment sắp hết hạn. */
    private Integer expirynotify;

    /** Ngưỡng thời gian để gửi thông báo hết hạn (tính bằng giây). */
    private Long expirythreshold;

    /** Cờ gửi thông báo cho tất cả người dùng. */
    private Integer notifyall;

    /** Mật khẩu enrolment (nếu có). */
    private String password;

    /** Chi phí enrolment (nếu có). */
    private String cost;

    /** Đơn vị tiền tệ (nếu có chi phí). */
    private String currency;

    /** ID vai trò được gán khi enrolment. */
    private Long roleid;

    /** Các trường tuỳ chỉnh kiểu số nguyên. */
    private Long customint1;
    private Long customint2;
    private Long customint3;
    private Long customint4;
    private Long customint5;
    private Long customint6;
    private Long customint7;
    private Long customint8;

    /** Các trường tuỳ chỉnh kiểu ký tự. */
    private String customchar1;
    private String customchar2;
    private String customchar3;

    /** Các trường tuỳ chỉnh kiểu số thập phân. */
    private BigDecimal customdec1;
    private BigDecimal customdec2;

    /** Các trường tuỳ chỉnh kiểu văn bản. */
    private String customtext1;
    private String customtext2;
    private String customtext3;
    private String customtext4;

    /** Timestamp khi enrolment được tạo. */
    private Long created;

    /** Timestamp khi enrolment được chỉnh sửa lần cuối. */
    private Long timemodified;

    /** Danh sách các enrolment của người dùng theo phương thức này. */
    @OneToMany(mappedBy = "enrol")
    private List<UserEnrolments> userEnrolments;

    /** Khóa học mà phương thức enrolment này áp dụng. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseid")
    private Course course;
}
